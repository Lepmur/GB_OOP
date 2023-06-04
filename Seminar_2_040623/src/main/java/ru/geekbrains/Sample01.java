package ru.geekbrains;

import java.util.function.IntBinaryOperator;

public class Sample01 {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик", "Белый");
        cat1.jump();
        cat1.voice();
        System.out.printf("Цвет котика: %s\n", cat1.getColor());
        System.out.printf("Имя котика: %s\n", cat1.getName());

        Dog dog1 = new Dog("Шарик", 9);
        dog1.jump();
        dog1.voice();

        Animal cat2 = new Cat("Персик", "Рыжий");
        cat2.jump();
        cat2.voice();

        if (cat2 instanceof Dog){
            System.out.printf("Цвет котика: %s\n", ((Dog)cat2).getWeight());
        }

        voiceAllAnimals(new Animal[] { cat1, dog1, cat2});

        CatV2 catV2 = new CatV2("Барсик");
        Runnable catV2_2 = new CatV2("Персик");
        DogV2 dobV2 = new DogV2("Шарик");
        Bird bird = new Bird("Птица");

        Object[] animals2 = new Object[] { catV2, catV2_2, dobV2, bird };

        for (Object animal: animals2 ) {
            if (animal instanceof Flyable){
                ((Flyable)animal).fly(50);
            }
        }

    }

    public static void voiceAllAnimals(Animal[] animals){
        for (Animal animal: animals) {
            animal.voice();
            if (animal instanceof Dog){
                System.out.printf("Собака весит: %s кг.\n", ((Dog)animal).getWeight());
            }
        }
    }

}

interface Runnable{

    int a = 12;
    String getName();

    void swim (int distance);
    void run (int distance);

}

interface Flyable{

    void fly (int distance);

}

class CatV2 implements Runnable{

    public CatV2(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {
        System.out.printf("%s пробежал %d метров.\n", name, distance);
    }
}

class DogV2 implements Runnable{

    public DogV2(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {
        System.out.printf("%s пробежал %d метров.\n", name, distance);
    }
}

class Bird implements Runnable, Flyable{

    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {
        System.out.printf("%s пробежал %d метров.\n", name, distance);
    }

    @Override
    public void fly(int distance) {
        System.out.printf("%s пролетела %d метров.\n", name, distance);
    }
}


abstract class Animal{

    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void jump(){
        System.out.println("Животное прыгнуло.");
    }

    public abstract void voice();

}

class Dog extends Animal{

    private int weight;

    public int getWeight() {
        return weight;
    }

    public Dog(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void jump() {
        System.out.println("Собака прыгает.");
    }

    @Override
    public void voice() {
        System.out.println("Собака лает.");
    }
}

class Cat extends Animal{

    private String color;

    public String getColor() {
        return color;
    }

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает.");
    }

    @Override
    public void voice() {
        System.out.println("Кот мяукает.");
    }
}