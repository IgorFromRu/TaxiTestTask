package com.exemple.test.taxi.controller;

import com.exemple.test.taxi.model.User;
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

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        final User creatUser = userService.crateUser(user);
        return creatUser != null
                ? new ResponseEntity<>(creatUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") long id) {
        return userService.getUser(id) != null
                ? new ResponseEntity<>(userService.getUser(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") long id, @RequestBody User user) {
        User userUpdate = userService.updateUser(id, user);
        return userUpdate != null
                ? new ResponseEntity<>(userUpdate, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        String deleteUser = userService.deleteUser(id);
        return deleteUser != null
                ? new ResponseEntity<>(deleteUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> usersList = userService.getUsers();
        return usersList != null
                ? new ResponseEntity<>(usersList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
