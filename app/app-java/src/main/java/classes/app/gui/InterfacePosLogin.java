package classes.app.gui;

import app.controller.ProcessController;
import app.controller.ServerController;
import app.controller.UserSingleton;
import app.controller.component.DiscoControllerStrategy;
import app.controller.component.ProcessadorControllerStrategy;
import app.controller.component.RamControllerStrategy;
import app.dao.ComponentDAO;
import app.dao.LogProcessComponentDAO;
import app.dao.ProcessDAO;
import app.dao.ServerDAO;
import app.model.ComponentModel;
import app.model.LogComponentProcess;
import app.model.ProcessModel;
import app.model.ServerModel;
import app.util.LOGGER;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class InterfacePosLogin extends javax.swing.JFrame {

  private ServerModel server;
  private ComponentDAO componentDAO;
  private ComponentModel ram;
  private ComponentModel cpu;
  private ComponentModel disco;

  public InterfacePosLogin() {
    initComponents();
    labelTexto1.setVisible(false);
    labelTexto2.setVisible(false);
    labelAcesseADashboard.setVisible(false);
    buttonParaIrAoSite.setVisible(false);

    this.componentDAO = new ComponentDAO();

    Timer timer = new Timer();
    final long secondsToGetDatas = (1000 * 4);

    labelTextoVariavel.setText("Configurando o servidor...");
    ServerDAO serverDAO = new ServerDAO();
    try {
      server = serverDAO.save(new ServerController().getServer(UserSingleton.user.getFkHospital()));
      System.out.println("Serial server: " + server.getSerialServer());
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), "components");
      LOGGER.error("Houve algo errado em capturar dados do servidor...", "components");

      labelTextoVariavel.setText("Houve algo errado em capturar dados do servidor...");
    }

    TimerTask taskServer = new TimerTask() {
      @Override
      public void run() {

      }
    };

    TimerTask task1 = new TimerTask() {
      @Override
      public void run() {
        labelTextoVariavel.setText("Pegando dados da CPU...");
        try {
          cpu = componentDAO.save(new ProcessadorControllerStrategy().getComponent(server.getSerialServer()));
        } catch (Exception ex) {

          LOGGER.error(ex.getMessage(), "components");
          LOGGER.error("Houve algo errado em capturar dados do CPU...", "components");
          labelTextoVariavel.setText("Houve algo errado em capturar dados do CPU...");
        }
      }
    };

    TimerTask task2 = new TimerTask() {
      @Override
      public void run() {
        labelTextoVariavel.setText("Salvando Memória RAM...");

        try {
          ram = componentDAO.save(new RamControllerStrategy().getComponent(server.getSerialServer()));
        } catch (Exception ex) {

          LOGGER.error(ex.getMessage(), "components");
          LOGGER.error("Houve algo errado em capturar dados da RAM...", "components");
          labelTextoVariavel.setText("Houve algo errado em capturar dados da RAM...");
        }
      }
    };

    TimerTask task3 = new TimerTask() {
      @Override
      public void run() {
        try {
          labelTextoVariavel.setText("Capturando dados dos discos...");
          List<ComponentModel> discos = new ArrayList<>();
          new DiscoControllerStrategy().getComponents(server.getSerialServer())
                  .forEach(d -> {
                    try {
                      ComponentModel save = componentDAO.save(d);
                      discos.add(save);
                    } catch (Exception e) {
                      System.out.println("Houve algo de errado ao inserir disco.");

                      LOGGER.error(e.getMessage(), "components");
                      LOGGER.error("Houve algo de errado ao inserir disco.", "components");
                    }
                  });
          disco = discos.get(0);
        } catch (Exception ex) {
          ex.printStackTrace();

          LOGGER.error(ex.getMessage(), "components");
          LOGGER.error("Houve algo de errado ao inserir disco.", "components");
          labelTextoVariavel.setText("Houve algo de errado ao inserir disco.");
        }

      }
    };

    TimerTask taskFinal = new TimerTask() {
      @Override
      public void run() {

        labelTextoVariavel.setVisible(false);
        labelGifCarregando.setVisible(false);
        labelTexto1.setVisible(true);
        labelTexto2.setVisible(true);
        labelAcesseADashboard.setVisible(true);
        buttonParaIrAoSite.setVisible(true);

        new Timer().scheduleAtFixedRate(new TimerTask() {
          @Override
          public void run() {

            if (serverDAO.componentExists(server) && server.getIsActive().equalsIgnoreCase("S")) {
              LOGGER.warning("Servidor Parado... Mude no site para voltar a captar dados", "components");
            } else {
              Date date = new Date();
              date.setHours(date.getHours() - 1);
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s.S");
              String now = sdf.format(date);

              ProcessDAO processDao = new ProcessDAO();
              System.out.println("Monitorando: " + now);
              new ProcessController()
                      .getProcessPerMemo()
                      .forEach(process -> {
                        LogProcessComponentDAO logDao = new LogProcessComponentDAO();
                        try {
                          ProcessModel saveProcess = processDao.saveProcess(process);
                          LogComponentProcess logCpu = new LogComponentProcess(cpu, saveProcess);
                          LogComponentProcess logDisco = new LogComponentProcess(disco, saveProcess);
                          LogComponentProcess logRam = new LogComponentProcess(ram, saveProcess);
                          logDao.save(logCpu, now);
                          logDao.save(logDisco, now);
                          logDao.save(logRam, now);
                        } catch (Exception e) {
                          e.printStackTrace();
                          LOGGER.error(e.getMessage(), "components");
                        }
                      });
            }
          }
        }, 0, 1000 * 60);
      }
    };

    timer.schedule(taskServer, secondsToGetDatas);
    timer.schedule(task1, secondsToGetDatas * 3);
    timer.schedule(task2, secondsToGetDatas * 5);
    timer.schedule(task3, secondsToGetDatas * 7);
    timer.schedule(taskFinal, secondsToGetDatas * 9);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        labelGifCarregando = new javax.swing.JLabel();
        labelTextoVariavel = new javax.swing.JLabel();
        labelAcesseADashboard = new javax.swing.JLabel();
        buttonParaIrAoSite = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelTexto1 = new javax.swing.JLabel();
        labelTexto2 = new javax.swing.JLabel();
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

        labelGifCarregando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/carregando.gif"))); // NOI18N
        labelGifCarregando.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelGifCarregandoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                labelGifCarregandoFocusLost(evt);
            }
        });

        labelTextoVariavel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTextoVariavel.setForeground(new java.awt.Color(0, 0, 0));
        labelTextoVariavel.setText("Pegando os dados do Servidor...");

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        labelTexto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTexto1.setForeground(new java.awt.Color(0, 0, 0));
        labelTexto1.setText("Seus dados estão sendo enviados");

        labelTexto2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTexto2.setForeground(new java.awt.Color(0, 0, 0));
        labelTexto2.setText("para sua dashboard");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelTextoVariavel)
                    .addComponent(jLabel4)
                    .addComponent(labelGifCarregando)
                    .addComponent(labelAcesseADashboard)
                    .addComponent(buttonParaIrAoSite, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTexto1)
                    .addComponent(labelTexto2))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addComponent(labelTextoVariavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGifCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(labelTexto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTexto2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(labelAcesseADashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonParaIrAoSite, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(35, 175, 174));
        kGradientPanel3.setkStartColor(new java.awt.Color(23, 235, 230));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Obrigado por confiar na");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(30, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addGap(36, 36, 36))
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

    private void labelGifCarregandoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelGifCarregandoFocusGained
      // TODO add your handling code here:
    }//GEN-LAST:event_labelGifCarregandoFocusGained

    private void labelGifCarregandoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelGifCarregandoFocusLost
      // TODO add your handling code here:
    }//GEN-LAST:event_labelGifCarregandoFocusLost

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
    //</editor-fold>
    //</editor-fold>
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
    private javax.swing.JLabel labelGifCarregando;
    private javax.swing.JLabel labelTexto1;
    private javax.swing.JLabel labelTexto2;
    private javax.swing.JLabel labelTextoVariavel;
    // End of variables declaration//GEN-END:variables
}
