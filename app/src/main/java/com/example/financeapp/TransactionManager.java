package com.example.financeapp;

import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<Transaction> transactions;
    private int nextId;

    public TransactionManager() {
        transactions = new ArrayList<>();
        nextId = 1; // Start IDs from 1
    }

    // Add a new transaction
    public void addTransaction(String description, double amount) {
        Transaction transaction = new Transaction(nextId++, description, amount);
        transactions.add(transaction);
    }

    // Remove a transaction by id
    public void removeTransaction(int id) {
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                transactions.remove(transaction);
                break;
            }
        }
    }

    // Get all transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}

