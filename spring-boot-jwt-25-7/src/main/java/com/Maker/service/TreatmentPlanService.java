package com.Maker.service;

import com.Maker.model.Illness;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.TreatmentPlan;

import java.util.List;

public interface TreatmentPlanService {

    TreatmentPlan addTreatmentPlan(TreatmentPlan treatmentPlan);

    TreatmentPlan EditTreatmentPlan(TreatmentPlan treatmentPlan);
    TreatmentPlan getTreatmentPlan(int id);
    List<TreatmentPlan> getAllTreatmentPlanByPatient(Patient patient);
    List<TreatmentPlan> getAllTreatmentPlanByTooth(PatientTooth patientTooth);
}
