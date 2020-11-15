package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.dto.CreateBankAccountRequest;
import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody CreateBankAccountRequest createBankAccountRequest) {
        BankAccount account = bankAccountService.createAccount(createBankAccountRequest.getUserId());
        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable(name = "id") long id) {
        BankAccount account = bankAccountService.getAccount(id);
        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "id") long id) {
        String deleteAccount = bankAccountService.deleteAccount(id);
        return deleteAccount != null
                ? new ResponseEntity<>(deleteAccount, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getBankAccountsByUser(@RequestParam(name = "user_id") long userId) {
        List<BankAccount> bankAccountsByUser = bankAccountService.getBankAccountsByUser(userId);
        return bankAccountsByUser != null
                ? new ResponseEntity<>(bankAccountsByUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
