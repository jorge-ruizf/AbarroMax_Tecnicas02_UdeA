package userInterface;

import Repository.PricesRepository;
import com.mongodb.client.MongoClient;
import entities.Categories;
import entities.Inventory;
import entities.Prices;
import entities.Product;
import entities.Sales;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import repository.CategoriesRepository;
import repository.InventoryRepository;
import repository.MongoConnection;
import repository.ProductRepository;

public class CatalogUI extends javax.swing.JDialog {

    private ArrayList<Product> products;
    private Inventory inventory;
    private Categories categories;
    private Prices prices;
    private Sales sales;

    public CatalogUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.conectDB();
        this.printComboBoxCategorie();
        this.printInventoryInScroll();
        this.showImage("Pastillas de menta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        before = new javax.swing.JButton();
        inventaryText = new javax.swing.JScrollPane();
        inventaryTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        searchCategorieInventory = new javax.swing.JButton();
        comboBoxCategorie = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        home1 = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        imgRight = new javax.swing.JLabel();
        nameRight = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        priceRight = new javax.swing.JLabel();
        nameRight1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        setModal(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Nexa Heavy", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Catalog");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(382, 382, 382))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(before, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        inventaryText.setToolTipText("El inventario esta vacio");
        inventaryText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inventaryTextArea.setEditable(false);
        inventaryTextArea.setColumns(20);
        inventaryTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextArea.setRows(5);
        inventaryText.setViewportView(inventaryTextArea);

        searchCategorieInventory.setBackground(new java.awt.Color(0, 153, 153));
        searchCategorieInventory.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        searchCategorieInventory.setForeground(new java.awt.Color(255, 255, 255));
        searchCategorieInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifying-glass-solid.png"))); // NOI18N
        searchCategorieInventory.setText("  Search");
        searchCategorieInventory.setActionCommand("searchCategorieInventory");
        searchCategorieInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchCategorieInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCategorieInventory(evt);
            }
        });

        comboBoxCategorie.setFont(new java.awt.Font("Nexa Extra Light", 0, 14)); // NOI18N
        comboBoxCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alls" }));
        comboBoxCategorie.setActionCommand("comboBoxCategorie");
        comboBoxCategorie.setAutoscrolls(true);
        comboBoxCategorie.setInheritsPopupMenu(true);
        comboBoxCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategorieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchCategorieInventory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCategorieInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchCategorieInventory.getAccessibleContext().setAccessibleName("  searchCategorieInventory");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        home.setBackground(new java.awt.Color(0, 153, 153));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-left-solid.png"))); // NOI18N
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

        home1.setBackground(new java.awt.Color(0, 153, 153));
        home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-right-solid.png"))); // NOI18N
        home1.setActionCommand("goMain");
        home1.setBorder(null);
        home1.setBorderPainted(false);
        home1.setContentAreaFilled(false);
        home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home1.setPreferredSize(new java.awt.Dimension(518, 519));
        home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1goHome(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
            .addComponent(home1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        imgRight.setText("img not found");
        imgRight.setMaximumSize(new java.awt.Dimension(225, 225));
        imgRight.setMinimumSize(new java.awt.Dimension(225, 225));
        imgRight.setPreferredSize(new java.awt.Dimension(225, 225));

        nameRight.setFont(new java.awt.Font("Nexa Extra Light", 0, 24)); // NOI18N
        nameRight.setText("Name:");
        nameRight.setToolTipText("");

        jLabelName1.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabelName1.setText("Name");
        jLabelName1.setToolTipText("");
        jLabelName1.setMaximumSize(new java.awt.Dimension(192, 99));

        priceRight.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        priceRight.setText("Price");
        priceRight.setToolTipText("");

        nameRight1.setFont(new java.awt.Font("Nexa Extra Light", 0, 24)); // NOI18N
        nameRight1.setText("Unit Price");
        nameRight1.setToolTipText("");

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRightLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(imgRight, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameRight)
                    .addComponent(nameRight1)
                    .addComponent(priceRight)
                    .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRightLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addComponent(nameRight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameRight1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceRight)
                        .addGap(65, 65, 65))
                    .addComponent(imgRight, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inventaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventaryText)
                    .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectDB(){
        
        try (MongoClient client = MongoConnection.createClient()) {
            ProductRepository productRepository = new ProductRepository(client);
            products =  productRepository.getAllProducts();
            InventoryRepository inventoryRepository = new InventoryRepository(client);
            inventory =  inventoryRepository.getInventory();
            CategoriesRepository categoriesRepository = new CategoriesRepository(client);
            categories =  categoriesRepository.getCategories();
            PricesRepository pricesRepository = new PricesRepository(client);
            prices =  pricesRepository.getPrices();
            //SalesRepository salesRepository = new SalesRepository(client);
            //sales =  salesRepository.getSales();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void printInventoryInScroll() {
        // Si se pasa la validación, procede
        String inventaryText = this.inventory.printInventoryCatalog(comboBoxCategorie.getSelectedIndex() - 1, "" ,this.products, this.categories, this.prices );
        this.inventaryTextArea.setText(inventaryText);
            System.out.println(inventaryText);
    }

    private void printComboBoxCategorie() {
        for (int i = 0; i < this.categories.getCategories().size(); i++) {
            comboBoxCategorie.addItem(this.categories.getCategories().get(i));
        }
    }
    
    private void showImage(String name){             
        java.net.URL imgUrl = getClass().getResource("/images/products/" + name + ".jpg");
        if (imgUrl == null) {
            System.err.println("No se encontró la imagen: " + name);
            return;
        }

        ImageIcon originalIcon = new ImageIcon(imgUrl);
        Image originalImage = originalIcon.getImage();

        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        int maxWidth = 500;
        int maxHeight = 500;

        // Escala proporcionalmente
        float widthRatio = (float) maxWidth / originalWidth;
        float heightRatio = (float) maxHeight / originalHeight;
        float scale = Math.min(widthRatio, heightRatio); // la menor escala mantiene proporción

        int newWidth = Math.round(originalWidth * scale);
        int newHeight = Math.round(originalHeight * scale);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        this.imgRight.setIcon(scaledIcon);
        this.imgRight.setHorizontalAlignment(JLabel.CENTER);
        this.imgRight.setVerticalAlignment(JLabel.CENTER);
    }

    private void searchCategorieInventory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCategorieInventory
        this.printInventoryInScroll();
    }//GEN-LAST:event_searchCategorieInventory

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

    private void comboBoxCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategorieActionPerformed

    }//GEN-LAST:event_comboBoxCategorieActionPerformed

    private void home1goHome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1goHome
        // TODO add your handling code here:
    }//GEN-LAST:event_home1goHome

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
            java.util.logging.Logger.getLogger(CatalogUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CatalogUI dialog = new CatalogUI(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboBoxCategorie;
    private javax.swing.JButton home;
    private javax.swing.JButton home1;
    private javax.swing.JLabel imgRight;
    private javax.swing.JScrollPane inventaryText;
    private javax.swing.JTextArea inventaryTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameRight;
    private javax.swing.JLabel nameRight1;
    private javax.swing.JPanel panelRight;
    private javax.swing.JLabel priceRight;
    private javax.swing.JButton searchCategorieInventory;
    // End of variables declaration//GEN-END:variables
}
