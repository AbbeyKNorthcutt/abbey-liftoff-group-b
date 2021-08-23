package com.company.hellobanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloBankingController {

    @GetMapping
    @ResponseBody
    public String hello(){
      return "Welcome To Your Banking made easy";
    }



}
