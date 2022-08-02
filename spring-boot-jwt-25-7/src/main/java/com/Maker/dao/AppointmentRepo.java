package com.Maker.dao;

import com.Maker.model.Appointment;
import com.Maker.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
    List<Appointment> findAllByDate(Date date);
    List<Appointment> findAllByDateBetween(Date date1, Date date2);
    List<Appointment> findAllByDateAndStartTimeGreaterThanAndEndTimeLessThan(Date date,int startTime, int endTime);
    List<Appointment> findAllByPatient(Patient patient);
    Appointment findByPatient(Patient patient);
}
