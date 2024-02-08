package com.beta.replyservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    ReplyService service;

    @Test
    public void shouldReturnSameString(){
        String result = service.processRequest("abc");
        Assertions.assertEquals("abc", result);

        result = service.processRequest("11-abc");
        Assertions.assertEquals("abc", result);
    }

    @Test
    public void shouldReverseAndHex(){
        String result = service.processRequest("12-kbzw9ru");
        Assertions.assertEquals("5a8973b3b1fafaeaadf10e195c6e1dd4", result);
    }

    @Test
    public void shouldHexAndHex(){
        String result = service.processRequest("22-kbzw9ru");
        Assertions.assertEquals("e8501e64cf0a9fa45e3c25aa9e77ffd5", result);
    }

    @Test
    public void shouldRaiseError(){
        String result = service.processRequest("223-kbzw9ru");
        Assertions.assertEquals("ERROR - Rules MUST always contain two numbers!", result);
    }
}
