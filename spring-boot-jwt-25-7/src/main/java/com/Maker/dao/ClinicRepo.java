package com.Maker.dao;

import com.Maker.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClinicRepo extends JpaRepository<Clinic, Integer> {
    Clinic findById(int id);
}