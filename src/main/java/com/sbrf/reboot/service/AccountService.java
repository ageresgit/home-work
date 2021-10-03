package com.sbrf.reboot.service;

import com.sbrf.reboot.account.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Account getMaxAccountBalance(long clientId) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).stream().max(Comparator.comparing(Account::getBalance)).get();
    }


    public Set<Account> getAllAccountsByDateMoreThen(long clientId, LocalDate minCreateDate) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).stream().filter(x->x.isCreatedAfter(minCreateDate)).collect(Collectors.toSet());
    }

    public BigDecimal getTotalBalanceByClient(long clientId) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).stream().map(Account::getBalance).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
