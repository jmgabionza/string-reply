package com.beta.replyservice.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeatureFactoryTest {

    @Autowired
    FeatureFactory factory;

    @Test
    public void shouldReturnStringReverseFeature() throws IllegalAccessException {
        Feature result = factory.getFeature(1);
        Assertions.assertTrue(result instanceof StringReverseFeature);
    }

    @Test
    public void shouldReturnStringToMD5Feature() throws IllegalAccessException {
        Feature result = factory.getFeature(2);
        Assertions.assertTrue(result instanceof StringToMD5Feature);
    }

    @Test()
    public void shouldThrowException() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factory.getFeature(0));
    }

}
