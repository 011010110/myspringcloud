package org.jiang.springcloud.consumer.controller;

import org.jiang.springcloud.consumer.entity.User;
import org.jiang.springcloud.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/9
 * @Version 1.0
 */
@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public User add(User user){
        User save = userService.add(user);
        return save;
    }

    @RequestMapping("{id}")
    public User get(@PathVariable(name = "id") String id){
        return userService.get(id);
    }

    @RequestMapping("list")
    public List<User> list(){
        Iterable<User> users = userService.list();
        List<User> userList = new ArrayList<>();
        users.forEach(user -> userList.add(user));
        return userList;
    }

    @RequestMapping("update")
    public void update(User user){
        userService.update(user);
    }
}
