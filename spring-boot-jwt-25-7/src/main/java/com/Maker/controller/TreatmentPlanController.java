package com.Maker.controller;

import com.Maker.model.*;
import com.Maker.service.PatientService;
import com.Maker.service.ToothProcedureService;
import com.Maker.service.TreatmentPlanService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/TreatmentPlan")
public class TreatmentPlanController {

    @Autowired
    private TreatmentPlanService treatmentPlanService;

    @Autowired
    private ToothProcedureService toothProcedureService;

    @Autowired
    private PatientService patientService;




    @PostMapping("/{pid}/AddTreatmentPlan")
    private ResponseEntity<TreatmentPlan> AddTreatmentPlan(@PathVariable int pid ,@RequestBody TreatmentPlan treatmentPlan){

        //set tooth id not pid
        treatmentPlan.setPatient(patientService.getPatient(pid));
        return ResponseEntity.accepted().body(treatmentPlanService.addTreatmentPlan(treatmentPlan));
    }


    @GetMapping("/{patientId}/GetAllPatientTreatmentPlan")
    private ResponseEntity<List<TreatmentPlan>> GetAllPatientTreatmentPlan(@PathVariable int patientId){
        Patient myPatient= patientService.getPatient(patientId);


        return ResponseEntity.accepted().body(treatmentPlanService.getAllTreatmentPlanByPatient(myPatient));
    }


    @PostMapping("/{TPid}/EditTreatmentPlan")
    private ResponseEntity<TreatmentPlan> EditTreatmentPlan(@PathVariable int TPid , @RequestBody TreatmentPlan treatmentPlan)
    {
        return ResponseEntity.accepted().body(treatmentPlanService.EditTreatmentPlan(TPid,treatmentPlan));
    }

    @PostMapping("/{TpId}/AddToothProcedure")
    private ResponseEntity<TreatmentPlan> AddToothProcedure(@PathVariable int TpId , @RequestBody AddToTreatment addToTreatment)
    {
        return ResponseEntity.accepted().body(treatmentPlanService.addToothProcedure(TpId,addToTreatment.pId,addToTreatment.ProcId,addToTreatment.PTId, addToTreatment.toothProcedure));
    }

//
//    @PostMapping("/{id}/DoToothProcedure")
//    private ResponseEntity<TreatmentPlan> DoToothProcedure(@PathVariable int id , @RequestBody TreatmentPlan treatmentPlan)
//    {
//        return ResponseEntity.accepted().body(treatmentPlanService.EditTreatmentPlan(treatmentPlan));
//    }

    // Todo add fun to add  Procedures to a TP
}

@Data
class AddToTreatment{
        public int PTId;//PatientTooth
        public int pId;//Patient
        public int ProcId;
        public ToothProcedure toothProcedure;
}
