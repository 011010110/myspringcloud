package org.jiang.springcloud.consumer.service;

import org.jiang.springcloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/9
 * @Version 1.0
 */
@Service
@RequestMapping("user")
@FeignClient("springcloud-provider-hello")
public interface UserService {
    @RequestMapping("add")
    public User add(User user);
    @RequestMapping("{id}")
    public User get(@PathVariable(name = "id") String id);
    @RequestMapping("list")
    public List<User> list();
    @RequestMapping("update")
    public void update(User user);
}
