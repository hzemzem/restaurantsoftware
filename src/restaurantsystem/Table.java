package restaurantsystem;

import java.util.ArrayList;

public class Table {
    int status = 0;
    Order[] customers;
    int id;

    public Table(int id) {
        this.id = id;
        customers = new Order[4];
    }

    public Order getOrder(int customer) {
        return customers[customer];
    }

    public void setOrder(int customer, Order order) {
        customers[customer] = order;
    }
}
