import java.util.Scanner;

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class Task_1 {
    public static void verifyPassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Пароль должен быть не менее 8 символов");
        }

        boolean containsDigit = false;
        boolean containsUppercase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
            }
            if (Character.isUpperCase(c)) {
                containsUppercase = true;
            }
        }

        if (!containsDigit) {
            throw new InvalidPasswordException("Пароль должен содержать хотя бы одну цифру");
        }

        if (!containsUppercase) {
            throw new InvalidPasswordException("Пароль должен содержать хотя бы одну заглавную букву");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            verifyPassword(password);
            System.out.println("Пароль прошел проверку успешно.");
        } catch (InvalidPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
