package com.Maker.controller;

import com.Maker.dao.PatientRepo;
import com.Maker.model.*;

import com.Maker.service.PatientService;
import com.Maker.service.PatientToothService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientToothService patientToothService;

    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>>GetAllPatient ( ) {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return ResponseEntity.ok().body(patientService.addPatient(patient));
    }

    @PostMapping("/{pId}/Diagnosis")
    public ResponseEntity<Patient> Diagnosis(@RequestBody Patient patient,@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.DiagnosisOrEdit(patient,pId));
    }

    @GetMapping("/{pId}/Teeth")
    public ResponseEntity<List<PatientTooth>> GetTeeth(@PathVariable int pId){
        return ResponseEntity.ok().body(patientToothService.GetPatientTeeth(pId));
    }

    @PostMapping("/searchPatient/{username}")
    public ResponseEntity<List<Patient>> getPlan(@PathVariable String username){
        return ResponseEntity.ok().body(patientService.searchPatient(username));
    }


    @PostMapping("/{pId}/addImage")
    public ResponseEntity addImage (@PathVariable int pId , @RequestBody Image image){
        return ResponseEntity.ok().body(patientService.addImage(pId,image));
    }

    @PostMapping("/{pId}/addFile")
    public ResponseEntity addFile (@PathVariable int pId , @RequestBody File file){
        return ResponseEntity.ok().body(patientService.addFile(pId,file));
    }
    @PostMapping("/{pId}/addMedHis")
    public ResponseEntity addMedHis (@PathVariable int pId , @RequestBody MedHistoryData medHistory){
        return ResponseEntity.ok().body(patientService.addMedHis(pId,medHistory.IllId,medHistory.notes));
    }


    @GetMapping("/{pId}/getAllImage")
    public ResponseEntity<List<Image>>getGallery (@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.getAllImage(pId));
    }

    @GetMapping("/{pId}/getAllFiles")
    public ResponseEntity<List<File>>getFiles (@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.getAllFile(pId));
    }

    @GetMapping("/{pId}/getAllMedHis")
    public ResponseEntity<List<MedHistory>>getAllMedHis (@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.getAllMedHis(pId));
    }




}
@Data
class MedHistoryData{
    public int IllId;
    public String notes;
}

