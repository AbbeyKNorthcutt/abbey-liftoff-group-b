package com.company.hellobanking.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloBankingController {

    @RequestMapping("")
    public String DisplayLanding(Model model){
        model.addAttribute("message", "Welcome To Your Online Banking !!");
        return "landing";
    }

    @RequestMapping("landing")
    public String displayHomePage(Model model){
        model.addAttribute("message","Welcome Back !!" );
        return "landing";
    }
}