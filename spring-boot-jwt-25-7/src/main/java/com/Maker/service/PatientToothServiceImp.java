package com.Maker.service;

import com.Maker.dao.PatientToothRepo;
import com.Maker.dao.ToothRepo;
import com.Maker.model.NotFoundException;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
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


        @Override
        public String addPatientTooth(Patient patient) {


                for (int i = 1; i <= 52 ; i++ ){
                    patientToothRepo.save(new PatientTooth(toothRepo.findById(i).getId(),patient.getId(),null,null,null));
            }


            return "Done";
    }

    @Override
    public List<PatientTooth> GetPatientTeeth(int pId) {
        return patientToothRepo.findAllByPatientId(pId);
    }

    @Override
    public PatientTooth EditPatientTeeth(int PTID, PatientTooth patientTooth) {
            Boolean found;
            if(found = patientToothRepo.existsById(PTID)){
                PatientTooth oldTooth=patientToothRepo.findById(PTID).get();
                oldTooth.setNotes(patientTooth.getNotes());
                oldTooth.setColor(oldTooth.getColor());
                oldTooth.setStatus(oldTooth.getStatus());
                return   patientToothRepo.save(oldTooth);
            }
            else throw new NotFoundException("No patientTooth with this information");


    }


}
