package GUI;

import BD.Servicos;
import Classes.bibliotecario;
import javax.swing.JOptionPane;

/**
 *
 * @author angel, arquivo criado dia 05/11/2018 às 15:50:33
 */
public class CadastroBibliotecario extends javax.swing.JFrame {

    private Servicos serv;
    private bibliotecario bib;
    private ConsultaBibliotecario cb;
    
    public CadastroBibliotecario(Servicos serv) {
        this.serv = serv;
        bib = new bibliotecario(serv);        
        
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CadastroBibliotecario(Servicos serv, String usuario_id){
        this.serv = serv;
        
        bib = new bibliotecario(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Config. de Usuário");
        Cadastrar.setText("Alterar");
        Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png")));
        
        bib.consulta(usuario_id, tfNome, tfEndereco, tfLogin);
        tfLogin.setEditable(false);
    }
    
    public CadastroBibliotecario(Servicos serv, ConsultaBibliotecario cb, String login, String nome, String endereco){
        this.serv = serv;
        this.cb = cb;
        
        bib = new bibliotecario(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Bibliotecário");
        
        Cadastrar.setText("Alterar");
        Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png")));
        tfLogin.setText(login);
        tfLogin.setEditable(false);
        tfNome.setText(nome);
        tfEndereco.setText(endereco);
    }
    
    private CadastroBibliotecario(){}
    
    private void limpar(){
        tfLogin.setText("");
        pfSenha.setText("");
        tfNome.setText("");
        tfEndereco.setText("");        
    }
    
    private boolean camposPreenchidos(){
        if(tfLogin.getText().length() == 0 && pfSenha.getText().length() == 0 &&
            tfNome.getText().length() == 0 && tfEndereco.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Campos não preenchidos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfLogin = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        Cadastrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Bibliotecários");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        pfSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pfSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        Cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        Cadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ok30.png"))); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cadastrar)
                    .addComponent(btnVoltar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

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

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        if(camposPreenchidos()){    
            if(Cadastrar.getText().equals("Alterar"))
                bib.altera(tfLogin.getText(), pfSenha.getText(), tfNome.getText(), tfEndereco.getText());               
            else
                bib.cadastra(tfLogin.getText(), tfNome.getText(), tfEndereco.getText(), pfSenha.getText());
            if (cb != null)
                cb.consulta();
            dispose();
        }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
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
            java.util.logging.Logger.getLogger(CadastroBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroBibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel painel;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}