package com.levantine.datagateway.analytics;

import javax.persistence.*;

@Entity
@Table(name = "portfolio_analytics")
public class PortfolioAnalyticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ip_addr")
    private String ipAddr;

    @Column(name = "timedate")
    private String timedate;

    @Column(name = "request")
    private String request;

    @Column(name = "geo_location")
    private String geoLocation;

    @Column(name = "user_agent")
    private String userAgent;

    // Implement setter methods
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    // Consider adding getter methods as well
}