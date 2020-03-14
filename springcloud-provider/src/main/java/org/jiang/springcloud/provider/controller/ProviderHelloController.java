package org.jiang.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author li.linhua
 * @Date 2020/3/8
 * @Version 1.0
 */
@RefreshScope
@RestController
public class ProviderHelloController {

    @Value("${message:hello default!}")
    private String message;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取中心配置属性
     * @return
     */
    @RequestMapping("/message")
    public String message() {
        return message;
    }

    /**
     * 获取注册中心实例
     * @param applicationName
     * @return
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
    @RequestMapping("/service-instances/escription")
    public List<String> getDescription(){
        List<String> services = this.discoveryClient.getServices();
        return services;
    }

    @RequestMapping("queryServices")
    public Map<String,Object> queryServices(){
        Map<String, Object> result = new HashMap<>();
        List<ServiceInstance> instances = this.discoveryClient.getInstances("springcloud-provider-hello");
        result.put("instances",instances);
        return result;
    }
}
