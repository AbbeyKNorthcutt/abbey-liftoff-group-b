package com.company.hellobanking.models.data;

import com.company.hellobanking.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    Appointment findByEmail(String email);
}

