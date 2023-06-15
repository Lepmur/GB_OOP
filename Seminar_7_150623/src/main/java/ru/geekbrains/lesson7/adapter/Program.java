package ru.geekbrains.lesson7.adapter;

public class Program {

    public static void main(String[] args) {
        MeteoStore meteoStore = new MeteoStore();
        MS200 ms200_1 = new MS200(5123);

        meteoStore.save(ms200_1);

        meteoStore.save(new AdapterST500Info(new ST500Info(4001)));

    }

}
