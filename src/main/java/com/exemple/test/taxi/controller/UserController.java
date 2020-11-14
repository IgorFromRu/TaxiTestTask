package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.model.BankAccount;
import com.exemple.test.taxi.model.User;
import com.exemple.test.taxi.service.BankAccountService;
import com.exemple.test.taxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        final User creatUser = userService.crateUser(user);
        return creatUser != null
                ? new ResponseEntity<>(creatUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") long id){
        return userService.getUser(id) != null
                ? new ResponseEntity<>(userService.getUser(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") long id, @RequestBody User user) {

        return null;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return null;
    }
}
