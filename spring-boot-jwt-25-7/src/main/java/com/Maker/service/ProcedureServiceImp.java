package com.Maker.service;

import com.Maker.dao.MyProcedureRepo;
import com.Maker.model.MyProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedureServiceImp implements ProceduresService {

    //TODO some validation


    @Autowired
    private MyProcedureRepo prodRepo;

    @Override
    public MyProcedure addProcedure(MyProcedure myProcedure) {
        return prodRepo.save(myProcedure);

    }

    @Override
    public List<MyProcedure> ShowProcedure() {
        return prodRepo.findAll();
    }

    @Override
    public MyProcedure getProcedure(String name) {
        return prodRepo.findByPName(name);
    }

    @Override
    public MyProcedure editProcedure(String name, MyProcedure pro) {

         MyProcedure myProcedure = prodRepo.findByPName(name);
         myProcedure.setpName(pro.getpName());
         myProcedure.setDefaultPrice(pro.getDefaultPrice());
         myProcedure.setDefaultNumberOfAppointments(pro.getDefaultNumberOfAppointments());
         myProcedure.setNotes(pro.getNotes());
         return prodRepo.save(myProcedure);
    }


}
