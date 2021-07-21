package com.example;

public class Calculator {

    public final String delimiter = ",|\n";

    public int calculate(String input) throws Exception {
        if (input.isEmpty()) {
            return 0;
        } else {
            if (input.length() != 1) {
                String[] numbers = input.split(delimiter);
                return getSum(numbers);
            }
            return transformToInt(input);
        }
    }


    private int getSum(String[] numbers) throws Exception {
        int result = 0;
        for (String num : numbers) {
            fireException(num);
            if(transformToInt(num) < 1000) {
                result += transformToInt(num);
            }
        }
        return result;
    }

    private int transformToInt(String input) {
        return Integer.parseInt(input);
    }

    private void fireException(String number) throws Exception {
        if (transformToInt(number) < 0) {
            throw new Exception("negative input");
        }
    }
}
