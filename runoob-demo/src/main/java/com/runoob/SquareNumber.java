package com.runoob;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文档注释演示实例
 * @author 张伯成
 * @version 1.0
 */
public class SquareNumber {
    /**
     * This method returns the square of number.
     * This is a multiline description. You can use as many lines as you like.
     * @param number The value to be squared.
     * @return number squared.
     */
    public double square(double number) {
        return number * number;
    }

    /**
     * This method input a number from the user.
     * @return The value input as a double.
     * @throws IOException in input error
     * @see IOException
     */
    public double getNumber() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inData = new BufferedReader(isr);
        String str;
        str = inData.readLine();
        return Double.parseDouble(str);
    }

    /**
     * This method demonstrates square().
     * @param args args unused.
     * @throws IOException on input error.
     * @see IOException
     */
    public static void main(String[] args) throws IOException {
        SquareNumber sn = new SquareNumber();
        double val;
        System.out.print("Enter value to be squared:");
        val = sn.getNumber();
        val = sn.square(val);
        System.out.println("Squared value is : " + val);
    }
}
