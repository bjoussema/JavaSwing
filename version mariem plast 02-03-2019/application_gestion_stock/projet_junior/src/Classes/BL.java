package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class BL extends javax.swing.JFrame {

    ResultSet rs;
    db_connection db;

    public BL() {
        db = new db_connection(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        txtdate.setEditable(true);
         date();
    }

    public void table() {
        String t[] = {"date","mat_fiscal", "nom", "tel", "fax", "adresse"};
        rs = db.querySelect(t, "bl");
        tbl_bl.setModel(new ResultSetTableModel(rs));
    }

    void actualiser() {
        txtdate.setEditable(true);
        date();
        txtmat_fiscal_bl.setText("");
        txtnom_bl.setText("");
        txttel_bl.setText("");
        txtfax_bl.setText("");
        txtadresse_bl.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        comrech_bl = new javax.swing.JComboBox();
        txtrech_bl = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bl = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtdate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfax_bl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttel_bl = new javax.swing.JTextField();
        txtnom_bl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtmat_fiscal_bl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtadresse_bl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 248, 248));
        getContentPane().setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BANDE DE LIVRAISON", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel5.setLayout(null);

        jButton1.setBackground(new java.awt.Color(2, 28, 67));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Accueil.png"))); // NOI18N
        jButton1.setText("Accueil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(30, 30, 170, 40);

        jButton6.setBackground(new java.awt.Color(2, 28, 67));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Quitter.png"))); // NOI18N
        jButton6.setText("Quitter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(30, 190, 170, 40);

        jButton2.setBackground(new java.awt.Color(2, 28, 67));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Ajouter.png"))); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(30, 70, 170, 40);

        jButton4.setBackground(new java.awt.Color(2, 28, 67));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Modifier.png"))); // NOI18N
        jButton4.setText("Modifier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(30, 110, 170, 40);

        jButton5.setBackground(new java.awt.Color(2, 28, 67));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Supprimer.png"))); // NOI18N
        jButton5.setText("Supprimer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(30, 150, 170, 40);

        jPanel6.setBackground(new java.awt.Color(233, 235, 230));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel6.setLayout(null);

        comrech_bl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "mat_fiscal", "nom", "tel", "fax", "adresse" }));
        jPanel6.add(comrech_bl);
        comrech_bl.setBounds(30, 40, 110, 30);

        txtrech_bl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_blActionPerformed(evt);
            }
        });
        jPanel6.add(txtrech_bl);
        txtrech_bl.setBounds(30, 80, 110, 30);

        jButton3.setBackground(new java.awt.Color(2, 28, 67));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Rechercher.png"))); // NOI18N
        jButton3.setText("Chercher");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);
        jButton3.setBounds(10, 130, 170, 40);

        jButton7.setBackground(new java.awt.Color(2, 28, 67));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Actualiser.png"))); // NOI18N
        jButton7.setText("Actualiser");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7);
        jButton7.setBounds(10, 170, 170, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(20, 240, 190, 230);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 150, 240, 490);

        tbl_bl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "date", "mat_fiscal", "nom", "tel", "fax", "adresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_blMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bl);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(250, 230, 1100, 440);

        jPanel7.setBackground(new java.awt.Color(233, 235, 230));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel7.setLayout(null);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel7.add(txtdate);
        txtdate.setBounds(60, 20, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Fax :");
        jPanel7.add(jLabel4);
        jLabel4.setBounds(760, 20, 98, 34);

        txtfax_bl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(txtfax_bl);
        txtfax_bl.setBounds(800, 20, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Tél :");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(600, 20, 50, 34);
        jPanel7.add(txttel_bl);
        txttel_bl.setBounds(640, 20, 110, 30);

        txtnom_bl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(txtnom_bl);
        txtnom_bl.setBounds(480, 20, 110, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Nom :");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(430, 20, 98, 34);

        txtmat_fiscal_bl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(txtmat_fiscal_bl);
        txtmat_fiscal_bl.setBounds(310, 20, 110, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Date :");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(10, 20, 98, 34);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Matricule fiscale :");
        jPanel7.add(jLabel3);
        jLabel3.setBounds(180, 20, 130, 34);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Adresse :");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(910, 20, 98, 34);

        txtadresse_bl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(txtadresse_bl);
        txtadresse_bl.setBounds(980, 20, 110, 30);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(250, 160, 1100, 70);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, -30, 1390, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Quitter
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //ajouter
        if (txtdate.getText().equals("") || txtmat_fiscal_bl.getText().equals("") || txtnom_bl.getText().equals("")
                || txttel_bl.getText().equals("") || txtfax_bl.getText().equals("")
                || txtadresse_bl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","mat_fiscal", "nom", "tel", "fax", "adresse"};
            String[] inf = {txtdate.getText(), txtmat_fiscal_bl.getText(), txtnom_bl.getText(), txttel_bl.getText(), txtfax_bl.getText(), txtadresse_bl.getText()};
            System.out.println(db.queryInsert("bl", colon, inf));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
        if (txtdate.getText().equals("") || txtmat_fiscal_bl.getText().equals("") || txtnom_bl.getText().equals("") || txttel_bl.getText().equals("")
                || txtfax_bl.getText().equals("") || txtadresse_bl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","mat_fiscal", "nom", "tel", "fax", "adresse"};
            String[] inf = {txtdate.getText(),txtmat_fiscal_bl.getText(), txtnom_bl.getText(), txttel_bl.getText(), txtfax_bl.getText(), txtadresse_bl.getText()};
            String id = String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("bl", colon, inf, "mat_fiscal='" + id + "'"));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualiser();
        table();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtrech_bl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
            if (comrech_bl.getSelectedItem().equals("date")) {
                rs = db.querySelectAll("bl", "date LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bl.getSelectedItem().equals("mat_fiscal")) {
                rs = db.querySelectAll("bl", "mat_fiscal LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bl.getSelectedItem().equals("nom")) {
                rs = db.querySelectAll("bl", "nom LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bl.getSelectedItem().equals("tel")) {
                rs = db.querySelectAll("bl", "tel LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bl.getSelectedItem().equals("fax")) {
                rs = db.querySelectAll("bl", "fax LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bl.getSelectedItem().equals("adresse")) {
                rs = db.querySelectAll("bl", "adresse LIKE '%" + txtrech_bl.getText() + "%' ");
                tbl_bl.setModel(new ResultSetTableModel(rs));

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrech_blActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_blActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_blActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("bl", "mat_fiscal=" + id);
        } else {
            return;
        }
        table();       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_blMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_blMouseClicked
        txtdate.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 0)));
        txtmat_fiscal_bl.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 1)));
        txtnom_bl.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 2)));
        txttel_bl.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 3)));
        txtfax_bl.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 4)));
        txtadresse_bl.setText(String.valueOf(tbl_bl.getValueAt(tbl_bl.getSelectedRow(), 5)));
    }//GEN-LAST:event_tbl_blMouseClicked

    public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
    }
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comrech_bl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_bl;
    private javax.swing.JTextField txtadresse_bl;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtfax_bl;
    private javax.swing.JTextField txtmat_fiscal_bl;
    private javax.swing.JTextField txtnom_bl;
    private javax.swing.JTextField txtrech_bl;
    private javax.swing.JTextField txttel_bl;
    // End of variables declaration//GEN-END:variables
}
