package com.sbrf.reboot.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.account.Account;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {
    private HashMap<Long, HashSet<Account>> clientToAccounts;
    private String filePath;

    public AccountRepositoryImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        if (clientToAccounts == null) {
            this.importDataFromJson();
        }
        return clientToAccounts.getOrDefault(clientId, new HashSet<>());
    }

    private void importDataFromJson() throws IOException {
        clientToAccounts =  new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(this.filePath);

        List<AccountParser> apList = objectMapper.readValue(jsonFile, new TypeReference<List<AccountParser>>() {
        });

        for (AccountParser ap : apList) {
            if (ap.getClientId() > 0 && ap.getNumber() != null && !ap.getNumber().isEmpty()) {
                addClientAccount(ap.getClientId(), new Account(ap.getNumber()));
            }
        }
    }

    private void addClientAccount(long clientId, Account account) {
        if (clientToAccounts.containsKey(clientId)) {
            HashSet<Account> accountsSet = clientToAccounts.get(clientId);

            accountsSet.add(account);
        }
        else {
            HashSet<Account> accountsSet = new HashSet<>();
            accountsSet.add(account);
            clientToAccounts.put(clientId, accountsSet);
        }
    }

}
