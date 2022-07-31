package com.Maker.service;

import com.Maker.dao.TransactionRepo;
import com.Maker.model.MoneySafe;
import com.Maker.model.NotFoundException;
import com.Maker.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction add(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction getTransaction(int  transactionId) {
        if(transactionRepo.existsById(transactionId))
        {
            return transactionRepo.findById(transactionId).get();

        }else
            throw new NotFoundException("Transaction not found");
    }

    @Override
    public List<Transaction> getAllTransaction(Date date) {
        return transactionRepo.findAllByDate(date);
    }

    @Override
    public List<Transaction> getAllTransaction(String safeName) {
        //Todo validation if MoneySafe Exists
        return transactionRepo.findAllBySafeName(safeName);
    }


    @Override
    public List<Transaction> getAllTransactionBySafeAndDate(String safeName, Date date) {

        //Todo validation if MoneySafe Exists.
        return transactionRepo.findAllBySafeNameAndDate(safeName, date);
    }






}
