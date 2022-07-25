package com.Maker.service;

import com.Maker.dao.PatientToothRepo;
import com.Maker.dao.ToothRepo;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientToothImp implements PatientToothService {




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


}
