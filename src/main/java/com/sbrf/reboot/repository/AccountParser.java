package com.sbrf.reboot.repository;

public class AccountParser {
    private long clientId;
    private String number;

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getClientId() {
        return clientId;
    }

    public String getNumber() {
        return number;
    }
}
