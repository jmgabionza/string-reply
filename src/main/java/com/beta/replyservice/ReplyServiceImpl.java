package com.beta.replyservice;

import com.beta.replyservice.features.FeatureFactory;
import com.beta.replyservice.utils.ReplyServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    FeatureFactory featureFactory;

    @Override
    public String processRequest(String request){
        try {
            String[] parsedRequest = ReplyServiceUtils.parseAndValidateRequest(request);

            // for backward compatibility
            if (parsedRequest.length == 1){
                return parsedRequest[0];
            }

            String features = parsedRequest[0].trim();
            String input = parsedRequest[1];

            for (int i = 0; i < features.length(); i++){
                int featureNumber = Integer.parseInt(String.valueOf(features.charAt(i)));
                input = (String) featureFactory.getFeature(featureNumber).execute(input);

            }
            return input;

        } catch (IllegalArgumentException e) {
            return "ERROR - " + e.getMessage();
        }
    }
}
