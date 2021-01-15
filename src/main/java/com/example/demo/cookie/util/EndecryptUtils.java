package com.example.demo.cookie.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EndecryptUtils {

    /**
     * 生成加密后的字符串
     *
     * @param raw
     * @param hashAlgorithm
     * @param length
     * @return
     */
    public static String hash(String raw, String hashAlgorithm, int length) {
        String hstring = hash(raw, hashAlgorithm);
        if (length < hstring.length()) {
            return hstring.substring(0, length);
        } else {
            return hstring;
        }
    }

    /**
     * 字符串装byte数组，通过MD5 加密，生成新的加密后的字符串；
     *
     * @param raw
     * @param hashAlgorithm
     * @return
     */
    public static String hash(String raw, String hashAlgorithm) {
        try {
            byte stringBytes[] = raw.getBytes();
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            md.reset();
            md.update(stringBytes);
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String hash(String raw, String hashAlgorithm, Base64 base64Encoder) {
        try {
            byte stringBytes[] = raw.getBytes();
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            md.reset();
            md.update(stringBytes);
            return base64Encoder.encode(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * byte数组转16 进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(EndecryptUtils.hash("le_ocean", "MD5", 5));
    }
}
