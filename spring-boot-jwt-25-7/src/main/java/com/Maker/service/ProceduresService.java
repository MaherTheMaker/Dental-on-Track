package com.Maker.service;

import com.Maker.model.Procedures;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProceduresService {

    Procedures addProcedure (Procedures procedure);
    List<Procedures> ShowProcedure();
    Procedures getProcedure (String name);
    Procedures editProcedure(String name, Procedures procedure);
}
