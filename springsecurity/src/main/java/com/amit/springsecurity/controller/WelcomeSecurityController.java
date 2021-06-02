package com.amit.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeSecurityController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to spring security";
    }
}
