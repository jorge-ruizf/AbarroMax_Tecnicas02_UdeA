package userInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Repository.InventoryMovementRepository;
import com.mongodb.client.MongoClient;
import entities.Inventory;
import entities.InventoryMovement;
import entities.InventoryMovementHistory;
import repository.InventoryRepository;
import repository.MongoConnection;

public class MovementsUploadJPanelUI extends javax.swing.JPanel {
    
    private InventoryMovementHistory inventaryMovementHistory;
    private Inventory inventory;
    private InventoryRepository inventoryRepository;
    public MovementsUploadJPanelUI() {
        initComponents();
        this.conectDB();
        printjLabelActualTimeClock();
        PrintInventaryTextAreaUpload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        uploadInventory = new javax.swing.JButton();
        jLabelActualTimeClock = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventaryTextAreaUpload = new javax.swing.JTextArea();

        jLabel2.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel2.setText("Actual Time:");

        uploadInventory.setBackground(new java.awt.Color(0, 153, 153));
        uploadInventory.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        uploadInventory.setForeground(new java.awt.Color(255, 255, 255));
        uploadInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload-solid.png"))); // NOI18N
        uploadInventory.setText("Upload");
        uploadInventory.setActionCommand("searchCategorieInventory");
        uploadInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadInventory(evt);
            }
        });

        jLabelActualTimeClock.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabelActualTimeClock.setText("dd-MM-YY-HH-MM-SS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uploadInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelActualTimeClock))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActualTimeClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(uploadInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        inventaryTextAreaUpload.setColumns(20);
        inventaryTextAreaUpload.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextAreaUpload.setRows(5);
        inventaryTextAreaUpload.setText("El inventario actual");
        jScrollPane1.setViewportView(inventaryTextAreaUpload);

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void printjLabelActualTimeClock() {
        Date now = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(now);

        jLabelActualTimeClock.setText(formattedDate);
    }

    private void PrintInventaryTextAreaUpload() {
        inventaryTextAreaUpload.setText(this.inventory.printStockStatus());
    }

    private void uploadInventory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadInventory
        HashMap<Integer, Integer> inventoryTemp = new HashMap<>();
        String inventoryText = inventaryTextAreaUpload.getText();

        if (inventoryText == null || inventoryText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "The inventory is void", "Alert", JOptionPane.WARNING_MESSAGE);
        }

        if (inventoryText.contains("The inventory is void")) {
            JOptionPane.showMessageDialog(null, "The inventory is void.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

        try {
            // Patrón para capturar líneas del tipo: ID: 1001 | Cantidad: 5
            Pattern pattern = Pattern.compile("ID:\\s*(\\d+)\\s*\\|\\s*Stock:\\s*(\\d+)");
            Matcher matcher = pattern.matcher(inventoryText);

            boolean found = false;

            while (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                int cantidad = Integer.parseInt(matcher.group(2));
                inventoryTemp.put(id, cantidad);
                found = true;
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "The inventory have a invalid format", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Process detect a error", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "The inventory is reload", "Sucess", JOptionPane.QUESTION_MESSAGE);
        
        this.inventory.setInventory(inventoryTemp);

        Date now = new Date();

        this.inventaryMovementHistory.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), now));
        
        try (MongoClient client = MongoConnection.createClient()) {
            InventoryRepository tempRepository = new InventoryRepository(client);
            tempRepository.clearInventory();
            tempRepository.uploadInventory(inventory);
            
            
            InventoryMovementRepository tempInventoryMovementRepository = new InventoryMovementRepository(client);
            tempInventoryMovementRepository.addInventoryMovement(this.inventory.getInventory());
        }

    }//GEN-LAST:event_uploadInventory


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea inventaryTextAreaUpload;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelActualTimeClock;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton uploadInventory;
    // End of variables declaration//GEN-END:variables
}
