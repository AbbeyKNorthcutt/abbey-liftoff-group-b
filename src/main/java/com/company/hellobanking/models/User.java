package com.company.hellobanking.models;

import org.jetbrains.annotations.NotNull;
import org.springframework.jmx.export.annotation.ManagedNotification;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String password;

    public static final BCryptPasswordEncoder encoder;

    public User(){

        public User(String username, String password){
            this.username = username;
            this.password = password;
        }
    }
}
