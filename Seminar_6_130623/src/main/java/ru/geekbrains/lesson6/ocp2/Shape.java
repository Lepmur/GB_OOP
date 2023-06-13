package ru.geekbrains.lesson6.ocp2;

public class Shape {

    private ShapeType type;

    public ShapeType getType() {
        return type;
    }

    public Shape(ShapeType type) {
        this.type = type;
    }
}
