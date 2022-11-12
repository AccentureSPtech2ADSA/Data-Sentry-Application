package classes.app.gui;

import app.controller.ProcessController;
import app.controller.ServerController;
import app.controller.component.DiscoControllerStrategy;
import app.controller.component.ProcessadorControllerStrategy;
import app.controller.component.RamControllerStrategy;
import app.dao.ComponentDAO;
import app.dao.LogProcessComponentDAO;
import app.dao.ProcessDAO;
import app.dao.ServerDAO;
import app.dao.UserDAO;
import app.database.Ambiente;
import app.database.Database;
import app.model.ComponentModel;
import app.model.LogComponentProcess;
import app.model.ProcessModel;
import app.model.ServerModel;
import app.model.UserModel;
import classes.app.cli.LoginCli;
import classes.app.cli.PostLoginCli;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InterfaceLogin extends javax.swing.JFrame {
    
    public InterfaceLogin() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundoGradienteBlocoDeLogin = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fundoGradienteBlocoMensagemEquipe = new keeptoo.KGradientPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sentinel Target");
        setBackground(new java.awt.Color(236, 236, 236));
        setMinimumSize(new java.awt.Dimension(1100, 550));
        setResizable(false);

        fundoGradienteBlocoDeLogin.setkEndColor(new java.awt.Color(0, 143, 140));
        fundoGradienteBlocoDeLogin.setkStartColor(new java.awt.Color(41, 198, 196));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email:");

        senha.setBackground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        senha.setForeground(new java.awt.Color(0, 0, 0));
        senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        senha.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        buttonLogin.setBackground(new java.awt.Color(35, 175, 174));
        buttonLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("LOGAR");
        buttonLogin.setToolTipText("");
        buttonLogin.setAutoscrolls(true);
        buttonLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        buttonLogin.setBorderPainted(false);
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senha, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fundoGradienteBlocoDeLoginLayout = new javax.swing.GroupLayout(fundoGradienteBlocoDeLogin);
        fundoGradienteBlocoDeLogin.setLayout(fundoGradienteBlocoDeLoginLayout);
        fundoGradienteBlocoDeLoginLayout.setHorizontalGroup(
            fundoGradienteBlocoDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoGradienteBlocoDeLoginLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        fundoGradienteBlocoDeLoginLayout.setVerticalGroup(
            fundoGradienteBlocoDeLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoGradienteBlocoDeLoginLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        fundoGradienteBlocoMensagemEquipe.setkEndColor(new java.awt.Color(237, 237, 237));
        fundoGradienteBlocoMensagemEquipe.setkStartColor(new java.awt.Color(215, 215, 215));

        kGradientPanel3.setkEndColor(new java.awt.Color(0, 143, 140));
        kGradientPanel3.setkStartColor(new java.awt.Color(41, 198, 196));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Equipe Data Sentry");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("É um prazer tê-lo conosco");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Obrigado pela confiança!");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gostar.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout fundoGradienteBlocoMensagemEquipeLayout = new javax.swing.GroupLayout(fundoGradienteBlocoMensagemEquipe);
        fundoGradienteBlocoMensagemEquipe.setLayout(fundoGradienteBlocoMensagemEquipeLayout);
        fundoGradienteBlocoMensagemEquipeLayout.setHorizontalGroup(
            fundoGradienteBlocoMensagemEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoGradienteBlocoMensagemEquipeLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        fundoGradienteBlocoMensagemEquipeLayout.setVerticalGroup(
            fundoGradienteBlocoMensagemEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoGradienteBlocoMensagemEquipeLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundoGradienteBlocoDeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fundoGradienteBlocoMensagemEquipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoGradienteBlocoDeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fundoGradienteBlocoMensagemEquipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        UserDAO dao = new UserDAO();
      String emailLogin = email.getText();
      String senhaLogin = String.valueOf(senha.getPassword());
      UserModel user = new UserModel();
      user.setEmail(emailLogin);
//      user.setPassword(senhaLogin);
//      user = dao.login(user);

      if (user.getIdUser() != null && user.getIdUser() > 0) {
        System.out.println("Login realizado!");
        InterfacePosLogin logado = new InterfacePosLogin();
        this.dispose();
        logado.setVisible(true);
      } else {
        System.out.println("Login invalido");
        JOptionPane.showMessageDialog(this, emailLogin);
        JOptionPane.showMessageDialog(this, senhaLogin);
      }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

  public static void main(String args[]) {
    String isGraphical = System.getenv().getOrDefault("XDG_CURRENT_DESKTOP", "");
    if (isGraphical == null || isGraphical.equals("") || isGraphical.trim().length() == 0) {
      LoginCli cli = new LoginCli();
      if (cli.hasConsole()) {
        if (cli.welcome()) {
          cli.readEmail();
          cli.readPassword();

          UserDAO userDao = new UserDAO();
          UserModel user = userDao.login(cli.getEmail(), cli.getPass());
          if (user.getFkHospital() != null && user.getFkHospital() > 0) {
            // segue o processo
            postLoginCli(user);
          }
        }
      } else {
        System.out.println("Não tem console");
      }
    } else {
      java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
          new InterfaceLogin().setVisible(true);
        }
      });
    }
  }

    private static void postLoginCli(UserModel user) {
    // set server;
    try {
      ServerDAO serverDAO = new ServerDAO();
      ServerModel server = serverDAO.save(new ServerController().getServer());
      System.out.println("Serial server: " + server.getSerialServer());

      ComponentDAO componentDAO = new ComponentDAO();
      ComponentModel ram = componentDAO.save(new RamControllerStrategy().getComponent(server.getSerialServer()));
      ComponentModel cpu = componentDAO.save(new ProcessadorControllerStrategy().getComponent(server.getSerialServer()));
      List<ComponentModel> discos = new ArrayList<>();
      new DiscoControllerStrategy().getComponents(server.getSerialServer())
              .forEach(d -> {
                try {
                  ComponentModel save = componentDAO.save(d);
                  discos.add(save);
                } catch (Exception e) {
                  System.out.println("Houve algo de errado ao inserir disco.");
                }
              });

      // get processos
      ProcessDAO processDao = new ProcessDAO();
      LogProcessComponentDAO logDao = new LogProcessComponentDAO();
      System.out.println("Monitorando...");
      new ProcessController()
              .getProcessPerMemo()
              .forEach(process -> {
                ProcessModel saveProcess = processDao.saveProcess(process);
                // get logs too
                LogComponentProcess logCpu = new LogComponentProcess(cpu, saveProcess);
                LogComponentProcess logDisco = new LogComponentProcess(discos.get(0), saveProcess);
                LogComponentProcess logRam = new LogComponentProcess(ram, saveProcess);

                logDao.save(logCpu);
                logDao.save(logDisco);
                logDao.save(logRam);
              });

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Houve algo de errado.");
    }
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JTextField email;
    private keeptoo.KGradientPanel fundoGradienteBlocoDeLogin;
    private keeptoo.KGradientPanel fundoGradienteBlocoMensagemEquipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
