package com.example.financeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
public class DataBase extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        DBHandler db = new DBHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = (ListView) findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(DataBase.this, userList, R.layout.list_row,new String[]{"name","designation","location"}, new int[]{R.id.name, R.id.designation, R.id.location});
        lv.setAdapter(adapter);
        Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DataBase.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}