package com.saran.SpringSecurityjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String all(){
        return "<h1> welcome all the users";
    }

    @GetMapping("/users")
    public String usersAndAdmin(){
        return "<h1>welcome user or admin</h1>";
    }

    @GetMapping("/admin")
    public String onlyAdmin(){
        return "<h1>welcome admin team</h1>";
    }
}
