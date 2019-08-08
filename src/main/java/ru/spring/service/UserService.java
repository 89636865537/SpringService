package ru.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.repository.UserRepository;
import ru.spring.repository.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public Optional<User> getUserById(Optional<String> optionalId) {
        Long id = optionalId.map(Long::parseLong).orElseThrow(() -> {
            log.warn("id is null");
            return new IllegalArgumentException();
        });

        return Optional.of(userRepository.findById(id))
                .orElseThrow(IllegalArgumentException::new);
    }


    public Optional<List<Long>> saveAllUsers(Optional<List<User>> inUsers) {

        List<User> users = inUsers.orElse(new ArrayList<User>());
        List<Long> usersId = new ArrayList<>();
        userRepository.saveAll(users).forEach((user) -> {
            usersId.add(user.getId());
        });
        return Optional.of(usersId);

    }
}
