package com.levantine.datagateway.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioAnalyticsService {

    @Autowired
    private PortfolioAnalyticsDataRepository repository;

    public void saveAnalyticsData(PortfolioAnalyticsRequest request) {
        PortfolioAnalyticsEntity data = new PortfolioAnalyticsEntity();
        // Convert request to data entity and set properties
        data.setIpAddr(request.getIpAddr());
        data.setTimedate(request.getTimedate());
        data.setRequest(request.getRequest());
        data.setGeoLocation(request.getGeoLocation());
        data.setUserAgent(request.getUserAgent());
        repository.save(data);
    }
}