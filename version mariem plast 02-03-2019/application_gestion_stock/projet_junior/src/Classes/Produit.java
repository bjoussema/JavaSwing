package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Produit extends javax.swing.JFrame {

    ResultSet rs;
    db_connection db;

    public Produit() {
        db = new db_connection(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        txtdate.setEditable(true);
        date();
        tablePrint();
    }

    public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
    }

    public void table() {
        String t[] = {"date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock"};
        rs = db.querySelect(t, "produit");
        tbl_pr.setModel(new ResultSetTableModel(rs));
    }

    void actualiser() {
        txtdate.setEditable(true);
        date();
        txtid_pr.setText("");
        txtlib_pr.setText("");
        txtpr_pr.setText("");
        txtfou_pr.setText("");
        txtcar_pr.setText("");
        txtst_pr.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pr = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        comrech_pr = new javax.swing.JComboBox();
        txtrech_pr = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcar_pr = new javax.swing.JTextField();
        txtid_pr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfou_pr = new javax.swing.JTextField();
        txtlib_pr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtst_pr = new javax.swing.JTextField();
        txtpr_pr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl_pr.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_pr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 250, 1090, 430);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, -30, 1390, 210);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PRODUIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(233, 235, 230));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel9.setLayout(null);

        comrech_pr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock" }));
        comrech_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comrech_prActionPerformed(evt);
            }
        });
        jPanel9.add(comrech_pr);
        comrech_pr.setBounds(30, 30, 110, 30);

        txtrech_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_prActionPerformed(evt);
            }
        });
        jPanel9.add(txtrech_pr);
        txtrech_pr.setBounds(30, 70, 110, 30);

        jButton7.setBackground(new java.awt.Color(2, 28, 67));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Actualiser");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton7);
        jButton7.setBounds(10, 150, 170, 40);

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
        jButton3.setBounds(10, 110, 170, 40);

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

        getContentPane().add(jPanel8);
        jPanel8.setBounds(10, 150, 240, 490);

        jPanel3.setBackground(new java.awt.Color(233, 235, 230));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Id :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(340, 20, 40, 34);
        jPanel3.add(txtcar_pr);
        txtcar_pr.setBounds(300, 60, 110, 30);
        jPanel3.add(txtid_pr);
        txtid_pr.setBounds(370, 20, 110, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Libellé :");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(550, 20, 98, 34);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Fournisseur :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(450, 60, 120, 34);
        jPanel3.add(txtfou_pr);
        txtfou_pr.setBounds(550, 60, 110, 30);
        jPanel3.add(txtlib_pr);
        txtlib_pr.setBounds(610, 20, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Caractéristique :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(180, 60, 130, 34);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Stock :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(700, 60, 98, 34);
        jPanel3.add(txtst_pr);
        txtst_pr.setBounds(750, 60, 110, 30);
        jPanel3.add(txtpr_pr);
        txtpr_pr.setBounds(810, 20, 110, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Date :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(110, 30, 60, 19);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtdate);
        txtdate.setBounds(160, 20, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Prix :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(770, 20, 98, 34);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 150, 1090, 100);

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton8.setText("Imprimer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(1160, 680, 180, 50);

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
        if (txtdate.getText().equals("") || txtid_pr.getText().equals("") || txtlib_pr.getText().equals("")
                || txtpr_pr.getText().equals("") || txtcar_pr.getText().equals("") || txtfou_pr.getText().equals("")
                || txtst_pr.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock"};
            String[] inf = {txtdate.getText(), txtid_pr.getText(), txtlib_pr.getText(), txtpr_pr.getText(), txtcar_pr.getText(), txtfou_pr.getText(), txtst_pr.getText()};
            System.out.println(db.queryInsert("produit", colon, inf));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
        if (txtdate.getText().equals("") || txtid_pr.getText().equals("") || txtlib_pr.getText().equals("") || txtpr_pr.getText().equals("")
                || txtcar_pr.getText().equals("") || txtfou_pr.getText().equals("") || txtst_pr.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock"};
            String[] inf = {txtdate.getText(), txtid_pr.getText(), txtlib_pr.getText(), txtpr_pr.getText(), txtcar_pr.getText(), txtfou_pr.getText(), txtst_pr.getText()};
            String id = String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("produit", colon, inf, "id_pr='" + id + "'"));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualiser();
        table();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtrech_pr.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else if (comrech_pr.getSelectedItem().equals("date")) {
            rs = db.querySelectAll("produit", "date LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("id_pr")) {
            rs = db.querySelectAll("produit", "id_pr LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("libellé")) {
            rs = db.querySelectAll("produit", "libellé LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("prix")) {
            rs = db.querySelectAll("produit", "prix LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("caractéristique")) {
            rs = db.querySelectAll("produit", "caractéristique LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("fournisseur")) {
            rs = db.querySelectAll("produit", "fournisseur LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));
        } else if (comrech_pr.getSelectedItem().equals("stock")) {
            rs = db.querySelectAll("produit", "stock LIKE '%" + txtrech_pr.getText() + "%' ");
            tbl_pr.setModel(new ResultSetTableModel(rs));

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrech_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_prActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_prActionPerformed

    private void tbl_prMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prMouseClicked
        txtdate.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 0)));
        txtid_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 1)));
        txtlib_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 2)));
        txtpr_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 3)));
        txtcar_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 4)));
        txtfou_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 5)));
        txtst_pr.setText(String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 6)));

// TODO add your handling code here:
    }//GEN-LAST:event_tbl_prMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = String.valueOf(tbl_pr.getValueAt(tbl_pr.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("produit", "id_pr=" + id);
        } else {
            return;
        }
        table();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comrech_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comrech_prActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comrech_prActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {

            DefaultTableModel tableModel = (DefaultTableModel) tbl_pr.getModel();
            HashMap<String, Object> para = new HashMap<>();
            para.put("title", "");

            JasperPrint jasperPrint = null;
            JasperCompileManager.compileReportToFile("D:\\JavaSwing\\version mariem plast 02-03-2019\\application_gestion_stock\\projet_junior\\src\\Classes\\printProduit.jrxml");
            jasperPrint = JasperFillManager.fillReport("D:\\JavaSwing\\version mariem plast 02-03-2019\\application_gestion_stock\\projet_junior\\src\\Classes\\printProduit.jasper", para, new JRTableModelDataSource(tableModel));
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Echec de l'operation !!");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tablePrint() {
        try {
            String t[] = {"date", "id_pr", "libellé", "prix", "caractéristique", "fournisseur", "stock"};
            rs = db.querySelect(t, "produit");
            tbl_pr.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Echec de l'operation !!");
        }
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
                new Produit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comrech_pr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_pr;
    private javax.swing.JTextField txtcar_pr;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtfou_pr;
    private javax.swing.JTextField txtid_pr;
    private javax.swing.JTextField txtlib_pr;
    private javax.swing.JTextField txtpr_pr;
    private javax.swing.JTextField txtrech_pr;
    private javax.swing.JTextField txtst_pr;
    // End of variables declaration//GEN-END:variables
}
