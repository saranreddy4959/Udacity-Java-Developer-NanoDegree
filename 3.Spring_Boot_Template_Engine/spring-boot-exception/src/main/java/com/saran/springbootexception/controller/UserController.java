package com.saran.springbootexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/add")
    public String add(){
        int num = 10/0;
        return "num";
    }

    @RequestMapping("/update")
    public String update(){
        String name = null;
        name = name.toLowerCase();
        return "update";
    }


   /* @ExceptionHandler(value={java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e.toString());
        mav.setViewName("mathError");
        return mav;
    }

    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView handlerNullPointerException(Exception e){
        ModelAndView m = new ModelAndView();
        m.addObject("exception",e.toString());
        m.setViewName("nullPointerError");
        return m;
    }*/
}
