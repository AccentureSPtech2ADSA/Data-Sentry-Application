/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classes.app;

import classes.get.dados.component.server.GetDadosDisco;
import classes.get.dados.component.server.GetDadosMemoriaRam;
import classes.get.dados.component.server.GetDadosProcessador;
import classes.get.dados.component.server.GetDadosServer;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zagreu
 */
public class InterfacePosLogin extends javax.swing.JFrame {

    /**
     * Creates new form InterfacePosLogin
     */
    public InterfacePosLogin() {
        initComponents();
        labelTexto1.setVisible(false);
        labelTexto2.setVisible(false);
        labelAcesseADashboard.setVisible(false);
        buttonParaIrAoSite.setVisible(false);

        Timer timer = new Timer();
        final long secondsToGetDatas = (1000 * 3);

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                try {
                    GetDadosProcessador getDadosProcessador = new GetDadosProcessador();
                    GetDadosMemoriaRam getDadosMemoriaRam = new GetDadosMemoriaRam();
                    GetDadosDisco getDadosDisco = new GetDadosDisco();
                    GetDadosServer getDadosServer = new GetDadosServer();

                    getDadosServer.setServerInfo();

                    getDadosProcessador.setTipoComponente();
                    getDadosProcessador.setInfoProcessador();

                    getDadosMemoriaRam.setTipoComponente();
                    getDadosMemoriaRam.setInfoMemoriaRam();

                    getDadosDisco.setTipoComponente();
                    getDadosDisco.setInfoDisco();

                    labelTextoVariavel.setText("Pegando os dados da CPU...");
                } catch (IOException ex) {
                    Logger.getLogger(InterfacePosLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                labelTextoVariavel.setText("Pegando os dados da memória ram...");
            }
        };

        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                labelTextoVariavel.setText("Pegando os dados do disco...");
            }
        };

        TimerTask taskFinal = new TimerTask() {
            @Override
            public void run() {
                Timer timerCancel = new Timer();

                labelTextoVariavel.setVisible(false);
                labelTexto1.setVisible(true);
                labelTexto2.setVisible(true);
                labelAcesseADashboard.setVisible(true);
                buttonParaIrAoSite.setVisible(true);

                timerCancel.cancel();
                timerCancel.purge();
            }
        };

        timer.schedule(task1, secondsToGetDatas);
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        timer.schedule(task2, 6000);
        timer.schedule(task3, 9000);
        timer.schedule(taskFinal, 12000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        labelAcesseADashboard = new javax.swing.JLabel();
        buttonParaIrAoSite = new javax.swing.JButton();
        labelTexto2 = new javax.swing.JLabel();
        labelTexto1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelTextoVariavel = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sentinel Target");
        setBackground(new java.awt.Color(23, 235, 230));
        setMinimumSize(new java.awt.Dimension(1100, 550));
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(23, 235, 230));
        kGradientPanel1.setkStartColor(new java.awt.Color(35, 175, 174));

        kGradientPanel2.setkEndColor(new java.awt.Color(236, 236, 236));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(1060, 481));

        labelAcesseADashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelAcesseADashboard.setForeground(new java.awt.Color(0, 0, 0));
        labelAcesseADashboard.setText("Acesse sua dashboard pelo nosso site:");
        labelAcesseADashboard.setToolTipText("");

        buttonParaIrAoSite.setBackground(new java.awt.Color(35, 175, 174));
        buttonParaIrAoSite.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonParaIrAoSite.setForeground(new java.awt.Color(255, 255, 255));
        buttonParaIrAoSite.setText("Data Sentry");
        buttonParaIrAoSite.setToolTipText("");
        buttonParaIrAoSite.setAutoscrolls(true);
        buttonParaIrAoSite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonParaIrAoSite.setBorderPainted(false);
        buttonParaIrAoSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParaIrAoSiteActionPerformed(evt);
            }
        });

        labelTexto2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTexto2.setForeground(new java.awt.Color(0, 0, 0));
        labelTexto2.setText("para sua dashboard");

        labelTexto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTexto1.setForeground(new java.awt.Color(0, 0, 0));
        labelTexto1.setText("Seus dados estão sendo enviados");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        labelTextoVariavel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTextoVariavel.setForeground(new java.awt.Color(0, 0, 0));
        labelTextoVariavel.setText("Pegando os dados do Servidor...");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonParaIrAoSite, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAcesseADashboard)
                    .addComponent(labelTextoVariavel)
                    .addComponent(labelTexto2)
                    .addComponent(labelTexto1)
                    .addComponent(jLabel4))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(66, 66, 66)
                .addComponent(labelTexto1)
                .addGap(0, 0, 0)
                .addComponent(labelTexto2)
                .addGap(18, 18, 18)
                .addComponent(labelTextoVariavel)
                .addGap(18, 18, 18)
                .addComponent(labelAcesseADashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonParaIrAoSite, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(35, 175, 174));
        kGradientPanel3.setkStartColor(new java.awt.Color(23, 235, 230));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Obrigado por confiar na");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Data Sentry!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confiar.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonParaIrAoSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParaIrAoSiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonParaIrAoSiteActionPerformed

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
            java.util.logging.Logger.getLogger(InterfacePosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePosLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonParaIrAoSite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel labelAcesseADashboard;
    private javax.swing.JLabel labelTexto1;
    private javax.swing.JLabel labelTexto2;
    private javax.swing.JLabel labelTextoVariavel;
    // End of variables declaration//GEN-END:variables
}
