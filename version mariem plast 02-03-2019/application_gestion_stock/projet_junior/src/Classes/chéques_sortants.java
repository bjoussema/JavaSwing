
package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class chéques_sortants extends javax.swing.JFrame {
    ResultSet rs;
    db_connection db;
    
    public chéques_sortants() {
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
        String a[] = {"date","id", "mat_fiscale", "RIB", "cheque_daté","date_échéance","montant","bank"};
        rs = db.querySelect(a, "chéques_sortants");
        table_ce.setModel(new ResultSetTableModel(rs));
    }
     public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
    }
     void actualiser() {
        txtdate.setEditable(true);
        date();   
        txtid_ce.setText("");
        txtmatf_ce.setText("");
        txtRIB_ce.setText("");
        txtdat_ce.setText("");
        txtdatéch_ce.setText("");
        txtmont_ce.setText("");
        txtbank_ce.setText("");
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_ce = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtid_ce = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdat_ce = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtbank_ce = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmont_ce = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdatéch_ce = new javax.swing.JTextField();
        txtRIB_ce = new javax.swing.JTextField();
        txtmatf_ce = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        comrech_ce = new javax.swing.JComboBox();
        txtrech_ce = new javax.swing.JTextField();
        chercher = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        table_ce.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "id", "mat_fiscale", "RIB", "cheque_daté", "date d'échéance", "montant", "bank"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_ce.setPreferredSize(new java.awt.Dimension(1090, 64));
        table_ce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ceMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_ce);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(240, 250, 1090, 480);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, -30, 1390, 210);

        jPanel7.setBackground(new java.awt.Color(233, 235, 230));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel7.setLayout(null);
        jPanel7.add(txtid_ce);
        txtid_ce.setBounds(340, 20, 110, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Mat_fiscale :");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(490, 20, 120, 34);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Date d'échéance : ");
        jPanel7.add(jLabel4);
        jLabel4.setBounds(340, 60, 150, 34);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Chèque daté :");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(100, 60, 110, 34);

        txtdat_ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdat_ceActionPerformed(evt);
            }
        });
        jPanel7.add(txtdat_ce);
        txtdat_ce.setBounds(210, 60, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Bank : ");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(860, 60, 80, 34);
        jPanel7.add(txtbank_ce);
        txtbank_ce.setBounds(930, 60, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Montant :");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(630, 60, 98, 34);
        jPanel7.add(txtmont_ce);
        txtmont_ce.setBounds(720, 60, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Id : ");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(310, 20, 98, 34);
        jPanel7.add(txtdatéch_ce);
        txtdatéch_ce.setBounds(490, 60, 110, 30);
        jPanel7.add(txtRIB_ce);
        txtRIB_ce.setBounds(800, 20, 110, 30);
        jPanel7.add(txtmatf_ce);
        txtmatf_ce.setBounds(590, 20, 110, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("RIB :");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(740, 20, 98, 34);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Date :");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(80, 20, 60, 22);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel7.add(txtdate);
        txtdate.setBounds(140, 20, 110, 30);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(240, 150, 1090, 100);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CHEQUES SORTANTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(233, 235, 230));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel3.setLayout(null);

        comrech_ce.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "mat_fiscale", "RIB", "date d'échéance", "montant", "bank" }));
        jPanel3.add(comrech_ce);
        comrech_ce.setBounds(40, 30, 110, 30);

        txtrech_ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_ceActionPerformed(evt);
            }
        });
        jPanel3.add(txtrech_ce);
        txtrech_ce.setBounds(40, 70, 110, 30);

        chercher.setBackground(new java.awt.Color(2, 28, 67));
        chercher.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        chercher.setForeground(new java.awt.Color(255, 255, 255));
        chercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Rechercher.png"))); // NOI18N
        chercher.setText("Chercher");
        chercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherActionPerformed(evt);
            }
        });
        jPanel3.add(chercher);
        chercher.setBounds(10, 120, 170, 40);

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
        jPanel3.add(jButton7);
        jButton7.setBounds(10, 160, 170, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 280, 190, 230);

        jButton1.setBackground(new java.awt.Color(2, 28, 67));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Accueil.png"))); // NOI18N
        jButton1.setText("Accueil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(30, 30, 170, 40);

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
        jPanel2.add(jButton2);
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
        jPanel2.add(jButton4);
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
        jPanel2.add(jButton5);
        jButton5.setBounds(30, 150, 170, 40);

        jButton3.setBackground(new java.awt.Color(2, 28, 67));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Retour.png"))); // NOI18N
        jButton3.setText("Retour");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(30, 190, 170, 40);

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
        jPanel2.add(jButton6);
        jButton6.setBounds(30, 230, 170, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 150, 230, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Quitter
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void table_ceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ceMouseClicked
        txtdate.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 0)));
        txtid_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 1)));
        txtmatf_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 2)));
        txtRIB_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 3)));
        txtdat_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 4)));
        txtdatéch_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 5)));
        txtmont_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 6)));
        txtbank_ce.setText(String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 7)));
    }//GEN-LAST:event_table_ceMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //ajouter
       if (txtdate.getText().equals("") ||txtid_ce.getText().equals("") || txtmatf_ce.getText().equals("")
                || txtRIB_ce.getText().equals("")|| txtdat_ce.getText().equals("")
                        || txtdatéch_ce.getText().equals("")|| txtmont_ce.getText().equals("")
               || txtbank_ce.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","id", "mat_fiscale", "RIB", "cheque_daté","date_échéance","montant","bank"};
            String[] inf = {txtdate.getText(),txtid_ce.getText(),txtmatf_ce.getText(),txtRIB_ce.getText(),  txtdat_ce.getText(),
                txtdatéch_ce.getText()
                    ,txtmont_ce.getText(),txtbank_ce.getText() };
            System.out.println(db.queryInsert("chéques_sortants", colon, inf));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
          if (txtdate.getText().equals("") || txtid_ce.getText().equals("") || txtmatf_ce.getText().equals("") || txtRIB_ce.getText().equals("")
                || txtdat_ce.getText().equals("")|| txtdatéch_ce.getText().equals("")|| txtmont_ce.getText().equals("")
                  || txtbank_ce.getText().equals("")) 
                {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
                  String[] colon = {"date","id", "mat_fiscale", "RIB", "cheque_daté","date_échéance","montant","bank"};
              String[] inf = {txtdate.getText(),txtid_ce.getText(), txtmatf_ce.getText(), txtRIB_ce.getText(), txtdat_ce.getText(),
                  txtdatéch_ce.getText()
                    ,txtmont_ce.getText(),txtbank_ce.getText() };
            String id = String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("chéques_sortants", colon, inf, "id='" + id + "'"));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualiser();
        table();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = String.valueOf(table_ce.getValueAt(table_ce.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("chéques_sortants", "id=" + id);
        } else {
            return;
        }
        table();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherActionPerformed
        if (txtrech_ce.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
            if (comrech_ce.getSelectedItem().equals("date")) {
                rs = db.querySelectAll("chéques_sortants", "date LIKE '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ce.getSelectedItem().equals("mat_fiscale")) {
                rs = db.querySelectAll("chéques_sortants", "mat_fiscale '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));} 
            else if (comrech_ce.getSelectedItem().equals("RIB")) {
                rs = db.querySelectAll("chéques_sortants", "RIB LIKE '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ce.getSelectedItem().equals("date d'échéance")) {
                rs = db.querySelectAll("chéques_sortants", "date_échéance LIKE '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ce.getSelectedItem().equals("montant")) {
                rs = db.querySelectAll("chéques_sortants", "montant LIKE '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ce.getSelectedItem().equals("bank")) {
                rs = db.querySelectAll("chéques_sortants", "bank LIKE '%" + txtrech_ce.getText() + "%' ");
                table_ce.setModel(new ResultSetTableModel(rs));
            }
        }
    }//GEN-LAST:event_chercherActionPerformed

    private void txtrech_ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_ceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_ceActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        facturation f = new facturation();
        f.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtdat_ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdat_ceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdat_ceActionPerformed

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
            java.util.logging.Logger.getLogger(BS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chéques_sortants().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chercher;
    private javax.swing.JComboBox comrech_ce;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_ce;
    private javax.swing.JTextField txtRIB_ce;
    private javax.swing.JTextField txtbank_ce;
    private javax.swing.JTextField txtdat_ce;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtdatéch_ce;
    private javax.swing.JTextField txtid_ce;
    private javax.swing.JTextField txtmatf_ce;
    private javax.swing.JTextField txtmont_ce;
    private javax.swing.JTextField txtrech_ce;
    // End of variables declaration//GEN-END:variables
}
