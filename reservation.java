/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 
 
 
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rk960
 */
public class reservation extends javax.swing.JFrame {

    /**
     * Creates new form Reservation
     */
    public reservation() {
        initComponents();
        Connect();
        LoadStartplace();
        LoadEndplace();
        
    }
    

      Connection con;
     PreparedStatement pst;   
     ResultSet rs;
    
     
    public void Connect()  
   {
       
        try {
            Class.forName("oracle.jdbc.OracleDriver");
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","9113");
             
             
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
            
        
  }
    
     
    public void  LoadStartplace()
    {
        try {
            pst=con.prepareStatement("select startplace from trainsinfo");
            rs=pst.executeQuery();
            txtstplace.removeAllItems();
            while(rs.next())
            {
                txtstplace.addItem(rs.getString(1));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    
    public void  LoadEndplace()
    {
        try {
            pst=con.prepareStatement("select  destinationplace from trainsinfo");
            rs=pst.executeQuery();
            txteplace.removeAllItems();
            while(rs.next())
            {
               txteplace.addItem(rs.getString(1));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    public void load()
    {
        String splace=txtstplace.getSelectedItem().toString();
        String eplace=txteplace.getSelectedItem().toString();
         
        
        try {
            pst=con.prepareStatement("SELECT * FROM   trainsinfo where startplace=? and destinationplace=?");
            pst.setString(1, splace);
            pst.setString(2, eplace);
            
            rs=pst.executeQuery();
            
            if(rs.next()==true)
            {
              txttno.setText(rs.getString(1));
              txttname.setText(rs.getString(2));
              txtprice.setText(rs.getString(5));
              
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Train Not Available This Root");
            }
            
            
            
        } catch (Exception e) {
           e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtticket = new javax.swing.JTextField();
        txttname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtpno = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txteplace = new javax.swing.JComboBox<>();
        txtstplace = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        txttno = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Start Place");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 89, 117, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Passenger Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 26, 153, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 387, 69, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Price");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 324, 69, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("End Place");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 162, 104, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Total");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 517, 69, -1));

        txtticket.setText(" ");
        txtticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtticketActionPerformed(evt);
            }
        });
        txtticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtticketKeyPressed(evt);
            }
        });
        jPanel1.add(txtticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 453, 352, 35));

        txttname.setText(" ");
        jPanel1.add(txttname, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 269, 352, 35));

        txtprice.setText(" ");
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 322, 352, 35));

        txtpno.setText(" ");
        jPanel1.add(txtpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 24, 353, 35));

        txttotal.setText(" ");
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 515, 352, 35));

        txteplace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txteplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteplaceActionPerformed(evt);
            }
        });
        jPanel1.add(txteplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 159, 353, 36));

        txtstplace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        txtstplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstplaceActionPerformed(evt);
            }
        });
        jPanel1.add(txtstplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 86, 353, 36));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText(" Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 502, 179, 52));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("No of Tickets");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 455, 117, -1));

        search.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 119, 169, 45));

        txttno.setText(" ");
        txttno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttnoActionPerformed(evt);
            }
        });
        jPanel1.add(txttno, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 213, 352, 35));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Train No");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 215, 104, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Train Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 271, 117, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 293, 124, 52));
        jPanel1.add(jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 350, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Railway Reservation System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtstplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstplaceActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtstplaceActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_searchActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txttnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttnoActionPerformed

    private void txteplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteplaceActionPerformed

    private void txtticketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtticketKeyPressed
      
// TODO add your handling code here:
  

       int price,ticket,tot;

      if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
           price=Integer.parseInt(txtprice.getText());
           ticket=Integer.parseInt(txtticket.getText());
           
            
              tot=price * ticket;
              txttotal.setText(String.valueOf(tot)) ;
        
        }
    }//GEN-LAST:event_txtticketKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String pno=txtpno.getText();
        String tsplace=txtstplace.getSelectedItem().toString();
        String teplace=txteplace.getSelectedItem().toString();
        String Tno= txttno.getText();
        String trainname=txttname.getText();
        String tprice=txtprice.getText();
        SimpleDateFormat date_form=new SimpleDateFormat("YYYY-MM-DD");
        String date=date_form.format(jdate.getDate());
        String tticket=txtticket.getText();
        String ttotal= txttotal.getText();
   
        
       
        try {
             pst= con.prepareStatement("insert into reservetrains  (pno,splace,eplace,tno,tname,price,dates,ticket,tot)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,pno);
            pst.setString(2,tsplace);
            pst.setString(3,teplace);
            pst.setString(4,Tno);
            pst.setString(5,trainname);
            pst.setString(6,tprice);
            pst.setString(7,date);
            pst.setString(8,tticket);
            pst.setString(9,ttotal);
            int k= pst.executeUpdate();
            
            
            if(k==1)
            {
   
                 JOptionPane.showMessageDialog(this,"Train Reserved Successfully");
            }
            else 
            {
                JOptionPane.showMessageDialog(this ,"Reserved  Failed");
            }
         
//        else
//            {
//                JOptionPane.showMessageDialog(this,"Record Can't Added");
//            }
//        
       
        
        }   
          catch (SQLException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
          } 
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:\
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtticketActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtticketActionPerformed

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
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservation().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> txteplace;
    private javax.swing.JTextField txtpno;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox<String> txtstplace;
    private javax.swing.JTextField txtticket;
    private javax.swing.JTextField txttname;
    private javax.swing.JTextField txttno;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

}