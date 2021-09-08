package com.company.hellobanking.models.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull
    @NotBlank
    @Size(min = 5, max = 255, message = "Passwords Do Not Match.")
    private String verifyPassword;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 255, message = "Invalid email. Must be between 5 and 255 characters.")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 255, message = "Invalid account number. Must be between 5 and 255 characters.")
    private String accountNumber;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 255, message = "Invalid social security number. Must be between 5 and 255 characters.")
    private String socialSecurityNumber;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 255, message = "Invalid address. Must be between 5 and 255 characters.")
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 5, max =11 , message = "Invalid phone number. Must be between 5 and 11 characters.")
    private int phoneNumber;

    public String getVerifyPassword(){
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword){
        this.verifyPassword = verifyPassword;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }

    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber){
        this.socialSecurityNumber=socialSecurityNumber;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }

}
