package com.kali.pong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;

@RestController
public class PongController {

    private static final Logger LOG = LoggerFactory.getLogger(PongController.class);


    @Value("${reply.message}")
    String replyMessage;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String pongMessage() {
        try {
            LOG.info("# Pong from: " + Inet4Address.getLocalHost().getHostAddress());
        } catch (Exception e) {
            LOG.error("Unknown host");
        }

        return replyMessage;
    }
}
