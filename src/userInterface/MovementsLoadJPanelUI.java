package userInterface;

import Repository.InventoryMovementRepository;
import com.mongodb.client.MongoClient;
import entities.Inventory;
import entities.InventoryMovementHistory;
import javax.swing.JOptionPane;
import repository.InventoryRepository;
import repository.MongoConnection;

public class MovementsLoadJPanelUI extends javax.swing.JPanel {

    private InventoryMovementHistory inventaryMovementHistory;
    private Inventory inventory;
    private InventoryRepository inventoryRepository;
    private InventoryMovementRepository inventoryMovementRepository;
    public MovementsLoadJPanelUI() {
        initComponents();
        this.conectDB();
        printJYearChooserIdInventory();
        printInventaryTextAreaMovements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LoadIdInventory = new javax.swing.JButton();
        jYearChooserIdInventory = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventaryTextAreaMovements = new javax.swing.JTextArea();

        jLabel2.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        LoadIdInventory.setBackground(new java.awt.Color(0, 153, 153));
        LoadIdInventory.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        LoadIdInventory.setForeground(new java.awt.Color(255, 255, 255));
        LoadIdInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotate-left-solid.png"))); // NOI18N
        LoadIdInventory.setText("  Load");
        LoadIdInventory.setActionCommand("searchCategorieInventory");
        LoadIdInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoadIdInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadIdInventory(evt);
            }
        });

        jYearChooserIdInventory.setMinimum(0);
        jYearChooserIdInventory.setValue(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoadIdInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jYearChooserIdInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jYearChooserIdInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(LoadIdInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        inventaryTextAreaMovements.setEditable(false);
        inventaryTextAreaMovements.setColumns(20);
        inventaryTextAreaMovements.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextAreaMovements.setRows(5);
        inventaryTextAreaMovements.setText("No Inventory");
        jScrollPane1.setViewportView(inventaryTextAreaMovements);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void conectDB(){
        
        try (MongoClient client = MongoConnection.createClient()) {
            InventoryMovementRepository inventoryMovementRepository = new InventoryMovementRepository(client);
            inventaryMovementHistory =  inventoryMovementRepository.getInventoryMovements();
            inventoryRepository = new InventoryRepository(client);
            inventory = inventoryRepository.getInventory();
        
            this.inventoryMovementRepository = new InventoryMovementRepository(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void printInventaryTextAreaMovements() {
        inventaryTextAreaMovements.setText(this.inventaryMovementHistory.report());
    }

    private void printJYearChooserIdInventory() {
        jYearChooserIdInventory.setMaximum(this.inventaryMovementHistory.getInventoryMovementHistory().size() - 1);
        jYearChooserIdInventory.setMinimum(0);
    }


    private void LoadIdInventory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadIdInventory
        this.inventory.setInventory(this.inventaryMovementHistory.getInventoryMovementHistory().get(jYearChooserIdInventory.getValue()).getInventory());
        
        try (MongoClient client = MongoConnection.createClient()) {
            InventoryRepository tempRepository = new InventoryRepository(client);
            tempRepository.clearInventory();
            tempRepository.uploadInventory(this.inventory);
            
            InventoryMovementRepository tempInventoryMovementRepository = new InventoryMovementRepository(client);
            tempInventoryMovementRepository.addInventoryMovement(this.inventory.getInventory());
            
            JOptionPane.showMessageDialog(null, "The inventory is reload", "Success", JOptionPane.QUESTION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Process detect a error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoadIdInventory


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadIdInventory;
    private javax.swing.JTextArea inventaryTextAreaMovements;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooserIdInventory;
    // End of variables declaration//GEN-END:variables
}
