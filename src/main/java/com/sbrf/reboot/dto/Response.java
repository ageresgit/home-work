package com.sbrf.reboot.dto;

public class Response {
    private String statusCode;

    public Response() {
        this.statusCode = "";
    }

    public Response(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
