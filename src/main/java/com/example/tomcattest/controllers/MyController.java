package com.example.tomcattest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/askUserDetails")
    public String askUserName(){
        return "ask-user-details-view";
    }

    @RequestMapping("/showUserDetails")
    public  String showUserName(){
        return "show-user-details-view";
    }
}
