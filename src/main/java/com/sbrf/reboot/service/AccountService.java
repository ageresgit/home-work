package com.sbrf.reboot.service;

import com.sbrf.reboot.account.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.io.IOException;
import java.util.Set;

public class AccountService{
    private AccountRepository accountRepository;

    public AccountService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public boolean isAccountExist(long clientId, Account account) throws IOException {
        Set<Account> accountSet = accountRepository.getAllAccountsByClientId(clientId);
        String numberToSearch = account.getAccountNumber();

        boolean numFound = false;
        for(Account repositoryAccount : accountSet) {
            if (repositoryAccount.getAccountNumber().equals(numberToSearch)) {
                numFound = true;
                break;
            }
        }

        return  numFound;
    }
}
