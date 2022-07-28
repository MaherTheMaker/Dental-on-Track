package com.Maker.service;

import com.Maker.dao.IllnessRepo;
import com.Maker.model.Illness;
import com.Maker.model.NotFoundException;
import com.Maker.model.ObjectAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IllnessServiceImp implements IllnessService {

    //TODO some validation

    @Autowired
    private IllnessRepo illnessRepo;
    @Override
    public Illness addIllness(Illness illness) {
      Illness illness1 = illnessRepo.findByName(illness.getName());
      if(illness1 == null)
       return illnessRepo.save(illness);
      else
          throw new NotFoundException("Illness already exists");

    }

    @Override
    public Illness getIllness(String name) {
        Illness illness1 = illnessRepo.findByName(name);
        if(illness1 == null){
            throw new NotFoundException("No Illness Exists with this name");
        }else return illness1;
    }

    @Override
    public Illness getIllness(int id) {  return illnessRepo.findById(id).orElseThrow(()
            ->new NotFoundException("No Illness Present With this details"));     }

    @Override
    public List<Illness> getAllIllness() {
        return illnessRepo.findAll();
    }
}
