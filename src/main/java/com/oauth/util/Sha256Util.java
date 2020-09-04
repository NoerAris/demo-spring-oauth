package com.oauth.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Util {

    private static Sha256Util hashing = new Sha256Util();

    public static Sha256Util getInstance() {
        return hashing;
    }

    public static String encode(String text) throws NoSuchAlgorithmException {
        return getInstance().get(text);
    }

    public String get(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] xbyte = digest.digest();
        StringBuilder build = new StringBuilder();
        for (int x = 0; x < xbyte.length; x++) {
            build.append(Integer.toString((xbyte[x] & 0xff) + 0x100, 16).substring(1));
        }
        return build.toString();
    }
}
