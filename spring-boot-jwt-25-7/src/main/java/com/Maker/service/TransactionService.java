package com.Maker.service;

import com.Maker.model.DAOUser;
import com.Maker.model.MoneySafe;
import com.Maker.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionService {

    Transaction add(Transaction transaction, int id);
    Transaction getTransaction (int id);
    List<Transaction> getAllTransaction (LocalDate date);
    List<Transaction> getAllSafeTransaction (String safeName);

    List<Transaction> getAllTransactionBySafeAndDate(String safeName, LocalDate date);


}
