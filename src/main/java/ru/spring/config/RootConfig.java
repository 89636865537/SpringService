package ru.spring.config;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.spring.controller.UserController;
import ru.spring.repository.UserRepository;
import ru.spring.repository.entity.User;
import ru.spring.service.UserService;

import javax.persistence.Entity;

@ComponentScan(basePackageClasses = {UserService.class, UserRepository.class, ru.spring.repository.entity.User.class, UserController.class})
@EnableJpaRepositories(basePackages = "ru.spring.repository")
@EntityScan(basePackages = "ru.spring.repository.entity")
@Configuration
public class RootConfig {

    @Bean(name = "password")
    public String generatePassword() {
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
                .build();
        return pwdGenerator.generate(10);
    }


}
