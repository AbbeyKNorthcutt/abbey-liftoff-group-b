package com.company.hellobanking.controllers;

import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;
}
