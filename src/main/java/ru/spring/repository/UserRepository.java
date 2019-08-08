package ru.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spring.repository.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
