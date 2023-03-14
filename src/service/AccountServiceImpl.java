package service;

import entity.Account;
import service.interfaces.AccountService;

import java.util.List;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account save(List<Account> list, Account account) {
        account.generateAccountNumber(list);
        account.setAccountIdentifier(UUID.randomUUID());
        list.add(account);
        return account;
    }

    @Override
    public Account updade(List<Account> list, Account account) {
        return null;
    }

    @Override
    public Void deleteById(List<Account> list, UUID id) {
        return null;
    }
}
