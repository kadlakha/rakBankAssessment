package com.assessment.budgetService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.budgetService.model.Budget;
import com.assessment.budgetService.service.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        return new ResponseEntity<>(budgetService.createBudget(budget), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudget(@PathVariable Long id) {
        return budgetService.getBudget(id)
            .map(budget -> new ResponseEntity<>(budget, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<Budget> getBudgetByCategory(@PathVariable String category) {
        Budget budget = budgetService.getBudgetByCategory(category);
        if (budget != null) {
            return ResponseEntity.ok(budget);
        }
        return ResponseEntity.notFound().build();
    }
}