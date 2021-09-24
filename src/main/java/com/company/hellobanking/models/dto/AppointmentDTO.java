package com.company.hellobanking.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;


    public class AppointmentDTO {

        @NotNull
        private Calendar selectDateAndTime;
        @NotNull
        @Size(min = 5, max = 255)
        private String question;
        @NotNull
        @Email
        private String email;

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
