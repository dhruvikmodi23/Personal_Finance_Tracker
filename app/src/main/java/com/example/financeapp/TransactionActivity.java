package com.example.financeapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity implements ShowTransaction.OnTransactionRemoveListener {

    private TransactionManager transactionManager;
    private ShowTransaction adapter;
    private RecyclerView recyclerView;
    private EditText etDescription, etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        transactionManager = new TransactionManager();

        etDescription = findViewById(R.id.etDescription);
        etAmount = findViewById(R.id.etAmount);
        Button btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShowTransaction(transactionManager.getTransactions(), this);
        recyclerView.setAdapter(adapter);

        // Add transaction button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = etDescription.getText().toString();
                double amount = Double.parseDouble(etAmount.getText().toString());

                transactionManager.addTransaction(description, amount);
                adapter.notifyDataSetChanged();  // Refresh the RecyclerView

                etDescription.setText("");
                etAmount.setText("");
            }
        });
    }

    // Handle transaction removal
    @Override
    public void onTransactionRemove(int transactionId) {
        transactionManager.removeTransaction(transactionId);
        adapter.notifyDataSetChanged();  // Refresh the RecyclerView
    }
}
