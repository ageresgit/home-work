package com.sbrf.reboot.service;

import java.util.Set;

public class AccountService extends basicAccountService{
    private AccountRepository accountRepository;

    public AccountService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    @Override
    public boolean isAccountExist(long clientId, Account account) {
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
