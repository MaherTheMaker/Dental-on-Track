package com.Maker.service;



import com.Maker.dao.ClinicRepo;
import com.Maker.dao.ExpensesRepo;
import com.Maker.dao.ReceiptRepo;
import com.Maker.dao.UserDao;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ClinicServiceImp implements ClinicService {

    //TODO some validation

    @Autowired
    private ClinicRepo clinicRepo;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Autowired
    private ExpensesRepo expensesRepo;


    @Autowired
    private ReceiptRepo receiptRepo;
    @Override
    public Clinic editInfo(Clinic clinic) {
        // have to be 1
        Clinic old= clinicRepo.findById(1);
        if(old != null) {
            old.setClinicAddress(clinic.getClinicAddress());
            old.setClinicName(clinic.getClinicName());
            old.setClinicPhone(clinic.getClinicPhone());
            old.setMobilePhone(clinic.getMobilePhone());
            return clinicRepo.save(old);
        } else throw new NotFoundException("no Clinic with this information");


    }

    @Override
    public DAOUser createUser(int role,UserDTO user) {
        DAOUser daoUser=new DAOUser();
        daoUser.setUsername(user.getUsername());
        daoUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        if (role==1)
        {
            daoUser.setRole(Role.Assistant);
        }
        else if (role==2)
        {
            daoUser.setRole(Role.Secretary);
        }


        return   userDao.save(daoUser);

    }

    @Override
    public DAOUser changePassword(String username, String newPass) {
        DAOUser daoUser= userDao.findByUsername(username);
        if(daoUser !=null) {
            daoUser.setPassword(bcryptEncoder.encode(newPass));
            return userDao.save(daoUser);
        }
        else throw new NotFoundException("there is no user with this username");
    }

    @Override
    public DAOUser changeUserInfo(DAOUser daoUser) {
        DAOUser daoUser1 = userDao.findById(daoUser.getId()) ;
        if(daoUser1 != null) {
            daoUser1.setFullName(daoUser.getFullName());
            daoUser1.setAddress(daoUser.getAddress());
            daoUser1.setRole(daoUser.getRole());
            daoUser1.setNumber(daoUser.getNumber());
            daoUser1.setEmail(daoUser.getEmail());
            return userDao.save(daoUser1) ;
        }
        else throw new NotFoundException("User Not Found");
    }


    @Override
    public float getProfit(Date from, Date to) {
        List<Expenses> expensesList = expensesRepo.findAllByDateBetween(from , to);
        List<Receipt>  receiptList = receiptRepo.findAllByDateBetween(from , to );
        float expensesBalance  = 0;     int j = 0 ;
        float receiptBalance = 0;       int i = 0;

        for (Expenses expenses : expensesList) {
            expensesBalance += expenses.getTotalPrice();
        }

        for(Receipt receipt :receiptList){
            receiptBalance += receipt.getTotal();
        }

        return receiptBalance - expensesBalance;
    }


}