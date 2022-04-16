
package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Client extends javax.swing.JFrame {
    ResultSet rs;
    db_connection db;
    
    public Client() {
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
        String t[] = {"date","mat_fiscal","nom","tel","fax","mail","adresse"};
        rs = db.querySelect(t, "client");
        tbl_cl.setModel(new ResultSetTableModel(rs));
    }
    
    void actualiser() {
        txtdate.setEditable(true);
         date();
        txtmat_fiscal_cl.setText("");
        txtnom_cl.setText("");
        txttel_cl.setText("");
        txtmail_cl.setText("");
        txtfax_cl.setText("");
        txtadresse_cl.setText("");
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cl = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtrech_cl = new javax.swing.JTextField();
        comrech_cl = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmat_fiscal_cl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfax_cl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnom_cl = new javax.swing.JTextField();
        txtmail_cl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtadresse_cl = new javax.swing.JTextField();
        txttel_cl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl_cl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_cl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "mat_fiscal", "nom", "tel", "fax", "maill", "adresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 270, 1090, 400);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, -30, 1390, 210);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CLIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(233, 235, 230));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel9.setLayout(null);

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
        jPanel9.add(jButton7);
        jButton7.setBounds(10, 170, 170, 40);

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
        jPanel9.add(jButton3);
        jButton3.setBounds(10, 130, 170, 40);

        txtrech_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_clActionPerformed(evt);
            }
        });
        jPanel9.add(txtrech_cl);
        txtrech_cl.setBounds(40, 70, 110, 30);

        comrech_cl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "mat_fiscal", "nom", "tel", "fax", "mail", "adresse" }));
        jPanel9.add(comrech_cl);
        comrech_cl.setBounds(40, 30, 110, 30);

        jPanel8.add(jPanel9);
        jPanel9.setBounds(20, 240, 190, 230);

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
        jPanel8.add(jButton1);
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
        jPanel8.add(jButton6);
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
        jPanel8.add(jButton2);
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
        jPanel8.add(jButton4);
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
        jPanel8.add(jButton5);
        jButton5.setBounds(30, 150, 170, 40);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(10, 150, 240, 490);

        jPanel3.setBackground(new java.awt.Color(233, 235, 230));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Matricule :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(290, 20, 98, 34);
        jPanel3.add(txtmat_fiscal_cl);
        txtmat_fiscal_cl.setBounds(380, 20, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Fax :");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(210, 60, 98, 34);
        jPanel3.add(txtfax_cl);
        txtfax_cl.setBounds(250, 60, 110, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Mail :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(460, 60, 98, 34);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Nom :");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(550, 20, 98, 34);
        jPanel3.add(txtnom_cl);
        txtnom_cl.setBounds(600, 20, 110, 30);
        jPanel3.add(txtmail_cl);
        txtmail_cl.setBounds(510, 60, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Adresse :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(670, 60, 98, 34);
        jPanel3.add(txtadresse_cl);
        txtadresse_cl.setBounds(740, 60, 110, 30);
        jPanel3.add(txttel_cl);
        txttel_cl.setBounds(800, 20, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Tél :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(760, 20, 98, 34);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Date :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(80, 30, 60, 19);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtdate);
        txtdate.setBounds(140, 20, 110, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 160, 1090, 110);

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
                if (txtdate.getText().equals("") || txtmat_fiscal_cl.getText().equals("") || txtnom_cl.getText().equals("")
                || txttel_cl.getText().equals("")|| txtfax_cl.getText().equals("")|| txtmail_cl.getText().equals("")
                        || txtadresse_cl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","mat_fiscal","nom", "tel","fax","mail","adresse"};
            String[] inf = {txtdate.getText(),txtmat_fiscal_cl.getText(),txtnom_cl.getText(),  txttel_cl.getText(), txtfax_cl.getText(),txtmail_cl.getText()
                    ,txtadresse_cl.getText() };
            System.out.println(db.queryInsert("client", colon, inf));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
                if (txtdate.getText().equals("") ||txtmat_fiscal_cl.getText().equals("") || txtnom_cl.getText().equals("") || txttel_cl.getText().equals("")
                || txtfax_cl.getText().equals("")|| txtmail_cl.getText().equals("")|| txtadresse_cl.getText().equals("")) 
                {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
                  String[] colon = {"date","mat_fiscal","nom", "tel","fax","mail","adresse"};
              String[] inf = {txtdate.getText(),txtmat_fiscal_cl.getText(), txtnom_cl.getText(), txttel_cl.getText(), txtfax_cl.getText(),txtmail_cl.getText()
                    ,txtadresse_cl.getText() };
            String id = String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("client", colon, inf, "mat_fiscal='" + id + "'"));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
  actualiser();
        table();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if (txtrech_cl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
            if (comrech_cl.getSelectedItem().equals("date")) {
                rs = db.querySelectAll("client", "date LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_cl.getSelectedItem().equals("mat_fiscal")) {
                rs = db.querySelectAll("client", "mat_fiscal LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_cl.getSelectedItem().equals("nom")) {
                rs = db.querySelectAll("client", "nom LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
               } else if (comrech_cl.getSelectedItem().equals("tel")) {
                rs = db.querySelectAll("client", "tel LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
                } else if (comrech_cl.getSelectedItem().equals("fax")) {
                rs = db.querySelectAll("client", "fax LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
                } else if (comrech_cl.getSelectedItem().equals("mail")) {
                rs = db.querySelectAll("client", "mail LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));
            } else if (comrech_cl.getSelectedItem().equals("adresse")) {
                rs = db.querySelectAll("client", "adresse LIKE '%" + txtrech_cl.getText() + "%' ");
                tbl_cl.setModel(new ResultSetTableModel(rs));

            } }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrech_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_clActionPerformed

    private void tbl_clMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clMouseClicked
        txtdate.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 0)));
        txtmat_fiscal_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 1)));
        txtnom_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 2)));
        txttel_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 3)));
        txtfax_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 4))); 
        txtmail_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 5)));
        txtadresse_cl.setText(String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 6)));
 
// TODO add your handling code here:
    }//GEN-LAST:event_tbl_clMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  String id = String.valueOf(tbl_cl.getValueAt(tbl_cl.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("client", "mat_fiscal=" + id);
        } else {
            return;
        }
        table();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
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
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comrech_cl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cl;
    private javax.swing.JTextField txtadresse_cl;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtfax_cl;
    private javax.swing.JTextField txtmail_cl;
    private javax.swing.JTextField txtmat_fiscal_cl;
    private javax.swing.JTextField txtnom_cl;
    private javax.swing.JTextField txtrech_cl;
    private javax.swing.JTextField txttel_cl;
    // End of variables declaration//GEN-END:variables
}
