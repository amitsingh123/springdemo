package com.amit.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/accounts")
    public String getAccountDetails(){
        return "Account no is 122331155";
    }
}
