package classes.app;

import classes.getDadosComponentServer.getDadosDisco;
import classes.getDadosComponentServer.getDadosMemoriaRam;
import classes.getDadosComponentServer.getDadosProcessador;

public class InterfaceLoading extends javax.swing.JFrame {

    Integer contador;

    /**
     * Creates new form InterfaceLogado
     */
    public InterfaceLoading() {
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

        jLabel1 = new javax.swing.JLabel();
        buttonPegarDadosMaquina = new javax.swing.JButton();
        buttonDesligar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(236, 236, 236));
        setMinimumSize(new java.awt.Dimension(520, 520));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Você logou!");

        buttonPegarDadosMaquina.setBackground(new java.awt.Color(0, 204, 204));
        buttonPegarDadosMaquina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonPegarDadosMaquina.setForeground(new java.awt.Color(255, 255, 255));
        buttonPegarDadosMaquina.setText("Pegar dados da máquina");
        buttonPegarDadosMaquina.setToolTipText("");
        buttonPegarDadosMaquina.setAutoscrolls(true);
        buttonPegarDadosMaquina.setBorderPainted(false);
        buttonPegarDadosMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPegarDadosMaquinaActionPerformed(evt);
            }
        });

        buttonDesligar.setText("Desligar");
        buttonDesligar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesligarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPegarDadosMaquina)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(buttonDesligar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(buttonPegarDadosMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDesligar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPegarDadosMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPegarDadosMaquinaActionPerformed
        // TODO add your handling code here:
        getDadosProcessador getDadosProcessador = new getDadosProcessador();
        getDadosMemoriaRam getDadosMemoriaRam = new getDadosMemoriaRam();
        getDadosDisco getDadosDisco = new getDadosDisco();

        getDadosProcessador.setTipoComponente();
        getDadosProcessador.setInfoProcessador();

        getDadosMemoriaRam.setTipoComponente();
        getDadosMemoriaRam.setInfoMemoriaRam();
        
        getDadosDisco.setTipoComponente();
        getDadosDisco.setInfoDisco();
    }//GEN-LAST:event_buttonPegarDadosMaquinaActionPerformed

    private void buttonDesligarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesligarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDesligarActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceLoading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDesligar;
    private javax.swing.JButton buttonPegarDadosMaquina;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}