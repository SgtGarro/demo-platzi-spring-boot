package com.demo.demo_platzi.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloWorldController {

    @GetMapping("/hello")
    public String greeting() {
        return "Hello world. Never stop learning! 🚀";
    }
}
