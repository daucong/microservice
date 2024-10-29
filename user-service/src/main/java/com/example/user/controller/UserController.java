package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    Environment environment;

    @GetMapping("")
    public List<User> list() {
        return userService.getAllUser();
    }

    @PostMapping("")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }


}