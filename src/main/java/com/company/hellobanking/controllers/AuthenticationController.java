package com.company.hellobanking.controllers;

import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import com.company.hellobanking.models.dto.LoginFormDTO;
import com.company.hellobanking.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.openmbean.OpenDataException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/* create a new class named AuthenticationController.
Since this controller will deal with User objects,
it needs a UserRepository instance. */

@Controller
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;

    /* Session-Handling Utilities
    -- utility methods for working with sessions
    //This code allows us to store and retrieve the login status of a user in a session.
    More specifically, a logged-in user’s user ID will be stored in their session.//
    //These utility methods will allow our handlers to manage authentication //
    */

    /* The static field userSessionKey is the key used to store user IDs */
    private static final String userSessionKey = "user";

    /* getUserFromSession looks for data with the key user in the user’s session.
    If it finds one, it attempts to retrieve the corresponding User object from the database.
     If no user ID is in the session, or if there is no user with the given ID, null is returned. */
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
    /* setUserInSession uses an HttpSession object
    (part of the standard javax.servlet.http package) to store key/value pair */
    private static void setUserSessionKey(HttpSession session, User user){
        session.setAttribute(userSessionKey, user.getId());
    }
    /*
    Before we can authenticate a user, we must have users in the application,
    so we’ll build the registration form first.
    //Handling the registration data
    // Add a GET handler to display a registration form*/
    @GetMapping("/register")
    public String displayRegistrationForm(Model model){
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }
     /*
     Define the handler method at the route /register
     that takes a valid RegisterFormDTO object, associated errors, and a Model.
     In addition, the method needs an HttpServletRequest object.
     This object represents the incoming request, and will be provided by Spring.
     */
    //Create a POST handler to process the form
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request, Model model) {

        //If the form has validation errors
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        /*If the username is already tied to a user
        Retrieve the user with the given username from the database. */
        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        /* If a user with the given username already exists,
        register a custom error with the errors object and return the user to the form.
        */
        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists",
                    "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        /*If the two form fields for passwords do not match,
        register a custom error and return the user to the form. */
        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        // If none of the above conditions are met, Create a new User and save in database.
        // Create new userSession and redirect to homepage.
        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserSessionKey(request.getSession(), newUser);

        return "redirect:";
    }

    // Handling the login data
    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Sign-In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors,HttpServletRequest request,Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Sign-In");
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if(theUser == null){
            errors.rejectValue("username", "username.invalid",
                    "The given username does not exist");
            model.addAttribute("title","Sign-In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if(!theUser.isMatchingPassword(password)){
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Sign-In");
            return "login";
        }

        setUserSessionKey(request.getSession(), theUser);

        return "redirect:";
    }

    // Handling the logging out data
    //create a GET handler method for a path to logout.
    //simply invalidate the session associated with the given user
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:";
    }
}
