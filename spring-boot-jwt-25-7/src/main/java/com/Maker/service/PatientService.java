package com.Maker.service;

import com.Maker.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientService {

    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient DiagnosisOrEdit(Patient patient,int pId);
    List<Patient> searchPatient(String name);

    Patient getPatient(Integer id);

    Image addImage(int pId ,Image image);
    File addFile(int pId , File file);
    MedHistory addMedHis(int pId , int IId,String notes);
    List<Image> getAllImage(int id);
    List<File> getAllFile(int id);
    List<MedHistory> getAllMedHis(int id);


}

