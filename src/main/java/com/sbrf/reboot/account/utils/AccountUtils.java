package com.sbrf.reboot.account.utils;

import com.sbrf.reboot.account.Account;

import java.util.*;

public class AccountUtils {
    public static void sortedById(List<Account> accountList) {
        Comparator<Account> compareById  = (o1, o2) -> o1.getAccountNumber().compareTo(o2.getAccountNumber());

        accountList.sort(compareById);
    }

    public static void sortedByIdDate (List<Account> accountList) {
        Comparator<Account> compareByIdDate  = new Comparator<Account>(){
            @Override
            public int compare(Account o1, Account o2) {
                int result = o1.compareTo(o2);
                return (result != 0)? result : o1.getCreateDate().compareTo(o2.getCreateDate());
            }
        };

        accountList.sort(compareByIdDate);
    }

    public static void sortedByIdDateBalance(List<Account> accountList) {
        Collections.sort(accountList);
    }
}
