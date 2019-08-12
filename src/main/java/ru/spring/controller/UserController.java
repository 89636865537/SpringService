package ru.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spring.repository.entity.User;
import ru.spring.service.UserService;

import java.util.*;

@RestController
@RequestMapping(value = "/service")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user", params = {"userId"})
    public User getUser(@RequestParam(value = "userId", required = false) Optional<String> id) {
        return userService.getUserById(id);
    }


    @PostMapping(value = "/user/save")
    public List<Long> saveUser(@RequestBody Optional<List<User>> users){
        return  userService.saveAllUsers(users);

    }


}
