package com.company.hellobanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloBankingController {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "Welcome To Your Banking made easy";
    }

}