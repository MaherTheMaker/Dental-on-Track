package com.Maker.controller;

import com.Maker.model.Appointment;
import com.Maker.service.AppointmentService;
import com.Maker.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;


    @PostMapping("/{pid}/AddAppointment")
    private ResponseEntity<Appointment> addAppointment(@PathVariable int pid ,@RequestBody Appointment appointment){
        appointment.setPatient(patientService.getPatient(pid));
        return ResponseEntity.accepted().body(appointmentService.addAppointment(appointment));
    }


    @GetMapping("/{patientId}/GetAllPatientAppointment")
    private ResponseEntity<List<Appointment>> addAppointment(@PathVariable int patientId){

        return ResponseEntity.accepted().body(appointmentService.getAllPatientAppointment(patientId));
    }


    @PostMapping("/{id}/EditAppointment")
    private ResponseEntity<Appointment> editAppointment(@PathVariable int id , @RequestBody Appointment appointment)
    {
        return ResponseEntity.accepted().body(appointmentService.editAppointment(id ,appointment));
    }
}
