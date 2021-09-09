package com.company.hellobanking.models.dto;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

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
    @Size(min = 5, max = 255, message = "Invalid first name. Must be between 5 and 255 characters.")
    private String firstName;

    @NotNull
    @Size(min = 5, max = 255, message = "Invalid last name. Must be between 5 and 255 characters.")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 255, message = "Passwords Do Not Match.")
    private String verifyPassword;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 255, message = "Invalid account number. Must be between 5 and 255 characters.")
    private String accountNumber;

    @NotNull
    @Min(value = 0)
    private int socialSecurityNumber;

    @NotNull
    @Size(min = 5, max = 255, message = "Invalid address. Must be between 5 and 255 characters.")
    private String address;

    @NotNull
    @Min(value = 0)
    private int phoneNumber;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public int getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    public void setSocialSecurityNumber(int socialSecurityNumber){
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
