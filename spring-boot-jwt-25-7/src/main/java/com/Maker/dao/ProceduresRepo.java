package com.Maker.dao;

import com.Maker.model.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProceduresRepo extends JpaRepository<Procedures,Integer> {
    Procedures findById(int id);
    Procedures findByPName (String name);
}
