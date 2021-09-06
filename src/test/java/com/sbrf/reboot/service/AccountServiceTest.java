package com.sbrf.reboot.service;

import com.sbrf.reboot.account.Account;
import com.sbrf.reboot.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    void bookExist() throws IOException {
        Account account = new Account("ACC1234NUM");
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() throws IOException {
        Set<Account> accounts = new HashSet<>();
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }
}