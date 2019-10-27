package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, Integer> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textField = findViewById(R.id.textField);

        final LinearLayout shoppingList = findViewById(R.id.shoppinglist);

        items = new HashMap<>();
        final Button shopButton = findViewById(R.id.shopButton);

        textField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    shoppingList.addView(new ListEntry(MainActivity.this, textField.getText().toString(), items, shoppingList));
                    items.put(textField.getText().toString().toLowerCase(), 1);
                    textField.setText("");
                    return true;
                }
                return false;
            }
        });

        shopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ShopActivity.class);
                Integer[] quantities = items.values().toArray(new Integer[0]);
                String[] itemArray = items.keySet().toArray(new String[0]);
                for(int i = 0; i < quantities.length; i++) {
                    myIntent.putExtra(i + "a", quantities[i].intValue());
                    myIntent.putExtra(i + "b", itemArray[i]);
                }
                startActivity(myIntent);
            }

        });
    }
}
