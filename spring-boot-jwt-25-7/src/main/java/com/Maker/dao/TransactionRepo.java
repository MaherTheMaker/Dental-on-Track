package com.Maker.dao;

import com.Maker.model.MoneySafe;
import com.Maker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByDate(Date date);
    List<Transaction> findAllBySafeName(String safeName);
    List<Transaction> findAllBySafeNameAndDate(String safeName,Date date);

}
