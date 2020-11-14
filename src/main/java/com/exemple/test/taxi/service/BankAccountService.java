package com.exemple.test.taxi.service;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.User;

import java.util.List;

public interface BankAccountService {

    BankAccount createAccount(long userId);

    BankAccount getAccount( long id);

    void deleteAccount(long id);

    List<BankAccount> getBankAccountsByUser(long userId);

}
