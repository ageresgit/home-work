package com.sbrf.reboot;

import com.sbrf.reboot.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator.getAddition(4, 5) = " + Calculator.getAddition(4, 5));
        System.out.println("Calculator.getSubtraction(4, 5) = " + Calculator.getSubtraction(4, 5));
        System.out.println("Calculator.getMultiplication(4, 5) = " + Calculator.getMultiplication(4, 5));
        System.out.println("Calculator.getDivision(9, 3) = " + Calculator.getDivision(9, 3));
        System.out.println("Calculator.getBitwiseAnd(4, 5) = " + Calculator.getBitwiseAnd(4, 5));
        System.out.println("Calculator.getBitwiseOr(4, 5) = " + Calculator.getBitwiseOr(4, 5));
        System.out.println("Calculator.getBitwiseXor(4, 5) = " + Calculator.getBitwiseXor(4, 5));
    }
}
