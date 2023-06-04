package ru.geekbrains;

public class Chocolate extends Product {

    private int weight;
    private int calories;

    public Chocolate(String name, double price, int weight, int calories) {
        super(name, price);
        this.weight = weight;
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }
    public int getCalories() {
        return calories;
    }

    @Override
    String displayInfo() {
        return String.format("%s - %s - %.2f - вес: %d - калорийность: %d", brand, name, price, weight, calories);
    }
}
