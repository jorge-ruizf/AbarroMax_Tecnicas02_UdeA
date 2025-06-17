package userInterface;

import Repository.InventoryMovementRepository;
import Repository.PricesRepository;
import Repository.SalesRepository;
import com.mongodb.client.MongoClient;
import entities.Categories;
import entities.Inventory;
import entities.Price;
import entities.Prices;
import entities.Product;
import entities.ProductSale;
import entities.Sale;
import entities.Sales;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import repository.CategoriesRepository;
import repository.InventoryRepository;
import repository.MongoConnection;
import repository.ProductRepository;

public class SaleUI extends javax.swing.JDialog {

    private ArrayList<Product> products;
    private Inventory inventory;
    private Categories categories;
    private Prices prices;
    private Sales sales;
    private Sale sale;
    
    private MongoClient client;
    private SalesRepository salesRepository;
    private InventoryRepository inventoryRepository;
    private InventoryMovementRepository inventoryMovementRepository;

    public SaleUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.conectDB();
        this.printInventoryInScroll();
        this.printComboBoxCategorie();
        sale = new Sale();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchCategorieInventory6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        before = new javax.swing.JButton();
        searchCategorieInventory = new javax.swing.JButton();
        JTextFieldSearch = new javax.swing.JTextField();
        comboBoxCategorie = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventaryTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        jYearChooserIdProduct = new com.toedter.calendar.JYearChooser();
        jYearChooserQuantity = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDeleteProduct = new javax.swing.JButton();
        jYearChooserDiscount = new com.toedter.calendar.JYearChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        saleTextArea = new javax.swing.JTextArea();
        btnSale = new javax.swing.JButton();

        searchCategorieInventory6.setBackground(new java.awt.Color(0, 153, 153));
        searchCategorieInventory6.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        searchCategorieInventory6.setForeground(new java.awt.Color(255, 255, 255));
        searchCategorieInventory6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifying-glass-solid.png"))); // NOI18N
        searchCategorieInventory6.setText("  Search");
        searchCategorieInventory6.setActionCommand("searchCategorieInventory");
        searchCategorieInventory6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchCategorieInventory6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCategorieInventory6(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 500));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Nexa Heavy", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sale");

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
                homegoHome(evt);
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
                beforegoBefore(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(before, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
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

        JTextFieldSearch.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldSearchActionPerformed(evt);
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

        inventaryTextArea.setEditable(false);
        inventaryTextArea.setColumns(20);
        inventaryTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextArea.setRows(5);
        jScrollPane1.setViewportView(inventaryTextArea);

        jLabel2.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        btnAddProduct.setBackground(new java.awt.Color(0, 153, 153));
        btnAddProduct.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload-solid.png"))); // NOI18N
        btnAddProduct.setText("  Add");
        btnAddProduct.setActionCommand("searchCategorieInventory");
        btnAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProduct(evt);
            }
        });

        jYearChooserIdProduct.setMinimum(0);
        jYearChooserIdProduct.setValue(0);

        jYearChooserQuantity.setMinimum(0);
        jYearChooserQuantity.setValue(0);

        jLabel3.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel3.setText("Quantity:");

        jLabel4.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel4.setText("Discount:");

        btnDeleteProduct.setBackground(new java.awt.Color(0, 153, 153));
        btnDeleteProduct.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotate-left-solid.png"))); // NOI18N
        btnDeleteProduct.setText("  Delete");
        btnDeleteProduct.setActionCommand("searchCategorieInventory");
        btnDeleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProduct(evt);
            }
        });

        jYearChooserDiscount.setMinimum(0);
        jYearChooserDiscount.setValue(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jYearChooserIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jYearChooserQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jYearChooserDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jYearChooserIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jYearChooserQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jYearChooserDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        saleTextArea.setColumns(20);
        saleTextArea.setRows(5);
        jScrollPane2.setViewportView(saleTextArea);

        btnSale.setBackground(new java.awt.Color(0, 153, 153));
        btnSale.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart-shopping-solid.png"))); // NOI18N
        btnSale.setText("  Sale");
        btnSale.setActionCommand("searchCategorieInventory");
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSale(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTextFieldSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchCategorieInventory)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchCategorieInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectDB(){
        
        this.client = MongoConnection.createClient();
        ProductRepository productRepository = new ProductRepository(client);
        products =  productRepository.getAllProducts();
        this.inventoryRepository = new InventoryRepository(client);
        inventory =  inventoryRepository.getInventory();
        CategoriesRepository categoriesRepository = new CategoriesRepository(client);
        categories =  categoriesRepository.getCategories();
        PricesRepository pricesRepository = new PricesRepository(client);
        prices =  pricesRepository.getPrices();
        this.salesRepository = new SalesRepository(client);
        sales = this.salesRepository.getSales();
        
        this.inventoryMovementRepository = new InventoryMovementRepository(client);
    }
   
    private void printInventoryInScroll() {
        String inventaryText = "";

        // Validar que el texto ingresado solo contenga letras y espacios opcionales
        String searchText = JTextFieldSearch.getText().trim();

        if (!searchText.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*$")) {
            JOptionPane.showMessageDialog(this, "El texto de búsqueda solo debe contener letras, sin espacios ni caracteres especiales.", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
            return; // Detener ejecución si la entrada es inválida
    }

        // Obtener el índice seleccionado del combo box
        int selectedIndex = comboBoxCategorie.getSelectedIndex() - 1;

        inventaryText = inventaryText.concat(
            this.inventory.printInventoryCatalog(
                selectedIndex,
                searchText,
                this.products,
                this.categories,
                this.prices
            )
        );

    this.inventaryTextArea.setText(inventaryText);
}


    private void printComboBoxCategorie() {
        for (int i = 0; i < this.categories.getCategories().size(); i++) {
            comboBoxCategorie.addItem(this.categories.getCategories().get(i));
        }
    }

    private void homegoHome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homegoHome
        this.dispose();
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        Main main = new Main(parent, true);
        main.setVisible(true);
    }//GEN-LAST:event_homegoHome

    private void beforegoBefore(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforegoBefore
        this.dispose();
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        Main main = new Main(parent, true);
        main.setVisible(true);
    }//GEN-LAST:event_beforegoBefore

    private void searchCategorieInventory6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCategorieInventory6

    }//GEN-LAST:event_searchCategorieInventory6

    private void searchCategorieInventory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCategorieInventory
        this.printInventoryInScroll();
    }//GEN-LAST:event_searchCategorieInventory

    private void JTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldSearchActionPerformed

    private void comboBoxCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategorieActionPerformed

    }//GEN-LAST:event_comboBoxCategorieActionPerformed


    private void btnAddProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProduct

        int idProduct = jYearChooserIdProduct.getValue();
        int discount = jYearChooserDiscount.getValue();
        int quantity = jYearChooserQuantity.getValue();

        boolean isAdd = false;

        // Verificar que los valores estén dentro de los rangos válidos
        for (ProductSale ps : this.sale.getProductSales()) {
            if (ps.getProductId() == idProduct) {
                isAdd = true;
            }
        }
        if (isAdd) {
            JOptionPane.showMessageDialog(null, "The product has already been added", "Alert", JOptionPane.WARNING_MESSAGE);

        } else if (idProduct < 0 || idProduct >= this.products.size()) {
            JOptionPane.showMessageDialog(null, "The ID product is out of index", "Alert", JOptionPane.WARNING_MESSAGE);

        } else if (discount < 0 || discount >= 100) {
            JOptionPane.showMessageDialog(null, "Invalid discount", "Alert", JOptionPane.WARNING_MESSAGE);

        } else if (quantity < 1 || quantity > this.inventory.getInventory().get(idProduct)) {
            JOptionPane.showMessageDialog(null, "Exced the actual stock of the product", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            ProductSale productSale = new ProductSale(idProduct, discount, quantity);
            this.sale.addProduct(productSale);
        }
        printSaleTextArea();


    }//GEN-LAST:event_btnAddProduct

    private void btnDeleteProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProduct
        int idProduct = jYearChooserIdProduct.getValue();

        this.sale.removeProductById(idProduct);
        printSaleTextArea();
    }//GEN-LAST:event_btnDeleteProduct

    private void btnSale(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSale
        String receipt = this.sale.printReceipt(this.products, this.prices);
        this.sales.addSale(this.sale);
        
        this.inventory.saleToUpdateInventory(this.sale);
        
        JOptionPane.showMessageDialog(null, receipt, "Sale Receipt", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        try (MongoClient client = MongoConnection.createClient()) {
            SalesRepository tempSaleRepository = new SalesRepository(client);
            tempSaleRepository.addSale(this.sale);
            
            InventoryRepository tempRepository = new InventoryRepository(client);
            tempRepository.clearInventory();
            tempRepository.uploadInventory(this.inventory);
            
            InventoryMovementRepository tempInventoryMovementRepository = new InventoryMovementRepository(client);
            tempInventoryMovementRepository.addInventoryMovement(this.inventory.getInventory());
        }
        
        this.sale = new Sale();
        
        printSaleTextArea();
        printInventoryInScroll();
    }//GEN-LAST:event_btnSale

    private void printSaleTextArea() {
        String text = sale.getProductSalesAsString();

        saleTextArea.setText(text);
    }

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
            java.util.logging.Logger.getLogger(SaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaleUI dialog = new SaleUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        if (dialog.client != null) {
                            dialog.client.close();
                        }
                        System.exit(0);
                    }
                });

                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldSearch;
    private javax.swing.JButton before;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnSale;
    private javax.swing.JComboBox<String> comboBoxCategorie;
    private javax.swing.JButton home;
    private javax.swing.JTextArea inventaryTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JYearChooser jYearChooserDiscount;
    private com.toedter.calendar.JYearChooser jYearChooserIdProduct;
    private com.toedter.calendar.JYearChooser jYearChooserQuantity;
    private javax.swing.JTextArea saleTextArea;
    private javax.swing.JButton searchCategorieInventory;
    private javax.swing.JButton searchCategorieInventory6;
    // End of variables declaration//GEN-END:variables
}
