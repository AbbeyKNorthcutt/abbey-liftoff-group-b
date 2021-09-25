package com.company.hellobanking.service;

import com.company.hellobanking.Exception.UserNotFoundException;
import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void updateResetPasswordToken(String token, String email){
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        }
    }
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPwHash(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
    public void updateResetPassword(String token ,String email) throws UserNotFoundException {
        User user =userRepository.findByEmail(email);
        if(user !=null){
            user.setResetPasswordToken(token);
            userRepository.save(user);
    }else{
          throw new UserNotFoundException("Could finds any User"+email);
        }}

    public User get(String resetPasswordToken){
        return userRepository.findByResetPasswordToken(resetPasswordToken);
    }


}
