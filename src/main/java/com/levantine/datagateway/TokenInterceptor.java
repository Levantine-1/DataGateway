package com.levantine.datagateway;

import com.levantine.datagateway.PerconaCluster.TokenRepository;
import com.levantine.datagateway.PerconaCluster.auth_token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedController.class);

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        String tokenHash = auth_token.hashify(token);
        auth_token authToken = tokenRepository.findByTokenHash(tokenHash);

        if (authToken == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        return true;
    }
}