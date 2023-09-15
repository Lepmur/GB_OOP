package org.example;

// Пользовательское исключение для недостаточных средств на счете
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Пользовательское исключение для превышения максимального баланса на счете
class MaxBalanceExceededException extends Exception {
    public MaxBalanceExceededException(String message) {
        super(message);
    }
}

// Класс представляющий банковский счет
class BankAccount {
    private String accountNumber;
    private double balance;
    private double maxBalance;

    public BankAccount(String accountNumber, double maxBalance) {
        this.accountNumber = accountNumber;
        this.maxBalance = maxBalance;
    }

    // Метод для пополнения счета
    public synchronized void deposit(double amount) throws MaxBalanceExceededException {
        if (balance + amount > maxBalance) {
            throw new MaxBalanceExceededException("Превышен максимально допустимый баланс");
        }
        balance += amount;
        System.out.println("Счет " + accountNumber + ": пополнение на " + amount + ". Баланс: " + balance);
    }

    // Метод для снятия денег со счета
    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Недостаточно средств на счете");
        }
        balance -= amount;
        System.out.println("Счет " + accountNumber + ": снятие " + amount + ". Баланс: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

// Класс для управления банковскими счетами и обработки транзакций
class Bank {
    // Метод для выполнения транзакции по пополнению счета
    public static void deposit(BankAccount account, double amount) {
        try {
            account.deposit(amount);
        } catch (MaxBalanceExceededException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Метод для выполнения транзакции по снятию денег со счета
    public static void withdraw(BankAccount account, double amount) {
        try {
            account.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

public class Task_4 {
    public static void main(String[] args) {
        // Создаем банковские счета с максимальным балансом
        BankAccount account1 = new BankAccount("12345", 1000);
        BankAccount account2 = new BankAccount("67890", 1500);

        // Создаем и запускаем потоки для пополнения и снятия средств
        Thread depositThread1 = new Thread(() -> Bank.deposit(account1, 500));
        Thread withdrawThread1 = new Thread(() -> Bank.withdraw(account1, 200));
        Thread depositThread2 = new Thread(() -> Bank.deposit(account2, 1000));
        Thread withdrawThread2 = new Thread(() -> Bank.withdraw(account2, 800));

        depositThread1.start();
        withdrawThread1.start();
        depositThread2.start();
        withdrawThread2.start();
    }
}
