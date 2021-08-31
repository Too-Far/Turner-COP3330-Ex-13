/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class App
{
    public static void compileMessage(float p, double r, int t, int n, double total)
    {
        System.out.println(
                "$"+ p + " invested at " + r +"% for " + t + " years compounded " + n + " times per year is $"
                + total
        );
    }

    public static void calculateInterest(float p, double r, int t, int n)
    {
        DecimalFormat df = new DecimalFormat("#.##");

        double total = p * (Math.pow((1 + r / 100), t));
        total = Float.parseFloat(df.format(total));

        compileMessage(p, r, t, n, total);
    }

    public static void getUserInput() throws IOException {
        DecimalFormat df = new DecimalFormat("#.##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float p;
        int t;
        double r;
        int n;

        System.out.println("What is the principal amount? ");
        p = Float.parseFloat(df.format(Float.parseFloat(reader.readLine())));

        System.out.println("What is the rate? ");
        r = Double.parseDouble(reader.readLine());

        System.out.println("What is the number of years? ");
        t = Integer.parseInt(reader.readLine());

        System.out.println("What is the number of times the interest is compounded per year? ");
        n = Integer.parseInt(reader.readLine());

        calculateInterest(p, r, t, n);
    }

    public static void main( String[] args ) throws IOException {
        getUserInput();
    }
}
