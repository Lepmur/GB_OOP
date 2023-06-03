package ru.geekbrains;

/**
 * Product
 */
public class Product {

    protected String name;
    protected String brand;
    protected double price;

    public Product() {
        this("Product");
    }
    public Product(String name) {
        this(name, 1);
    }
    public Product(String name, double price) {
        this(name, price, "NoName");
    }
    public Product(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() <= 3){
            throw new RuntimeException("Имя слишком короткое.");
        }
        this.name = name;
    }
    public void setPrice(double price){
        if (price <= 0){
            throw new RuntimeException("Цена указана некорректно.");
        }
        this.price = price;
    }

    /**
     * Получить информацию по продукту
     * @return Информация по продукту
     */
    String displayInfo() {
        return String.format("%s - %s - %.2f", brand, name, price);
    }

}
