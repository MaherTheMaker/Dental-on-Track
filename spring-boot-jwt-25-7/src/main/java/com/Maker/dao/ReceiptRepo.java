package com.Maker.dao;


import com.Maker.model.Appointment;
import com.Maker.model.Expenses;
import com.Maker.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.ReverbType;
import java.util.Date;
import java.util.List;

@Repository

public interface ReceiptRepo extends JpaRepository<Receipt,Integer> {

    List<Expenses> findAllBySafeName(String safeName);
    List<Expenses> findAllBySafeNameAndDate(String SafeName,Date date);
    List<Receipt> findAllByDate(Date date);
    List<Receipt> findAllByDateBetween(Date date1, Date date2);






}
