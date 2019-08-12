package ru.spring.runner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.spring.config.RootConfig;
import ru.spring.repository.UserRepository;
import ru.spring.service.UserService;

import java.util.Arrays;

//@SpringBootApplication(scanBasePackages = {"ru.spring.service", "ru.spring.controller","ru.spring.config", "ru.spring.repository"})

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {RootConfig.class})
public class Application {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).sorted(String::compareTo).forEach(System.out::println);
    }
}
