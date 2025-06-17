package userInterface;

import Repository.InventoryMovementRepository;
import com.mongodb.client.MongoClient;
import entities.InventoryMovementHistory;
import repository.MongoConnection;

public class MovementsHistoryJPanelUI extends javax.swing.JPanel {

    private InventoryMovementHistory inventaryMovementHistory;
    public MovementsHistoryJPanelUI() {
        initComponents();
        this.conectDB();
        printInventaryTextAreaMovements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jDateChooserSince = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateChooserUntil = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        searchDateInventoryMovements = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventaryTextAreaMovements = new javax.swing.JTextArea();

        jDateChooserSince.setFont(new java.awt.Font("Nexa Extra Light", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel14.setText("Since:");

        jDateChooserUntil.setFont(new java.awt.Font("Nexa Extra Light", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Nexa Extra Light", 0, 18)); // NOI18N
        jLabel15.setText("Until:");

        searchDateInventoryMovements.setBackground(new java.awt.Color(0, 153, 153));
        searchDateInventoryMovements.setFont(new java.awt.Font("Nexa Heavy", 0, 24)); // NOI18N
        searchDateInventoryMovements.setForeground(new java.awt.Color(255, 255, 255));
        searchDateInventoryMovements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifying-glass-solid.png"))); // NOI18N
        searchDateInventoryMovements.setText("  Search");
        searchDateInventoryMovements.setActionCommand("searchCategorieInventory");
        searchDateInventoryMovements.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchDateInventoryMovements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateInventoryMovements(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchDateInventoryMovements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jDateChooserSince, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jDateChooserUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(searchDateInventoryMovements, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        inventaryTextAreaMovements.setEditable(false);
        inventaryTextAreaMovements.setColumns(20);
        inventaryTextAreaMovements.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        inventaryTextAreaMovements.setRows(5);
        inventaryTextAreaMovements.setText("No Movements");
        jScrollPane1.setViewportView(inventaryTextAreaMovements);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void conectDB(){
        
        try (MongoClient client = MongoConnection.createClient()) {
            InventoryMovementRepository inventoryMovementRepository = new InventoryMovementRepository(client);
            inventaryMovementHistory =  inventoryMovementRepository.getInventoryMovements();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printInventaryTextAreaMovements() {
        inventaryTextAreaMovements.setText(this.inventaryMovementHistory.report());
    }


    private void searchDateInventoryMovements(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateInventoryMovements
        inventaryTextAreaMovements.setText(this.inventaryMovementHistory.report(jDateChooserSince.getDate(), jDateChooserUntil.getDate()));
    }//GEN-LAST:event_searchDateInventoryMovements


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea inventaryTextAreaMovements;
    private com.toedter.calendar.JDateChooser jDateChooserSince;
    private com.toedter.calendar.JDateChooser jDateChooserUntil;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchDateInventoryMovements;
    // End of variables declaration//GEN-END:variables
}
