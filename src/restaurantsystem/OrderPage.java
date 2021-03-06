/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class OrderPage extends javax.swing.JFrame {
    RestaurantSystem r = RestaurantSystem.getInstance();

    /**
     * Creates new form OrderPage
     */
    final int SANDWICH = 0;
    final  int WRAPS = 1;
    final  int BURGERS = 2;
    final  int APPETIZERS = 3;
    final  int SALADS = 4;
    
    int categoryCount = 5;

    Table table;
    int customer;
    boolean newOrder = false;
    
    /**
     * Array of panels to show different categories
     */
    JPanel panel[] = new JPanel[categoryCount];
    Color background = new Color(41,128,185);
    
    Color yellow = new Color(253,192,5);
    Color red = new Color(174,70,69);
    Color green = new Color(112,172,71);
    
    ArrayList<ArrayList<FoodItem>> foodArray = new ArrayList<>();
    JPanel currentPanel = null;
    Color buttonColor = new Color(41,128,185);
    public OrderPage(int tableNo, int customer) {
        table = r.tables[tableNo];
        this.customer = customer;
        if(table.getOrder(customer).getOrderList().size() == 0) {
            newOrder = true;
        }
        initComponents();
        repopulateTable();
        for(int i = 0; i < categoryCount; i++)
        {
            foodArray.add(new ArrayList<FoodItem>()); 
        }
        addFoodItems();
        this.setSize(1000, 700);
        for(int i = 0; i < categoryCount; i++)
        {
            panel[i] = new JPanel((new FlowLayout(FlowLayout.CENTER, 0, 0)));  
            int x = 570+(i*150);
            

            panel[i].setBounds(650,20,150,600);
            JButton button;
            for(int j = 0; j < foodArray.get(i).size(); j++)
            {
                button = new JButton();
                button.setText(foodArray.get(i).get(j).getName());
                button.addMouseListener(new MouseHandler(foodArray.get(i).get(j)));
                
                button.setPreferredSize(new Dimension(150, 100));
                button.setBackground(buttonColor);
                panel[i].add(button);
                
        
                
            }
            
            /**
             * Setting colors of buttons
             */
            panel[i].setBackground(buttonColor);
            this.getContentPane().setBackground(background);
            AppetizerButton.setBackground(yellow);
            WrapsButton.setBackground(yellow);
            burgerButton.setBackground(yellow);
            saladButton.setBackground(yellow);
            sandwichButton.setBackground(yellow);
            
            jButton3.setBackground(red);
            jButton4.setBackground(red);
            CancelItem.setBackground(red);
            SubmitButton.setBackground(red);
            jButton1.setBackground(red);
            
            
            //this.add(panel[i]);
            
        }
        
        
    }
    
    /**
     * add values to the table
     */
    void repopulateTable()
    {
        DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
        dt.setRowCount(0);
        for(FoodItem f: table.getOrder(customer).getOrderList())
        {
            dt.addRow(new Object[]{f.getName(), f.getPrice()});   
        }
    }
    
    /**
     * Buttons, when clicked, adds item to the table
     */
    private class MouseHandler extends MouseAdapter {

        public FoodItem Item; // instance variables
        
        public MouseHandler(FoodItem item) {
            this.Item = item;
          
        }
        
        public void mouseClicked(MouseEvent e) {
            RestaurantSystem r = RestaurantSystem.getInstance();
            table.getOrder(customer).addItem(Item);
            repopulateTable();
            float sum = 0;
            for(FoodItem f: table.getOrder(customer).getOrderList())
            {
                sum += f.getPrice();
            }
            Subtotal.setText(Float.toString(sum));
            
            float tax = sum*(float)0.10;
            float total = sum + tax;
            
            Tax.setText(Float.toString((float)Math.floor(tax * 100) / 100));
            Total.setText(Float.toString((float)Math.floor((total) * 100) / 100) );
            Balance.setText(Float.toString((float)Math.floor((total) * 100) / 100) );

            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        burgerButton = new javax.swing.JButton();
        WrapsButton = new javax.swing.JButton();
        saladButton = new javax.swing.JButton();
        AppetizerButton = new javax.swing.JButton();
        sandwichButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SubmitButton = new javax.swing.JButton();
        CancelItem = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Subtotal = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        Tax = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Balance = new javax.swing.JTextField();
        error = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        burgerButton.setText("Burgers");
        burgerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                burgerButtonMouseClicked(evt);
            }
        });
        burgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burgerButtonActionPerformed(evt);
            }
        });

        WrapsButton.setText("Wraps");
        WrapsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WrapsButtonMouseClicked(evt);
            }
        });

        saladButton.setText("Salads");
        saladButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saladButtonMouseClicked(evt);
            }
        });

        AppetizerButton.setText("Appetizers");
        AppetizerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppetizerButtonMouseClicked(evt);
            }
        });

        sandwichButton.setText("Sandwich");
        sandwichButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sandwichButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sandwichButtonMouseEntered(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        SubmitButton.setText("Submit Order");
        SubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitButtonMouseClicked(evt);
            }
        });

        CancelItem.setText("Cancel Item");
        CancelItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelItemMouseClicked(evt);
            }
        });

        jButton3.setText("Modify Order");

        jButton4.setText("Discount");

        jLabel1.setText("Subtotal");

        jLabel2.setText("Tax");

        jLabel3.setText("Total");

        Subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtotalActionPerformed(evt);
            }
        });

        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        Tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaxActionPerformed(evt);
            }
        });

        jLabel4.setText("Balance Due");

        jButton1.setText("Pay");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tax, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(Balance)
                                .addGap(109, 109, 109))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saladButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(burgerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WrapsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AppetizerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sandwichButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(431, 431, 431))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(burgerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(WrapsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saladButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AppetizerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sandwichButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * add food items to the foodArray
     */
    void addFoodItems()
    {
        foodArray.get(SANDWICH).add(new FoodItem("Grilled Cheese", (float) 5.50));
        foodArray.get(SANDWICH).add(new FoodItem("Beef Hot Dog", (float) 5.50));
        foodArray.get(SANDWICH).add(new FoodItem("Chicken BLT&A", (float) 10.00));
        foodArray.get(SANDWICH).add(new FoodItem("Cordon Blue", (float) 11.00));
        foodArray.get(SANDWICH).add(new FoodItem("Philly", (float) 13.50));
        foodArray.get(SANDWICH).add(new FoodItem("Pulled Pork", (float) 9.50));
        foodArray.get(SANDWICH).add(new FoodItem("Club", (float) 10.00));
        
        foodArray.get(WRAPS).add(new FoodItem("Club", (float) 10.00));
        foodArray.get(WRAPS).add(new FoodItem("Chicken BLT&A", (float) 10.00));
        foodArray.get(WRAPS).add(new FoodItem("Veggie", (float) 10.00));
        foodArray.get(WRAPS).add(new FoodItem("Chicken Caesar", (float) 10.00));
        
        
        foodArray.get(BURGERS).add(new FoodItem("J's Burger", (float) 10.00));
        foodArray.get(BURGERS).add(new FoodItem("Bacon Cheese Burger", (float) 11.00));
        foodArray.get(BURGERS).add(new FoodItem("Mushroom Swiss Burger", (float) 11.00));
        foodArray.get(BURGERS).add(new FoodItem("Carolina Burger", (float) 11.00));
        foodArray.get(BURGERS).add(new FoodItem("Portobello Burger", (float) 8.50));
        foodArray.get(BURGERS).add(new FoodItem("Vegan Boca Burger", (float) 10.00));

        
        foodArray.get(APPETIZERS).add(new FoodItem("Chicken Nachos", (float) 8.50));
        foodArray.get(APPETIZERS).add(new FoodItem("Pork Nachos", (float) 8.50));
        foodArray.get(APPETIZERS).add(new FoodItem("Catfish Bites", (float) 6.50));
        foodArray.get(APPETIZERS).add(new FoodItem("Fried Veggies", (float) 6.50));
        foodArray.get(APPETIZERS).add(new FoodItem("Fried Cheese", (float) 7.50));
        
        foodArray.get(SALADS).add(new FoodItem("House Salad", (float) 7.50));
        foodArray.get(SALADS).add(new FoodItem("Wedge Salad", (float) 7.50));
        foodArray.get(SALADS).add(new FoodItem("Caesar Salad", (float) 7.50));
        foodArray.get(SALADS).add(new FoodItem("Sweet Potato Chicken Salad", (float) 7.50));
        
        /*for(ArrayList<FoodItem> f: foodArray)
        {
            for(FoodItem fItem: f)
            {
                System.out.println(fItem.getName()+ " " + fItem.getPrice());
            }
        }*/



    }
    
    
    private void burgerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_burgerButtonMouseClicked
        // TODO add your handling code here:
        if(currentPanel != null)
        {
            this.remove(currentPanel);
            
        }
        currentPanel = panel[BURGERS];
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_burgerButtonMouseClicked

    private void burgerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burgerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_burgerButtonActionPerformed

    private void WrapsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WrapsButtonMouseClicked
        // TODO add your handling code here:
        if(currentPanel != null)
        {
            this.remove(currentPanel);
            
        }
        currentPanel = panel[WRAPS];
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_WrapsButtonMouseClicked

    private void saladButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saladButtonMouseClicked
        // TODO add your handling code here:
        if(currentPanel != null)
        {
            this.remove(currentPanel);
            
        }
        currentPanel = panel[SALADS];
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_saladButtonMouseClicked

    private void AppetizerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppetizerButtonMouseClicked
        // TODO add your handling code here:
        if(currentPanel != null)
        {
            this.remove(currentPanel);
            
        }
        currentPanel = panel[APPETIZERS];
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_AppetizerButtonMouseClicked

    private void sandwichButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sandwichButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sandwichButtonMouseEntered

    private void sandwichButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sandwichButtonMouseClicked
        // TODO add your handling code here:
        if(currentPanel != null)
        {
            this.remove(currentPanel);
            
        }
        currentPanel = panel[SANDWICH];
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_sandwichButtonMouseClicked

    private void SubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubtotalActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void TaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaxActionPerformed

    private void SubmitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitButtonMouseClicked
        // TODO add your handling code here:
        RestaurantSystem r = RestaurantSystem.getInstance();
        if(newOrder) {
            r.orderlist.add(table.getOrder(customer));
        }
        this.setVisible(false);
        Pay.start(table.getOrder(customer));
        
    }//GEN-LAST:event_SubmitButtonMouseClicked

    private void CancelItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelItemMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow >= 0 )
        {
            table.getOrder(customer).getOrderList().remove(selectedRow);
            repopulateTable();
            error.setText("");
            
            float sum = 0;
            for(FoodItem f: table.getOrder(customer).getOrderList())
            {
                sum += f.getPrice();
            }
            Subtotal.setText(Float.toString(sum));
            Tax.setText(Float.toString(sum*(float)0.10));
            Total.setText(Float.toString(sum*(float)1.10));
            Balance.setText(Float.toString(sum* (float)1.10));
        }
        else
        {
            error.setText("Select an item from table first then click cancel button");
        }
    }//GEN-LAST:event_CancelItemMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        RestaurantSystem r = RestaurantSystem.getInstance();
        if(newOrder) {
            r.orderlist.add(table.getOrder(customer));
        }
        this.setVisible(false);
        Pay.start(table.getOrder(customer));
    }//GEN-LAST:event_jButton1MouseClicked

    public static void start(int table, int customer) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderPage(table, customer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AppetizerButton;
    private javax.swing.JTextField Balance;
    private javax.swing.JButton CancelItem;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField Subtotal;
    private javax.swing.JTextField Tax;
    private javax.swing.JTextField Total;
    private javax.swing.JButton WrapsButton;
    private javax.swing.JButton burgerButton;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saladButton;
    private javax.swing.JButton sandwichButton;
    // End of variables declaration//GEN-END:variables
}
