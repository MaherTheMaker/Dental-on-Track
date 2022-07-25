package com.Maker.service;

import com.Maker.dao.ProceduresRepo;
import com.Maker.model.Procedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedureServiceImp implements ProceduresService {

    @Autowired
    private ProceduresRepo prodRepo;

    @Override
    public Procedures addProcedure(Procedures procedure) {
        return prodRepo.save(procedure);

    }

    @Override
    public List<Procedures> ShowProcedure() {
        return prodRepo.findAll();
    }

    @Override
    public Procedures getProcedure(String name) {
        return prodRepo.findByPName(name);
    }

    @Override
    public Procedures editProcedure(String name,Procedures pro) {

         Procedures procedure = prodRepo.findByPName(name);
         procedure.setpName(pro.getpName());
         procedure.setDefaultPrice(pro.getDefaultPrice());
         procedure.setDefaultNumberOfAppointments(pro.getDefaultNumberOfAppointments());
         procedure.setNotes(pro.getNotes());
         return prodRepo.save(procedure);
    }

}
