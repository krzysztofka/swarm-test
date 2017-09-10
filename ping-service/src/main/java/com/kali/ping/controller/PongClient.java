package com.kali.ping.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pong-service")
public interface PongClient {

    @RequestMapping(method = RequestMethod.GET, value = "message")
    String getMessage();
}
