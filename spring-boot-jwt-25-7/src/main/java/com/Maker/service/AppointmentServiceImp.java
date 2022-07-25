package com.Maker.service;

import com.Maker.dao.AppointmentRepo;
import com.Maker.dao.PatientRepo;
import com.Maker.model.Appointment;
import com.Maker.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Repository
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientRepo;


    @Override
    public Appointment addAppointment(Appointment appointment) {
        //todo how can i know that the saving done correctly

        return appointmentRepo.save(appointment);

    }

    @Override
    public List<Appointment> getAllPatientAppointment(int pid) {

        Patient patient = patientRepo.findById(pid);
        List<Appointment>  appointment1 = appointmentRepo.findAllByPatient(patient);
        if(appointment1==null){
            return null;
        }
        else return appointment1;
    }

    @Override
    public List<Appointment> getDateAppointment(Date date) {
        List<Appointment> appointment1;
        appointment1 = appointmentRepo.findAllByDate(date);
        if(appointment1==null){
            return null;
        }
        else return appointment1;
    }

    @Override
    public Appointment editAppointment(int id,Appointment appointment) {
        Appointment appointment1 = appointmentRepo.findById(id).get();
        appointment1.setPatient(appointment.getPatient());
        appointment1.setDate(appointment.getDate());
        appointment1.setStartTime(appointment.getStartTime());
        appointment1.setEndTime(appointment.getEndTime());
        appointment1.setNotes(appointment.getNotes());
        return appointment1;
    }
}
