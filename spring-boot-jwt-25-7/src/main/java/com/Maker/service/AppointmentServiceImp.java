package com.Maker.service;

import com.Maker.dao.AppointmentRepo;
import com.Maker.model.Appointment;
import com.Maker.model.NotFoundException;
import com.Maker.model.ObjectAlreadyExist;
import com.Maker.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Slf4j
@Repository
public class AppointmentServiceImp implements AppointmentService {

    //TODO some validation

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientService patientService;


    @Override
    public Appointment addAppointment(Appointment appointment) {


       List<Appointment> test=  appointmentRepo.findAllByDateAndStartTimeGreaterThanAndEndTimeLessThan(appointment.getDate(),appointment.getStartTime()
               ,appointment.getEndTime());



    if (test.isEmpty())
        return appointmentRepo.save(appointment);

    else
        throw  new ObjectAlreadyExist("There is an appointment in that range ");
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
    public List<Appointment> getRangeAppointment(Date startDate, Date endDate) {

        List<Appointment> appointment1;

        appointment1 = appointmentRepo.findAllByDateBetween(startDate,endDate);



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
