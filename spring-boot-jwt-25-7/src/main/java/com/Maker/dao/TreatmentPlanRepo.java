package com.Maker.dao;

import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
import com.Maker.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentPlanRepo extends JpaRepository<TreatmentPlan, Integer> {

    TreatmentPlan findAllByPatient(Patient patient);
    TreatmentPlan findAllByPatientTooth (PatientTooth patientTooth);

}
