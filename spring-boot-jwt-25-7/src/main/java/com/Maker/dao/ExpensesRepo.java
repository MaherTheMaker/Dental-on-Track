package com.Maker.dao;

import com.Maker.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses,Integer> {

    List<Expenses> findAllByDate(Date date);
    List<Expenses> findAllBySafeName(String safeName);
    List<Expenses> findAllBySafeNameAndDate(String SafeName,Date date);
}
