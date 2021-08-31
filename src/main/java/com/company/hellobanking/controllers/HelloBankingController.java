package com.company.hellobanking.controllers;

import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloBankingController {

    @Autowired
    private UserRepository userRepo;
    @GetMapping("")
    public String  DisplayLanding(Model model){
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/process_register")
    public <BCryptPasswordEncoder> String processRegister(User user) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);
        userRepo.save(user);
        return "register_success";
    }
}