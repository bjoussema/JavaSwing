
package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class BS extends javax.swing.JFrame {
    ResultSet rs;
    db_connection db;
    
    public BS() {
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
        String a[] = {"date","mat_camion", "cin_employe", "nom","tel","fax","adresse"};
        rs = db.querySelect(a, "bs");
        table_bs.setModel(new ResultSetTableModel(rs));
    }
     void actualiser() {
        txtdate.setEditable(true);
         date();
        txtmat_camion_bs.setText("");
        txtcin_bs.setText("");
        txtnom_bs.setText("");
        txttel_bs.setText("");
        txtfax_bs.setText("");
        txtadresse_bs.setText("");
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_bs = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        comrech_bs = new javax.swing.JComboBox();
        txtrech_bs = new javax.swing.JTextField();
        chercher = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmat_camion_bs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcin_bs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnom_bs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttel_bs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfax_bs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtadresse_bs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        table_bs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "mat_camion", "cin_employe", "nom", "tel", "fax", "adresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_bs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_bs);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(250, 270, 1090, 440);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, -30, 1390, 210);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BANDE DE SORTIE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(233, 235, 230));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel9.setLayout(null);

        comrech_bs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "mat_camion", "cin_employe", "nom", "tel", "fax", "adresse" }));
        jPanel9.add(comrech_bs);
        comrech_bs.setBounds(40, 40, 110, 30);

        txtrech_bs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_bsActionPerformed(evt);
            }
        });
        jPanel9.add(txtrech_bs);
        txtrech_bs.setBounds(40, 80, 110, 30);

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
        jPanel9.add(chercher);
        chercher.setBounds(10, 130, 170, 40);

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

        jPanel8.add(jPanel9);
        jPanel9.setBounds(20, 240, 190, 230);

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
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
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

        jPanel7.setBackground(new java.awt.Color(233, 235, 230));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel7.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Date :");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(70, 20, 50, 34);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel7.add(txtdate);
        txtdate.setBounds(120, 20, 110, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Matricule camion :");
        jPanel7.add(jLabel3);
        jLabel3.setBounds(240, 20, 150, 34);
        jPanel7.add(txtmat_camion_bs);
        txtmat_camion_bs.setBounds(370, 20, 110, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("CIN :");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(540, 20, 60, 34);
        jPanel7.add(txtcin_bs);
        txtcin_bs.setBounds(590, 20, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Nom :");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(800, 20, 98, 34);
        jPanel7.add(txtnom_bs);
        txtnom_bs.setBounds(850, 20, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Tél :");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(170, 60, 98, 34);
        jPanel7.add(txttel_bs);
        txttel_bs.setBounds(210, 60, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Fax :");
        jPanel7.add(jLabel4);
        jLabel4.setBounds(470, 60, 50, 34);
        jPanel7.add(txtfax_bs);
        txtfax_bs.setBounds(510, 60, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Adresse :");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(690, 60, 80, 34);
        jPanel7.add(txtadresse_bs);
        txtadresse_bs.setBounds(760, 60, 110, 30);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(250, 160, 1090, 110);

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

    private void txtrech_bsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_bsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_bsActionPerformed

    private void chercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherActionPerformed
if (txtrech_bs.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
            if (comrech_bs.getSelectedItem().equals("date")) {
                rs = db.querySelectAll("bs", "date LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("mat_camion")) {
                rs = db.querySelectAll("bs", "mat_camion LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("cin_employe")) {
                rs = db.querySelectAll("bs", "cin_employe LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("nom")) {
                rs = db.querySelectAll("bs", "nom LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("tel")) {
                rs = db.querySelectAll("bs", "tel LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("fax")) {
                rs = db.querySelectAll("bs", "fax LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } else if (comrech_bs.getSelectedItem().equals("adresse")) {
                rs = db.querySelectAll("bs", "adresse LIKE '%" + txtrech_bs.getText() + "%' ");
                table_bs.setModel(new ResultSetTableModel(rs));
            } 
        }

    }//GEN-LAST:event_chercherActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("bs", "mat_camion=" + id);
        } else {
            return;
        }
        table();       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualiser();
        table();        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
            if (txtdate.getText().equals("") ||txtmat_camion_bs.getText().equals("") || txtcin_bs.getText().equals("")
            || txtnom_bs.getText().equals("")|| txttel_bs.getText().equals("") || txtfax_bs.getText().equals("")
            || txtadresse_bs.getText().equals("")) 
                {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","mat_camion","cin_employe","nom", "tel","fax","adresse"};
            String[] inf = {txtdate.getText(),txtmat_camion_bs.getText(),txtcin_bs.getText(), txtnom_bs.getText(),txttel_bs.getText() ,
            txtfax_bs.getText() ,txtadresse_bs.getText() };
            String id = String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("bs", colon, inf, "mat_camion='" + id + "'"));
            table();
            actualiser();
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //ajouter
        if (txtdate.getText().equals("") ||txtmat_camion_bs.getText().equals("") || txtcin_bs.getText().equals("")
            || txtnom_bs.getText().equals("")|| txttel_bs.getText().equals("") || txtfax_bs.getText().equals("")
            || txtadresse_bs.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","mat_camion","cin_employe","nom", "tel","fax","adresse"};
            String[] inf = {txtdate.getText(),txtmat_camion_bs.getText(),txtcin_bs.getText(), txtnom_bs.getText(),txttel_bs.getText() ,
            txtfax_bs.getText() ,txtadresse_bs.getText() };
            System.out.println(db.queryInsert("bs", colon, inf));
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table_bsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bsMouseClicked
        txtdate.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 0)));
        txtmat_camion_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 1)));
        txtcin_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 2)));
        txtnom_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 3)));
        txttel_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 4)));
        txtfax_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 5)));
        txtadresse_bs.setText(String.valueOf(table_bs.getValueAt(table_bs.getSelectedRow(), 6)));
    }//GEN-LAST:event_table_bsMouseClicked
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
                new BS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chercher;
    private javax.swing.JComboBox comrech_bs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_bs;
    private javax.swing.JTextField txtadresse_bs;
    private javax.swing.JTextField txtcin_bs;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtfax_bs;
    private javax.swing.JTextField txtmat_camion_bs;
    private javax.swing.JTextField txtnom_bs;
    private javax.swing.JTextField txtrech_bs;
    private javax.swing.JTextField txttel_bs;
    // End of variables declaration//GEN-END:variables
}
