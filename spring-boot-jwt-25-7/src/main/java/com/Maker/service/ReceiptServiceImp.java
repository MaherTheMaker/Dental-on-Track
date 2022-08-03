package com.Maker.service;


import com.Maker.model.*;
import com.Maker.dao.ReceiptRepo;
import com.Maker.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ReceiptServiceImp implements ReceiptService {

    @Autowired
    private ReceiptRepo receiptRepo;

    @Autowired
    private PatientService patientService;


    @Autowired
    private UserDao userDao;

    @Autowired
    private MoneySafeService moneySafeService;


    @Autowired
    private ProceduresService proceduresService;

    public Receipt add(int id, ReceiptForm receipt) {
        Receipt receipt1 = new Receipt();
        receipt1.setUserName(receipt.getUsername());
        receipt1.setSafeName(receipt.getSafeName());
        receipt1.setDate(receipt.getDate());
        Patient patient=patientService.getPatient(id);
        receipt1.setPatientName(patient.getFullName());
        receipt1.setPatient(patient);
        receipt1.setDiscount(receipt.isDiscount());




        MoneySafe moneySafe=moneySafeService.getMoneySafe(receipt.getSafeName());
        receipt1.setMoneySafe(moneySafe);

        float amount;


        if(receipt1.isDiscount()&&patient.getDiscountType()!=null) {
            float discountPercent = patient.getDiscountType().value;
            amount = receipt.getTotal() - receipt.getTotal() * discountPercent;
        }
        else
            amount=receipt.getTotal();

        moneySafeService.AddBalancedMoneySafe(moneySafe.getId(),amount);

        receipt1.setTotal(amount);

        receipt1.setDaoUser(userDao.findByUsername(receipt.getUsername()));


        return receiptRepo.save(receipt1);
    }

    @Override
    public Receipt editReceipt(int recId, Receipt receipt) {

        if(receiptRepo.existsById(recId)) {

            Receipt receipt1 = receiptRepo.findById(recId).get();
            receipt1.setDaoUser(receipt.getDaoUser());
            receipt1.setMoneySafe(receipt.getMoneySafe());
            receipt1.setTotal(receipt.getTotal());
            receipt1.setProcedure(receipt.getProcedure());
            return receipt1;
        }else throw new NotFoundException("No Receipt with this Id");
    }

    @Override
    public Receipt getReceipt(int id) {
        if(receiptRepo.existsById(id))
        {
            return receiptRepo.findById(id).get();
        } else throw new NotFoundException("No Receipt with this id");
    }

    @Override
    public List<Receipt> getAllReceipt(Date date) {
        return receiptRepo.findAllByDate(date);
    }

    @Override
    public List<Receipt> getAllReceiptRange(Date startDate, Date endDate) {
           return receiptRepo.findAllByDateBetween(startDate,endDate);

    }

    @Override
    public List<Receipt> getAllReceipt() {

        return receiptRepo.findAll();
    }



}
