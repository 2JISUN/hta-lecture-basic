package app;

import lib.Calculator;


public class SamsungCalculator extends Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double average(int[] array) {
        double sum = 0;
        for (int i = 0; i<array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }
}
