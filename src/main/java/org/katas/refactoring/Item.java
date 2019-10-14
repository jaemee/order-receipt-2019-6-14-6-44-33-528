package org.katas.refactoring;

public class Item {
    private String desc;
    private double price;
    private int quantity;

    public Item(String desc, double price, int quantity) {
        super();
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return price * quantity;
    }
}