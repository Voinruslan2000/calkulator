package ru.calculator;

public class DefaultCalculator extends Calculator {

    @Override
    int parseStringToNumber(String number) {
        return Integer.parseInt(number);
    }

    @Override
    String parseNumberToString(int number) {
        return String.valueOf(number);
    }

}
