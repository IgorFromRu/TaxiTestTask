package com.exemple.test.taxi.service;

import com.exemple.test.taxi.model.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccount createAccount(long userId);

    BankAccount getAccount(long id);

    String deleteAccount(long id);

    List<BankAccount> getBankAccountsByUser(long userId);

}
