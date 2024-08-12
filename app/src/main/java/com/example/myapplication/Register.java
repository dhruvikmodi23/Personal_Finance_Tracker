package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    Button Reg;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        Username = findViewById(R.id.username1);
        Password = findViewById(R.id.password1);
        Reg = findViewById(R.id.register);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle the signup logic here
                    DBHandler dbHandler = new DBHandler(Register.this);
                    dbHandler.insertUserDetails(username, password);
                    Toast.makeText(Register.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    // You can also start another activity here if needed
                }
            }
        });

    }
}