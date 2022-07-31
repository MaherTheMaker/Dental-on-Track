package com.Maker.service;

import com.Maker.dao.MyProcedureRepo;
import com.Maker.model.MyProcedure;
import com.Maker.model.NotFoundException;
import com.Maker.model.ObjectAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedureServiceImp implements ProceduresService {

    //TODO some validation...Done


    @Autowired
    private MyProcedureRepo prodRepo;

    @Override
    public MyProcedure addProcedure(MyProcedure myProcedure) {
        MyProcedure procedure1 = prodRepo.findByPName(myProcedure.getpName());
        if(procedure1 ==null){

            return prodRepo.save(myProcedure);

        }else throw new ObjectAlreadyExist("Procedure Already Exists");

    }

    @Override
    public List<MyProcedure> ShowProcedure() {
        return prodRepo.findAll();
    }

    @Override
    public MyProcedure getProcedure(String name) {
        MyProcedure procedures = prodRepo.findByPName(name);
        if(procedures == null )
        {
            throw new NotFoundException("Procedure Not Found");
        }else
            return procedures;
    }

    @Override
    public MyProcedure editProcedure(String name, MyProcedure pro) {
//Todo check if exist
        MyProcedure procedure = getProcedure(name);
        procedure.setpName(pro.getpName());
        procedure.setDefaultPrice(pro.getDefaultPrice());
        procedure.setDefaultNumberOfAppointments(pro.getDefaultNumberOfAppointments());
        procedure.setNotes(pro.getNotes());
        return prodRepo.save(procedure);
    }


}
