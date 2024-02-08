package com.beta.replyservice.features;

import org.springframework.stereotype.Component;

@Component("stringReverseFeature")
public class StringReverseFeature implements Feature{

    @Override
    public String execute(Object param) {
        if (param == null){
            return "";
        }

        String str = (String) param;
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
