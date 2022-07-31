package com.Maker.service;

import com.Maker.dao.ExpensesRepo;
import com.Maker.model.Expenses;
import com.Maker.model.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ExpensesServiceImp implements ExpensesService {

    @Autowired
    private ExpensesRepo expensesRepo;

    @Override
    public Expenses add(Expenses expenses) {
        return expensesRepo.save(expenses);
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
        return expensesRepo.findAllByMoneySafe(safeName);
    }

    @Override
    public List<Expenses> getMoneySafeExpensesInDate(String safeName,Date date) {
        return expensesRepo.findAllByMoneySafeAndDate(safeName,date);
    }
}
