package ru.geekbrains.spr2;

public class Order {
    private String clientName;
    private String product;
    private int qnt;
    private int price;

    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQnt() {
        return qnt;
    }

    public int getPrice() {
        return price;
    }

    public void inputFromConsole() {
        DataInput dataInput = new ConsoleInput();
        clientName = dataInput.getInput("Client name: ");
        product = dataInput.getInput("Product: ");
        qnt = Integer.parseInt(dataInput.getInput("Quantity: "));
        price = Integer.parseInt(dataInput.getInput("Price: "));
    }
}
