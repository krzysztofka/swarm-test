package com.kali.ping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PongDiscoveryClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> getServiceInstanceInfo() {
        List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances("PONG-SERVICE");
        return serviceInstances;

    }
}
