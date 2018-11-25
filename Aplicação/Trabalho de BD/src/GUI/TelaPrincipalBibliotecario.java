package GUI;

import BD.Servicos;
import Classes.funcoes;
import Classes.usuario;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas, arquivo criado dia 24/11/2018 às 10:36:02
 */
public class TelaPrincipalBibliotecario extends javax.swing.JFrame {

    private Servicos serv;
    private String nome = "", usuario_id;
    private usuario u;
    
    private Thread t = new Thread(){
        funcoes f = new funcoes();
        public void run(){
            while (true){
                String data = f.pegaDataAtual();
                String hora = f.pegaHoraAtual();
                String mes = data.substring(data.indexOf("/") + 1, data.length() - 5);
                switch(mes){
                    case "01": mes = "Janeiro de "; break;
                    case "02": mes = "Fevereiro de "; break;
                    case "03": mes = "Março de "; break;
                    case "04": mes = "Abril de "; break;
                    case "05": mes = "Maio de "; break;
                    case "06": mes = "Junho de "; break;
                    case "07": mes = "Julho de "; break;
                    case "08": mes = "Agosto de "; break;
                    case "09": mes = "Setembro de "; break;
                    case "10": mes = "Outubro de "; break;
                    case "11": mes = "Novembro de "; break;
                    case "12": mes = "Dezembro de "; break;
                }
                boasVindas.setText("Seja Bem Vindo " + nome + "! Hoje é dia " + data.substring(0, data.indexOf("/")) + " de " + mes + data.substring(data.length() - 4) + ", " + hora);
            }
        }
    };    
    
    public TelaPrincipalBibliotecario(Servicos serv, String usuario_id) {
        this.serv = serv;
        this.usuario_id = usuario_id;
        
        u = new usuario(serv);
        nome = u.pegaNome(usuario_id);
        
        initComponents();
        setLocationRelativeTo(null);
        
        t.start();
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/principal.png")));
    }
    
    private TelaPrincipalBibliotecario(){}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        boasVindas = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        barra_menu = new javax.swing.JMenuBar();
        biblioteca = new javax.swing.JMenu();
        reserva = new javax.swing.JMenuItem();
        consultaReserva = new javax.swing.JMenuItem();
        separador1 = new javax.swing.JPopupMenu.Separator();
        livros = new javax.swing.JMenuItem();
        usuario = new javax.swing.JMenuItem();
        separador2 = new javax.swing.JPopupMenu.Separator();
        emprestimos = new javax.swing.JMenuItem();
        consultaEmprestimos = new javax.swing.JMenuItem();
        configuracao = new javax.swing.JMenu();
        configUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logout30.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        boasVindas.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        boasVindas.setText("Seja Bem Vindo abcdef ghijk! Hoje é dia 22 de Novembro de 2018, 14:05:13");

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/telaprincipal.jpg"))); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(boasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addComponent(boasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        biblioteca.setForeground(new java.awt.Color(255, 255, 255));
        biblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/livros.png"))); // NOI18N
        biblioteca.setText("Biblioteca");
        biblioteca.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        reserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reserva30.png"))); // NOI18N
        reserva.setText("Realizar Reserva");
        reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservaActionPerformed(evt);
            }
        });
        biblioteca.add(reserva);

        consultaReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        consultaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reserva30.png"))); // NOI18N
        consultaReserva.setText("Consulta de Reserva");
        consultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaReservaActionPerformed(evt);
            }
        });
        biblioteca.add(consultaReserva);
        biblioteca.add(separador1);

        livros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        livros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscalivros30.png"))); // NOI18N
        livros.setText("Consultar Livros");
        livros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livrosActionPerformed(evt);
            }
        });
        biblioteca.add(livros);

        usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/usuario30.png"))); // NOI18N
        usuario.setText("Cadastro de Usuário");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        biblioteca.add(usuario);
        biblioteca.add(separador2);

        emprestimos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        emprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo30.png"))); // NOI18N
        emprestimos.setText("Fazer Empréstimos");
        emprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestimosActionPerformed(evt);
            }
        });
        biblioteca.add(emprestimos);

        consultaEmprestimos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        consultaEmprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo30.png"))); // NOI18N
        consultaEmprestimos.setText("Consultar Empréstimos");
        consultaEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaEmprestimosActionPerformed(evt);
            }
        });
        biblioteca.add(consultaEmprestimos);

        barra_menu.add(biblioteca);

        configuracao.setForeground(new java.awt.Color(255, 255, 255));
        configuracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/config.png"))); // NOI18N
        configuracao.setText("Configurações");
        configuracao.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        configUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        configUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.jpg"))); // NOI18N
        configUser.setText("Configurações de Usuário");
        configUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configUserActionPerformed(evt);
            }
        });
        configuracao.add(configUser);

        barra_menu.add(configuracao);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservaActionPerformed
        new Reserva(serv).setVisible(true);
    }//GEN-LAST:event_reservaActionPerformed

    private void configUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configUserActionPerformed
        new CadastroUsuario(serv, usuario_id).setVisible(true);
    }//GEN-LAST:event_configUserActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Sair?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
            new TelaLogin(serv).setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void livrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livrosActionPerformed
        new ConsultaViewLivros(serv).setVisible(true);
    }//GEN-LAST:event_livrosActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        new CadastroUsuario(serv).setVisible(true);
    }//GEN-LAST:event_usuarioActionPerformed

    private void emprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestimosActionPerformed
        new Emprestimo(serv).setVisible(true);
    }//GEN-LAST:event_emprestimosActionPerformed

    private void consultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaReservaActionPerformed
        new ConsultaReserva(serv).setVisible(true);
    }//GEN-LAST:event_consultaReservaActionPerformed

    private void consultaEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaEmprestimosActionPerformed
        new ConsultaEmprestimo(serv).setVisible(true);
    }//GEN-LAST:event_consultaEmprestimosActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalBibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JMenu biblioteca;
    private javax.swing.JLabel boasVindas;
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenuItem configUser;
    private javax.swing.JMenu configuracao;
    private javax.swing.JMenuItem consultaEmprestimos;
    private javax.swing.JMenuItem consultaReserva;
    private javax.swing.JMenuItem emprestimos;
    private javax.swing.JLabel img;
    private javax.swing.JMenuItem livros;
    private javax.swing.JPanel painel;
    private javax.swing.JMenuItem reserva;
    private javax.swing.JPopupMenu.Separator separador1;
    private javax.swing.JPopupMenu.Separator separador2;
    private javax.swing.JMenuItem usuario;
    // End of variables declaration//GEN-END:variables
}