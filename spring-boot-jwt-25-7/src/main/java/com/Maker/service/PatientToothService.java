package com.Maker.service;

import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;

import java.util.List;

public interface PatientToothService {

    String addPatientTooth (Patient patient);
    List<PatientTooth> GetPatientTeeth (int pId);


}
