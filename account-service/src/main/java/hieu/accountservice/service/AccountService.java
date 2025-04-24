package hieu.accountservice.service;

import hieu.accountservice.entity.Account;
import hieu.accountservice.entity.User;

public interface AccountService {
    Account findByName(String name);
    Account create(User user);
    void saveChanges(String name, Account account);
}
