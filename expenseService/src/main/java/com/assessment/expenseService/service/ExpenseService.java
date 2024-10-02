package com.assessment.expenseService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.expenseService.model.Budget;
import com.assessment.expenseService.model.Expense;
import com.assessment.expenseService.model.NotificationRequest;
import com.assessment.expenseService.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public Expense addExpense(Expense expense) {
    	 String budgetServiceUrl = "http://localhost:8081/budgets/category/" + expense.getCategory();
         Budget budget = restTemplate.getForObject(budgetServiceUrl, Budget.class);

         if (budget != null && expense.getAmount() > budget.getAmount()) {
             sendNotification(expense, budget);
         }

         return expenseRepository.save(expense);
    }
    
    private void sendNotification(Expense expense, Budget budget) {
        // Logic for sending notifications
        NotificationRequest notificationRequest = new NotificationRequest(
            budget.getCategory(),
            budget.getAmount(),
            expense.getDescription(),
            expense.getAmount()
        );

        String notificationServiceUrl = "http://localhost:8083/notifications";
        restTemplate.postForObject(notificationServiceUrl, notificationRequest, String.class);
    }
}
