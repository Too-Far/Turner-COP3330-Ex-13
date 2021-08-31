/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void compileMessage(Map<String, Float> values)
    {
        System.out.println("After " + values.get("years") + " years at " + values.get("rate")
                + "%, the investment will be worth $"+ Math.round(values.get("totalValue")));
    }

    public static void calculateInterest(Map<String, Float> values)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        Float total = values.get("principal") * (1 + (values.get("rate") / 100) * values.get("years"));

        values.put("totalValue", Float.valueOf(df.format(total)));
        compileMessage(values);
    }

    public static void getUserInput() throws IOException {
        DecimalFormat df = new DecimalFormat("#.##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> values = new HashMap<>();

        System.out.println("Enter the principal: ");
        values.put("principal", Float.valueOf(df.format(Float.parseFloat(reader.readLine()))));

        System.out.println("Enter the rate of interest: ");
        float rate = Float.parseFloat(df.format(Float.parseFloat(reader.readLine())));
        values.put("rate", Float.parseFloat(df.format(rate)));

        System.out.println("Enter the number of years");
        values.put("years", Float.valueOf(df.format(Float.parseFloat(reader.readLine()))));

        calculateInterest(values);
    }

    public static void main( String[] args ) throws IOException {
        getUserInput();
    }
}
