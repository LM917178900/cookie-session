package com.example.demo.cookie.session;

import com.example.demo.cookie.constants.CommonConstants;
import com.example.demo.cookie.constants.Constants;
import com.example.demo.cookie.model.Userdetail;
import com.example.demo.cookie.util.CookieUtils;
import com.example.demo.cookie.util.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @description: SessionService
 * @author: leiming5
 * @date: 2021-01-15 13:32
 */
@Service
public class SessionService {

    @Resource
    private RedisUtils<Object> redisUtils;


    @Value("${session.cookie.key}")
    private String sessionIdKey = "__sid__";
    private String udItemKey = "__ud__";

    @Value("${session.cookie.domain}")
    private String sessionDomain;
    @Value("${session.cookie.path}")
    private String sessionPath;
    @Value("${session.cookie.secure}")
    private boolean sessionCookieSecure = false;
    @Value("${session.cookie.http-only}")
    private boolean sessionCookieHttpOnly = true;
    @Value("${session.cookie.ttl}")
    private int sessionTTL = 1800;
    @Value("${custom.config.aes.key}")
    private String aesKey;

    /**
     * 查询用户信息，然后，将用户信息和sessionId 分别保存到redis
     *
     * @param request
     * @param response
     * @return
     */
    public Userdetail login(HttpServletRequest request, HttpServletResponse response) {

        // 通过传参获取用户
        Userdetail userdetail = readUserdetail(request);
        if (userdetail != null) {
            Integer userid = userdetail.getId();

            // 获取sessionId
            String sessionId = ensureSessionId(request, response, userid);

            // 将用户信息和sessionId 分别保存到redis
            saveUserdetailToSession(sessionId, userdetail);
        }
        return userdetail;
    }

    private void saveUserdetailToSession(String sessionId, Userdetail userdetail) {

        // 设置过期时间 30 分钟
        long expireAt = System.currentTimeMillis() + sessionTTL * 1000;
        userdetail.setExpireAt(expireAt);

        // 将用户信息 和sessionId 分别存入redis
        redisUtils.hset(sessionkey(sessionId), udItemKey, userdetail, new Date(expireAt));
        redisUtils.set(desessionkey(String.valueOf(userdetail.getId())), sessionId, new Date(expireAt));
    }

    /**
     * 所有数据都放在 request 中
     *
     * @param request
     * @return
     */
    private Userdetail readUserdetail(HttpServletRequest request) {

        // 获取数据
//        String origin = request.getParameter("o");
//        String username = request.getParameter("u");
//        String password = request.getParameter("p");
//
//        if (StringUtils.isBlank(origin)) {
//            origin = (String) request.getAttribute("o");
//        }
//        if (StringUtils.isBlank(origin)) {
//            origin = Constants.USER_ORIGIN_LOCAL;
//        }
//        if (StringUtils.isBlank(username)) {
//            username = (String) request.getAttribute("u");
//        }
//        if (StringUtils.isBlank(password)) {
//            password = (String) request.getAttribute("p");
//        }
//
//        if (StringUtils.isNotBlank(username)) {
//
//            // 解析密码，将加密后的密码破解为明文密码；
//            try {
//                password = AesUtils.aesDecrypt(password, aesKey);
//            } catch (Exception e) {
//                LOGGER.error("decrypt password error,password=[{}],key=[{}]", password, aesKey);
//                e.printStackTrace();
//            }
//
//            // 获取满足指定用户密码的有效用户
//            Userdetail userdetail = authService.getUserdetail(origin, username, password);
//            if (userdetail != null) {
//                if (AcUserEnum.IN_ACTIVE.getCode().equals(userdetail.getState())) {
//                    throw new BussinessException("this account has been inactive");
//                }
//
//                // 获取成功，更新登录时间；
//                acUserService.updateLastLoginTime(origin, username);
//                return userdetail;
//            }
//
//            // 获取失败返回null
//            else {
//                return null;
//            }
//        } else {
            return null;
//        }
    }

    /**
     * 从redis 获取动态验证码
     * @param request
     * @return
     */
    public boolean isCaptchaValid(HttpServletRequest request) {
        String c = request.getParameter("c");
        if (StringUtils.isBlank(c)) {
            return false;
        }

        // 先查询后删除
        String s = redisUtils.remove(CommonConstants.RedisKey.PREFIX_USER_CAPTCHA + c.toUpperCase());
        return !StringUtils.isBlank(s);
    }


    public String touch(HttpServletRequest request) {
        String sessionId = findSessionId(request);
        if (sessionId != null) {
            touch(sessionId);
        }
        return sessionId;
    }

    public String touch(String sessionId) {
        if (sessionId != null) {
            long expireAt = System.currentTimeMillis() + sessionTTL * 1000;
            String userIdIntStr = CookieUtils.parseUserid(sessionId);
            if (StringUtils.isNumeric(userIdIntStr)) {
                redisUtils.expireAt(sessionkey(sessionId), expireAt);
                redisUtils.expireAt(desessionkey(userIdIntStr), expireAt);
            }
        }
        return sessionId;
    }

    /**
     * 获取sessionId key
     *
     * @param sessionId
     * @return
     */
    private String sessionkey(String sessionId) {
        String usefull = sessionId.substring(sessionId.indexOf('_') + 1);
        return "ud#" + usefull.replace('_', '{') + "}";
    }

    /**
     * userId 加密后拼接
     *
     * @param userIdStr
     * @return
     */
    private String desessionkey(String userIdStr) {
        return "sid#" + userIdStr + "{" + CookieUtils.hashMark(userIdStr) + "}";
    }

    /**
     * 校验sessionId 是否匹配
     *
     * @param request
     * @param response
     * @param userid
     * @return
     */
    private String ensureSessionId(HttpServletRequest request, HttpServletResponse response, Integer userid) {

        // 从请求中获取sessionId
        String sessionId = findSessionId(request);

        // 校验 传入的userId 和 sessionId 是否匹配；
        // 如果不匹配，生成新的sessionId，重新放入request ,response,cookie
        if (sessionId == null || !CookieUtils.isSessionIdMatch(sessionId, userid.toString())) {
            sessionId = newSessionId(request, response, userid);
        }
        return sessionId;
    }

    /**
     * todo 通过userId 生成cookie 并放入响应对象和 request;
     *
     * @param request
     * @param response
     * @param userid
     * @return
     */
    private String newSessionId(HttpServletRequest request, HttpServletResponse response, Integer userid) {

        // 通过userID ,按照指定规则生成sessionId
        String sessionId = CookieUtils.genSessionId(userid.toString());
        if (response != null) {
            int sessionCookieAge = -1;

            // 通过userId 生成cookie 并放入响应对象
            CookieUtils.addCookie(response, sessionIdKey, sessionId, sessionDomain, sessionPath, sessionCookieAge, sessionCookieSecure, sessionCookieHttpOnly);
        }

        // 将sessionId 放入 request 对象
        request.setAttribute(sessionIdKey, sessionId);
        return sessionId;
    }


    /**
     * 在request 中获取sessionId
     *
     * @param request
     * @return
     */
    public String findSessionId(HttpServletRequest request) {
        String sessionId = (String) request.getAttribute(sessionIdKey);
        if (StringUtils.isBlank(sessionId)) {
            sessionId = request.getParameter(sessionIdKey);
            if (StringUtils.isBlank(sessionId)) {
                sessionId = CookieUtils.findCookie(request, sessionIdKey);
            }
        }
        return sessionId;
    }

    public String getSessionIdKey() {
        return sessionIdKey;
    }

    public String getSessionDomain() {
        return sessionDomain;
    }

    public String getSessionPath() {
        return sessionPath;
    }

}
