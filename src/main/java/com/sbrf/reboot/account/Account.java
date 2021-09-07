package com.sbrf.reboot.account;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
public class Account implements Comparable<Account> {
    private String accountNumber;
    private LocalDate createDate;
    private BigDecimal balance;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getCreateDate() {
        return  createDate;
    }

    public BigDecimal getBalance() {
        return balance;
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

}
