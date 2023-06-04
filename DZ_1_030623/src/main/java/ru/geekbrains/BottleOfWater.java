package ru.geekbrains;

public class BottleOfWater extends Product {

    private int volume;

    public BottleOfWater(String name, double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    String displayInfo() {
        return String.format("%s - %s - %.2f - объём: %d", brand, name, price, volume);
    }
}
