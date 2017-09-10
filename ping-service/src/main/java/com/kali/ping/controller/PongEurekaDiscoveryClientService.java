package com.kali.ping.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PongEurekaDiscoveryClientService {

    private static final Logger LOG = LoggerFactory.getLogger(PongEurekaDiscoveryClientService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private EurekaClient discoveryClient;

    public InstanceInfo getServiceInstanceInfo() {
        InstanceInfo serviceInstance = this.discoveryClient.getNextServerFromEureka("PONG-SERVICE", false);
        return serviceInstance;
    }


    public String pong() {
        InstanceInfo instanceInfo = getServiceInstanceInfo();

        LOG.info("# Calling: " + instanceInfo.getHomePageUrl());

        String url = instanceInfo.getHomePageUrl() + "message";

        return restTemplate.getForObject(url, String.class);

    }
}
