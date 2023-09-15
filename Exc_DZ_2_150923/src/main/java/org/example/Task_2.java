package org.example;

import java.util.Scanner;

// Создаем пользовательское исключение DivisionByZeroException
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class Task_2 {
    public static void main(String[] args) {
        try {
            // Запрос двух чисел у пользователя
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double numerator = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            double denominator = scanner.nextDouble();

            // Проверка деления на ноль
            if (denominator == 0) {
                throw new DivisionByZeroException("Деление на ноль недопустимо");
            }

            // Выполнение деления и вывод результата
            double result = numerator / denominator;
            System.out.println("Результат деления: " + result);
        } catch (DivisionByZeroException e) {
            // Перехватываем исключение DivisionByZeroException и выводим сообщение об ошибке
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Перехватываем другие исключения, которые могут возникнуть при вводе чисел
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
