package com.exemple.test.taxi.service.impl;

import com.exemple.test.taxi.model.User;
import com.exemple.test.taxi.repository.UserRepository;
import com.exemple.test.taxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User crateUser(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not found."));
    }

    @Override
    @Transactional
    public User updateUser(long id, User user) {
        User dbUser = getUser(id);
        dbUser.setName(user.getName());
        return dbUser;
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
