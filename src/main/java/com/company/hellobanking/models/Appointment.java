package com.company.hellobanking.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "appointment")
public class Appointment extends User{

    @Column(name = "select_date_and_time")
    private Calendar selectDateAndTime;

    @Column(name = "question")
    private String question;

    @Column(name = "email")
    private String email;

    public Appointment(){}

    public Appointment(Calendar selectDateAndTime,String question, String email){
        this.question = question;
        this.selectDateAndTime = selectDateAndTime;
        this.email = email;
    }

    public Calendar getSelectDateAndTime(){return selectDateAndTime;}
    public void setSelectDateAndTime(Calendar selectDateAndTime) {
        this.selectDateAndTime = selectDateAndTime;
    }

    public String getQuestion(){return question;}
    public void setQuestion(){this.question = question;}

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

}
