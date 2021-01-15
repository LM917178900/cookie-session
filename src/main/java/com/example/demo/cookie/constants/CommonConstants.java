package com.example.demo.cookie.constants;

import java.util.regex.Pattern;

/**
 * 通用常量
 */
public class CommonConstants {

    /**
     * 通用http常量
     */
    public static class Http {
        // 响应请求成功code
        public static final Integer RESPONSE_SUCCESS_CODE = 0;

        // 系统错误
        public static final Integer RESPONSE_CODE_500 = 500;

        // 响应请求成功
        public static final String RESPONSE_CODE_200_VALUE = "success";

        // 系统错误
        public static final String RESPONSE_CODE_500_VALUE = "fail";
    }

    /**
     * 通用数据状态
     */
    public static class DataStatus {
        // 正常
        public static final Integer NORMAL = 0;
        // 禁用
        public static final Integer DISABLED = 1;
    }

    public static final Pattern SYMBOL_PATTERN = Pattern.compile("^[a-zA-Z\\$][a-zA-Z\\d_]*$");

    public static class RedisKey{
        public static final String PREFIX_USER_CAPTCHA  = "qes:sys:captcha:";
    }

    public static class CookieKey{
        public static final String COOKIE_SAMESITE = "SameSite";
    }

    public static class RegEx{
        public static final String EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        public static final String PHONE = "";
    }


    public static class Origin{
        public static final String LOCAL = "local";
    }

    public static final class Key{
        public static final String USER = "user";
        public static final String EXCEPTION = "exception";
    }
    public static class ResType {
        public static final String UI = "ui"; // 界面相关的(菜单，按钮，页面等等)
        public static final String API = "api";// 后端API
        public static final String SIGN = "sign";// 记号(仅仅标识某种权限)
    }

    public static class Email{
        public static final String LENOVO = "@lenovo.com";
        public static final String MOTO = "@motorola.com";
    }

    public static class ReportApi{
        public static final String LENOVO_LOGIN = "Lenovo login";
        public static final String PARTNER_LOGIN = "Partner login";
        public static final String LOGOUT = "Logout";
    }
}
