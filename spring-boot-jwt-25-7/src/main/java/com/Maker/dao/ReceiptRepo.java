package com.Maker.dao;


import com.Maker.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ReceiptRepo extends JpaRepository<Receipt,Integer> {

    List<Receipt> findAllByDate(Date date);




}
