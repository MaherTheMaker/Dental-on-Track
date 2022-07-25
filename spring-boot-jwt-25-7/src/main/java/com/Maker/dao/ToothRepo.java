package com.Maker.dao;

import com.Maker.model.Tooth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToothRepo extends JpaRepository<Tooth,Integer> {
    Tooth findById(int id);
}
