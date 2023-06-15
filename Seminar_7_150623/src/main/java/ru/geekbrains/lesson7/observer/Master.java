package ru.geekbrains.lesson7.observer;

public class Master implements Observer {
    private  String name;
    private double salary;

    public Master(String name) {
        this.name = name;
        salary = 80000;
    }

    @Override
    public void receiveOffer(String companyName, double salary) {
        if (this.salary < salary){
            System.out.printf("Мастер %s >>> Мне нужна эта работа! [%s - %f]\n", name, companyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Мастер %s >>> Я найду работу получше! [%s - %f]\n", name, companyName, salary);
        }
    }
}
