package com.sbrf.reboot.account;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

@EqualsAndHashCode
@ToString
public class Account implements Comparable<Account> {
    private String accountNumber;
    private LocalDate createDate;
    private BigDecimal balance;
    private long id = 0;
    private long clientId = 0;

    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        createDate = LocalDate.now();
        balance = BigDecimal.ZERO;
    }

    public Account(String accountNumber, LocalDate createDate, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.createDate = createDate;
        this.balance = balance;
    }

    public Account(String accountNumber, LocalDate createDate, BigDecimal balance, long id, long clientId) {
        this.accountNumber = accountNumber;
        this.createDate = createDate;
        this.balance = balance;
        this.id = id;
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public long getClientId() {
        return clientId;
    }

    @Override
    public int compareTo(Account o) {
        int result = accountNumber.compareTo(o.getAccountNumber());
        if (result == 0) {
            result = createDate.compareTo(o.getCreateDate());
            if (result == 0) {
                result = balance.compareTo(o.getBalance());
            }
        }

        return result;
    }

    public static AccountBuilder builder() {
        return AccountBuilder.empty();
    }

    public boolean isCreatedAfter(LocalDate minCreateDate) {
        return (createDate.compareTo(minCreateDate) >= 0);
    }
}
