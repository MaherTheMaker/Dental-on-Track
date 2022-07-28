package com.Maker.service;

import com.Maker.dao.AppointmentRepo;
import com.Maker.dao.PatientRepo;
import com.Maker.model.Appointment;
import com.Maker.model.NotFoundException;
import com.Maker.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Repository
public class AppointmentServiceImp implements AppointmentService {

    //TODO some validation

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientService patientService;


    @Override
    public Appointment addAppointment(Appointment appointment) {


        return appointmentRepo.save(appointment);

    }

    @Override
    public List<Appointment> getAllPatientAppointment(int pid) {

        Patient patient = patientService.getPatient(pid);
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
            throw new NotFoundException("No Appointment Found in this Date");
        }
        else return appointment1;
    }


    @Override
    public Appointment editAppointment(int id,Appointment appointment) {
        Appointment appointment1 = appointmentRepo.findById(id).orElseThrow(()->
                new NotFoundException("Appointment not found"));

        appointment1.setDate(appointment.getDate());
        appointment1.setStartTime(appointment.getStartTime());
        appointment1.setEndTime(appointment.getEndTime());
        appointment1.setNotes(appointment.getNotes());
        return appointment1;
    }


}
