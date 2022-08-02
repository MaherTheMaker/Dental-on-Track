package com.Maker.dao;

import com.Maker.model.MoneySafe;
import com.Maker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByDate(LocalDate date);

    List<Transaction> findAllBySafeName( String moneySafe);
    List<Transaction> findAllBySafeNameAndDate(String moneySafe , LocalDate date);

}
