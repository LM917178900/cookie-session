package com.example.demo.cookie.session;

import com.example.demo.cookie.constants.CommonConstants;
import com.example.demo.cookie.util.CookieUtils;
import com.example.demo.cookie.util.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * 通过userId 生成cookie 并放入响应对象和 request;
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
