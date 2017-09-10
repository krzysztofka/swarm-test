package com.kali.ping.controller;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PingController {

    @Autowired
    private PongEurekaDiscoveryClientService pongDiscoveryClientService;

    @Autowired
    private PongClient pongClient;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String pingMessage() {
        return pongDiscoveryClientService.pong();
    }

    @RequestMapping(value = "/ping-info", method = RequestMethod.GET)
    public InstanceInfo pingInfoMessage() {
        return pongDiscoveryClientService.getServiceInstanceInfo();
    }

}
