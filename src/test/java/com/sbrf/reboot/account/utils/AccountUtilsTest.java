package com.sbrf.reboot.account.utils;

import com.sbrf.reboot.account.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class AccountUtilsTest {
    List<Account> accountList;
    final LocalDate year2010 = LocalDate.of(2010, 1, 1);
    final LocalDate year2000 = LocalDate.of(2000, 1, 1);

    @BeforeEach
    void setCollection() {
        accountList = new ArrayList<>();
        accountList.add(new Account("9-000", LocalDate.now(), BigDecimal.ZERO));
        accountList.add(new Account("2-000", year2010, BigDecimal.TEN));
        accountList.add(new Account("2-000", year2010, BigDecimal.ONE));
        accountList.add(new Account("1-000", LocalDate.now(), BigDecimal.ZERO));
        accountList.add(new Account("2-000", year2000, BigDecimal.TEN));
    }

    @Test
    void sortedById() {
        AccountUtils.sortedById(accountList);
        Assertions.assertEquals("1-000", accountList.get(0).getAccountNumber());
    }

    @Test
    void sortedByIdDate() {
        AccountUtils.sortedByIdDate(accountList);
        Assertions.assertEquals(accountList.get(1).getCreateDate(), year2000);
    }

    @Test
    void sortedByIdDateBalance() {
        AccountUtils.sortedByIdDateBalance(accountList);
        Assertions.assertEquals(accountList.get(2).getBalance(), BigDecimal.ONE);
    }
}
