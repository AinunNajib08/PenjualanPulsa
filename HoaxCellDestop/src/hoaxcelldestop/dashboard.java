/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxcelldestop;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        Logout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        KontakKami = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        InfoSaldo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        CekData = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BeliPaketan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BeliPulsa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jButton6.setBackground(new java.awt.Color(255, 0, 51));
        jButton6.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(730, 580, 140, 40);

        Logout.setBackground(new java.awt.Color(102, 102, 102));
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setToolTipText("");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/logout.png"))); // NOI18N
        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(Logout);
        Logout.setBounds(700, 390, 190, 160);

        jButton5.setBackground(new java.awt.Color(0, 255, 0));
        jButton5.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton5.setText("Kontak Kami");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(410, 580, 140, 40);

        KontakKami.setBackground(new java.awt.Color(102, 102, 102));
        KontakKami.setForeground(new java.awt.Color(255, 255, 255));
        KontakKami.setToolTipText("");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/book.png"))); // NOI18N

        javax.swing.GroupLayout KontakKamiLayout = new javax.swing.GroupLayout(KontakKami);
        KontakKami.setLayout(KontakKamiLayout);
        KontakKamiLayout.setHorizontalGroup(
            KontakKamiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KontakKamiLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        KontakKamiLayout.setVerticalGroup(
            KontakKamiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KontakKamiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(KontakKami);
        KontakKami.setBounds(390, 390, 190, 160);

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton4.setText("Info Saldo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(100, 580, 130, 40);

        InfoSaldo.setBackground(new java.awt.Color(102, 102, 102));
        InfoSaldo.setForeground(new java.awt.Color(255, 255, 255));
        InfoSaldo.setToolTipText("");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/risk.png"))); // NOI18N

        javax.swing.GroupLayout InfoSaldoLayout = new javax.swing.GroupLayout(InfoSaldo);
        InfoSaldo.setLayout(InfoSaldoLayout);
        InfoSaldoLayout.setHorizontalGroup(
            InfoSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoSaldoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        InfoSaldoLayout.setVerticalGroup(
            InfoSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(InfoSaldo);
        InfoSaldo.setBounds(70, 390, 190, 160);

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton3.setText("Cek Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(730, 320, 130, 40);

        CekData.setBackground(new java.awt.Color(102, 102, 102));
        CekData.setForeground(new java.awt.Color(255, 255, 255));
        CekData.setToolTipText("");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/earth-globe.png"))); // NOI18N

        javax.swing.GroupLayout CekDataLayout = new javax.swing.GroupLayout(CekData);
        CekData.setLayout(CekDataLayout);
        CekDataLayout.setHorizontalGroup(
            CekDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CekDataLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        CekDataLayout.setVerticalGroup(
            CekDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CekDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(60, 60, 60))
        );

        getContentPane().add(CekData);
        CekData.setBounds(700, 140, 190, 160);

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton2.setText("Beli Paketan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 320, 140, 40);

        BeliPaketan.setBackground(new java.awt.Color(102, 102, 102));
        BeliPaketan.setForeground(new java.awt.Color(255, 255, 255));
        BeliPaketan.setToolTipText("");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/telegram.png"))); // NOI18N

        javax.swing.GroupLayout BeliPaketanLayout = new javax.swing.GroupLayout(BeliPaketan);
        BeliPaketan.setLayout(BeliPaketanLayout);
        BeliPaketanLayout.setHorizontalGroup(
            BeliPaketanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BeliPaketanLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        BeliPaketanLayout.setVerticalGroup(
            BeliPaketanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BeliPaketanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        getContentPane().add(BeliPaketan);
        BeliPaketan.setBounds(390, 140, 190, 160);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton1.setText("Beli Pulsa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 320, 140, 40);

        BeliPulsa.setBackground(new java.awt.Color(102, 102, 102));
        BeliPulsa.setForeground(new java.awt.Color(255, 255, 255));
        BeliPulsa.setToolTipText("");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/chat.png"))); // NOI18N

        javax.swing.GroupLayout BeliPulsaLayout = new javax.swing.GroupLayout(BeliPulsa);
        BeliPulsa.setLayout(BeliPulsaLayout);
        BeliPulsaLayout.setHorizontalGroup(
            BeliPulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BeliPulsaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        BeliPulsaLayout.setVerticalGroup(
            BeliPulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BeliPulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(BeliPulsa);
        BeliPulsa.setBounds(70, 140, 190, 160);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("THE HOAX CELL");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(140, 0, 400, 100);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/lo.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 0, 110, 100);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/tras1.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 950, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hoaxcelldestop/gambar1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            layoutHoax lay;
            lay = new layoutHoax();
            lay.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      belipaketdata tam;
      tam = new belipaketdata();
      tam.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cekdatapaketan view;
        view = new cekdatapaketan();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BeliPaketan;
    private javax.swing.JPanel BeliPulsa;
    private javax.swing.JPanel CekData;
    private javax.swing.JPanel InfoSaldo;
    private javax.swing.JPanel KontakKami;
    private javax.swing.JPanel Logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
