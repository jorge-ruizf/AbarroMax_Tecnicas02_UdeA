/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package userInterface;

import Repository.SalesRepository;
import com.mongodb.client.MongoClient;
import entities.Categories;
import entities.AbarroMax;
import static entities.AbarroMax.categories;
import static entities.AbarroMax.inventory;
import static entities.AbarroMax.products;
import entities.Inventory;
import entities.Product;
import entities.Sale;
import entities.Sales;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import java.util.HashMap;
import java.util.Map;
import repository.InventoryRepository;
import repository.MongoConnection;
import repository.ProductRepository;

/**
 *
 * @author jorge
 */
public class ReportUI extends javax.swing.JDialog {

    /**
     * Creates new form InventoryUI
     */
    private Sales sales;
    private ArrayList<Product> products;
    private Inventory inventory;
    public ReportUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.conectDB();
        this.printInventoryInScroll();
    }

    
    private void conectDB(){
        
        try (MongoClient client = MongoConnection.createClient()) {
            ProductRepository productRepository = new ProductRepository(client);
            products =  productRepository.getAllProducts();
            InventoryRepository inventoryRepository = new InventoryRepository(client);
            inventory =  inventoryRepository.getInventory();
            SalesRepository salesRepository = new SalesRepository(client);
            sales =  salesRepository.getSales();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        before = new javax.swing.JButton();
        inventaryText = new javax.swing.JScrollPane();
        inventaryTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Nexa Heavy", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reports");

        home.setBackground(new java.awt.Color(0, 153, 153));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-home.png"))); // NOI18N
        home.setActionCommand("goMain");
        home.setBorder(null);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setPreferredSize(new java.awt.Dimension(518, 519));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHome(evt);
            }
        });

        before.setBackground(new java.awt.Color(0, 153, 153));
        before.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-left-solid.png"))); // NOI18N
        before.setActionCommand("goBefore");
        before.setBorder(null);
        before.setBorderPainted(false);
        before.setContentAreaFilled(false);
        before.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        before.setPreferredSize(new java.awt.Dimension(518, 519));
        before.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBefore(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(before, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(250, 250, 250)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(before, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        inventaryText.setToolTipText("El inventario esta vacio");
        inventaryText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inventaryTextArea.setEditable(false);
        inventaryTextArea.setColumns(20);
        inventaryTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextArea.setRows(5);
        inventaryText.setViewportView(inventaryTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventaryText)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventaryText, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void printInventoryInScroll() {
        String text = "";

        text = text.concat(this.inventory.printReportStock(this.products) + "\n");
        text = text.concat(this.sales.printReportForDayWeekMonth());
        
        for(int i = 0; i < this.sales.getSales().size(); i++){
            text = text.concat( Float.toString(this.sales.getSales().get(i).calculateTotalCost()) );
        }

        if (text.equals("\n")) {
            text = text.concat("No report available!");
        }
        
        this.inventaryTextArea.setText(text);
    }


    private void goHome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHome
        this.dispose();
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        Main main = new Main(parent, true);
        main.setVisible(true);
    }//GEN-LAST:event_goHome

    private void goBefore(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBefore
        this.dispose();
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        Main main = new Main(parent, true);
        main.setVisible(true);
    }//GEN-LAST:event_goBefore

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportUI dialog = new ReportUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton before;
    private javax.swing.JButton home;
    private javax.swing.JScrollPane inventaryText;
    private javax.swing.JTextArea inventaryTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
