
package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

import org.joda.time.*;
import org.joda.time.format.*;


public class echeance extends javax.swing.JFrame {
    ResultSet rs;
    db_connection db;
    public echeance() throws SQLException {
        db = new db_connection(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
        somme();
        //test(rs);
        Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int) tk.getScreenSize().getWidth();
            int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        txtdate_ec.setEditable(true);
        setVisible(true);
        check();
    }
    
    public void somme(){
        double total = 0;
         try {
                    for(int i=0;i<tbl_ec.getRowCount();i++)
                    { 
                         //JOptionPane.showMessageDialog(this, tbl_ec.getValueAt(i,6));

                        if(tbl_ec.getValueAt(i,6).toString().toLowerCase().equals("non")) {   
                            total += Double.parseDouble(tbl_ec.getValueAt(i,5).toString());
                        } else {
                            total +=0;
                        }
                    }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.toString());
        }
 
    txttotal_ec.setText(String.valueOf(total));
    }
    
  
    public void table() {
        String t[] = {"date","num_facture","num_chéque","fournisseur","echéance","montant","reglée"};
        rs = db.querySelect(t, "echeance");
        tbl_ec.setModel(new ResultSetTableModel(rs));
    }
    
    public void check() {
        DateTime now = new DateTime();
        StringBuilder nums = new StringBuilder("Un jour pour l'échéance des chèques suivants :\n");
        int count = 0;
        for (int i = 0; i < tbl_ec.getRowCount(); i++) {
            String cell = tbl_ec.getModel().getValueAt(i, 4).toString();
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
            DateTime current = formatter.parseDateTime(cell);
            if (now.getDayOfYear() - current.getDayOfYear() == -1) {
                String cheq = tbl_ec.getModel().getValueAt(i, 2).toString() + " ";
                String four = tbl_ec.getModel().getValueAt(i, 3).toString() + " ";
                nums.append("* ").append(four).append(cheq).append(cell).append("\n");
                count++;
            }
        }
        if (count > 0)
            JOptionPane.showMessageDialog(null, nums.toString(), "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    void actualiser() {
        txtdate.setEditable(true);
         date();
        txtnumf_ec.setText("");
        txtnumc_ec.setText("");
        txtfour_ec.setText("");
        txtmo_ec.setText("");
        txtdate_ec.setText("");
        combo.setSelectedItem("reglée");
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ec = new javax.swing.JTable() {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){

                Component c = super.prepareRenderer(renderer, rowIndex, columnIndex);
                try{
                    String value = getModel().getValueAt(rowIndex,6).toString();
                    String Cellule;

                    if(value.equalsIgnoreCase("Non"))
                    {

                        Cellule=getModel().getValueAt(rowIndex,4).toString();
                        //date systeme:
                        DateTime s = new DateTime();
                        // changer la forme de s
                        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
                        DateTime date = formatter.parseDateTime(Cellule);
                        if (date.getDayOfYear() - s.getDayOfYear() == 1) {
                            c.setBackground(Color.cyan);
                        } else if(s.isBefore(date.getMillis()))
                        { c.setBackground(Color.yellow);
                            //System.out.println("orange");
                        }
                        else
                        {c.setBackground(Color.red);
                            //System.out.println("red")
                        }
                    }
                    else
                    {
                        c.setBackground(Color.green);
                        //System.out.println("vert");
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return c;

            }

        };
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtrech_ec = new javax.swing.JTextField();
        comrech_ec = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnumf_ec = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmo_ec = new javax.swing.JTextField();
        txtfour_ec = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdate_ec = new javax.swing.JFormattedTextField();
        txtnumc_ec = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();
        combo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttotal_ec = new javax.swing.JTextField();

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl_ec.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_ec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "num_facture", "num_chéque", "fournisseur", "echéance", "montant", "reglée"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_ec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ec);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 270, 1090, 390);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Echeance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
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

        txtrech_ec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_ecActionPerformed(evt);
            }
        });
        jPanel9.add(txtrech_ec);
        txtrech_ec.setBounds(40, 70, 110, 30);

        comrech_ec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "num_facture", "num_chéque", "fournisseur", "echéance", "montant", "reglée" }));
        jPanel9.add(comrech_ec);
        comrech_ec.setBounds(40, 30, 110, 30);

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
        jLabel2.setText("Num facture");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(280, 20, 98, 34);
        jPanel3.add(txtnumf_ec);
        txtnumf_ec.setBounds(380, 20, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Echéance : ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(170, 60, 98, 34);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Montant : ");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(430, 60, 98, 34);

        txtmo_ec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmo_ecActionPerformed(evt);
            }
        });
        jPanel3.add(txtmo_ec);
        txtmo_ec.setBounds(510, 60, 110, 30);
        jPanel3.add(txtfour_ec);
        txtfour_ec.setBounds(830, 20, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Fournisseur : ");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(740, 20, 98, 34);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Date :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(80, 30, 60, 19);

        try {
            txtdate_ec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtdate_ec);
        txtdate_ec.setBounds(260, 60, 110, 30);
        jPanel3.add(txtnumc_ec);
        txtnumc_ec.setBounds(600, 20, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Num chéque : ");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(500, 20, 98, 34);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtdate);
        txtdate.setBounds(140, 20, 110, 30);

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "Oui", "Non" }));
        jPanel3.add(combo);
        combo.setBounds(740, 60, 110, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Reglée : ");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(670, 60, 98, 34);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 160, 1090, 110);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -30, 1390, 210);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Montant total : ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(890, 670, 130, 34);

        txttotal_ec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttotal_ecMouseClicked(evt);
            }
        });
        txttotal_ec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotal_ecActionPerformed(evt);
            }
        });
        getContentPane().add(txttotal_ec);
        txttotal_ec.setBounds(1030, 670, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Quitter
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
        //check();
        JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //ajouter
                if (txtdate.getText().equals("") || txtnumf_ec.getText().equals("") || txtnumc_ec.getText().equals("")
                || txtfour_ec.getText().equals("")|| txtdate_ec.getText().equals("")|| txtmo_ec.getText().equals("")
                        || combo.getSelectedItem().equals("reglée")) {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","num_facture","num_chéque","fournisseur","echéance","montant","reglée"};
            String[] inf = {txtdate.getText(),txtnumf_ec.getText(),txtnumc_ec.getText(),  txtfour_ec.getText(), txtdate_ec.getText(),txtmo_ec.getText()
                    ,combo.getSelectedItem().toString() };
            System.out.println(db.queryInsert("echeance", colon, inf));
            table();
            actualiser();
            //System.out.println(combo.getSelectedItem());
            if (combo.getSelectedItem().toString().equalsIgnoreCase("Non") )
                {
                    somme();
                    /*Double s=Double.parseDouble( txttotal_ec.getText()) + Double.parseDouble(txtmo_ec.getText());
                    txttotal_ec.setText(s.toString());*/
                }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // modifier
                if (txtdate.getText().equals("") || txtnumf_ec.getText().equals("") || txtnumc_ec.getText().equals("")
                || txtfour_ec.getText().equals("")|| txtdate_ec.getText().equals("")|| txtmo_ec.getText().equals("")
                ||combo.getSelectedItem().equals("reglée")) 
                {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
                  String[] colon = {"date","num_facture","num_chéque","fournisseur","echéance","montant","reglée"};
              String[] inf = {txtdate.getText(),txtnumf_ec.getText(),txtnumc_ec.getText(),  txtfour_ec.getText(), txtdate_ec.getText(),txtmo_ec.getText()
                    ,combo.getSelectedItem().toString()};
            String id = String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 2));
            System.out.println(db.queryUpdate("echeance", colon, inf, "num_chéque='" + id + "'"));
            table();
            actualiser();
             if (combo.getSelectedItem().toString().equalsIgnoreCase("Non") )
                {
                    somme();
                    /*Double s=Double.parseDouble( txttotal_ec.getText()) + Double.parseDouble(txtmo_ec.getText());
                    txttotal_ec.setText(s.toString());*/
                }
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
  actualiser();
        table();   
        if (combo.getSelectedItem().toString().equalsIgnoreCase("Non") )
                {
                    somme();
                    /*Double s=Double.parseDouble( txttotal_ec.getText()) + Double.parseDouble(txtmo_ec.getText());
                    txttotal_ec.setText(s.toString());*/
                }// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if (txtrech_ec.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        } else {
            if (comrech_ec.getSelectedItem().equals("date")) {
                rs = db.querySelectAll("echeance", "date LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ec.getSelectedItem().equals("num_facture")) {
                rs = db.querySelectAll("echeance", "num_facture LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ec.getSelectedItem().equals("num_chéque")) {
                rs = db.querySelectAll("echeance", "num_chéque LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
               } else if (comrech_ec.getSelectedItem().equals("fournisseur")) {
                rs = db.querySelectAll("echeance", "fournisseur LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
                } else if (comrech_ec.getSelectedItem().equals("echéance")) {
                rs = db.querySelectAll("echeance", "echéance LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
                } else if (comrech_ec.getSelectedItem().equals("montant")) {
                rs = db.querySelectAll("echeance", "montant LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));
            } else if (comrech_ec.getSelectedItem().equals("reglée")) {
                rs = db.querySelectAll("echeance", "reglée LIKE '%" + txtrech_ec.getText() + "%' ");
                tbl_ec.setModel(new ResultSetTableModel(rs));

            } }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrech_ecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_ecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_ecActionPerformed

    private void tbl_ecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ecMouseClicked
        txtdate.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 0)));
        txtnumf_ec.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 1)));
        txtnumc_ec.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 2)));
        txtfour_ec.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 3)));
        txtdate_ec.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 4))); 
        txtmo_ec.setText(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 5)));
        combo.setSelectedItem(String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 6)));
       
// TODO add your handling code here:
    }//GEN-LAST:event_tbl_ecMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id = String.valueOf(tbl_ec.getValueAt(tbl_ec.getSelectedRow(), 2));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("echeance", "num_chéque=" + id);
        } else {
            return;
        }
        table(); 
        if (combo.getSelectedItem().toString().equalsIgnoreCase("Non") )
                {
                    somme();
                    /*Double s=Double.parseDouble( txttotal_ec.getText()) + Double.parseDouble(txtmo_ec.getText());
                    txttotal_ec.setText(s.toString());*/
                }// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttotal_ecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotal_ecActionPerformed
        // TODO add your handling code here:
    //   
    }//GEN-LAST:event_txttotal_ecActionPerformed

    private void txtmo_ecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmo_ecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmo_ecActionPerformed

    private void txttotal_ecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttotal_ecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotal_ecMouseClicked

    public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
                try {
                    new echeance();
                } catch (SQLException ex) {
                    Logger.getLogger(echeance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo;
    private javax.swing.JComboBox comrech_ec;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ec;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JFormattedTextField txtdate_ec;
    private javax.swing.JTextField txtfour_ec;
    private javax.swing.JTextField txtmo_ec;
    private javax.swing.JTextField txtnumc_ec;
    private javax.swing.JTextField txtnumf_ec;
    private javax.swing.JTextField txtrech_ec;
    private javax.swing.JTextField txttotal_ec;
    // End of variables declaration//GEN-END:variables
/*
    private Object getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private LocalDateTime LocalDateTime(Instant plusSeconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private LocalDate LocalDate(Instant plusSeconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
