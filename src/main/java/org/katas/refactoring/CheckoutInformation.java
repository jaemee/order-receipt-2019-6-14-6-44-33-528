package org.katas.refactoring;

import java.util.List;

public class CheckoutInformation {
    private String name;
    private String address;
    private List<Item> items;

    public CheckoutInformation(String name, String address, List<Item> items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<Item> getItems() {
        return items;
    }
}
