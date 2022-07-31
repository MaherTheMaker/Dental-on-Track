package com.Maker.service;

import com.Maker.model.Expenses;
import org.apache.tomcat.util.security.Escape;

import java.util.Date;
import java.util.List;

public interface ExpensesService {
    Expenses add(Expenses expenses);
    Expenses getExpense(int id);
    List<Expenses> getExpenses(Date date);
    List<Expenses> getMoneySafeExpenses(String safeName);

    List<Expenses> getMoneySafeExpensesInDate(String safeName,Date date);
}
