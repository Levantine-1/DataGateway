package com.levantine.datagateway;

import com.levantine.datagateway.PerconaCluster.TokenRepository;
import com.levantine.datagateway.PerconaCluster.auth_token;
import com.levantine.datagateway.analytics.PortfolioAnalyticsDTO;
import com.levantine.datagateway.analytics.PortfolioAnalyticsDataRepository;
import com.levantine.datagateway.analytics.PortfolioAnalyticsEntity;
import org.apache.catalina.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    @Autowired
    private PortfolioAnalyticsDataRepository portfolioAnalyticsDataRepository;

    @PostMapping("/analytics")
    public ResponseEntity<Void> analytics(@RequestBody PortfolioAnalyticsDTO requestDTO) {
        PortfolioAnalyticsEntity entity = new PortfolioAnalyticsEntity();
        entity.setIpAddr(requestDTO.getIpAddr());
        entity.setTimedate(requestDTO.getTimedate());
        entity.setRequest(requestDTO.getRequest());
        entity.setGeoLocation(requestDTO.getGeoLocation());
        entity.setUserAgent(requestDTO.getUserAgent());

        portfolioAnalyticsDataRepository.save(entity);

        return ResponseEntity.noContent().build();
    }

}
