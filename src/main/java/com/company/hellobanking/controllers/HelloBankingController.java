package com.company.hellobanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloBanking {

    @GetMapping
    @ResponseBody
    public String hello(){
      return "Hello Banking";
    }

}
