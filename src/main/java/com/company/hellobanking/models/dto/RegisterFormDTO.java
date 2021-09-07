package com.company.hellobanking.models.dto;


/*
Our login and registration forms will use DTOs
to help with form rendering and processing
--since these forms will be similar—both require a username and password
—we’ll use inheritance in creating our DTOs.

--Our registration form will ask for a username/password pair,
 and then ask the user to confirm the password by typing it in again.
 So the associated DTO can extend LoginFormDTO and add an additional field for password verification.
*/
public class RegisterFormDTO extends LoginFormDTO{
    private String verifyPassword;

    public String getVerifyPassword(){
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword){
        this.verifyPassword = verifyPassword;
    }

}
