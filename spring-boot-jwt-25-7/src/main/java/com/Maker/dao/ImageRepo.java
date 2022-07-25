package com.Maker.dao;

import com.Maker.model.Image;
import com.Maker.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image, Integer> {
    List<Image> findAllByPatient(Patient patient);
}
