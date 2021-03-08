package ru.calculator;

import java.util.HashSet;
import java.util.Set;

public class CalculatorProvider {

    private final static Set<String> ROMAN_NUMBERS = new HashSet<>();

    static {
        ROMAN_NUMBERS.add("I");  // 1
        ROMAN_NUMBERS.add("V");  // 5
        ROMAN_NUMBERS.add("X");  // 10
    }

    public Calculator getCalculator(String[] input) {
        if (isNumber(input[0]) && isNumber(input[2])) {
            return new DefaultCalculator();
        } else if (isRomeNumber(input[0]) && isRomeNumber(input[2])) {
            return new RomanCalculator();
        }

        // пробрасываем исключение, если числа имеют разный формат или это вообще не числа
        throw new IllegalArgumentException("Invalid string format");
    }

    // проверка не обычное число
    private boolean isNumber(String number) {
        try {
            // проверяем, если строку можно спарсить в число => значит возвращаем true, в противном случае возвращаем false
            // Integer.parseInt кинет Exception, если попробуем спарсить невалидную строку в int;
            int n = Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // проверка на римское число
    private boolean isRomeNumber(String number) {
        String[] symbols = number.split("");

        for (String symbol : symbols) {
            if (!ROMAN_NUMBERS.contains(symbol)) {
                return false;
            }
        }

        return true;
    }
}
