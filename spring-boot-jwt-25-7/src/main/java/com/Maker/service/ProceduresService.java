package com.Maker.service;

import com.Maker.model.MyProcedure;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProceduresService {

    MyProcedure addProcedure (MyProcedure myProcedure);
    List<MyProcedure> ShowProcedure();
    MyProcedure getProcedure (String name);
    MyProcedure editProcedure(String name, MyProcedure myProcedure);
}
