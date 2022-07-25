package com.Maker.dao;

import com.Maker.model.File;
import com.Maker.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepo extends JpaRepository<File,Integer> {
    List<File> findAllByPatient(Patient patient);

}
