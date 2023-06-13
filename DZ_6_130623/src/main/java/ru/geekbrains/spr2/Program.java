package ru.geekbrains.spr2;

public class Program {

    public static void main(String[] args) {

        System.out.println("Введите заказ:");
        Order order = new Order("", "", 0, 0);
        order.inputFromConsole();

        FileSaver fileSaver = new FileSaver();

        fileSaver.saveJson(order);
        fileSaver.saveXML(order);

    }

}
