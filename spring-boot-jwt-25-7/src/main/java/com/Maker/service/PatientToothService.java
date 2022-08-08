package com.Maker.service;

import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;

import java.util.List;

public interface PatientToothService {


    String addPatientTooth(int pId);

    List<PatientTooth> GetPatientTeeth (int pId);
    PatientTooth EditPatientTeeth (int PTID,PatientTooth patientTooth);


}
