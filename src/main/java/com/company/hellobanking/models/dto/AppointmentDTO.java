package com.company.hellobanking.models.dto;

import com.company.hellobanking.models.AbstractEntity;
import com.company.hellobanking.models.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;


    public class AppointmentDTO {

        @NotNull
        private int zipCode;
        @NotNull
        private Calendar selectDateAndTime;
        @NotNull
        @Size(min = 5, max = 255)
        private String question;
        @NotNull
        @Email
        private String email;

        public int getZipCode(){return zipCode;}
        public void setZipCode(int zipCode){this.zipCode = zipCode;}

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
