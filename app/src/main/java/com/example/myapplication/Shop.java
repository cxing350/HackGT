package com.example.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    private HashMap<String, Double> ShopList;

    public Shop(double[] prices) {
        ShopList = new HashMap<String, Double>();

        ShopList.put("hot dogs", prices[0]);
        ShopList.put("bread", prices[1]);
        ShopList.put("cheese", prices[2]);
        ShopList.put("milk", prices[3]);
        ShopList.put("apples", prices[4]);
        ShopList.put("oranges", prices[5]);
        ShopList.put("bananas", prices[6]);
        ShopList.put("chicken", prices[7]);
        ShopList.put("rice", prices[8]);
        ShopList.put("steak", prices[9]);

    }


    public HashMap<String, Double> getShopList() {
        return ShopList;
    }
}


