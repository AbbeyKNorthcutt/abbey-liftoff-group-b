package com.company.hellobanking.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private String email;
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
    public User(String username, String password, String email) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail(){
        return email;
    }

    /*User objects should also be responsible for determining
    if a given password is a match for the hash stored by the object*/
    public boolean isMatchingPassword(String password) {
        String candidateHash = encoder.encode(password);
        return candidateHash.equals(pwHash);
    }

}
