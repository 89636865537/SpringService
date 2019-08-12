package ru.spring.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.spring.repository.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
