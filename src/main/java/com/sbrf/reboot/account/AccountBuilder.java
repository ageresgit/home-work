package com.sbrf.reboot.account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class AccountBuilder {
    private String accountNumber;
    private LocalDate createDate;
    private BigDecimal balance;
    private long id;
    private long clientId;

    private AccountBuilder() {
        accountNumber = "";
        createDate = LocalDate.now();
        balance = BigDecimal.ZERO;
        id = 0;
        clientId = 0;
    }

    public static AccountBuilder empty() {
        return new AccountBuilder();
    }

    public AccountBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public AccountBuilder balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder id(long id) {
        this.id = id;
        return this;
    }

    public AccountBuilder clientId(long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Account build() {
        return new Account(accountNumber, createDate, balance, id, clientId);
    }
}
