package com.exemple.test.taxi.service.impl;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.User;
import com.exemple.test.taxi.repository.AccountRepository;
import com.exemple.test.taxi.service.BankAccountService;
import com.exemple.test.taxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Override
    public BankAccount createAccount(long userId) {
        User user = userService.getUser(userId);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUser(user);
        bankAccount.setNumberCard(UUID.randomUUID().toString());
        bankAccount.setBalance(0);
        accountRepository.save(bankAccount);
        bankAccount.getUser().setBankAccounts(null);
        return bankAccount;
    }

    @Override
    public BankAccount getAccount(long id) {
        BankAccount bankAccount = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account is not found."));
        bankAccount.getUser().setBankAccounts(null);
        return bankAccount;
    }

    @Override
    public String deleteAccount(long id) {
        accountRepository.deleteById(id);
        return "Account deleted";
    }

    @Override
    public List<BankAccount> getBankAccountsByUser(long userId) {
        User user = userService.getUser(userId);
        List<BankAccount> bankAccounts = accountRepository.findByUser(user);
        bankAccounts.forEach(bankAccount -> bankAccount.getUser().setBankAccounts(null));
        return bankAccounts;
    }
}
