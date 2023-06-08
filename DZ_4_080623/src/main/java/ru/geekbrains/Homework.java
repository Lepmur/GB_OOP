package ru.geekbrains;

import java.util.ArrayList;

public class Homework {
    public static void main(String[] args) {

        Box<Apple> boxOfApples = new Box<>(10);

        boxOfApples.add(10, new Apple());
        System.out.println(boxOfApples);

        boxOfApples.remove(11);
        boxOfApples.remove(7);
        System.out.println(boxOfApples);

        boxOfApples.add(8, new Apple());
        boxOfApples.add(3, new Apple());
        System.out.println(boxOfApples);


        Box<Orange> boxOfOranges = new Box<>(10, 8, new Orange());
        boxOfOranges.remove(3);
        System.out.println(boxOfOranges);

        Box<Orange> boxOfOranges1 = new Box<>(10, 5, new Orange());
        Box<Apple> boxOfApples1 = new Box<>(10, 5, new Apple());

        boxOfOranges.shiftFruitTo(boxOfOranges1, 10);
        boxOfOranges.shiftFruitTo(boxOfOranges1);

        boxOfApples1.shiftFruitTo(boxOfApples);
        boxOfApples1.shiftFruitTo(boxOfApples, 4);

        System.out.println(boxOfApples.compare(boxOfOranges));
    }
}

abstract class Fruit{
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit{
    public Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit{
    public Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit>{
    int size;
    ArrayList<T> fruits;
    T fruit;

    public Box(int size) {
        this.size = size;
        this.fruits = new ArrayList<>();
        System.out.printf("Создана пустая коробка размером %s\n ==========\n", size);
    }

    public Box(int size, int quantityFruits, T fruit) {
        this.size = size;
        this.fruits = new ArrayList<>();
        for (int i = 0; i < quantityFruits; i++) fruits.add(fruit);
        this.fruit = fruit;
        System.out.printf("Создана коробка размером %s, в ней %s %s\n ==========\n", size, quantityFruits, this.getTypeFruit());
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits)
            weight += fruit.getWeight();
        return weight;
    }

    public int getSize() {
        return size;
    }

    public int freeSpace() {
        return size - fruits.size();
    }

    public String getTypeFruit() {
        if (fruit instanceof Apple)
            return "apples";
        return "oranges";
    }

    public void add(int quantity, T fruit) {
        if (this.freeSpace() >= quantity) {
            this.fruit = fruit;
            for (int i = 0; i < quantity; i++) fruits.add(fruit);
            System.out.printf("В коробку добавлено %s %s\n", quantity, this.getTypeFruit());
        } else System.out.printf("В коробку не поместится %s %s\n", quantity, this.getTypeFruit());
    }

    public void remove(int quantity) {
        if (fruits.size() >= quantity) {
            fruits.subList(0, quantity).clear();
            System.out.printf("Из коробки убрано %s %s\n", quantity, this.getTypeFruit());
        }
        else System.out.printf("Не могу убрать %s %s, там столько нет\n", quantity, this.getTypeFruit());
    }

    public String compare(Box<?> anotherBox) {
        if (anotherBox.getWeight() > this.getWeight())
            return String.format("Вторая коробка с %s тяжелее\n ==========", anotherBox.getTypeFruit());
        if (anotherBox.getWeight() < this.getWeight())
            return String.format("Первая коробка с %s тяжелее\n ==========", this.getTypeFruit());
        return "Коробки весят одинаково\n ==========";
    }

    public void shiftFruitTo(Box<T> boxTo) {
        if (this.fruits.size() <= boxTo.freeSpace()) {
            int temp = fruits.size();
            this.remove(temp);
            boxTo.add(temp, fruit);
        } else System.out.printf("Во второй коробке только %s мест\n", boxTo.freeSpace());

    }

    public void shiftFruitTo(Box<T> boxTo, int quantity) {
        if  (this.fruits.size() >= quantity)
            if (quantity <= boxTo.freeSpace()) {
                this.remove(quantity);
                boxTo.add(quantity, fruit);
            } else System.out.printf("Во второй коробке только %s мест\n", boxTo.freeSpace());
        else System.out.printf("В этой коробке нет столько %s\n", this.getTypeFruit());
    }

    @Override
    public String toString() {
        if (!fruits.isEmpty())
            return String.format("Это коробка с %s размером %s, свободно %s\n ==========", getTypeFruit(), getSize(), freeSpace());
        return String.format("Это пустая коробка размером %s\n ==========", getSize());
    }
}

