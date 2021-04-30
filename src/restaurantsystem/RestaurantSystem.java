/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.util.ArrayList;
import java.util.Random;

class RestaurantSystem
{
    // static variable single_instance of type Singleton
    private static RestaurantSystem single_instance = null;
    
    
    /**
     * waiterList stores information regarding all the waiters
     */
    ArrayList<Waiter> waiterList ;
    
    /**
     * orderlist stores information regarding all the orders
     */
    ArrayList<Order> orderlist ;
    
    /**
     * tablesCount stores the number of tables on floor
     */
    int tablesCount = 30;
    
    /**
     * tables integer array store the current state of the table. Different values is assigned based on whether it is red, green, or yellow
     */
    Table tables[];

    

    
    
    // variable of type String
    public String s;
  
    // private constructor restricted to this class itself
    private RestaurantSystem()
    {
        
        waiterList = new ArrayList<>();
        orderlist = new ArrayList<>();
        tables = new Table[tablesCount];
        for (int i=0; i<tablesCount; i++) {
            tables[i] = new Table(i);
        }
        
        
        /**
         * Making Yellow tables and assigning them at random indexes
         */
        for(int i = 0; i < 5; i++)
        {
            Random rand = new Random();
            int index = rand.nextInt(30);
            tables[index].status = 1;
            for (int j = 0; j < 4; j++) {
                tables[index].setOrder(j, new Order("Customer#" + String.valueOf(index) + '.' + String.valueOf(j)));
            }
        }
        /**
         * Making red tables and assigning them at random indexes
         */
        for(int i = 0; i < 5; i++)
        {
            Random rand = new Random();
            tables[rand.nextInt(30)].status = 2;
            
        }
        
    }
    
    
   /**
    * Adds waiter to the waiterlist
    */
    void addWaiter(Waiter w)
    {
        waiterList.add(w);
    }
    /**
    * Adds order to the orderlist
    */
    void addOrder(Order o)
    {
        orderlist.add(o);
    }
    
    /**
    * This functions does the validation when the waiter is trying to login
    */
    boolean logInWaiter(String pin)
    {
        for(Waiter w: waiterList)
        {
            if(w.getPassword().equals(pin))
                return true;
        }
        return false;
    }
    
    /**
     * This returns the name of the waiter by matching the unique pin of the waiter
     * @param pin
     * @return 
     */
    String getWaiterName(String pin)
    {
        for(Waiter w: waiterList)
        {
            if(w.getPassword().equals(pin))
                return w.getUsername();
        }
        return "";
    }
  
    // static method to create instance of Singleton class
    public static RestaurantSystem getInstance()
    {
        if (single_instance == null)
            single_instance = new RestaurantSystem();
  
        return single_instance;
    }
}