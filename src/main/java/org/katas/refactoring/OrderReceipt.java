package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        final char tab = '\t';
        output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription())
                    .append(tab)
                    .append(lineItem.getPrice())
                    .append(tab)
                    .append(lineItem.getQuantity())
                    .append(tab)
                    .append(lineItem.totalAmount())
                    .append('\n');

            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            totalAmount += lineItem.totalAmount() + salesTax;
        }

        output.append("Sales Tax").append(tab).append(totSalesTx);
        output.append("Total Amount").append(tab).append(totalAmount);
        return output.toString();
    }
}