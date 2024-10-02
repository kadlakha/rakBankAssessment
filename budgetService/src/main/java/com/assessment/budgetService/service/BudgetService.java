package com.assessment.budgetService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.budgetService.model.Budget;
import com.assessment.budgetService.repository.BudgetRepository;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget createBudget(Budget bud) {
        Budget budget = budgetRepository.findByCategory(bud.getCategory());

        if (budget != null) {
            budget.setAmount(bud.getAmount());
            return budgetRepository.save(budget);
        } else {
            budget = new Budget();
            budget.setCategory(bud.getCategory());
            budget.setAmount(bud.getAmount());
            return budgetRepository.save(budget);
        }
    }

    public Optional<Budget> getBudget(Long id) {
        return budgetRepository.findById(id);
    }
    
    public Budget getBudgetByCategory(String category) {
        return budgetRepository.findByCategory(category);
    }
}