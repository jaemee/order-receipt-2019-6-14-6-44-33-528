package org.katas.refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckoutInformationReceiptTest {

    @Test
    public void shouldPrintCustomerInformationOnOrder() {
        CheckoutInformation checkoutInformation = new CheckoutInformation("Mr X", "Chicago, 60601", new ArrayList<Item>());
        OrderReceipt receipt = new OrderReceipt(checkoutInformation);

        String output = receipt.printReceipt();

        assertThat(output).contains("Mr X", "Chicago, 60601");
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("milk", 10.0, 2));
        items.add(new Item("biscuits", 5.0, 5));
        items.add(new Item("chocolate", 20.0, 1));

        OrderReceipt receipt = new OrderReceipt(new CheckoutInformation(null, null, items));

        String output = receipt.printReceipt();

        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

}
