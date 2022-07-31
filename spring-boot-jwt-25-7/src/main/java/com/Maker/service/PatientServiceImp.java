package com.Maker.service;

//import com.Maker.dao.FileRepo;
import com.Maker.dao.FileRepo;
import com.Maker.dao.ImageRepo;
import com.Maker.dao.MedHisRepo;
import com.Maker.dao.PatientRepo;
//import com.Maker.model.File;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientServiceImp implements PatientService {

    //TODO some validation

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private MedHisRepo medHisRepo;

    @Autowired
    private PatientToothService patientToothService;

    @Autowired
    private IllnessService illnessService;


    @Override
    public Patient addPatient(Patient patient) {
        //No need To validate Existing Patient because patient can be more than one with the same name

        return
                patientRepo.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient DiagnosisOrEdit(Patient patient,int pId) {

        //todo check if exist
        Patient oldPatient = patientRepo.findById(pId);

        oldPatient.setAge(patient.getAge());
        oldPatient.setDeciduousTeeth(patient.getDeciduousTeeth());
        oldPatient.setCareWays(patient.getCareWays());
        oldPatient.setHabits(patient.getHabits());
        oldPatient.setFamilyStatus(patient.getFamilyStatus());
        oldPatient.setLastVisitToADoctor(patient.getLastVisitToADoctor());
        oldPatient.setEmail(patient.getEmail());
        oldPatient.setAddress(patient.getAddress());
        oldPatient.setDiscountType(patient.getDiscountType());



       Patient result= patientRepo.save(oldPatient);

        if (result.getDeciduousTeeth()!=null)
        {
            //TODO check if Diagnosed Before
           List<PatientTooth> test= patientToothService.GetPatientTeeth(pId);
           if(test.isEmpty())
            patientToothService.addPatientTooth(result);
        }


        return result;
    }




    @Override
    public List<Patient> searchPatient(String name) {
        List<Patient> patient = patientRepo.findAllByFullName(name);
        if(patient.isEmpty()){
            throw new NotFoundException("No Patient with this name");
        }
        else return patient;
    }

    @Override
    public Patient getPatient(Integer id) {
        if(patientRepo.existsById(id))
        return patientRepo.findById(id).get();
        else throw new NotFoundException("Patient NotFound");
    }

    @Override
    public Image addImage(int pId, Image image) {
        Patient patient= getPatient(pId);
        image.setPatient(patient);
        Image im = imageRepo.save(image);
        patient.getGallery().add(image);
        return im;
    }

    @Override
    public File addFile(int pId, File file) {
        Patient patient = getPatient(pId);
        file.setPatient(patient);
        File fi = fileRepo.save(file);
        patient.getFilesList().add(file);
        return fi;
    }

    @Override
    public MedHistory addMedHis(int pId,int IID,String notes) {
        Patient patient = getPatient(pId);
        Illness illness =illnessService.getIllness(IID);
        MedHistory medHistory = new MedHistory();
        medHistory.setIllness(illness);
        medHistory.setPatient(patient);
        MedHistory me = medHisRepo.save(medHistory);
        patient.getMedHistoryList().add(medHistory);
        return me;
    }

    @Override
    public List<Image> getAllImage(int id) {
        Patient patient = patientRepo.findById(id);
        return imageRepo.findAllByPatient(patient);
    }


    @Override
    public List<File> getAllFile(int id) {
        Patient patient = patientRepo.findById(id);
        return fileRepo.findAllByPatient(patient);
    }

    @Override
    public List<MedHistory> getAllMedHis(int id) {
        Patient patient = patientRepo.findById(id);
        return medHisRepo.findAllByPatient(patient);
    }


}