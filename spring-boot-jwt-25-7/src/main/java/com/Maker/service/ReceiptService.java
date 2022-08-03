package com.Maker.service;


import com.Maker.model.ReceiptForm;
import com.Maker.model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceiptService {
    Receipt add(int id, ReceiptForm receipt);
    Receipt editReceipt(int id, Receipt receipt);
    Receipt getReceipt(int id);
    List<Receipt> getAllReceipt(Date date);
    List<Receipt> getAllReceiptRange(Date startDate,Date endDate);
    List<Receipt> getAllReceipt();
}
