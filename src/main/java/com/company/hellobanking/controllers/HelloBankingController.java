package com.company.hellobanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloBankingController {

    @GetMapping
    public String  DisplayLanding(Model model){

        return "landing";
    }

}