package com.example.limit_service.controller;

import com.example.limit_service.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/limit")
public class LimitController {
    @Autowired
    private LimitConfiguration configuration;

    @GetMapping("/limits")
    public LimitConfiguration getLimt(){
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
