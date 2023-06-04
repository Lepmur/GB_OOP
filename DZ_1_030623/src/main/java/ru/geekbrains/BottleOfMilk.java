package ru.geekbrains;

public class BottleOfMilk extends Product {

    private int volume;
    private int fat;

    public int getVolume() {
        return volume;
    }

    public int getFat() {
        return fat;
    }

    public BottleOfMilk(String name, double price, int volume, int fat){
        super(name, price);
        this.volume = volume;
        this.fat = fat;
    }

    @Override
    String displayInfo() {
        return String.format("%s - %s - %.2f - объём: %d - жирность: %d", brand, name, price, volume, fat);
    }
}
