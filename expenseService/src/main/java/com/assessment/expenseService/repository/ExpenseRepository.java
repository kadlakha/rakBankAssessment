package com.assessment.expenseService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.expenseService.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
