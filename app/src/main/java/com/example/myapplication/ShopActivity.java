package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ShopActivity extends AppCompatActivity {
    double[] companyAPrices = {2.50, 3.5, 2.25, 2.00, 1.00, 1.50, 1.75, 2.40, 4.20, 5.55};
    Shop CompanyA = new Shop(companyAPrices);
    double[] companyBPrices = {2.50, 3.5, 2.25, 2.00, 1.00, 1.50, 1.75, 2.40, 4.20, 5.55};
    Shop CompanyB = new Shop(companyBPrices);
    double[] companyCPrices = {2.50, 3.5, 2.25, 2.00, 1.00, 1.50, 1.75, 2.40, 4.20, 5.55};
    Shop CompanyC = new Shop(companyCPrices);

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent myIntent = getIntent();
        Bundle b = myIntent.getExtras();
        HashMap<String, Integer> userItems = new HashMap<>();
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
        } catch (NullPointerException e) {
        }


//        textField.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                    shoppingList.addView(new ListEntry(MainActivity.this, textField.getText().toString(), items));
//                    items.put(textField.getText().toString(), 1);
//                    textField.setText("");
//                    return true;
//                }
//                return false;
//            }
//        });
        LinearLayout ShopTotal = findViewById(R.id.ShopTotal);

       TextView ShopAndTotalA = new TextView(this);



       ShopAndTotalA.setText(String.format("Company A $%.2f", product(userItems, CompanyA.getShopList())));
       ShopTotal.addView(ShopAndTotalA);

        TextView ShopAndTotalB = new TextView(this);
        ShopAndTotalB.setText(String.format("Company B $%.2f", product(userItems, CompanyB.getShopList())));
        ShopTotal.addView(ShopAndTotalB);

        TextView ShopAndTotalC = new TextView(this);
        ShopAndTotalC.setText(String.format("Company C $%.2f", product(userItems, CompanyC.getShopList())));
        ShopTotal.addView(ShopAndTotalC);

        LinearLayout ShopItems = findViewById(R.id.ShopItems);



       /* TextView ShopAndTotalD = new TextView(this);
        ShopAndTotalD.setText("Company CfdfsddsAAAAA   " + "$12.50");
        ShopItems.addView(ShopAndTotalD);
        TextView ShopAndTotal1 = new TextView(this);
        ShopAndTotal1.setText("Company CfdfsddfgdfsgBBBBBB   " + "$12.50");
        ShopItems.addView(ShopAndTotal1);
        TextView ShopAndTotal2 = new TextView(this);
        ShopAndTotal2.setText("Company CfdfsddfsgsdgrCCCCC   " + "$12.50");
        ShopItems.addView(ShopAndTotal2);
        TextView ShopAndTotal3 = new TextView(this);
        ShopAndTotal3.setText("Company CfdfsdgsrgreerDDDDD   " + "$12.50");
        ShopItems.addView(ShopAndTotal3);*/
       Map.Entry<String, Integer>[] entries = userItems.entrySet().toArray(new Map.Entry[0]);

       for(Map.Entry<String, Integer> e:entries) {
           LinearLayout layout = new LinearLayout(this);
           layout.setOrientation(LinearLayout.VERTICAL);
           TextView itemText = new TextView(this);
           itemText.setText(e.getKey() + " " + e.getValue() + "x\n");
           itemText.setTypeface(itemText.getTypeface(), Typeface.BOLD);
           layout.addView(itemText);

           TextView CAText = new TextView(this);
           if(CompanyA.getShopList().get(e.getKey()) != null) {
               CAText.setText(String.format("$%.2f" + "\n", CompanyA.getShopList().get(e.getKey())));
           } else {
               CAText.setText("Not available\n");
           }
           layout.addView(CAText);

           TextView CBText = new TextView(this);
           if(CompanyB.getShopList().get(e.getKey()) != null) {
            CBText.setText(String.format("$%.2f" + "\n", CompanyB.getShopList().get(e.getKey())));
           } else {
               CBText.setText("Not available\n");
           }
           layout.addView(CBText);

           TextView CCText = new TextView(this);
           if(CompanyC.getShopList().get(e.getKey()) != null) {
           CCText.setText(String.format("$%.2f" + "\n", CompanyC.getShopList().get(e.getKey())));
           } else {
               CCText.setText("Not available\n");
           }
           layout.addView(CCText);

           LinearLayout.LayoutParams params =
                   new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                           LinearLayout.LayoutParams.WRAP_CONTENT);
           params.setMargins(10, 0, 10, 0);
           layout.setLayoutParams(params);

           ShopItems.addView(layout);
       }

    }

    private double product(HashMap<String, Integer> h1, HashMap<String, Double> h2) {
        double sum = 0;
        Set<String> items = h1.keySet();
        for(String item:items) {
            if (h1.get(item) != null && h2.get(item) != null) {
                sum += h1.get(item) * h2.get(item);
            }
        }
        return sum;
    }
}
