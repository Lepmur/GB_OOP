package ru.geekbrains.lesson7.singleton;

public class Program {

    public static void main(String[] args) {

        //Singleton singleton = new Singleton();
        Singleton singleton = Singleton.getInstance();
        singleton = Singleton.getInstance();

    }

}
