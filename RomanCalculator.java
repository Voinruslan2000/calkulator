package ru.calculator;


public class RomanCalculator extends Calculator {
    @Override
    int parseStringToNumber(String romanNumber) {
        if ("I".equals(romanNumber)) return 1;

        if ("II".equals(romanNumber)) return 2;

        if ("III".equals(romanNumber)) return 3;

        if ("IV".equals(romanNumber)) return 4;

        if ("V".equals(romanNumber)) return 5;

        if ("VI".equals(romanNumber)) return 6;

        if ("VII".equals(romanNumber)) return 7;

        if ("VIII".equals(romanNumber)) return 8;

        if ("IX".equals(romanNumber)) return 9;

        if ("X".equals(romanNumber)) return 10;

        throw new IllegalArgumentException("Illegal number");
    }

    @Override
    String parseNumberToString(int number) {
        // проверяем число на отрицательность и равенство нулю
        String prefix = "";
        if (number == 0) {
            return "0";
        }
        if (number < 0) {
            number = number * (-1);
            prefix = "-";
        }

        return prefix + parseToString(number, "");
    }

    // с помощью рекурсии преобразуем обычное число в римское число
    private String parseToString(int number, String result) {
        if (number == 100) {
            return parseToString(number - 100, result + "C");
        } else if (number >= 90) {
            return parseToString(number - 90, result + "XC");
        } else if (number >= 50) {
            return parseToString(number - 50, result + "L");
        } else if (number >= 10) {
            return parseToString(number - 10, result + "X");
        } else if (number >= 5) {
            if (number == 9) return parseToString(number - 9, result + "IX");
            return parseToString(number - 5, result + "V");
        } else if (number >= 1) {
            if (number == 4) return parseToString(number - 4, result + "IV");
            return parseToString(number - 1, result + "I");
        } else {
            return result;
        }
    }
}
