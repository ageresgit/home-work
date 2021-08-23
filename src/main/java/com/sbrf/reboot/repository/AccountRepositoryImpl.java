package com.sbrf.reboot.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.account.Account;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    // Методы для примитивного парсинга json как текста getClientId, getAccountNumber, importDataFromFile
    private static long getClientId(String line) {
        long clientId = -1;
        int p1 = line.indexOf(": ");
        if (p1 > 0){
            int p2 = line.indexOf(",", p1 + 2);
            if (p2 > 0) {
                clientId = Long.parseLong(line.substring(p1 + 2, p2));
            }
        }

        return clientId;
    }

    private static String getAccountNumber(String line) {
        String accountNumber = "";
        int p1 = line.indexOf(": ");
        if (p1 > 0) {
            if (line.length() - 1 - (p1 + 3) > 0) {
                accountNumber = line.substring(p1 + 3, line.length() - 1);
            }
        }

        return accountNumber;
    }

    private void importDataFromFile() throws IOException {
        clientToAccounts =  new HashMap<Long, HashSet<Account>>();
        boolean foundClient = false;
        long clientId = -1;
        for (String nextLine: Files.readAllLines(Paths.get(this.filePath))) {
            if (foundClient) {
                foundClient = false;
                if (nextLine.contains("number") && clientId > 0) {
                    String accountNumber =getAccountNumber(nextLine);
                    if (!accountNumber.isEmpty()) {
                        Account account = new Account(accountNumber);
                        if (clientToAccounts.containsKey(clientId)) {
                            HashSet<Account> accountsSet = clientToAccounts.get(clientId);

                            if (!accountsSet.contains(account)) {
                                accountsSet.add(account);
                            }
                        }
                        else {
                            HashSet<Account> accountsSet = new HashSet<Account>();
                            accountsSet.add(account);
                            clientToAccounts.put(clientId, accountsSet);
                        }
                    }
                }

            }
            else {
                if (nextLine.contains("clientId")) {
                    foundClient = true;
                    clientId = getClientId(nextLine);
                }
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
