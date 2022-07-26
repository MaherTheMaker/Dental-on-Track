package com.Maker.service;

import com.Maker.dao.ToothProcedureRepo;
import com.Maker.dao.TreatmentPlanRepo;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToothProcedureServiceImp implements ToothProcedureService {

    //TODO some validation
    @Autowired
    private ToothProcedureRepo toothProcedureRepo;


    @Override
    public ToothProcedure addToothProcedure(ToothProcedure toothProcedure) {
        return toothProcedureRepo.save(toothProcedure);
    }

    @Override
    public ToothProcedure doToothProcedure(int id) {
               ToothProcedure toothProcedure= toothProcedureRepo.findById(id).get();
                        toothProcedure.setDone(true);
        return toothProcedureRepo.save(toothProcedure);

    }

    @Override
    public ToothProcedure getToothProcedure(int id) {
        return toothProcedureRepo.findById(id).get();
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByPatientTooth(PatientTooth patientTooth) {
        return toothProcedureRepo.findAllByPatientTooth(patientTooth);
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByProcedure(Procedures procedures) {
        return toothProcedureRepo.findAllByProcedure(procedures);
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByTreatmentPlan(TreatmentPlan treatmentPlan) {
        return toothProcedureRepo.findAllByTreatmentPlan(treatmentPlan);
    }


}

