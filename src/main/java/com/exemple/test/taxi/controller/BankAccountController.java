package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.dto.CreateBankAccountRequest;
import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("accounts")
public class BankAccountController {

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody CreateBankAccountRequest createBankAccountRequest) {

        return null;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getAccount(@PathVariable(name = "id") long id){
        return null;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<User> deleteAccount(@PathVariable(name = "id") long id){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getBankAccountsByUser(@RequestParam(name = "user_id") long userId){
        return null;
    }
}
