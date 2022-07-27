package com.Maker.dao;

import com.Maker.model.MyProcedure;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyProcedureRepo extends JpaRepository<MyProcedure,Integer> {
    MyProcedure findById(int id);
    MyProcedure findByPName (String name);
}
