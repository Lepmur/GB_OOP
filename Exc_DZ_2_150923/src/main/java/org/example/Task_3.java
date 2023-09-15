package org.example;

import java.util.Scanner;

class NumberOutOfRangeException extends Exception {
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    public NumberSumException(String message) {
        super(message);
    }
}

class DivisionByZeroExceptions extends Exception {
    public DivisionByZeroExceptions (String message) {
        super(message);
    }
}


public class Task_3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите первое число: ");
            int firstNumber = scanner.nextInt();
            if (firstNumber > 100) {
                throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
            }

            System.out.print("Введите второе число: ");
            int secondNumber = scanner.nextInt();
            if (secondNumber < 0) {
                throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
            }

            int sum = firstNumber + secondNumber;
            if (sum < 10) {
                throw new NumberSumException("Сумма первого и второго чисел слишком мала");
            }

            System.out.print("Введите третье число: ");
            int thirdNumber = scanner.nextInt();
            if (thirdNumber == 0) {
                throw new DivisionByZeroExceptions("Деление на ноль недопустимо");
            }

            System.out.println("Проверка пройдена успешно");
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroExceptions e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}


