package com.assessment.budgetService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.budgetService.model.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
	Budget findByCategory(String category);
}