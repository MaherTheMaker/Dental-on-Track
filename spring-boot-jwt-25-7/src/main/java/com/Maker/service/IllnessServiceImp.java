package com.Maker.service;

import com.Maker.dao.IllnessRepo;
import com.Maker.model.Illness;
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
        return illnessRepo.save(illness);
    }

    @Override
    public Illness getIllness(String name) {
        return illnessRepo.findByName(name);
    }

    @Override
    public Illness getIllness(int id) {  return illnessRepo.findById(id).get();     }

    @Override
    public List<Illness> getAllIllness() {
        return illnessRepo.findAll();
    }
}
