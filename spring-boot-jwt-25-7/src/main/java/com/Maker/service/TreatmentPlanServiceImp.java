package com.Maker.service;

import com.Maker.dao.IllnessRepo;
import com.Maker.dao.TreatmentPlanRepo;
import com.Maker.model.Illness;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.TreatmentPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TreatmentPlanServiceImp implements TreatmentPlanService {

    @Autowired
    private TreatmentPlanRepo treatmentPlanRepo;


    @Override
    public TreatmentPlan addTreatmentPlan(TreatmentPlan treatmentPlan) {
        return treatmentPlanRepo.save(treatmentPlan);
    }

    @Override
    public TreatmentPlan EditTreatmentPlan(TreatmentPlan treatmentPlan) {
        Optional<TreatmentPlan> optionalOldTreatmentPlan =treatmentPlanRepo.findById(treatmentPlan.getId());
        TreatmentPlan oldPlan=optionalOldTreatmentPlan.get();
        oldPlan.setNotes(treatmentPlan.getNotes());
//        oldPlan.setProceduresList(treatmentPlan.getProceduresList());



        return treatmentPlanRepo.save(oldPlan);
    }

    @Override
    public TreatmentPlan getTreatmentPlan(int id) {

        return treatmentPlanRepo.findById(id).get();
    }

    @Override
    public List<TreatmentPlan> getAllTreatmentPlanByPatient(Patient patient) {
        return treatmentPlanRepo.findAllByPatient(patient);
    }

    @Override
    public List<TreatmentPlan> getAllTreatmentPlanByTooth(PatientTooth patientTooth) {
        return treatmentPlanRepo.findAllByPatientTooth(patientTooth);
    }
}

