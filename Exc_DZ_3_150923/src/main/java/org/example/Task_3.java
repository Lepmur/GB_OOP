import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Интерфейс для математической операции
interface Operation {
    double execute(double a, double b);
    String getSymbol();
}

// Класс операции сложения
class Addition implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}

// Класс операции вычитания
class Subtraction implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}

// Класс операции умножения
class Multiplication implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }

    @Override
    public String getSymbol() {
        return "*";
    }
}

// Класс операции деления
class Division implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return a / b;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}

// Класс операции возведения в степень
class Exponentiation implements Operation {
    @Override
    public double execute(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public String getSymbol() {
        return "^";
    }
}

class MiniCalculator {
    private List<String> history;

    public MiniCalculator() {
        history = new ArrayList<>();
    }

    public double performOperation(Operation operation, double a, double b) {
        double result = operation.execute(a, b);
        history.add(a + " " + operation.getSymbol() + " " + b + " = " + result);
        return result;
    }

    public List<String> getHistory() {
        return history;
    }
}



public class Task_3 {
    public static void main(String[] args) {
        MiniCalculator calculator = new MiniCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение (+)");
            System.out.println("2. Вычитание (-)");
            System.out.println("3. Умножение (*)");
            System.out.println("4. Деление (/)");
            System.out.println("5. Возведение в степень (^)");
            System.out.println("6. Вывести историю операций");
            System.out.println("7. Выйти");

            int choice;
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 7) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректный номер операции.");
                scanner.nextLine(); // Очистить буфер после неправильного ввода
                continue;
            }

            if (choice == 7) {
                break;
            }

            System.out.print("Введите первое число: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка: Введите корректное число.");
                scanner.nextLine(); // Очистить буфер после неправильного ввода
            }
            double a = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка: Введите корректное число.");
                scanner.nextLine(); // Очистить буфер после неправильного ввода
            }
            double b = scanner.nextDouble();

            Operation operation = null;
            switch (choice) {
                case 1:
                    operation = new Addition();
                    break;
                case 2:
                    operation = new Subtraction();
                    break;
                case 3:
                    operation = new Multiplication();
                    break;
                case 4:
                    operation = new Division();
                    break;
                case 5:
                    operation = new Exponentiation();
                    break;
                case 6:
                    for (String entry : calculator.getHistory()) {
                        System.out.println(entry);
                    }
                    break;
            }

            if (operation != null) {
                double result = calculator.performOperation(operation, a, b);
                System.out.println("Результат: " + result);
            }
        }

        scanner.close();
    }
}
