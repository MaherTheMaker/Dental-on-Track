package com.Maker.service;

import com.Maker.model.Appointment;
import com.Maker.model.Patient;

import java.util.Date;
import java.util.List;

public interface AppointmentService {

    Appointment addAppointment(Appointment appointment);
    List<Appointment> getAllPatientAppointment(int  pid);
    List<Appointment> getDateAppointment(Date date);
    Appointment editAppointment(int id,Appointment appointment );

}
