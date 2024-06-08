/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProjectSE;

import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yustina Yunita
 */
public class UserML extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql; 
    
    public UserML() {
        initComponents();
        Config DB = new Config();
        DB.conn();
        con = DB.con;
        stat = DB.stm;
    }
    private void Table() {
    DefaultTableModel model = (DefaultTableModel) MenuTable.getModel();
    model.setRowCount(0); // Clear existing rows

        try {
            sql = "SELECT * FROM menu";
            rs = stat.executeQuery(sql);

            MenuTable.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

            while (rs.next()) {
                String menuId = rs.getString("menu_id");
                String menuName = rs.getString("menu_name");
                double price = rs.getDouble("price");

                byte[] imageData = rs.getBytes("image");
                ImageIcon icon = new ImageIcon(imageData);
                Image scaledImage = icon.getImage().getScaledInstance(
                    100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                model.addRow(new Object[]{menuId, menuName, price, scaledIcon});
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error populating table!");
        }
    }
    
    public class ImageRenderer extends DefaultTableCellRenderer {
       @Override
       public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
               boolean hasFocus, int row, int column) {
           JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           if (value instanceof ImageIcon) {
               label.setIcon((ImageIcon) value);
               label.setText(null);
           }
           return label;
       }
   }
    
    void find() {
    DefaultTableModel tbl = new DefaultTableModel();
    tbl.addColumn("ID");
    tbl.addColumn("Menu Name");
    tbl.addColumn("Price");
    tbl.addColumn("Image");
    
        try {
        String FindQuery = "SELECT * FROM menu WHERE menu_name like '%" + UMPFindTextField.getText() + "%'";
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(FindQuery);
        
        while (rs.next()) {
            String menuId = rs.getString("menu_id");
            String menuName = rs.getString("menu_name");
            double price = rs.getDouble("price");

            byte[] imageData = rs.getBytes("image");

            ImageIcon icon = new ImageIcon(imageData);
            Image scaledImage = icon.getImage().getScaledInstance(
                100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            tbl.addRow(new Object[]{menuId, menuName, price, scaledIcon});
        }
        MenuTable.setModel(tbl);

        MenuTable.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error finding menu items!");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        UMPFindButton = new javax.swing.JButton();
        UMPFindTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        UMPShowButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        UMPMenuMenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        UMPPOMenu = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        UMPProfileMenu = new javax.swing.JMenu();
        UMPContactMenu = new javax.swing.JMenu();
        UMPLogoutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        UMPFindButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UMPFindButton.setText("Find");
        UMPFindButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPFindButtonMouseClicked(evt);
            }
        });

        UMPFindTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        MenuTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Menu Name", "Price", "Image"
            }
        ));
        MenuTable.setRowHeight(100);
        MenuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MenuTable);

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 3, 36)); // NOI18N
        jLabel1.setText("Our Menu");

        UMPShowButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UMPShowButton.setText("Show");
        UMPShowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPShowButtonMouseClicked(evt);
            }
        });
        UMPShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UMPShowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(UMPShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UMPFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UMPFindTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel1)
                                .addGap(410, 410, 410)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UMPFindTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UMPFindButton)
                    .addComponent(UMPShowButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        UMPMenuMenu.setText("Menu List");
        UMPMenuMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPMenuMenuMouseClicked(evt);
            }
        });
        jMenu1.add(UMPMenuMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Order");

        UMPPOMenu.setText("Place Order");
        UMPPOMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPPOMenuMouseClicked(evt);
            }
        });
        jMenu2.add(UMPPOMenu);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("About");

        UMPProfileMenu.setText("My Profile");
        UMPProfileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPProfileMenuMouseClicked(evt);
            }
        });
        jMenu6.add(UMPProfileMenu);

        UMPContactMenu.setText("Contact Us");
        UMPContactMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPContactMenuMouseClicked(evt);
            }
        });
        jMenu6.add(UMPContactMenu);

        UMPLogoutMenu.setText("Logout");
        UMPLogoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMPLogoutMenuMouseClicked(evt);
            }
        });
        jMenu6.add(UMPLogoutMenu);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTableMouseClicked
    
    }//GEN-LAST:event_MenuTableMouseClicked

    private void UMPShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UMPShowButtonActionPerformed
    DefaultTableModel model = (DefaultTableModel) MenuTable.getModel();
    model.setRowCount(0); // Clear existing rows

    try {
        sql = "SELECT * FROM menu";
        rs = stat.executeQuery(sql);

        MenuTable.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

        while (rs.next()) {
            String menuId = rs.getString("menu_id");
            String menuName = rs.getString("menu_name");
            double price = rs.getDouble("price");

            byte[] imageData = rs.getBytes("image");
            ImageIcon icon = new ImageIcon(imageData);
            Image scaledImage = icon.getImage().getScaledInstance(
                100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            model.addRow(new Object[]{menuId, menuName, price, scaledIcon});
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error populating table!");
    }
    }//GEN-LAST:event_UMPShowButtonActionPerformed

    private void UMPShowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPShowButtonMouseClicked

    }//GEN-LAST:event_UMPShowButtonMouseClicked

    private void UMPFindButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPFindButtonMouseClicked
    find();
    }//GEN-LAST:event_UMPFindButtonMouseClicked

    private void UMPMenuMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPMenuMenuMouseClicked
        dispose();
        UserML UMP = new UserML();
        UMP.setLocationRelativeTo(null);
        UMP.setLocationRelativeTo(null);
        UMP.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_UMPMenuMenuMouseClicked

    private void UMPPOMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPPOMenuMouseClicked
        dispose();
        UserOP UOP = new UserOP();
        UOP.setLocationRelativeTo(null);
        UOP.setLocationRelativeTo(null);
        UOP.setVisible(true);
    }//GEN-LAST:event_UMPPOMenuMouseClicked

    private void UMPLogoutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPLogoutMenuMouseClicked
        dispose();
        MainPage MP = new MainPage();
        MP.setLocationRelativeTo(null);
        MP.setLocationRelativeTo(null);
        MP.setVisible(true);
    }//GEN-LAST:event_UMPLogoutMenuMouseClicked

    private void UMPProfileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPProfileMenuMouseClicked
        dispose();
        UserAP UAP = new UserAP();
        UAP.setLocationRelativeTo(null);
        UAP.setLocationRelativeTo(null);
        UAP.setVisible(true);
    }//GEN-LAST:event_UMPProfileMenuMouseClicked

    private void UMPContactMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMPContactMenuMouseClicked
        dispose();
        UserCUP UCUP = new UserCUP();
        UCUP.setLocationRelativeTo(null);
        UCUP.setLocationRelativeTo(null);
        UCUP.setVisible(true);
    }//GEN-LAST:event_UMPContactMenuMouseClicked

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
            java.util.logging.Logger.getLogger(UserML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MenuTable;
    private javax.swing.JMenu UMPContactMenu;
    private javax.swing.JButton UMPFindButton;
    private javax.swing.JTextField UMPFindTextField;
    private javax.swing.JMenu UMPLogoutMenu;
    private javax.swing.JMenu UMPMenuMenu;
    private javax.swing.JMenu UMPPOMenu;
    private javax.swing.JMenu UMPProfileMenu;
    private javax.swing.JButton UMPShowButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
