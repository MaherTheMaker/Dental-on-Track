package com.Maker.service;

import com.Maker.model.DAOUser;
import com.Maker.model.MoneySafe;
import com.Maker.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionService {

    Transaction add(Transaction transaction);
    Transaction getTransaction (int id);
    List<Transaction> getAllTransaction (Date date);
    List<Transaction> getAllTransaction (String safeName);

    List<Transaction> getAllTransactionBySafeAndDate(String safeName, Date date);


}
