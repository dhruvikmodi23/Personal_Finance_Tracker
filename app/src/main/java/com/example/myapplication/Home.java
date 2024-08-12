package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private TextView balanceText;
    private Button addTransactionButton;
    private Button viewReportsButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI components
        balanceText = findViewById(R.id.balanceText);
        addTransactionButton = findViewById(R.id.addTransactionButton);
        viewReportsButton = findViewById(R.id.viewReportsButton);
        settingsButton = findViewById(R.id.settingsButton);

        // Set click listeners for buttons
        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, AddTransactionActivity.class));
            }
        });

        viewReportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, ViewReportsActivity.class));
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        // Update balance text

    }

    private void updateBalance(String balance) {
        balanceText.setText("Total Balance: ₹" + balance);
    }
}