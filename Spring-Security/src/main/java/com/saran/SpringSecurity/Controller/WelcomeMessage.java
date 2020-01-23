package com.saran.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessage {

    @GetMapping("/")
    public String welcome(){

        return "<h1>Welcome Saran</h1>";
    }

    @GetMapping("/user")
    public String user(){

        return "<h1>Welcome user Saran</h1>";
    }

    @GetMapping("/admin")
    public String admin(){

        return "<h1>Welcome Admin Rahul</h1>";
    }
}
