package com.levantine.datagateway;

import com.levantine.datagateway.PerconaCluster.TokenRepository;
import com.levantine.datagateway.PerconaCluster.auth_token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticatedController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedController.class);

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/listTokens")
    public Iterable<auth_token> getTokens() {
        return tokenRepository.findAll();
    }

    @GetMapping("/amIAGoodMouse")
    public static Object mouse_message() {
        String[] responses = {"You are a very good mouse.",
                                "You are a good mouse.",
                                "You are an OK mouse.",
                                "You are a bad mouse.",
                                "You are a very bad mouse."};
        return responses[(int) (Math.random() * responses.length)];
    }

}
