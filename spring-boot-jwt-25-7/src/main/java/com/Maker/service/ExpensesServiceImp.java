package com.Maker.service;

import com.Maker.dao.ExpensesRepo;
import com.Maker.dao.UserDao;
import com.Maker.model.Expenses;
import com.Maker.model.MoneySafe;
import com.Maker.model.NotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Repository
public class ExpensesServiceImp implements ExpensesService {

    @Autowired
    private ExpensesRepo expensesRepo;


    @Autowired
    private UserDao userDao;

    @Autowired
    private MoneySafeService moneySafeService;

    @Override
    public Expenses add(ExpensesForm expenses) {
        Expenses e = new Expenses();
        e.setDaoUser(userDao.findByUsername(expenses.daoUserName));
        e.setMoneySafe(moneySafeService.getMoneySafe(expenses.safeName));
        e.setSafeName(expenses.safeName);
        e.setDetails(expenses.details);
        e.setDate(expenses.date);
        e.setDaoUserName(expenses.daoUserName);
        return expensesRepo.save(e);
    }

    @Override
    public Expenses getExpense(int id) {
        if(expensesRepo.existsById(id)){
            return expensesRepo.findById(id).get();
        }
        else throw new NotFoundException("No Expense with this name");
    }

    @Override
    public List<Expenses> getExpenses(Date date) {
        return expensesRepo.findAllByDate(date);
    }

    @Override
    public List<Expenses> getMoneySafeExpenses(String safeName) {
        return expensesRepo.findAllBySafeName(safeName);
    }

    @Override
    public List<Expenses> getMoneySafeExpensesInDate(String safeName,Date date) {
        return expensesRepo.findAllBySafeNameAndDate(safeName,date);
    }
}


