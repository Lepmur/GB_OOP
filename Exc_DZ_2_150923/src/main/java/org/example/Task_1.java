package org.example;

import java.util.Scanner;

// Создаем пользовательское исключение InvalidNumberException
class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class Task_1 {
    public static void main(String[] args) {
        try {
            // Запрос числа у пользователя
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число: ");
            int number = scanner.nextInt();

            // Проверка на положительное число
            if (number <= 0) {
                throw new InvalidNumberException("Некорректное число");
            }

            // Если число положительное, выводим сообщение
            System.out.println("Число корректно");
        } catch (InvalidNumberException e) {
            // Перехватываем исключение InvalidNumberException и выводим сообщение об ошибке
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Перехватываем другие исключения, которые могут возникнуть при вводе числа
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
