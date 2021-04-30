/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.util.ArrayList;

/**
 *
 * Order class stores information regarding a particular order
 */
public class Order {
    /**
     * orderList stores information regarding the FoodItems in a particular order
     */
    private ArrayList<FoodItem> orderList;

    private String customerName;
    private int tableNo;

    
    public ArrayList<FoodItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<FoodItem> orderList) {
        this.orderList = orderList;
    }

    public String getName() { return customerName;}

    public int getTableNo() {
        return tableNo;
    }

    public Order(int tableNo, String name, ArrayList<FoodItem> orderList) {
        this.customerName = name;
        this.orderList = orderList;
    }

    public Order(int tableNo, String name) {
        this.customerName = name;
        this.orderList = new ArrayList<>();
    }

    /**
     * This adds foodItem to the orderlist
     * @param f 
     */
    void addItem(FoodItem f)
    {
        orderList.add(f);
    }
    
}
