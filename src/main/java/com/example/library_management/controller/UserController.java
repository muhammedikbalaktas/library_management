package com.example.library_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management.dao.UserDao;
import com.example.library_management.model.User;
import com.example.library_management.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User controllerGetUserById(@PathVariable Long id){

        return userService.serviceGetUserById(id);
    }

    @GetMapping("/all")
    public List<User> controllerGetAllUser(){
        return userService.serviceGetAllUsers();
    }
    
    @PostMapping
    public User controllerCreateUser(@RequestBody UserDao userDao){

        return userService.serviceCreateUser(userDao);
    }

    
}
