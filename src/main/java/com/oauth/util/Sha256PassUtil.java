package com.oauth.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class Sha256PassUtil implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        String encoded;
        try {
            encoded = Sha256Util.encode(charSequence.toString());
        } catch (RuntimeException | NoSuchAlgorithmException d) {
            encoded = "";
        }
        return encoded;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return this.encode(charSequence.toString()).equals(s);
    }
}
