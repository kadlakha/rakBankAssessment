package com.assessment.expenseService.model;

public class NotificationRequest {

	private String budgetCategory;
	private double budgetAmount;
	private String expenseDescription;
	private double expenseAmount;

	public NotificationRequest(String budgetCategory, double budgetAmount, String expenseDescription,
			double expenseAmount) {
		this.budgetCategory = budgetCategory;
		this.budgetAmount = budgetAmount;
		this.expenseDescription = expenseDescription;
		this.expenseAmount = expenseAmount;
	}

	public String getBudgetCategory() {
		return budgetCategory;
	}

	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	public double getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
}
