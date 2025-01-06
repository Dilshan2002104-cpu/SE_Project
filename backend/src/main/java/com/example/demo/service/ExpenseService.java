package com.example.demo.service;

import com.example.demo.Repository.ExpenseRepository;
import com.example.demo.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id,Expense expenseDetails) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if (expenseOptional.isPresent()) {
            Expense expense = expenseOptional.get();

            expense.setDate(expenseDetails.getDate());
            expense.setDescription(expenseDetails.getDescription());
            expense.setCategory(expenseDetails.getCategory());
            expense.setAmount(expenseDetails.getAmount());

            return expenseRepository.save(expense);
        }
        return null;
    }

    public boolean deleteExpense(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            expenseRepository.delete(expense.get());
            return true;
        }
        return false;
    }
}
