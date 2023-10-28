/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweet_house;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JayodyaRupasinghe
 */
public class workwindow extends javax.swing.JFrame {

    /**
     * Creates new form workwindow
     */
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    
    
    public workwindow() {
        super("Work Window");
        initComponents();
        conn = dbconnection.connection();
        PreparedStatement pst;
        
        
        showdate();
        showtime();
        
        
    }
    public void showdate() 
    {

            
		java.util.Date d = new java.util.Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		lbldate.setText(form.format(d));

    }

    public void showtime() 
    {

		new Timer(0, new ActionListener() 
                {
			@Override
			public void actionPerformed(ActionEvent e) 
                        {
				java.util.Date d = new java.util.Date();
				SimpleDateFormat form = new SimpleDateFormat("hh:mm:ss a");
				lbltime.setText(form.format(d));

			}
		}
                ).start();
    }
    public void clear()
    {
                    txtfcode.setText("");
                    txtfname.setText("");
                    txtprice.setText("");
                    txtquantity.setText("");
                    txttprice.setText("");
    }
    
    
    /* ---------------------------------------------------------------------------------------------------------*/
    
    
    public void tablerowclear()
    {
         DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        //Delete Selected Row
        
    try
    {
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),0);
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),1);
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),2);
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),3);
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),4);
             tblModel.setValueAt(" ", jTable1.getSelectedRow(),5);
        
        
                    
            if (jTable1.getSelectedRowCount()==1)
            {
                //if singal row is selected than delete
                tblModel.removeRow(jTable1.getSelectedRow());
                
                
                String currentfoodcode = txtfcode.getText();
                st=conn.createStatement();
                String qry = "DELETE FROM sales_products WHERE foodcode='"+currentfoodcode+"'";
                st.executeUpdate(qry);
                
                
            }
            else
            {
                if(jTable1.getRowCount()==0) 
                {
                    // if table is empty (no data) than display message
                    JOptionPane.showMessageDialog(this,"Table is Empty");
                }
                else
                {
                    //if table is not empty but row is not selected or mmultiple row are selected.
                    JOptionPane.showMessageDialog(this,"Please selecte singal row for delete");
                }
             }
    }
    catch(Exception e)
                {
                     JOptionPane.showMessageDialog(null,e);
                }
        
    
    }
    /* -----------------------------------------------------------------------------------------------------------------------------------*/ 
    
    
    
    public void showfoodlist()
    {
        try
        {
            
            String invono = lbldisplayinovno.getText();
            
            int Currentinvono = Integer.parseInt(invono);
            
            st=conn.createStatement();
            
            String qry = "SELECT * FROM sales_products WHERE invoiceno='"+Currentinvono+"'";
            
            rs = st.executeQuery(qry);
           
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           
           // JOptionPane.showMessageDialog(null,"Successfull");
        }
        catch(Exception e)
                {
                     JOptionPane.showMessageDialog(null,e);
                }
    }
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------*/
    public void caltabletotalprice()
    {
        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        
        int numofrow = jTable1.getRowCount();
        
        double rowtotalprice = 0.00;
        
        for (int i=0; i<numofrow; i++)
        {
            double value = Double.valueOf(jTable1.getValueAt(i, 8).toString());
            rowtotalprice = rowtotalprice+value;
           
            txttotalp.setText(Double.toString(rowtotalprice));
            
        }
        
    }
    /*-------------------------------------------------------------------------------------------------------------------------------------------*/
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblfcode = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtfcode = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        butsearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttprice = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        lbldisc = new javax.swing.JLabel();
        txtdisc = new javax.swing.JTextField();
        lblremarks = new javax.swing.JLabel();
        txtremarks = new javax.swing.JTextField();
        butcheckout = new javax.swing.JButton();
        butadd = new javax.swing.JButton();
        butclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttotalp = new javax.swing.JTextField();
        txtamonutre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtchange = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblinvoiceno = new javax.swing.JLabel();
        lbldisplayinovno = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitemlout = new javax.swing.JMenuItem();
        mitemexit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Input Food Code Here:");

        lblfcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblfcode.setText("Food Code");

        lblfname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblfname.setText("Food Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Price");

        txtfcode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfcodeMouseClicked(evt);
            }
        });
        txtfcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfcodeActionPerformed(evt);
            }
        });
        txtfcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfcodeKeyPressed(evt);
            }
        });

        txtfname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });

        txtprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("*");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        butsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/icons8_search_25px.png"))); // NOI18N
        butsearch.setText("Search");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sales Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Price");

        txttprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttprice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttpriceMouseClicked(evt);
            }
        });

        txtquantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantityActionPerformed(evt);
            }
        });

        lbldisc.setText("Discount");

        txtdisc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtdisc.setText("0");
        txtdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscActionPerformed(evt);
            }
        });

        lblremarks.setText("Add Remarks");

        txtremarks.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        butcheckout.setBackground(new java.awt.Color(51, 255, 51));
        butcheckout.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        butcheckout.setText("Check Out");
        butcheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcheckoutMouseClicked(evt);
            }
        });
        butcheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butcheckoutActionPerformed(evt);
            }
        });

        butadd.setBackground(new java.awt.Color(51, 153, 255));
        butadd.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        butadd.setText("ADD");
        butadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butaddMouseClicked(evt);
            }
        });
        butadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaddActionPerformed(evt);
            }
        });

        butclear.setBackground(new java.awt.Color(0, 255, 255));
        butclear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butclear.setText("Clear");
        butclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butclearActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice No", "Food Code", "Food Name", "Food Price", "Quantity", "Discount", "Total Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(700);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(700);
            jTable1.getColumnModel().getColumn(4).setMinWidth(10);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(500);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel6.setText("              Horana Sweet House & Hot Hut Foods System");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setText("Total Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel8.setText("Amount Received");

        txtamonutre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamonutreActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setText("Change");

        txtchange.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Horana Sweeet House & Hot Hut Foods System");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Copyright by : JR Technology");

        lbldate.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

        lbltime.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

        lblinvoiceno.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblinvoiceno.setText("Invoice NO:");

        lbldisplayinovno.setText("0001");
        lbldisplayinovno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbldisplayinovnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(txttotalp)
                                    .addComponent(jLabel9)
                                    .addComponent(txtchange)
                                    .addComponent(txtamonutre)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butcheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblfcode)
                                    .addComponent(lblfname)
                                    .addComponent(jLabel2))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtprice, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtfcode)
                                    .addComponent(txtfname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)
                                .addComponent(butsearch)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(175, 175, 175)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(lblinvoiceno))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txttprice)
                                                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(butadd)
                                                    .addComponent(butclear)))
                                            .addComponent(lbldisplayinovno, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblremarks)
                                            .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtremarks, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(622, 622, 622)
                                        .addComponent(lbldisc)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblfcode)
                                .addComponent(butsearch)
                                .addComponent(jLabel3)
                                .addComponent(txtfcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblinvoiceno)
                                .addComponent(lbldisplayinovno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblfname))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(butadd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttprice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(butclear))
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbldisc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblremarks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtremarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(butcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotalp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtamonutre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        mitemlout.setText("Log Out");
        mitemlout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemloutActionPerformed(evt);
            }
        });
        jMenu1.add(mitemlout);

        mitemexit.setText("Exit");
        mitemexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemexitActionPerformed(evt);
            }
        });
        jMenu1.add(mitemexit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitemloutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemloutActionPerformed
        // TODO add your handling code here:
        loginform lform = new loginform();
        if (JOptionPane.showConfirmDialog(lform, "Are you sure if you want to Logout?","Sweet House System",
   JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
              setVisible(false);
              lform.setVisible(true);
              this.dispose();
        } 
    }//GEN-LAST:event_mitemloutActionPerformed

    private void mitemexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemexitActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("EXIT");
 
        if (JOptionPane.showConfirmDialog(frame, "Are you sure if you want to exit?","Sweet House System",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
        System.exit(0);
        }
    }//GEN-LAST:event_mitemexitActionPerformed

    private void butaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaddActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_butaddActionPerformed

    private void butaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseClicked
        // TODO add your handling code here:
        String  invoiceno, fcode, fname, fprice, quantity, discount, totalp;
               try
                {
                   //String itemselected = jComboBox1.getSelectedItem().toString();
                    
                    invoiceno=lbldisplayinovno.getText();
                    fcode=txtfcode.getText();
                    fname=txtfname.getText();
                    fprice=txtprice.getText();
                    quantity =txtquantity.getText();
                    discount =txtdisc.getText();
                    totalp=txttprice.getText();
                    
                    st= conn.createStatement();
                    
                    String qry = "INSERT INTO sales_products (invoiceno,foodcode,foodname,foodprice,qty,dis, totalprice) VALUES ('"+invoiceno+"','"+fcode+"','"+fname+"','"+fprice+"','"+quantity+"','"+discount+"','"+totalp+"')";
                    
                    st.executeUpdate(qry);
                  
                   JOptionPane.showMessageDialog(null,"Insertion is Successful!!...");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
    
    
                 clear(); 
                 caltabletotalprice();
                 showfoodlist();  
                 
    }//GEN-LAST:event_butaddMouseClicked

    private void butclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butclearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_butclearActionPerformed

    private void butcheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butcheckoutActionPerformed
        try
        {
            bill.setText("\tHorana Sweet House &\n");
            bill.setText(bill.getText()+" \t\tHot - Hut - Foods \n");
            bill.setText(bill.getText()+"\t No. 47/B, Suderis Silva Mw, Horana.\n");
            bill.setText(bill.getText()+"\t TEL 076 9902685 / 034 2262804\n");
            bill.setText(bill.getText()+"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - -\n");
            bill.setText(bill.getText()+"Food Name"+"    \tQTY"+"\tPrice"+"\tDis"+"\tAmmount"+"\n");
            bill.setText(bill.getText()+"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - -\n");
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            for(int i=0; i<jTable1.getRowCount(); i++)
            {
                String fname = df.getValueAt(i, 2).toString();
                String fprice = df.getValueAt(i, 3).toString();
                String qty = df.getValueAt(i, 4).toString();
                String dis = df.getValueAt(i, 5).toString();
                String ammount = df.getValueAt(i, 6).toString();
                
                bill.setText(bill.getText()+fname+"    "+"\t"+qty+"\t"+fprice+"\t"+dis+"\t"+ammount+"\n");
            }
            
        }
        catch(Exception e)
        {
        }
        
                 
                
  
    }//GEN-LAST:event_butcheckoutActionPerformed

    private void txtquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantityActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtquantityActionPerformed

    private void txtdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtdiscActionPerformed

    private void txtfcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfcodeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtfcodeActionPerformed

    private void txtfcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfcodeMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtfcodeMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
         String fcode = txtfcode.getText();
        
        
        try
        {
           st=conn.createStatement();
           
           String qry = "SELECT foodname, price FROM foodlist where foodcode='"+fcode+"'";
           
           rs=st.executeQuery(qry);
           
          if (rs.next()) 
          {
              
        
       String fname = rs.getString("foodname");
       String fprice=rs.getString("price");
       
       
       txtfname.setText(fname);
       txtprice.setText(fprice);
       
    } else {
        
    }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }       
        
        
        
        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txttpriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttpriceMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("Get Value on Click");
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        String fprice = txtprice.getText();
        int foodprice = Integer.parseInt(fprice);
        
        
        String fqty = txtquantity.getText();
        int foodqty = Integer.parseInt(fqty);
        
        int totalprice = (foodprice * foodqty);
        String toprice = Integer.toString(totalprice);
        
        txttprice.setText(toprice);
        
            
    }//GEN-LAST:event_txttpriceMouseClicked

    private void txtfcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfcodeKeyPressed
        // TODO add your handling code here:
       /* if(evt.getKeyCode()==KeyEvent.VK_ENTER);
        {
            String fcode = txtfcode.getText();
            
            try
            {
                Class.forName("com.mysql.jdbcDriver");
                
                pst =conn.prepareStatement(fcode);
                String qry = ("SELECT foodname, price FROM foodlist where foodcode='"+fcode+"' ");
                
                
            }
            catch(Exception e)
            {
            }*/
                
            
       
    }//GEN-LAST:event_txtfcodeKeyPressed

    private void lbldisplayinovnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbldisplayinovnoActionPerformed
        // TODO add your handling code here:
        
       
        
       
        
    }//GEN-LAST:event_lbldisplayinovnoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r= jTable1.getSelectedRow();
        String invoiceno=jTable1.getValueAt(r, 0).toString();
        String fcode=jTable1.getValueAt(r,1).toString();
        String fname=jTable1.getValueAt(r, 2).toString();
        String fprice=jTable1.getValueAt(r, 3).toString();
        String qty=jTable1.getValueAt(r, 4).toString();
        String dis=jTable1.getValueAt(r, 5).toString();
        String tprice=jTable1.getValueAt(r, 5).toString();

        lbldisplayinovno.setText(invoiceno);
        txtfcode.setText(fcode);
        txtfname.setText(fname);
        txtfcode.setText(fcode);
        txtprice.setText(fprice);
        txtquantity.setText(qty);
        txtdisc.setText(dis);
        txttprice.setText(tprice);
        
        tablerowclear();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void butcheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheckoutMouseClicked
        // TODO add your handling code here:
        int i= Integer.valueOf (lbldisplayinovno.getText());
        
        
        ++i;
        
         lbldisplayinovno.setText(String.valueOf(i));
        
        
            
    }//GEN-LAST:event_butcheckoutMouseClicked

    private void txtamonutreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamonutreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamonutreActionPerformed

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

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
            java.util.logging.Logger.getLogger(workwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workwindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton butadd;
    private javax.swing.JButton butcheckout;
    private javax.swing.JButton butclear;
    private javax.swing.JButton butsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldisc;
    private javax.swing.JTextField lbldisplayinovno;
    private javax.swing.JLabel lblfcode;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblinvoiceno;
    private javax.swing.JLabel lblremarks;
    private javax.swing.JLabel lbltime;
    private javax.swing.JMenuItem mitemexit;
    private javax.swing.JMenuItem mitemlout;
    private javax.swing.JTextField txtamonutre;
    private javax.swing.JTextField txtchange;
    private javax.swing.JTextField txtdisc;
    private javax.swing.JTextField txtfcode;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txtremarks;
    private javax.swing.JTextField txttotalp;
    private javax.swing.JTextField txttprice;
    // End of variables declaration//GEN-END:variables

