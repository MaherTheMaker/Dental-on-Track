package com.Maker.service;

import com.Maker.dao.PatientRepo;
import com.Maker.dao.PatientToothRepo;
import com.Maker.dao.ToothRepo;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientToothServiceImp implements PatientToothService {


    //TODO some validation

        @Autowired
        private PatientToothRepo patientToothRepo ;

        @Autowired
        private ToothRepo toothRepo;

        @Autowired
        private PatientRepo patientRepo;


        @Override
        public String addPatientTooth(int pId) {

            if(patientRepo.existsById(pId)) {

                for (int i = 1; i <= 52; i++) {
                    patientToothRepo.save(new PatientTooth(toothRepo.findById(i).getToothNumber(),pId,null, ToothStatus.Normal,null));
                }


                return "Done";
            }
            else throw new NotFoundException("No Patient With this Id!");
    }

    @Override
    public List<PatientTooth> GetPatientTeeth(int pId) {
        return patientToothRepo.findAllByPatientId(pId);
    }

    @Override
    public PatientTooth EditPatientTeeth(int PTID, PatientTooth patientTooth) {
            if(patientToothRepo.existsById(PTID)){
            PatientTooth oldTooth=patientToothRepo.findById(PTID).get();
                oldTooth.setNotes(patientTooth.getNotes());
                oldTooth.setColor(patientTooth.getColor());
                oldTooth.setStatus(patientTooth.getStatus());
                return   patientToothRepo.save(oldTooth);
            }
            else throw new NotFoundException("No patientTooth with this information");

    }



}
