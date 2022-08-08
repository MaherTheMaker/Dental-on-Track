package com.Maker.service;

import com.Maker.dao.ToothProcedureRepo;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToothProcedureServiceImp implements ToothProcedureService {

    //TODO some validation
    //Todo ...maybe... merge this with TreatmentPlan service

    @Autowired
    private ToothProcedureRepo toothProcedureRepo;


    @Override
    public ToothProcedure doToothProcedure(int id) {
               ToothProcedure toothProcedure= toothProcedureRepo.findById(id).get();
                        toothProcedure.setDone(true);
        return toothProcedureRepo.save(toothProcedure);

    }


    @Override
    public ToothProcedure getToothProcedure(int id) {
        return toothProcedureRepo.findById(id).orElseThrow(()-> new NotFoundException("Tooth Procedure not Found"));
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByPatientTooth(PatientTooth patientTooth) {
        return toothProcedureRepo.findAllByPatientTooth(patientTooth);
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByProcedure(MyProcedure myProcedure) {
        return toothProcedureRepo.findAllByMyProcedure(myProcedure);
    }

    @Override
    public List<ToothProcedure> getAllToothProceduresByTreatmentPlan(TreatmentPlan treatmentPlan) {
        return toothProcedureRepo.findAllByTreatmentPlan(treatmentPlan);
    }


     @Override
    public float getTotalExpenses() {
        float sum = (float) toothProcedureRepo.findAllByIsPaidAndIsDone(false,true).stream()
                .mapToDouble(x -> x.getPrice())
                .sum();
        return sum;
    }


}

