package org.katas.refactoring;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private CheckoutInformation checkoutInformation;

    public OrderReceipt(CheckoutInformation checkoutInformation) {
        this.checkoutInformation = checkoutInformation;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        final char tab = '\t';
        output.append("======Printing Orders======\n");

        output.append(checkoutInformation.getCustomerName());
        output.append(checkoutInformation.getCustomerAddress());

        double totSalesTx;
        double totalAmount = getTotalAmount(checkoutInformation.getItems());

        for (Item item : checkoutInformation.getItems()) {
            output.append(item.getDescription())
                    .append(tab)
                    .append(item.getPrice())
                    .append(tab)
                    .append(item.getQuantity())
                    .append(tab)
                    .append(item.getTotalAmount())
                    .append('\n');

        }

        totSalesTx = getSalesTax(totalAmount);
        totalAmount += totSalesTx;

        output.append("Sales Tax").append(tab).append(totSalesTx);
        output.append("Total Amount").append(tab).append(totalAmount);
        return output.toString();
    }

    private double getTotalAmount(List<Item> items) {
        return items.stream()
                .mapToDouble(Item::getTotalAmount)
                .reduce(Double::sum)
                .orElse(0d);
    }

    private Double getSalesTax(double totalAmount) {
        return totalAmount * 0.10;
    }
}