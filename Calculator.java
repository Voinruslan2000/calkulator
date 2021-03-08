package ru.calculator;

public abstract class Calculator {

    public String calculate(String[] input) {
        int firstNumber = parseStringToNumber(input[0]);
        int secondNumber = parseStringToNumber(input[2]);

        if (!notGreaterThen10AndNotLessThen1(firstNumber)
                || !notGreaterThen10AndNotLessThen1(secondNumber)) {
            throw new IllegalArgumentException("Numbers must be not greater then 10 and not less then 1");
        }

        switch (input[1]) {
            case "+":
                return parseNumberToString(firstNumber + secondNumber);
            case "-":
                return parseNumberToString(firstNumber - secondNumber);
            case "*":
                return parseNumberToString(firstNumber * secondNumber);
            case "/":
                return parseNumberToString(firstNumber / secondNumber);
            default:
                throw new IllegalArgumentException("Invalid sign");
        }
    }

    public boolean notGreaterThen10AndNotLessThen1(int number) {
        return number >= 1 && number <= 10;
    }

    abstract int parseStringToNumber(String number);

    abstract String parseNumberToString(int number);


}
