package com.company.hellobanking.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* we can authenticate users,
we need users to authenticate!
We’ll start by adding a User model */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String pwHash;

    @Column(name = "email")
    private String email;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phoneNumber;
   /*
    //Hashing Passwords--- bcrypt hash algorithm//
    -- make it static so it can be shared by all User objects.
    */

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    /* constructor takes a parameter named password
    and uses it to set the value of pwHash
    >> use encoder to create a hash from the given password
    */
    public User(String username, String password, String email,
                String accountNumber, String socialSecurityNumber, String address, int phoneNumber) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.accountNumber=accountNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
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


    /*User objects should also be responsible for determining
    if a given password is a match for the hash stored by the object*/
    public boolean isMatchingPassword(String password) {
        String candidateHash = encoder.encode(password);
        return candidateHash.equals(pwHash);
    }

}
