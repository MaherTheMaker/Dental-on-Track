package com.Maker.dao;

import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
import com.Maker.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentPlanRepo extends JpaRepository<TreatmentPlan, Integer> {
    List<TreatmentPlan> findAllByPatient(Patient patient);
    List<TreatmentPlan> findAllByPatientTooth (PatientTooth patientTooth);

}
