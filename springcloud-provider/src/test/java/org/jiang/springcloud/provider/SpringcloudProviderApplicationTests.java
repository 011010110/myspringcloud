package org.jiang.springcloud.provider;

import org.aspectj.lang.annotation.Before;
import org.jiang.springcloud.provider.entity.User;
import org.jiang.springcloud.provider.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringcloudProviderApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private List<User> userList;

    @Test
    void contextLoads() {
        List<User> userList = new ArrayList<>();
        userRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setPassword("111111");
            user.setSex("男");
            userList.add(user);
        }
        userRepository.saveAll(userList);
    }

    @Test
    void saveUserTest() {
        User user = new User();
        user.setName("admin");
        user.setPassword("111111");
        user.setSex("man");
        User save = userRepository.save(user);
        System.out.printf(save.toString());
    }

    @Test
    void finsUsersTest() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.asc("id")));
        Page<User> userPage = userRepository.findAll(pageable);
        userPage.get().forEach(user -> System.out.printf(user.toString()));
    }
}
