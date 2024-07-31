package com.levantine.datagateway.analytics;

public class PortfolioAnalyticsRequest {
    private String ipAddr;
    private String timedate;
    private String request;
    private String geoLocation;
    private String userAgent;

    // Getters and Setters
    public String getIp_addr() {
        return ipAddr;
    }

    public void setIp_addr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}