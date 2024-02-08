package com.beta.replyservice.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringToMD5FeatureTest {

    @Autowired
    @Qualifier("stringToMD5Feature")
    private Feature feature;

    @Test
    public void shouldReturnHex(){
        String result = (String) feature.execute("kbzw9ru");
        Assertions.assertEquals("0fafeaae780954464c1b29f765861fad", result);
    }

    @Test
    public void shouldHandleNullString(){
        String result = (String) feature.execute(null);
        Assertions.assertEquals("", result);
    }

    @Test
    public void shouldHandleEmptyString(){
        String result = (String) feature.execute("");
        Assertions.assertEquals("d41d8cd98f00b204e9800998ecf8427e", result);
    }
}
