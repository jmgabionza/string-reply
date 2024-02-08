package com.beta.replyservice.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * ALL FEATURES MUST BE ADDED IN THIS FACTORY!
 */
@Component
public class FeatureFactory {

    @Autowired
    @Qualifier("stringReverseFeature")
    private Feature stringReverseFeature;

    @Autowired
    @Qualifier("stringToMD5Feature")
    private Feature stringToMD5Feature;

    public Feature getFeature(int featureNumber) throws IllegalArgumentException {
        switch (featureNumber){
            case 1:
                return stringReverseFeature;
            case 2:
                return stringToMD5Feature;
            default:
                throw new IllegalArgumentException("Unsupported Feature");
        }
    }
}
