package ru.geekbrains;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

    public void addFood(int food) {
        this.setFood(this.getFood() + food);
        System.out.println("В тарелку добавлено " + food + " еды.");
    }

    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        this.food = food;
    }

}

