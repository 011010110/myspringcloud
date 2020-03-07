package org.jiang.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/8
 * @Version 1.0
 */
@RefreshScope
@RestController
public class HelloController {

    @Value("${message:hello default!}")
    private String message;

    @RequestMapping("/message")
    public String message() {
        return message;
    }
}
