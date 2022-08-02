package com.Maker.service;

import com.Maker.dao.TransactionRepo;
import com.Maker.model.MoneySafe;
import com.Maker.model.NotFoundException;
import com.Maker.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;


    @Autowired
    private MoneySafeService moneySafeService;

    @Override
    public Transaction add(Transaction transaction, int id) {
            transaction.setFromSafe(moneySafeService.getMoneySafe(id));
            transaction.setSafeName(transaction.getFromSafe().getName());
            transaction.setDate(LocalDate.now());
            transaction.setPayment(moneySafeService.getMoneySafe(id).getBalance());
            if(transaction.getPayment() > 0){
                moneySafeService.addTransactionAmount(transaction.getPayment());
                moneySafeService.getMoneySafe(id).setBalance(0);
            }
            else throw new NotFoundException("No payments Method Today");

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
    public List<Transaction> getAllTransaction(LocalDate date) {
        return transactionRepo.findAllByDate(date);
    }

    @Override
    public List<Transaction> getAllSafeTransaction(String safeName) {
        MoneySafe safe = moneySafeService.getMoneySafe(safeName);
        //Todo validation if MoneySafe Exists
        return transactionRepo.findAllBySafeName(safeName);
    }

    @Override
    public List<Transaction> getAllTransactionBySafeAndDate(String safeName, LocalDate date) {

        MoneySafe safe = moneySafeService.getMoneySafe(safeName);
        //Todo validation if MoneySafe Exists.
        return transactionRepo.findAllBySafeNameAndDate(safeName,date);
    }






}
