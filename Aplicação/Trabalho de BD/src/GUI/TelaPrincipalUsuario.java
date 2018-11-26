package GUI;

import BD.Servicos;
import Classes.funcoes;
import Classes.usuario;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * @author lucas, arquivo criado dia 23/11/2018 às 13:56:14
 */

/**
 * Tela Principal do usuário comum (aluno, professor, funcionário) do sistema, onde contém todos 
 * os botões que dão acesso as telas do sistema que são permitido o acesso à estes tipos de usuário.
 */
public class TelaPrincipalUsuario extends javax.swing.JFrame {

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
    
    public TelaPrincipalUsuario(Servicos serv, String usuario_id) {
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
    
    private TelaPrincipalUsuario(){}
    
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
        conssultaReserva = new javax.swing.JMenuItem();
        professores = new javax.swing.JMenuItem();
        livros = new javax.swing.JMenuItem();
        emprestimos = new javax.swing.JMenuItem();
        configuracao = new javax.swing.JMenu();
        configUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        biblioteca.setForeground(new java.awt.Color(0, 10, 85));
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

        conssultaReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        conssultaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscareserva30.png"))); // NOI18N
        conssultaReserva.setText("Consultar suas Reservas");
        conssultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conssultaReservaActionPerformed(evt);
            }
        });
        biblioteca.add(conssultaReserva);

        professores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        professores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscausuario30.png"))); // NOI18N
        professores.setText("Consulta Professores");
        professores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professoresActionPerformed(evt);
            }
        });
        biblioteca.add(professores);

        livros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        livros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscalivros30.png"))); // NOI18N
        livros.setText("Consulta Livros");
        livros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livrosActionPerformed(evt);
            }
        });
        biblioteca.add(livros);

        emprestimos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        emprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaemprestimo30.png"))); // NOI18N
        emprestimos.setText("Consulta seus Empréstimos");
        emprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestimosActionPerformed(evt);
            }
        });
        biblioteca.add(emprestimos);

        barra_menu.add(biblioteca);

        configuracao.setForeground(new java.awt.Color(0, 10, 85));
        configuracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/config.png"))); // NOI18N
        configuracao.setText("Configurações");
        configuracao.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        configUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Sair?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
            new TelaLogin(serv).setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservaActionPerformed
        new ConsultaLivros(serv, true, usuario_id).setVisible(true);
    }//GEN-LAST:event_reservaActionPerformed

    private void configUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configUserActionPerformed
        new CadastroUsuario(serv, usuario_id).setVisible(true);
    }//GEN-LAST:event_configUserActionPerformed

    private void professoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professoresActionPerformed
        new ConsultaProfbyCurso(serv).setVisible(true);
    }//GEN-LAST:event_professoresActionPerformed

    private void livrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livrosActionPerformed
        new ConsultaViewLivros(serv).setVisible(true);
    }//GEN-LAST:event_livrosActionPerformed

    private void emprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestimosActionPerformed
        ConsultaEmprestimo ce = new ConsultaEmprestimo(serv);
        ce.setaUsuarioID(usuario_id);
        ce.setVisible(true);
    }//GEN-LAST:event_emprestimosActionPerformed

    private void conssultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conssultaReservaActionPerformed
        ConsultaReserva cr = new ConsultaReserva(serv);
        cr.setaUsuarioID(usuario_id);
        cr.setVisible(true);
    }//GEN-LAST:event_conssultaReservaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalUsuario().setVisible(true);
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
    private javax.swing.JMenuItem conssultaReserva;
    private javax.swing.JMenuItem emprestimos;
    private javax.swing.JLabel img;
    private javax.swing.JMenuItem livros;
    private javax.swing.JPanel painel;
    private javax.swing.JMenuItem professores;
    private javax.swing.JMenuItem reserva;
    // End of variables declaration//GEN-END:variables
}