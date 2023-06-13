package ru.geekbrains.dip;

public class ReportItem {

    private final String description;
    private final float amount;

    public ReportItem(String description, float amount) {
        this.description = description;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
