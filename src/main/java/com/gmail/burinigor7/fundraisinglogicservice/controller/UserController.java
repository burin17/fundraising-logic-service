package com.gmail.burinigor7.fundraisinglogicservice.controller;

import com.gmail.burinigor7.fundraisinglogicservice.model.User;
import com.gmail.burinigor7.fundraisinglogicservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getSelfProfileInfo(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/isInvestor")
    public boolean isInvestor(@RequestParam String username, @RequestParam Long fpId) {
        return userService.isInvestor(username, fpId);
    }
}
