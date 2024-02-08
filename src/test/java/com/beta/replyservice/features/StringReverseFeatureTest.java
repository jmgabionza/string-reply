package com.beta.replyservice.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringReverseFeatureTest {

    @Autowired()
    @Qualifier("stringReverseFeature")
    private Feature feature;

    @Test
    public void shouldReverseString(){
        String result = (String) feature.execute("test");
        Assertions.assertEquals("tset", result);
    }

    @Test
    public void shouldHandleNullString(){
        String result = (String) feature.execute(null);
        Assertions.assertEquals("", result);
    }

    @Test
    public void shouldHandleEmptyString(){
        String result = (String) feature.execute("");
        Assertions.assertEquals("", result);
    }
}
