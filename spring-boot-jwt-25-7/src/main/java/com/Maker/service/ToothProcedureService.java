package com.Maker.service;

import com.Maker.model.*;

import java.util.List;

public interface ToothProcedureService {

    ToothProcedure addToothProcedure(ToothProcedure toothProcedure);


    ToothProcedure doToothProcedure(int id);


    ToothProcedure getToothProcedure(int id);


    List<ToothProcedure> getAllToothProceduresByPatientTooth(PatientTooth patientTooth);

    List<ToothProcedure> getAllToothProceduresByProcedure(Procedures procedures);

    List<ToothProcedure> getAllToothProceduresByTreatmentPlan(TreatmentPlan treatmentPlan);

}
