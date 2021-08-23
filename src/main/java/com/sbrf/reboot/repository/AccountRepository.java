package com.sbrf.reboot.repository;

import com.sbrf.reboot.account.Account;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {

    Set<Account> getAllAccountsByClientId(long clientId) throws IOException;

}