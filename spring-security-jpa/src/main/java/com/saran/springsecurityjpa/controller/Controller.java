package com.saran.springsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/")
    public String forAllUsers(){

        return "<h1>Welcome Users</h1>";
    }

    @GetMapping("/users")
    public String users(){
        return "<h1>Welcome users and admins</h1>";
    }

    @GetMapping("/admin")
    public String admin(){

        return "<h1>Welocme  admin</h1>";
    }
}
