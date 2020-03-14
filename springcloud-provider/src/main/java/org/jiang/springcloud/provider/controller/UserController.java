package org.jiang.springcloud.provider.controller;

import org.jiang.springcloud.provider.entity.User;
import org.jiang.springcloud.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/9
 * @Version 1.0
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("add")
    public User add(User user){
        User save = userRepository.save(user);
        return save;
    }

    @RequestMapping("{id}")
    public User get(@PathVariable(name = "id") String id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @RequestMapping("list")
    public List<User> list(){
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(user -> userList.add(user));
        return userList;
    }

    @RequestMapping("update")
    public void update(User user){
        User save = userRepository.save(user);
    }
}
