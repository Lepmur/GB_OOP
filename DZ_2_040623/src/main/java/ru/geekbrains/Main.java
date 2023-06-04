package ru.geekbrains;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        Cat catOne = new Cat("Barsik", 5);
        Cat catTwo = new Cat("Persik", 4);
        Cat catThree = new Cat("Musya", 3);
        Cat catFour = new Cat("Lyusya", 4);
        Cat catFive = new Cat("Gosha", 7);

        catOne.info();
        catTwo.info();
        catThree.info();
        catFour.info();
        catFive.info();

        System.out.println();
        Plate plate = new Plate(20);
        plate.info();

        ArrayList<Cat> cats = new ArrayList<>(asList(catOne, catTwo, catThree, catFour, catFive));

        System.out.println();
        for (Cat cat : cats) {
            if (cat.getFullness().equalsIgnoreCase("голодный")) {
                cat.eat(plate);
                cat.info();
            }
        }

        System.out.println();
        plate.info();

        plate.addFood(3);
        plate.info();

        System.out.println();
        for (Cat cat : cats) {
            if (cat.getFullness().equalsIgnoreCase("голодный")) {
                cat.eat(plate);
                cat.info();
            }
        }
    }
}
