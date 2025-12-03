package com.hifi.util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String hash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] arr = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : arr) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed");
        }
    }
}
