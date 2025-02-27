package Homework32;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final PriorityQueue<Order> orders;
    private int nextOrderNumber = 1;

    public CoffeeOrderBoard() {
        this.orders = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getOrderNumber(), o2.getOrderNumber()));
    }

    public void add(String customerName) {
        Order newOrder = new Order(nextOrderNumber++, customerName);
        orders.add(newOrder);
        logger.info("Added new order: {}", newOrder);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Attempted to deliver order, but queue is empty.");
            return null;
        }
        Order order = orders.poll();
        logger.info("Delivered order: {}", order);
        return order;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                logger.info("Delivered specific order: {}", order);
                return order;
            }
        }
        logger.warn("Order with number {} not found.", orderNumber);
        return null;
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
        logger.info("Displayed current queue state.");
    }
}
