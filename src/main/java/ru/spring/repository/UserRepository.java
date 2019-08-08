package ru.spring.controller;

import org.springframework.data.repository.CrudRepository;
import ru.spring.controller.data.User;

public interface UserRepoApi extends CrudRepository<User,String> {
}
