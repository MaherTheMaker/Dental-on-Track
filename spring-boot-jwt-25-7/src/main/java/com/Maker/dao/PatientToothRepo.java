package com.Maker.dao;

import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientToothRepo extends JpaRepository<PatientTooth,Integer> {
   List<PatientTooth> findAllByPatientId(int pid);

}

