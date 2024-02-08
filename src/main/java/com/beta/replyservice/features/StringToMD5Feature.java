package com.beta.replyservice.features;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component("stringToMD5Feature")
public class StringToMD5Feature implements Feature{
    @Override
    public Object execute(Object param) {
        if (param == null){
            return "";
        }

        String input = (String) param;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : messageDigest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
