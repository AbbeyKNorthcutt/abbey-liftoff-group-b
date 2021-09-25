package com.company.hellobanking.controllers;

import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class WalletController {
    private static final String userSessionKey = "user";
    @Autowired
    UserRepository userRepository;
    @RequestMapping("personal_Wallet")
    public String  DisplayWallet(HttpServletRequest request,Model model){
        User optUser=getUserFromSession(request.getSession());
        String username=optUser.getUsername();
        String fullName = optUser.getFirstName()+"  , "+optUser.getLastName();
        String account=optUser.getAccountNumber();
        String email=optUser.getEmail();
        String address=optUser.getAddress();
        int phoneNumber =optUser.getPhoneNumber();
        model.addAttribute("username", username);
        model.addAttribute("fullName", fullName);
        model.addAttribute("account", account);
        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);
        return "personal_Wallet";
    }
    public User getUserFromSession(HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null){
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()){
            return null;
        }

        return user.get();
    }
}
