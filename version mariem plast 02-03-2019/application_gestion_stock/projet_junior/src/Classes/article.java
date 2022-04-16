
package Classes;

import BDD.Parameter;
import BDD.ResultSetTableModel;
import BDD.db_connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class article extends javax.swing.JFrame {
    ResultSet rs;
    db_connection db;
    int old, dec,dec1, nv;

    public article() {
        db = new db_connection(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        /***** Modif ******/
        //table();  // nouvelle
        initComponents();
        table();  // avant
        //tbl_ar.setModel(md); // nouvelle
        
        Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int) tk.getScreenSize().getWidth();
            int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        txtdate.setEditable(true);
        date();   
        
        JTableHeader Theader = tbl_ar.getTableHeader();
        Theader.setBackground(Color.RED); // change the Background color
        Theader.setForeground(Color.BLACK); // change the Foreground
        
        Theader.setFont(new Font("Times New Roman", Font.BOLD, 18)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        
    }
     public void table() {
        String colon[] = {"date","id","nom_produit","libellé", "quantité_p","prix_p","valeur_p","quantité_v","prix_v","valeur_v","stock_total"};
        rs = db.querySelect(colon, "article");
        //md = new ResultSetTableModel(rs); // nouvelle
        tbl_ar.setModel(new ResultSetTableModel(rs));  //avant
    }
     
    
     public void date() {
        Date s = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(d.format(s));
    }
     void actualiser() {
        txtdate.setEditable(true);
        date();
        txtid_ar.setText("");
        txtnomp_ar.setText("");
        combolib_ar.setSelectedItem("libellé");
        txtqte_entrees.setText("");
        txtprix_entrees.setText("");
        txtval_entrees.setText("");
        txtqte_sorties.setText("");
        txtval_sorties.setText("");
        txtprix_sorties.setText("");
        txttotalqe_ar.setText("");
        txttotalpe_ar.setText("");
        txttotalve_ar.setText("");
        txttotalqs_ar.setText("");
        txttotalps_ar.setText("");
        txttotalvs_ar.setText("");
        txtvalfinal.setText("");
        txtstock.setText("");
     }
     
      public void cout_p() {
        double qe = Double.parseDouble(txtqte_entrees.getText());
        double pe = Double.parseDouble(txtprix_entrees.getText());
        double ve = qe * pe;
        txtval_entrees.setText(String.valueOf(ve));
    }
     
     public void cout_v() {
        double qs = Double.parseDouble(txtqte_sorties.getText());
        double ps = Double.parseDouble(txtprix_sorties.getText());
        double vs = qs * ps;
        txtval_sorties.setText(String.valueOf(vs));
    }
     
     public void sommeTot(){
        double t=0,t1=0.018,t2=0,t3=0,t4=0.018,t5=0,total=0;
        int x=tbl_ar.getRowCount();
         try {
                    for(int i=0;i<x;i++)
                    {   
                            t  +=Double.parseDouble(tbl_ar.getValueAt(i,4).toString()) ;
                            t2 += Double.parseDouble(tbl_ar.getValueAt(i,6).toString());
                            t3 += Double.parseDouble(tbl_ar.getValueAt(i,7).toString());
                            t5 += Double.parseDouble(tbl_ar.getValueAt(i,9).toString());
                        
                    }
                    
                            total=Double.parseDouble(tbl_ar.getValueAt(x-1,10).toString());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.toString());
        } 
                            txttotalqe_ar.setText(String.valueOf(t));
                            txttotalpe_ar.setText(String.valueOf(t1));
                            txttotalve_ar.setText(String.valueOf(t2));
                            txttotalqs_ar.setText(String.valueOf(t3));
                            txttotalps_ar.setText(String.valueOf(t4));
                            txttotalvs_ar.setText(String.valueOf(t5));
                            txtstock.setText(String.valueOf(total));
    }
    
     public void total() {
        double tve = Double.parseDouble(txttotalve_ar.getText());
        double tvs = Double.parseDouble(txttotalvs_ar.getText());
        double tot = tve - tvs;
        txtvalfinal.setText(String.valueOf(tot)); }
    
        public void essai() throws SQLException{
        rs = db.querySelectAll("article", "id='" + txtid_ar.getText() + "'");    
        for(int i=0;i<tbl_ar.getRowCount();i++)
                    { 
                        old = rs.getInt(tbl_ar.getValueAt(i,10).toString());
                        }
        
        /*while (rs.next()) {
            old = rs.getInt("stock_total");
        }*/
        dec1 = Integer.parseInt(txtqte_sorties.getText());
         nv = old - dec1;
            txtstock.setText(String.valueOf(Integer.toString(nv)));
    
    }
        
        public boolean test_stock() throws SQLException {
          boolean teststock;
          rs = db.querySelectAll("article","id='" + txtid_ar.getText() + "'");
            while (rs.next()) {
                old = rs.getInt("stock_total");
            }
          dec1 = Integer.parseInt(txtqte_sorties.getText());
            if (old < dec1 ) {
                teststock = false;
            } else {
            teststock = true;
            }
          return teststock;
        }
        
        public void stock() throws SQLException {
          rs = db.querySelectAll("article", "id='" + txtid_ar.getText() + "'");
            while (rs.next()) {
                old = rs.getInt("stock_total"); 
            }
          dec  = Integer.parseInt(txtqte_entrees.getText());
          dec1 = Integer.parseInt(txtqte_sorties.getText());
            String r=rs.getNString(2);
            if(combolib_ar.getSelectedItem().toString().equalsIgnoreCase("vente") && txtnomp_ar.getText().equals(r) ){
                nv = old - dec1;
                String nvstock = Integer.toString(nv);
                String a = String.valueOf(nvstock);
                String[] colon = {"stock_total"}; 
                String[] isi = {a};
                System.out.println(db.queryInsert("article", colon, isi));            
            } else if (combolib_ar.getSelectedItem().toString().equalsIgnoreCase("achat") 
                    && txtnomp_ar.getText().equals(r)) 
            {
                nv = old + dec;
                String nvstock = Integer.toString(nv);
                String a = String.valueOf(nvstock);
                String[] colon = {"stock_total"};
                String[] isi = {a};
                System.out.println(db.queryInsert("article", colon, isi));
            }        
        }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        comrech_ar = new javax.swing.JComboBox();
        txtrech_ar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new javax.swing.JFormattedTextField();
        txtid_ar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtqte_entrees = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtprix_sorties = new javax.swing.JTextField();
        txtqte_sorties = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combolib_ar = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtprix_entrees = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnomp_ar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtval_entrees = new javax.swing.JLabel();
        txtval_sorties = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ar = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){

                Component c = super.prepareRenderer(renderer, rowIndex, columnIndex);
                try
                {
                    if (tbl_ar.getValueAt(rowIndex, 3).toString().equalsIgnoreCase("vente"))
                    {
                        if (columnIndex>=4 && columnIndex<7)
                        {
                            // ne change pas le champ :
                            tbl_ar.setValueAt("0",rowIndex,columnIndex);
                            c.setBackground(Color.gray);
                        }
                        else
                        c.setBackground(Color.white);
                    }
                    else
                    {
                        if (columnIndex>=7 && columnIndex<10)
                        {tbl_ar.setValueAt("0",rowIndex,columnIndex);
                            c.setBackground(Color.gray);
                        }
                        else c.setBackground(Color.white);
                    }
                    /*for(int i=0;i<tbl_ar.getRowCount();i++)

                    if(combolib_ar.getSelectedItem().toString().equals("Vente"))
                    {

                        tbl_ar.setValueAt("",i,7);
                        //System.out.println(tbl_ar.setValueAt("",i,7)+"islem");
                        tbl_ar.setValueAt("",i,8);
                        tbl_ar.setValueAt("",i,9);
                        c.setBackground(Color.gray);
                    }*/

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return c;

            }

        };
        jLabel25 = new javax.swing.JLabel();
        txtvalfinal = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txttotalqe_ar = new javax.swing.JTextField();
        txttotalpe_ar = new javax.swing.JTextField();
        txttotalve_ar = new javax.swing.JTextField();
        txttotalqs_ar = new javax.swing.JTextField();
        txttotalps_ar = new javax.swing.JTextField();
        txttotalvs_ar = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(233, 235, 238));
        getContentPane().setLayout(null);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/couverture.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(140, 30, 1390, 210);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ARTICLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(233, 235, 230));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recherche par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel9.setLayout(null);

        comrech_ar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "date", "nom_produit" }));
        jPanel9.add(comrech_ar);
        comrech_ar.setBounds(40, 30, 110, 30);

        txtrech_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrech_arActionPerformed(evt);
            }
        });
        jPanel9.add(txtrech_ar);
        txtrech_ar.setBounds(40, 70, 110, 30);

        jButton1.setBackground(new java.awt.Color(2, 28, 67));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Rechercher.png"))); // NOI18N
        jButton1.setText("Recherche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1);
        jButton1.setBounds(10, 120, 170, 40);

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
        jButton7.setBounds(10, 160, 170, 40);

        jPanel8.add(jPanel9);
        jPanel9.setBounds(20, 240, 190, 230);

        jButton4.setBackground(new java.awt.Color(2, 28, 67));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Supprimer.png"))); // NOI18N
        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4);
        jButton4.setBounds(30, 150, 170, 40);

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

        jButton3.setBackground(new java.awt.Color(2, 28, 67));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Modifier.png"))); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);
        jButton3.setBounds(30, 110, 170, 40);

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

        jButton5.setBackground(new java.awt.Color(2, 28, 67));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Accueil.png"))); // NOI18N
        jButton5.setText("Accueil");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5);
        jButton5.setBounds(30, 30, 170, 40);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(150, 210, 240, 490);

        jPanel3.setBackground(new java.awt.Color(233, 235, 230));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CRUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Date :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(60, 30, 60, 20);

        try {
            txtdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtdate);
        txtdate.setBounds(120, 20, 110, 30);
        jPanel3.add(txtid_ar);
        txtid_ar.setBounds(330, 20, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Libellé :");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(750, 20, 69, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Quantité :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(260, 60, 100, 30);

        txtqte_entrees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqte_entreesActionPerformed(evt);
            }
        });
        jPanel3.add(txtqte_entrees);
        txtqte_entrees.setBounds(360, 60, 110, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Quantité :");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(260, 100, 120, 30);
        jPanel3.add(txtprix_sorties);
        txtprix_sorties.setBounds(590, 100, 110, 30);
        jPanel3.add(txtqte_sorties);
        txtqte_sorties.setBounds(360, 100, 110, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Valeur Totale :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(720, 60, 140, 30);

        combolib_ar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vente", "Achat" }));
        combolib_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combolib_arActionPerformed(evt);
            }
        });
        jPanel3.add(combolib_ar);
        combolib_ar.setBounds(820, 20, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Prix unitaire : ");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(480, 60, 130, 30);
        jPanel3.add(txtprix_entrees);
        txtprix_entrees.setBounds(590, 60, 110, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Prix unitaire :");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(480, 100, 140, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Valeur Totale :");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(720, 100, 140, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setText("Production ");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(50, 60, 110, 30);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel16.setText("Vente ");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(60, 100, 90, 30);

        txtnomp_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomp_arActionPerformed(evt);
            }
        });
        jPanel3.add(txtnomp_ar);
        txtnomp_ar.setBounds(590, 20, 110, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Id :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(300, 20, 31, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Produit :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(520, 20, 70, 30);

        txtval_entrees.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel3.add(txtval_entrees);
        txtval_entrees.setBounds(850, 60, 110, 30);

        txtval_sorties.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel3.add(txtval_sorties);
        txtval_sorties.setBounds(850, 100, 110, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(390, 210, 1090, 150);

        tbl_ar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_ar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "date", "id", "nom_produit", "libellé", "quantité_p", "prix_p", "valeur_p", "quantité_v", "prix_v", "valeur_v", "stock_total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ar.setToolTipText("");
        tbl_ar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_ar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_arMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_ar);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(390, 360, 1090, 340);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setText("Valeur du stock final en DT :");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(160, 710, 200, 30);

        txtvalfinal.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtvalfinal.setText(" ");
        getContentPane().add(txtvalfinal);
        txtvalfinal.setBounds(360, 710, 100, 30);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setText("TOTAL");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(590, 710, 60, 30);
        getContentPane().add(txttotalqe_ar);
        txttotalqe_ar.setBounds(780, 710, 100, 30);
        getContentPane().add(txttotalpe_ar);
        txttotalpe_ar.setBounds(880, 710, 100, 30);
        getContentPane().add(txttotalve_ar);
        txttotalve_ar.setBounds(980, 710, 100, 30);
        getContentPane().add(txttotalqs_ar);
        txttotalqs_ar.setBounds(1080, 710, 100, 30);
        getContentPane().add(txttotalps_ar);
        txttotalps_ar.setBounds(1180, 710, 100, 30);
        getContentPane().add(txttotalvs_ar);
        txttotalvs_ar.setBounds(1280, 710, 100, 30);
        getContentPane().add(txtstock);
        txtstock.setBounds(1380, 710, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

      Accueil a = new Accueil();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 1));
        if (JOptionPane.showConfirmDialog(this, "est ce que tu es sure que tu veux suuprimer", "attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("article", "id=" + id);
        } else {
            return;
        }
        table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if (combolib_ar.getSelectedItem().toString().equalsIgnoreCase("vente"))
      {
          // Le choix est vente
        if (txtdate.getText().equals("") || txtid_ar.getText().equals("") || txtnomp_ar.getText().equals("") || combolib_ar.getSelectedItem().equals("libellé")  
          ||txtqte_sorties.getText().equals("")|| txtprix_sorties.getText().equals("") ) 
        {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","id","nom_produit", "libellé", "quantité_p","prix_p","valeur_p","quantité_v","prix_v","valeur_v","stock_total"};
            cout_v();
            String[] inf = {txtdate.getText(),txtid_ar.getText(),txtnomp_ar.getText(), combolib_ar.getSelectedItem().toString(), 
            "0","0","0",txtqte_sorties.getText(),txtprix_sorties.getText(), txtval_sorties.getText(), txtstock.getText()};
            String id = String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("article", colon, inf, "id='" + id + "'"));
            /*try {
                if (!test_stock()) { 
                    JOptionPane.showMessageDialog(this, "le stock est Limiter");
                } else {
                    stock(); //true
                    table(); //true
                    actualiser();
                }
            } catch (SQLException ex) {
                Logger.getLogger(article.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("\n"+ex);
            }*/
        }
        
      } else 
        {
           if (txtdate.getText().equals("") || txtid_ar.getText().equals("") || txtnomp_ar.getText().equals("") || combolib_ar.getSelectedItem().equals("libellé") 
          || txtqte_entrees.getText().equals("") || txtprix_entrees.getText().equals("") ) 
        {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","id","nom_produit","libellé", "quantité_p","prix_p","valeur_p", "quantité_v","prix_v","valeur_v","stock_total"};
            cout_p();
            String[] inf = {txtdate.getText(),txtid_ar.getText(),txtnomp_ar.getText(), combolib_ar.getSelectedItem().toString(), txtqte_entrees.getText(), 
            txtprix_entrees.getText(), txtval_entrees.getText(),"0","0","0" , txtstock.getText()};
            String id = String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 1));
            System.out.println(db.queryUpdate("article", colon, inf, "id='" + id + "'"));
            table();
            actualiser();
        }
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if (combolib_ar.getSelectedItem().toString().equalsIgnoreCase("vente"))
      {
          // Le choix est vente
        if (txtdate.getText().equals("") || txtid_ar.getText().equals("") || txtnomp_ar.getText().equals("") || combolib_ar.getSelectedItem().equals("libellé")  
          ||txtqte_sorties.getText().equals("")|| txtprix_sorties.getText().equals("") ) 
        {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","id","nom_produit", "libellé", "quantité_p","prix_p","valeur_p","quantité_v","prix_v","valeur_v","stock_total"};
            cout_v();
            String[] inf = {txtdate.getText(),txtid_ar.getText(),txtnomp_ar.getText(), combolib_ar.getSelectedItem().toString(), 
            "0","0","0",txtqte_sorties.getText(),txtprix_sorties.getText(), txtval_sorties.getText(), txtstock.getText()};
            System.out.println(db.queryInsert("article", colon, inf));
            table();
            actualiser();
        }
      }
      else
      {
           if (txtdate.getText().equals("") || txtid_ar.getText().equals("") || txtnomp_ar.getText().equals("") || combolib_ar.getSelectedItem().equals("libellé") 
          || txtqte_entrees.getText().equals("") || txtprix_entrees.getText().equals("") ) 
        {
            JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
        } else {
            String[] colon = {"date","id","nom_produit","libellé", "quantité_p","prix_p","valeur_p", "quantité_v","prix_v","valeur_v","stock_total"};
            cout_p();
            String[] inf = {txtdate.getText(),txtid_ar.getText(),txtnomp_ar.getText(), combolib_ar.getSelectedItem().toString(), txtqte_entrees.getText(), 
            txtprix_entrees.getText(), txtval_entrees.getText(),"0","0","0" , txtstock.getText()};
            System.out.println(db.queryInsert("article", colon, inf));
            table();
            actualiser();
        }
      }

    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualiser();
        table();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtrech_ar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose");
        }else { if (comrech_ar.getSelectedItem().equals("date")) {
            rs = db.querySelectAll("article", "date LIKE '%" + txtrech_ar.getText() + "%' ");
            tbl_ar.setModel(new ResultSetTableModel(rs));
        } else if (comrech_ar.getSelectedItem().equals("nom_produit")) {
            rs = db.querySelectAll("article", "nom_produit LIKE '%" + txtrech_ar.getText() + "%' ");
            tbl_ar.setModel(new ResultSetTableModel(rs));
        } 
        sommeTot();
        total();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtrech_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrech_arActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrech_arActionPerformed

    private void tbl_arMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_arMouseClicked
        txtdate.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 0)));
        txtid_ar.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 1)));
        txtnomp_ar.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 2)));
        combolib_ar.setSelectedItem(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 3)));
        txtqte_entrees.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 4)));
        txtprix_entrees.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 5)));
        txtval_entrees.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 6))); 
        txtqte_sorties.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 7)));
        txtval_sorties.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 8)));
        txtprix_sorties.setText(String.valueOf(tbl_ar.getValueAt(tbl_ar.getSelectedRow(), 9)));
    }//GEN-LAST:event_tbl_arMouseClicked

    private void txtnomp_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomp_arActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomp_arActionPerformed

    private void txtqte_entreesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqte_entreesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqte_entreesActionPerformed

    private void combolib_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combolib_arActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combolib_arActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(soustraitance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(soustraitance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(soustraitance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(soustraitance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new article().setVisible(true);
            }
        }); }
    
       
//public ResultSetTableModel md;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combolib_ar;
    private javax.swing.JComboBox comrech_ar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_ar;
    private javax.swing.JFormattedTextField txtdate;
    private javax.swing.JTextField txtid_ar;
    public static javax.swing.JTextField txtnomp_ar;
    private javax.swing.JTextField txtprix_entrees;
    private javax.swing.JTextField txtprix_sorties;
    private javax.swing.JTextField txtqte_entrees;
    private javax.swing.JTextField txtqte_sorties;
    private javax.swing.JTextField txtrech_ar;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txttotalpe_ar;
    private javax.swing.JTextField txttotalps_ar;
    private javax.swing.JTextField txttotalqe_ar;
    private javax.swing.JTextField txttotalqs_ar;
    private javax.swing.JTextField txttotalve_ar;
    private javax.swing.JTextField txttotalvs_ar;
    private javax.swing.JLabel txtval_entrees;
    private javax.swing.JLabel txtval_sorties;
    private javax.swing.JLabel txtvalfinal;
    // End of variables declaration//GEN-END:variables
}
