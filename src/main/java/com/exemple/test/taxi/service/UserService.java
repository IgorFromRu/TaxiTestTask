package com.exemple.test.taxi.service;

import com.exemple.test.taxi.model.User;

import java.util.List;

public interface UserService {

    User crateUser(User user);

    User getUser(long id);

    User updateUser(long id, User user);

    String deleteUser(long id);

    List<User> getUsers();

}
