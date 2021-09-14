package com.company.hellobanking.controllers;

import com.company.hellobanking.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WalletController {

    @RequestMapping("personal_Wallet")
    public String  DisplayWallet(Model model){
        model.addAttribute("message", "Welcome To Your Online Wallet !!");
        return "personal_Wallet";
    }
    @PostMapping("personal_Wallet")
    public String  DisplayWallet(@ModelAttribute("user") User user){
      System.out.println(user);
        return "personal_Wallet";
    }
}
