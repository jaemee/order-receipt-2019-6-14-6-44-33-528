package org.katas.refactoring;

public class LineItem {
    private String desc;
    private double price;
    private int quantity;

    public LineItem(String desc, double price, int quantity) {
        super();
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    String getDescription() {
        return desc;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }
}