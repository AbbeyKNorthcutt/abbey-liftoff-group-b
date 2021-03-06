package com.company.hellobanking.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*
Our login and registration forms will use DTOs
to help with form rendering and processing
to help with form rendering and processing
--since these forms will be similar—both require a username and password
—we’ll use inheritance in creating our DTOs.
*/
public class LoginFormDTO {

    /*The DTO for the login form needs only username and password fields.*/
    @NotNull
    @Size(min = 5, max = 255, message = "Invalid username. Must be between 5 and 30 characters.")
    private String username;

    @NotNull
    @Size(min = 5, max = 255, message = "Invalid password. Must be between 5 and 30 characters.")
    private String password;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
