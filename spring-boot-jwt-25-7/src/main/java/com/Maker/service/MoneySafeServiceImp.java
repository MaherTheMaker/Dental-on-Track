package com.Maker.service;

import com.Maker.dao.MoneySafeRepo;
import com.Maker.dao.UserDao;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MoneySafeServiceImp implements MoneySafeService{

    @Autowired
    private MoneySafeRepo moneySafeRepo;

    @Autowired
    private UserDao userDao;



    @Override
    public MoneySafe addMoneySafe(MoneySafe moneySafe,int uID) {
        DAOUser daoUser1 = userDao.findById(uID);

        MoneySafe moneySafe1 = moneySafeRepo.findByName(moneySafe.getName());
        if(moneySafe1 == null)
            // set user ti safe
            return moneySafeRepo.save(moneySafe);
        else
            throw new NotFoundException("SafeName already exists");

    }


    @Override
    public MoneySafe editMoneySafe(int id, MoneySafe moneySafe) {
        MoneySafe moneySafe2;
        Optional<MoneySafe> moneySafe1 = moneySafeRepo.findById(id);
        if(!moneySafe1.isPresent()){
            throw new NotFoundException("No moneySafe Exists with this ID");
        }
        else moneySafe2= moneySafe1.get();

        moneySafe2.setDaoUsers(moneySafe.getDaoUsers());
        moneySafe2.setName(moneySafe.getName());

        return  moneySafeRepo.save(moneySafe2);
    }

    @Override
    public MoneySafe AddBalancedMoneySafe(int id, float balance) {
        MoneySafe moneySafe2;
        Optional<MoneySafe> moneySafe1 = moneySafeRepo.findById(id);
        if(!moneySafe1.isPresent()){
            throw new NotFoundException("No moneySafe Exists with this ID");
        }

        else moneySafe2= moneySafe1.get();


        moneySafe2.addToBalance(balance);

        return  moneySafeRepo.save(moneySafe2);
    }

    @Override
    public MoneySafe TakeBalancedMoneySafe(int id, float balance) {
        MoneySafe moneySafe2;
        Optional<MoneySafe> moneySafe1 = moneySafeRepo.findById(id);
        if(!moneySafe1.isPresent()){
            throw new NotFoundException("No moneySafe Exists with this ID");
        }

        else moneySafe2= moneySafe1.get();

        if(moneySafe2.getBalance()<balance)
            throw  new BalanceNotEnough("Not Enough Money in the safe to add this expense ");
        moneySafe2.takeFromBalance(balance);

        return  moneySafeRepo.save(moneySafe2);
    }

    @Override
    public MoneySafe getMoneySafe(String username) {
        MoneySafe moneySafe1 = moneySafeRepo.findByName(username);
        if(moneySafe1 == null){
            throw new NotFoundException("No moneySafe Exists with this name");
        }
        else return moneySafe1;

    }


    @Override
    public MoneySafe getMoneySafe(int id) {
        Optional<MoneySafe> moneySafe1 = moneySafeRepo.findById(id);
        if(!moneySafe1.isPresent()){
            throw new NotFoundException("No moneySafe Exists with this ID");
        }
        else return moneySafe1.get();
    }



    @Override
    public List<MoneySafe> getAllMoneySafe() {
        return moneySafeRepo.findAll();
    }



}
