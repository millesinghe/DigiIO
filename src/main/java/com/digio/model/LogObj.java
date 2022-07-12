package com.digio.model;

import com.digio.util.AttributesTypes;

public class LogObj {
    private String ip;
    private String method; //Enum
    private String url;
    private String user;
    private String dateTime;
    private Integer response;
    private String fullContent;

    public LogObj(String ip, String method, String url, String user, String dateTime, Integer response, String fullContent) {
        this.ip = ip;
        this.method =method;
        this.url = url;
        this.user = user;
        this.dateTime = dateTime;
        this.response = response;
        this.fullContent = fullContent;
    }

    public String getKey(String type) {
        AttributesTypes attributesType = AttributesTypes.valueOf(type);
        if (attributesType == AttributesTypes.URL) {
            return this.url;
        } else if (attributesType == AttributesTypes.IP) {
            return this.ip;
        } else {
            return fullContent;
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }
}
