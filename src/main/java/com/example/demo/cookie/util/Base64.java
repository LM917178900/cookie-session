package com.example.demo.cookie.util;


import java.io.ByteArrayOutputStream;

/**
 * Created by kongkp on 16-8-25.
 */

public class Base64 {

    private final char padChar;
    private static final Base64 base64Standard = new Base64();
    private static final Base64 base64UrlSafe = new Base64('~', '_', '-');

    private Base64() {
        this('=', '+', '/');
    }

    public Base64(char padChar, char char62, char char63) {
        this.padChar = padChar;
        encodingChars[62] = char62;
        encodingChars[63] = char63;
    }

    public static Base64 standardBase64() {
        return base64Standard;
    }

    public static Base64 urlSafeBase64() {
        return base64UrlSafe;
    }

    private final char[] encodingChars = new char[]{'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'};

    public String encode(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        byte cur = 0, last = 0, left = 0;
        for (int i = 0; i < bytes.length; i++) {
            last = cur;
            cur = bytes[i];

            if (left == 0) {
                builder.append(encodingChars[(cur & 0xFF) >>> 2]);
            } else {
                builder.append(encodingChars[((last << 6 >> left) | ((cur & 0xff) >> left >> 2)) & 0x3F]);

                if (left == 4) {
                    builder.append(encodingChars[cur & 0x3F]);
                }
            }

            left += 2;
            left %= 6;
        }

        if (left != 0) {
            builder.append(encodingChars[(cur << (8 - left) & 0xFF) >>> 2]);
            builder.append(padChar);
            if (left == 2) {
                builder.append(padChar);
            }
        }

        return builder.toString();
    }

    public byte[] decode(String str) {
        ByteArrayOutputStream bais = new ByteArrayOutputStream();

        byte cur, last = -1, padding = 0;
        for (int i = 0, len = str.length(); i < len; i++) {
            cur = computeByteVal(str.charAt(i));

            if (padding > 0 && cur >= 0) {
                bais.write(last << padding | (cur & 0xFF) >>> (6 - padding));
            }

            if (cur >= 0) {
                padding += 2;
                padding &= 0x06;
                last = cur;
            }
        }

        return bais.toByteArray();
    }

    private byte computeByteVal(char base64Char) {

        if (base64Char >= 'A' && base64Char <= 'Z') {
            return (byte) (base64Char - 'A');
        }
        if (base64Char >= 'a' && base64Char <= 'z') {
            return (byte) ((base64Char - 'a') + 26);
        }
        if (base64Char >= '0' && base64Char <= '9') {
            return (byte) ((base64Char - '0') + 52);
        }

        if (base64Char == encodingChars[62]) {
            return 62;
        }
        if (base64Char == encodingChars[63]) {
            return 63;
        }

        return -1;
    }

    public static void main(String [] args){
        String s = new String(Base64.urlSafeBase64().decode("L2FwcHMvYnVzaW5lc3NkYXRhL3ZpZGVvcy8xMDAtMDAyLTAwMS95emMxMDkuc3RyZWFtLzIwMTktMDgtMTkvYzZiZjczNjVkM2ZlZGE0ODAzMzcwOTFlZjk2YjE1NzYubXA0"));
        System.out.println(s);
    }
}