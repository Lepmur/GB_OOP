package ru.geekbrains.spr2;

import java.util.Scanner;

public class ConsoleInput implements DataInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
