package com.company.hellobanking.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


/* we can authenticate users,
we need users to authenticate!
We’ll start by adding a User model */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String pwHash;

    @Column(name = "email")
    private String email;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "social_security_number")
    private int socialSecurityNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
   /*
    //Hashing Passwords--- bcrypt hash algorithm//
    -- make it static so it can be shared by all User objects.
    */

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    /* constructor takes a parameter named password
    and uses it to set the value of pwHash
    >> use encoder to create a hash from the given password
    */
    public User(String username, String firstName, String lastName,String password, String email,
                String accountNumber, int socialSecurityNumber, String address, int phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
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

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    /*User objects should also be responsible for determining
        if a given password is a match for the hash stored by the object*/
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
