package com.Maker.service;

import com.Maker.dao.*;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TreatmentPlanServiceImp implements TreatmentPlanService {

    //TODO some validation

    @Autowired
    private TreatmentPlanRepo treatmentPlanRepo;

    @Autowired
    private ToothProcedureService toothProcedureService;


    @Autowired
    private ToothProcedureRepo toothProcedureRepo;

    @Autowired
    private PatientToothRepo patientToothRepo;


    @Autowired
    private ProceduresService procedureService;

    @Autowired
    private MyProcedureRepo myProcedureRepo;


    @Autowired
    private PatientService patientService;



    @Override
    public TreatmentPlan addTreatmentPlan(TreatmentPlan treatmentPlan) {
       //no need to check if there is an exists treatment plan
        return treatmentPlanRepo.save(treatmentPlan);
    }



    @Override
    public TreatmentPlan EditTreatmentPlan(int tpId,TreatmentPlan treatmentPlan) {

        TreatmentPlan oldPlan =getTreatmentPlan(tpId);
        oldPlan.setNotes(treatmentPlan.getNotes());
//        oldPlan.setProceduresList(treatmentPlan.getProceduresList());
        return treatmentPlanRepo.save(oldPlan);
    }


    @Override
    public TreatmentPlan getTreatmentPlan(int id) {

       Boolean treatmentPlan = treatmentPlanRepo.findById(id).isPresent();
       if(treatmentPlan.equals(false)) {
           return treatmentPlanRepo.findById(id).get();
       }else throw new NotFoundException("treatment Plan not found");
    }

    @Override
    public List<TreatmentPlan> getAllTreatmentPlanByPatient(Patient patient) {
        return treatmentPlanRepo.findAllByPatient(patient);
    }


    @Override
    public List<TreatmentPlan> getAllTreatmentPlanByTooth(PatientTooth patientTooth) {
        return treatmentPlanRepo.findAllByPatientTooth(patientTooth);
    }

    @Override
    public TreatmentPlan addToothProcedureToTreatmentPlan(int tpId, ToothProcedure toothProcedure) {
        TreatmentPlan oldPlan= getTreatmentPlan(tpId);
        oldPlan.getToothProcedures().add(toothProcedure);
        oldPlan.setPatient(oldPlan.getPatient());
        return treatmentPlanRepo.save(oldPlan);
    }


    @Override
    public TreatmentPlan addToothProcedure(int tpId,int pId,int proId,int PtId, ToothProcedure toothProcedure) {
        ToothProcedure newToothP = toothProcedure;
        //Patient link
        MyProcedure myProcedure = myProcedureRepo.findById(proId);
        PatientTooth patientTooth = patientToothRepo.findById(PtId).get();
        TreatmentPlan treatmentPlan = treatmentPlanRepo.findById(tpId).get();
        if (myProcedure == null || !patientToothRepo.existsById(PtId) || !treatmentPlanRepo.existsById(tpId))
        {
            throw new NotFoundException("Procedure, Patient tooth or Treatment Plan not found ");
        }
        newToothP.setPatientTooth(patientTooth);
        newToothP.setProcedure(myProcedure);
        newToothP.setTreatmentPlan(treatmentPlan);

        return addToothProcedureToTreatmentPlan(tpId,toothProcedure);
    }

    @Override
    public TreatmentPlan removeToothProcedureFromTreatmentPlan(int tpId, int TProcId) {
        TreatmentPlan treatmentPlan=treatmentPlanRepo.findById(tpId).orElseThrow(()->new NotFoundException("Treatment Plan not found"));
        ToothProcedure removedTPro= toothProcedureRepo.findById(TProcId).orElseThrow(()->new NotFoundException("Tooth Procedure not found"));
        treatmentPlan.getToothProcedures().remove(removedTPro);
        toothProcedureRepo.delete(removedTPro);
        return treatmentPlanRepo.save(treatmentPlan);
    }


    @Override
    public ToothProcedure doToothProcedure(int id) {
        ToothProcedure toothProcedure= toothProcedureRepo.findById(id).get();
        toothProcedure.setDone(true);
        return toothProcedureRepo.save(toothProcedure);

    }


    @Override
    public ToothProcedure EditToothProcedureNotes(int id, String newNotes) {
        ToothProcedure toothProcedure= toothProcedureRepo.findById(id).get();
        toothProcedure.setNotes(newNotes);
        return toothProcedureRepo.save(toothProcedure);

    }



    @Override
    public ToothProcedure getToothProcedure(int id) {
        if(toothProcedureRepo.existsById(id)) {
            return toothProcedureRepo.findById(id).get();
        }
        else throw new NotFoundException("NO ToothProcedure found with this info ");}

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
    public List<ToothProcedure> getAllUnpaidTP(int pId, boolean paid){
        Patient patient = patientService.getPatient(pId);
        return toothProcedureRepo.findAllByPatientAndIsPaid(patient,false);
    }



}

