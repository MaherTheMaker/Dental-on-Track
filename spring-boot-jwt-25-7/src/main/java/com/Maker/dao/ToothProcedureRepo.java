package com.Maker.dao;

import com.Maker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToothProcedureRepo extends JpaRepository<ToothProcedure,Integer> {
    List<ToothProcedure> findAllByPatientTooth(PatientTooth patientTooth);
    List<ToothProcedure> findAllByMyProcedure(MyProcedure myProcedure);
    List<ToothProcedure> findAllByTreatmentPlan(TreatmentPlan treatmentPlan);
    List<ToothProcedure> findAllByPatient(Patient patient);
    List<ToothProcedure> findAllByPatientAndIsPaid(Patient patient,boolean b);




}
