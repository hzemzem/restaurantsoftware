/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Floor extends javax.swing.JFrame {

    /**
     * Creates new form Floor
     */
    RestaurantSystem r = RestaurantSystem.getInstance();
    /**
     * stores the table count
     */
    int tableCount = r.tablesCount;
    
    
    Color yellow = new Color(199, 151, 11);
    Color red = new Color(146, 56, 55);
    Color green = new Color(79, 127, 45);
    Color background = new Color(180,199,230);
    Color buttonColor = new Color(41,128,185);
    
    JFrame frame;
    
    public JButton button[] = new JButton[tableCount];
    public Floor() {
        
        initComponents();

        /**
         * creating a JPanel to add buttons to 
         */
        JPanel Panel=new JPanel((new FlowLayout(FlowLayout.CENTER, 0, 0)));  
        Panel.setBounds(20,20,360,420);
        frame = this;
        
        
        /**
         * creating and adding buttons to panel and setting different background color of buttons 
         * based on whether the table is clean, dirty or assigned
         */
        for(int i = 0; i < tableCount; i++)
        {
            button[i] = new JButton();
            button[i].setText(String.valueOf(i+1));
            button[i].setForeground(Color.WHITE);
            button[i].setFont(new Font("Sans", Font.BOLD, 16));
            button[i].addMouseListener(new MouseHandler(i));
            if(r.tables[i].status == 0)
                button[i].setBackground(green);
            else if(r.tables[i].status == 1)
                button[i].setBackground(yellow);
            else if(r.tables[i].status == 2)
                button[i].setBackground(red);
            button[i].setPreferredSize(new Dimension(70, 70));
                //blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
            Panel.add(button[i]);
        }
        
        Panel.setBackground(background);
        this.setSize(510, 500);
       
        this.getContentPane().setBackground(background);
        this.add(Panel);

        jButton1.setForeground(Color.WHITE);
        jButton1.setBackground(buttonColor);
        jButton1.setFont(new Font("Sans", Font.BOLD, 14));
        jButton2.setForeground(Color.WHITE);
        jButton2.setBackground(buttonColor);
        jButton2.setFont(new Font("Sans", Font.BOLD, 14));
    }
    
    /**
     * This handles the actions on buttons
     */
    private class MouseHandler extends MouseAdapter {

        public int tableNo; // instance variables
        
        public MouseHandler(int i) {
            this.tableNo = i;
          
        }
        
        public void mouseClicked(MouseEvent e) {
            RestaurantSystem r = RestaurantSystem.getInstance();
            
            /**
             * The case when the table is Green
             */
            if(r.tables[tableNo].status == 0)
            {
               
                Object[] options1 = {  "Continue","Go Back" };

                JPanel panel = new JPanel();
                JTextField customer1 = new JTextField(10);
                JTextField customer2 = new JTextField(10);
                JTextField customer3 = new JTextField(10);
                JTextField customer4 = new JTextField(10);
                panel.add(new JLabel("Customer #1"));
                panel.add(customer1);
                panel.add(new JLabel("Customer #2"));
                panel.add(customer2);
                panel.add(new JLabel("Customer #3"));
                panel.add(customer3);
                panel.add(new JLabel("Customer #4"));
                panel.add(customer4);


                int result = JOptionPane.showOptionDialog(null, panel, "Assign Table",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);
                if (result == JOptionPane.YES_OPTION){
                    Table table = r.tables[tableNo];
                    table.setOrder(0, new Order(customer1.getText()));
                    table.setOrder(1, new Order(customer2.getText()));
                    table.setOrder(2, new Order(customer3.getText()));
                    table.setOrder(3, new Order(customer4.getText()));
                    r.tables[tableNo].status = 1;
                    button[tableNo].setBackground(yellow);
                    //System.out.println(r.customerNames[tableNo] );
                    JOptionPane.showMessageDialog(null, "Table Assigned");
                }

            }
            /**
             * The case when the table is Yellow
             */
            else if(r.tables[tableNo].status == 1)
            {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background", background);
                UI.put("Panel.background", background);

                Object[] whichCustomer = {r.tables[tableNo].getOrder(0).getName(),
                        r.tables[tableNo].getOrder(1).getName(),
                        r.tables[tableNo].getOrder(2).getName(),
                        r.tables[tableNo].getOrder(3).getName()};

                int result = JOptionPane.showOptionDialog(null,
                                "Which customer's order do you want to manage",
                                "Manage Order", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, whichCustomer, null);
                    frame.setVisible(false);
                    OrderPage.start(tableNo, result);
               
            }
            /**
             * The case when the table is red
             */
            else if(r.tables[tableNo].status == 2)
            {
                Object[] options1 = {  "Continue","Go Back" };
                JPanel panel = new JPanel();
                panel.add(new JLabel("Mark Table " + String.valueOf(tableNo+1)+ " clean" ));
                int result = JOptionPane.showOptionDialog(null, panel, "Assign Table",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);
                if (result == JOptionPane.YES_OPTION){
                    r.tables[tableNo].status = 0;
                    button[tableNo].setBackground(green);
                    JOptionPane.showMessageDialog(null, "Table Cleaning Done");

                }
            }
            
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Sign out");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Orders");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Login.start();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * Prints the Order queue
     * @param evt 
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        RestaurantSystem r = RestaurantSystem.getInstance();
        System.out.println("Total Orders: " + r.orderlist.size());
        for(int i = 0; i < r.orderlist.size();i++)
        {
            System.out.println("Order#"+ String.valueOf(i+1));
            for(int j = 0; j< r.orderlist.get(i).getOrderList().size() ; j++)
            {
                System.out.println(r.orderlist.get(i).getOrderList().get(j).getName());
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    public static void start() {
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
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Floor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
