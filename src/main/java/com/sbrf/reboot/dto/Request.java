package com.sbrf.reboot.dto;

public class Request {
    private String atmNumber;

    public Request(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public Request() {
        this.atmNumber = "";
    }

    public String getAtmNumber() {
        return atmNumber;
    }

    public void setAtmNumber(String atmNumber) {
        this.atmNumber = atmNumber;
    }
}
