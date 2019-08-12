package ru.spring.service;

import javassist.bytecode.annotation.IntegerMemberValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.spring.repository.UserRepository;
import ru.spring.repository.entity.User;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ApplicationContext context;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public User getUserById(Optional<String> optionalId) {
        Long id = optionalId.map(Long::parseLong).orElseThrow(() -> {
            log.warn("id is null");
            return new IllegalArgumentException();
        });
        streamService();
        return userRepository.findById(id).get();
    }


    public List<Long> saveAllUsers(Optional<List<User>> inUsers) {

        List<User> users = inUsers.orElse(new ArrayList<User>());
        users.stream().forEach(user -> user.setPassword((String)context.getBean("password")));
        List<Long> usersId = new ArrayList<>();
        userRepository.saveAll(users).forEach((user) -> {
            usersId.add(user.getId());
        });
        return usersId;

    }

    public void streamService(){
//        Stream.of(22, 2, 5, 19, 23, 17).map((x) -> x*2).forEachOrdered(System.out::println);
        Map<String, Integer> map = new HashMap<>();
        map.entrySet().stream();
        String[] array = {"Java", "Ruuuuussshhh"};
        Arrays.stream(array).map((s) -> s.split("")).flatMap((x) -> Arrays.stream(x)).forEach(System.out::println);


        Stream.of(2, 3, 0, 1, 3, 10)
                .flatMapToInt(x -> IntStream.range(0, x))
                .distinct()
                .limit(5)
                .skip(1)
                .peek((x) -> log.info(x + " "))
                .forEach(System.out::println);

    }

}
