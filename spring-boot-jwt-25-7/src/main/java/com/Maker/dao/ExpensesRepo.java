package com.Maker.dao;

import com.Maker.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpensesRepo extends JpaRepository<Expenses,Integer> {

    List<Expenses> findAllByDate(Date date);
    List<Expenses> findAllByMoneySafe(String safeName);
    List<Expenses> findAllByMoneySafeAndDate(String SafeName,Date date);
}
