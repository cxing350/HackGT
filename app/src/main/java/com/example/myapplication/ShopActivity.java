package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent myIntent = getIntent();
        Bundle b = myIntent.getExtras();
        HashMap<String, Integer> userItems = new HashMap<>();
        TextView text = findViewById(R.id.name);
        try {
            int count = 0;
            String item = b.getString(count + "b");
            Integer quantity = b.getInt(count + "a");
            while (item != null && quantity != null) {
                userItems.put(item, quantity);
                count++;
                item = b.getString(count + "b");
                quantity = b.getInt(count + "a");
            }

            int total = 0;
            for(Integer i:userItems.values()) {
                total += i;
            }
            text.setText(total + "");
        } catch (NullPointerException e) {
            text.setText("Couldn't find hashmap");
        }
    }
}
