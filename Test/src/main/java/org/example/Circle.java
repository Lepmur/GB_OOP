package org.example;

public class Circle {

    private double radius;
    private double lengthRound;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        this.lengthRound = 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLengthRound() {
        return lengthRound;
    }

    public void setLengthRound(double lengthRound) {
        this.lengthRound = lengthRound;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("Круг (радиус = %.4f, длина = %.4f, площадь = %.4f)\n", radius, lengthRound, area);
    }

    public void
}
