package com.beta.replyservice.utils;

import org.springframework.stereotype.Component;

@Component
public class ReplyServiceUtils {

    public static String[] parseAndValidateRequest(String request) throws IllegalArgumentException {
        String[] result =  request.split("-");

        if (result.length > 2){
            throw new IllegalArgumentException("Incorrect request format!");
        }

        if (result.length > 1 && result[0].length() != 2){
            throw new IllegalArgumentException("Rules MUST always contain two numbers!");
        }

        return result;
    }
}
