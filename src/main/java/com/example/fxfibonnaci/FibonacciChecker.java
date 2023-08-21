package com.example.fxfibonnaci;

import java.util.HashMap;

public interface FibonacciChecker {
    HashMap<Long, Long> numberToResultMap = new HashMap<>();
    static long findFibonacciNumber(long index){
        if (index < 0) return -1;
        if (index <= 2) return 1;
        if (numberToResultMap.containsKey(index)) {
            return numberToResultMap.get(index);
        } else {
            long sum = findFibonacciNumber(index - 1) + findFibonacciNumber(index - 2);
            numberToResultMap.put(index, sum);
            return sum;
        }
    }

    static boolean isFibonacciNumber(int number) {
        if (number < 0) return false;
        int nSquared = (int) Math.pow(number, 2);
        int formulaOne = (5 * nSquared) + 4;
        int formulaTwo = (5 * nSquared) - 4;
        return isPerfectSquare(formulaOne) || isPerfectSquare(formulaTwo);
    }
    private static boolean isPerfectSquare(int number) {
        int num = (int) Math.sqrt(number);
        return num * num == number;
    }
}
