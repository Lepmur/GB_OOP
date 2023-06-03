package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product productOne = new Product();
        Product productTwo = new Product("Cross");
        Product productThree = new Product("Bread", 35);
        Product productFour = new Product("Fish", 50, "Ocean");

        BottleOfWater bottleOne = new BottleOfWater("Вода1", 100, 2);
        BottleOfWater bottleTwo = new BottleOfWater("Вода2", 100, 2);
        BottleOfWater bottleThree = new BottleOfWater("Вода3", 110, 1);
        BottleOfWater bottleFour = new BottleOfWater("Вода4", 130, 3);
        BottleOfWater bottleFive = new BottleOfWater("Вода5", 100, 1);

        Product bottleOfMilkOne = new BottleOfMilk("Молоко1", 100, 2, 10);
        Product bottleOfMilkTwo = new BottleOfMilk("Молоко2", 110, 2, 12);
        Product bottleOfMilkThree = new BottleOfMilk("Молоко3", 120, 1, 14);
        Product bottleOfMilkFour = new BottleOfMilk("Молоко4", 130, 3, 16);
        Product bottleOfMilkFive = new BottleOfMilk("Молоко5", 140, 1, 18);

        Product chocolateOne = new Chocolate("Шоколадка1", 80, 50, 500);
        Product chocolateTwo = new Chocolate("Шоколадка2", 90, 60, 600);
        Product chocolateThree = new Chocolate("Шоколадка3", 70, 40, 400);
        Product chocolateFour = new Chocolate("Шоколадка4", 100, 70, 700);
        Product chocolateFive = new Chocolate("Шоколадка5", 60, 30, 300);


        List<Product> products = new ArrayList<>();
        products.add(productOne); products.add(productTwo); products.add(productThree); products.add(productFour);
        products.add(bottleOne); products.add(bottleTwo); products.add(bottleThree); products.add(bottleFour);
        products.add(bottleFive); products.add(bottleOfMilkOne); products.add(bottleOfMilkTwo);
        products.add(bottleOfMilkThree); products.add(bottleOfMilkFour); products.add(bottleOfMilkFive);
        products.add(chocolateOne); products.add(chocolateTwo); products.add(chocolateThree);
        products.add(chocolateFour); products.add(chocolateFive);


        BottleOfWaterVendingMachine machine = new BottleOfWaterVendingMachine(products);

        BottleOfWater bottleOfWaterRes = machine.getBottleOfWater("Вода3", 1);
        if (bottleOfWaterRes != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        BottleOfMilk bottleOfMilkRes = machine.getBottleOfMilk("Молоко4", 3, 16);
        if (bottleOfMilkRes != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfMilkRes.displayInfo());
        }
        else {
            System.out.println("Такого молока нет в автомате.");
        }

        Chocolate chocolateRes = machine.getChocolate("Шоколадка2", 60, 600);
        if (chocolateRes != null){
            System.out.println("Вы купили: ");
            System.out.println(chocolateRes.displayInfo());
        }
        else {
            System.out.println("Такой околадки нет в автомате.");
        }



    }
}
