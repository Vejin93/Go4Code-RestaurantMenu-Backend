package com.go4code.service;

import com.go4code.data.UserRepository;
import com.go4code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }
}
