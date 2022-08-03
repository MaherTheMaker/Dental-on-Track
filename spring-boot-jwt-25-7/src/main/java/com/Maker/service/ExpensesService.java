package com.Maker.service;

import com.Maker.model.Expenses;
import org.apache.tomcat.util.security.Escape;

import java.util.Date;
import java.util.List;

public interface ExpensesService {
    Expenses add(ExpensesForm expenses);
    Expenses getExpense(int id);
    List<Expenses> getExpensesDate(Date date);
    List<Expenses> getExpensesDateRange(Date start,Date end);
    List<Expenses> getMoneySafeExpenses(String safeName);

    List<Expenses> getMoneySafeExpensesInDate(String safeName,Date date);
}
