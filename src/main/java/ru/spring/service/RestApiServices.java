package ru.spring.service;


import org.springframework.web.bind.annotation.*;
import ru.spring.service.data.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/service")
public class RestApiServices {

    @GetMapping(value = "/user", params = {"userId", "login", "password"})
    public User getUser(@RequestParam(value = "userId", required = false) String id, @RequestParam(name = "login", required = false) String login, @RequestParam(name = "password", required = false) String password) {
        System.out.println("userId : " + id);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        System.out.println("user : " + user);
        return user;
    }


    @PostMapping(value = "/user/save")
    public Boolean saveUser(@RequestBody List<User> users){
        Stream<User> userStream = Optional.of(users)
                                                .map(Collection:: stream)
                                                .orElseGet(Stream::empty);

        userStream.forEach(System.out::println);
        return true;

    }


}
