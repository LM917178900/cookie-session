package com.example.demo.cookie.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

public final class CookieUtils {
    private static Logger logger = LoggerFactory.getLogger(CookieUtils.class);
    private static String encryptKey = "!Q@W#E$Rcdlianxiang)O(I*U&Y";
    private static ThreadLocal<Blowfish> blowfishThreadLocal = new ThreadLocal<>();

    private CookieUtils() {
    }

    private static Blowfish blowfish() {
        Blowfish blowfish = blowfishThreadLocal.get();
        if (blowfish == null) {
            blowfish = new Blowfish(encryptKey);
            blowfishThreadLocal.set(blowfish);
        }
        return blowfish;
    }

    /**
     * 将信息生成cookie,然后将cookie 添加到 response
     *
     * @param response
     * @param name
     * @param value
     * @param domain
     * @param path
     * @param age
     * @param secure
     * @param httpOnly
     */
    public static void addCookie(
            HttpServletResponse response,
            String name,
            String value,
            String domain,
            String path,
            int age,
            boolean secure,
            boolean httpOnly) {

        // url 编码 sessionId 名称
        String n = urlEncode(name);

        // url 编码 sessionId
        String v = urlEncode(value);

        // 生成cookie
        Cookie cookie = makeCookie(n, v, domain, path, age, secure, httpOnly);

        // cookie 放入 response
        response.addCookie(cookie);
    }

    public static void delCookie(
            HttpServletResponse response,
            String name,
            String domain,
            String path) {

        String n = urlEncode(name);
        Cookie cookie = makeCookie(n, "", domain, path, 0, null, null);
        response.addCookie(cookie);
    }

    /**
     *  从request 中获取cookie,从cookie 中获取上次的重定向地址
     * @param request
     * @param name
     * @return
     */
    public static String findCookie(HttpServletRequest request, String name) {

        // lastUrl 名称url 编码
        String n = urlEncode(name);

        // 通过cookie 的名称,从request 中获取对应的cookie
        Cookie cookie = findCookie2(request, n);

        // 解码url 地址
        if (cookie != null) {
            return urlDecode(cookie.getValue());
        }
        return null;
    }

    public static String findAndDelCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        String n = urlEncode(name);
        Cookie cookie = findCookie2(request, n);
        if (cookie != null) {
            delCookie(response, n, cookie.getDomain(), cookie.getPath());
            return urlDecode(cookie.getValue());
        }
        return null;
    }

    /**
     * 通过cookie 的名称,从request 中获取对应的cookie
     *
     * @param request
     * @param name
     * @return
     */
    private static Cookie findCookie2(HttpServletRequest request, String name) {
        assert name != null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c != null && name.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * 设置 cookie 内容
     * @param name
     * @param value
     * @param domain
     * @param path
     * @param age
     * @param secure
     * @param httpOnly
     * @return
     */
    private static Cookie makeCookie(
            String name,
            String value,
            String domain,
            String path,
            int age,
            Boolean secure,
            Boolean httpOnly) {

        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(age);
        if (StringUtils.isNotBlank(path)) {
            cookie.setPath(path);
        }

        if (secure != null) {
            cookie.setSecure(secure);
        }

        if (httpOnly != null) {
            try {
                cookie.setHttpOnly(httpOnly);
            } catch (Throwable e) {
                e.printStackTrace(System.err);
            }
        }

        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }

        return cookie;
    }


    /**
     * url 编码
     * @param rawString
     * @return
     */
    private static String urlEncode(String rawString) {
        try {
            return URLEncoder.encode(rawString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.err);
        }
        return rawString;
    }

    private static String urlDecode(String encoded) {
        try {
            return URLDecoder.decode(encoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.err);
        }
        return encoded;
    }

    public static String genSessionId() {
        UUID uuid = UUID.randomUUID();
        String sid = uuid.toString().toLowerCase();
        return StringUtils.replaceChars(sid, "-", "");
    }

    /**
     * todo 通过 userId 生成 sessionId
     *
     * @param userid
     * @return
     */
    public static String genSessionId(String userid) {

        // 加密 userId
        String encrypted = blowfish().encryptString(userid);
        UUID uuid = UUID.randomUUID();
        String uuidStr = StringUtils.replaceChars(uuid.toString(), "-", "");
        return encrypted + "_" + uuidStr + "_" + hashMark(userid);
    }

    public static String[] parse(String sessionId) {
        String[] tokens = StringUtils.split(sessionId, '_');
        if (tokens.length == 3) {
            String userid = blowfish().decryptString(tokens[0]);
            String hashMark = hashMark(userid);
            if (hashMark.equals(tokens[2])) {
                tokens[0] = userid;
                return tokens;
            } else {
                logger.debug("CookieUtils.parse: hashMark not match, sessionId:{}, userid:{}, hashMark:{}, computedHashMark:{}", sessionId, userid, tokens[2], hashMark);
                return new String[]{sessionId};
            }
        }
        return new String[]{sessionId};
    }

    /**
     * 校验 传入的userId 和 sessionId 是否匹配；
     * @param sessionId
     * @param userid
     * @return
     */
    public static boolean isSessionIdMatch(String sessionId, String userid) {
        
        // 加密用户id
        String hashMark = hashMark(userid);
        // 解析sessionId中的 userId
        String target = parseHashMark(sessionId);

        // 解密 sessionId 中的 userId 字符串
        String uname = parseUserid(sessionId);
        return target != null && target.equals(hashMark) && uname != null && uname.equals(userid);
    }

    public static String hashMark(String userid) {
        String hash = EndecryptUtils.hash(userid, "MD5", 5);
        return hash.toLowerCase();
    }

    /**
     * 解析 sessionId
     *
     * @param sessionId
     * @return
     */
    public static String parseHashMark(String sessionId) {
        int from = sessionId.lastIndexOf('_');
        if (from >= 0) {
            return sessionId.substring(from + 1);
        }
        return null;
    }

    /**
     * 解密 sessionId 中的 userId 字符串
     *
     * @param sessionId
     * @return
     */
    public static String parseUserid(String sessionId) {
        int from = sessionId.indexOf('_');
        if (from >= 0) {
            // 解密
            return blowfish().decryptString(sessionId.substring(0, from));
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CookieUtils.hashMark("le_ocean"));
        System.out.println(CookieUtils.genSessionId("le_ocean"));
    }
}
