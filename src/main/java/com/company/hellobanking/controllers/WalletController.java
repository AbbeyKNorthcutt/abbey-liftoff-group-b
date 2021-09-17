package com.company.hellobanking.controllers;

import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WalletController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "{username}")
    public String  DisplayWallet(HttpServletRequest request,Model model,@PathVariable String username){
        System.out.println("username 11 "+username);
        User optUser = userRepository.findByUsername(username);
        System.out.println("username  "+optUser);
        model.addAttribute("user", "optUser");

        return "personal_Wallet";
    }

}
