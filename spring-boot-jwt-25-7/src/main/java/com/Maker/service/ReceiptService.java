package com.Maker.service;

import com.Maker.model.Receipt;
import com.Maker.model.ReceiptForm;

import java.util.Date;
import java.util.List;

public interface ReceiptService {
    Receipt add(int id, ReceiptForm receipt);

    Receipt editReceipt(int recId, Receipt receipt);

    Receipt getReceipt(int id);

    List<Receipt> getAllReceipt(Date date);

    List<Receipt> getAllReceipt();
}
