package com.beta.replyservice.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyServiceUtilsTest {

    @Test
    public void shouldSplitFeatureAndString(){
        String[] result = ReplyServiceUtils.parseAndValidateRequest("11-abcd123");
        Assertions.assertEquals("11", result[0]);
        Assertions.assertEquals("abcd123", result[1]);
    }

    @Test
    public void shouldSupportBackwardCompatibility(){
        String[] result = ReplyServiceUtils.parseAndValidateRequest("abcd123");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals("abcd123", result[0]);
    }

    @Test
    public void shouldThrowErrorWhenIncorrectRequestFormat(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ReplyServiceUtils.parseAndValidateRequest("11-abc-11"));

    }

    @Test
    public void shouldThrowErrorWhenOnlyOneRule(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ReplyServiceUtils.parseAndValidateRequest("1-abc"));
    }

    @Test
    public void shouldThrowErrorWhenMoreThanTwoRules(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ReplyServiceUtils.parseAndValidateRequest("121-abc"));
    }
}
