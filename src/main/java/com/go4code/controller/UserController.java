package com.go4code.controller;

import com.go4code.dto.UserDTO;
import com.go4code.model.User;
import com.go4code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "api/login")
    public User login(@RequestBody UserDTO userDTO) {
        String userName = userDTO.getUsername();
        String password = userDTO.getPassword();


        User user = userService.findByUsername(userName);
        if (user == null) {
            return null;

        }

        if (!user.getPassword().equals(password)) {
            return null;
        }
        System.out.println(user);
        return user;
    }
}
