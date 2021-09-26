package com.company.hellobanking.controllers;

import com.company.hellobanking.models.Appointment;
import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.AppointmentRepository;
import com.company.hellobanking.models.data.UserRepository;
import com.company.hellobanking.models.dto.AppointmentDTO;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/* create a class named SchedulingController.
        Since this controller will deal with Appointment objects,
        it needs a AppointmentRepository instance. */
@Controller
public class SchedulingController {

     AppointmentRepository appointmentRepository;

     /* The static field userSessionKey is the key used to store user IDs */
     //private static final String userSessionKey = "user";

     /*public User getUserFromSession(HttpSession session){
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
     }*/

     /*
     private static void setUserSessionKey(HttpSession session, User user){
          session.setAttribute(userSessionKey, user.getId());
     }*/


     public SchedulingController(AppointmentRepository appointmentRepository){
         this.appointmentRepository = appointmentRepository;
     }

     // Add a GET handler to display a scheduling form */
     @GetMapping("/invest")
     public String displaySchedulingForm(Model model){
          model.addAttribute(new AppointmentDTO());
          model.addAttribute("title", "Book My Appointment");
          return "invest";
     }

     @PostMapping("/invest")
     public String processSchedulingForm(@ModelAttribute @Valid AppointmentDTO appointmentDTO,
                                         Errors errors, HttpServletRequest request, Model model){
          //If the form has validation errors
          if(errors.hasErrors()) {
               model.addAttribute("title", "Book My Appointment");
               return "invest";
          }

          /* if the email is already tied to a user, retrieve the user from database */
          User existingUser = appointmentRepository.findByEmail(appointmentDTO.getEmail());

          if(existingUser != null){
               errors.rejectValue("email", "email.alreadyexists",
                       "A user with that email already exists");
               model.addAttribute("title", "Book My Appointment");
               return "login";
          }

         /* // If none of the above conditions are met, Create a new User and save in database.
          // Create new userSession//
          User newUser = new Appointment(appointmentDTO.getSelectDateAndTime(),
                  appointmentDTO.getQuestion(),
                  appointmentDTO.getEmail());
          userRepository.save(newUser);
          setUserSessionKey(request.getSession(), newUser);*/

          return "redirect:/appointment_booked";
     }

     @RequestMapping("/appointment_booked")
     public String displayAppointments(Model model){
          model.addAttribute("title", "Appointment Scheduled Successfully");
          return "invest/appointment_booked";
     }




}
