package com.Maker.controller;

import com.Maker.model.Appointment;
import com.Maker.service.AppointmentService;
import com.Maker.service.PatientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    private ResponseEntity<List<Appointment>> GetAllPatientAppointment(@PathVariable int patientId){

        return ResponseEntity.accepted().body(appointmentService.getAllPatientAppointment(patientId));
    }

    @GetMapping("/GetAllDateAppointment")
    private ResponseEntity<List<Appointment>> GetAllByDateAppointment(@RequestBody com.Maker.controller.date date){
        System.out.printf(date.date.toString());
        return ResponseEntity.accepted().body(appointmentService.getDateAppointment(date.date));
    }


    @GetMapping("/GetAllDateRangeAppointment")
    private ResponseEntity<List<Appointment>> GetAllByDateRangeAppointment(@RequestBody rangeDate date){

        System.out.println(date.start+ " "+ date.end);
        return ResponseEntity.accepted().body(appointmentService.getRangeAppointment(date.start,date.end));
    }



    @PostMapping("/{id}/EditAppointment")
    private ResponseEntity<Appointment> editAppointment(@PathVariable int id , @RequestBody Appointment appointment)
    {
        return ResponseEntity.accepted().body(appointmentService.editAppointment(id ,appointment));
    }

  public   boolean calculateConflict(Appointment oldAppointment,Appointment newAppointment)
    {
        if(newAppointment.getStartTime()>=oldAppointment.getStartTime() &&newAppointment.getStartTime()<=oldAppointment.getEndTime())
            return true;
       else if(newAppointment.getEndTime()>=oldAppointment.getStartTime() &&newAppointment.getEndTime()<=oldAppointment.getEndTime())
            return true;
       else if(oldAppointment.getStartTime()>=newAppointment.getStartTime() && oldAppointment.getStartTime()<=newAppointment.getEndTime())
           return true;

        return false;
    }

}


@Data
class rangeDate {
    Date start;
    Date end;
}