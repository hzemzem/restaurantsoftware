/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * This is the driver class
 */
public class Driver {
    public static void main(String args[]) throws FileNotFoundException
    {
        
        RestaurantSystem r = RestaurantSystem.getInstance();

        /**
        * Reading the waiters file for validation later on
        */
        File myObj = new File("waiters.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String token[] = data.split(",");
            String username = token[0];
            String password = token[1];
            r.addWaiter(new Waiter(username, password));
        }
        /**
        * login starts the program
        */
        Login.start();
        
                
    }
}
