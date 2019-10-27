package com.saran.springbootwebsocket.controller;


import com.saran.springbootwebsocket.model.User;
import com.saran.springbootwebsocket.model.UserResponse;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user){
        return new UserResponse("Hello, "+user.getName());
    }
}
