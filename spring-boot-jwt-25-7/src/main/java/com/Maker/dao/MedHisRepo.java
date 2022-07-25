package com.Maker.dao;

import com.Maker.model.File;
import com.Maker.model.MedHistory;
import com.Maker.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MedHisRepo extends JpaRepository<MedHistory,Integer> {
    List<MedHistory> findAllByPatient(Patient patient);
    List<MedHistory> findAllByIllness(Patient patient);

}
