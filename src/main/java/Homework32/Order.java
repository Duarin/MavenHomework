package Homework32;

import java.util.Objects;

public class Order {
    private final int orderNumber;
    private final String customerName;

    public Order(int orderNumber, String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }

    @Override
    public String toString() {
        return orderNumber + " | " + customerName;
    }
}
