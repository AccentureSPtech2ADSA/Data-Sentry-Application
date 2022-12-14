package classes.app.gui;

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

    kGradientPanel1 = new keeptoo.KGradientPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    buttonPegarDadosMaquina = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 0, 0));
    setMaximumSize(new java.awt.Dimension(1100, 550));
    setMinimumSize(new java.awt.Dimension(1100, 550));
    setResizable(false);

    kGradientPanel1.setkEndColor(new java.awt.Color(28, 98, 96));
    kGradientPanel1.setkStartColor(new java.awt.Color(2, 205, 200));
    kGradientPanel1.setMaximumSize(new java.awt.Dimension(1100, 550));
    kGradientPanel1.setMinimumSize(new java.awt.Dimension(1100, 550));
    kGradientPanel1.setPreferredSize(new java.awt.Dimension(1100, 550));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setPreferredSize(new java.awt.Dimension(1050, 500));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Seus dados estão sendo enviados");

    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("para sua dashboard");

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Acesse sua dashboard pelo nosso site:");
    jLabel1.setToolTipText("");

    buttonPegarDadosMaquina.setBackground(new java.awt.Color(35, 175, 174));
    buttonPegarDadosMaquina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    buttonPegarDadosMaquina.setForeground(new java.awt.Color(255, 255, 255));
    buttonPegarDadosMaquina.setText("Data Sentry");
    buttonPegarDadosMaquina.setToolTipText("");
    buttonPegarDadosMaquina.setAutoscrolls(true);
    buttonPegarDadosMaquina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    buttonPegarDadosMaquina.setBorderPainted(false);
    buttonPegarDadosMaquina.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonPegarDadosMaquinaActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(373, 373, 373)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel3)
          .addComponent(jLabel2)
          .addComponent(jLabel1)
          .addComponent(buttonPegarDadosMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4))
        .addGap(279, 285, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap(94, Short.MAX_VALUE)
        .addComponent(jLabel4)
        .addGap(62, 62, 62)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addGap(57, 57, 57)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonPegarDadosMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32))
    );

    javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
    kGradientPanel1.setLayout(kGradientPanel1Layout);
    kGradientPanel1Layout.setHorizontalGroup(
      kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(kGradientPanel1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    kGradientPanel1Layout.setVerticalGroup(
      kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(kGradientPanel1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(25, Short.MAX_VALUE))
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

    private void buttonPegarDadosMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPegarDadosMaquinaActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_buttonPegarDadosMaquinaActionPerformed

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
  private javax.swing.JButton buttonPegarDadosMaquina;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel2;
  private keeptoo.KGradientPanel kGradientPanel1;
  // End of variables declaration//GEN-END:variables
}
