package ru.geekbrains;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }
    public void eat(Plate plate) {
        if (plate.getFood() >= this.getAppetite()) {
            plate.setFood(plate.getFood() - this.getAppetite());
            System.out.printf("%s покушал!\n", this.getName());
            this.setAppetite(0);
            this.fullness = true;
        } else {
            System.out.printf("Котику %s не хватило еды!\n", this.getName());
        }
    }

    public void info() {
        System.out.printf("Я котик %s, %s, хочу %s еды!\n", this.getName(), this.getFullness(), this.getAppetite());
    }

    public int getAppetite() {
        return appetite;
    }
    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }
    public String getName() {
        return name;
    }

    public String getFullness() {
        if (this.fullness)
            return "сытый";
        else return "голодный";
    }
}

