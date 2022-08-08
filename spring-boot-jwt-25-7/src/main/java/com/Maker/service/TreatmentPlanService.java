package com.Maker.service;

import com.Maker.model.*;

import java.util.List;

public interface TreatmentPlanService {

    TreatmentPlan addTreatmentPlan(TreatmentPlan treatmentPlan);

    TreatmentPlan EditTreatmentPlan(int tpId ,TreatmentPlan treatmentPlan);

    TreatmentPlan getTreatmentPlan(int tpId);
    List<TreatmentPlan> getAllTreatmentPlanByPatient(Patient patient);
    List<TreatmentPlan> getAllTreatmentPlanByTooth(PatientTooth patientTooth);
    TreatmentPlan addToothProcedureToTreatmentPlan(int tpId, ToothProcedure toothProcedure);

    TreatmentPlan addToothProcedure(int tpId,int pId,int proId,int PtId, ToothProcedure toothProcedure);
    TreatmentPlan removeToothProcedureFromTreatmentPlan(int tpId,int TProcId);

    ToothProcedure doToothProcedure(int id);


    ToothProcedure EditToothProcedureNotes(int id, String newNotes);

    ToothProcedure getToothProcedure(int id);


    List<ToothProcedure> getAllToothProceduresByPatientTooth(PatientTooth patientTooth);

    List<ToothProcedure> getAllToothProceduresByProcedure(MyProcedure myProcedure);

    List<ToothProcedure> getAllToothProceduresByTreatmentPlan(TreatmentPlan treatmentPlan);

     List<ToothProcedure> getAllUnpaidTP(int pId, boolean paid);

    List<PatientFinancialDetails> getPatientFinancialDetails();
}
