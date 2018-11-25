package GUI;

import BD.Servicos;
import Classes.autores;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * @author lucas, arquivo criado dia 05/11/2018 às 14:44:44
 */

//Tela de cadastro de autores
public class CadastroAutores extends javax.swing.JFrame {

    private Servicos serv;
    private autores autores;
    private ConsultaAutores ca;
    
    //construtor de funcionamento padrão
    public CadastroAutores(Servicos serv) {
        this.serv = serv;
        
        autores = new autores(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setIcon();
    }
    
    //construtor caso tenha sido chamado pelo consulta autores
    public CadastroAutores(Servicos serv, ConsultaAutores ca) {
        this.serv = serv;
        this.ca = ca;
        
        autores = new autores(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setIcon();
    }
    
    //construtor usado para modificar a instancia da tela e usá-la como alteração de autores
    public CadastroAutores(Servicos serv, String nome, String cpf, String nacionalidade) {
        this.serv = serv;
        
        autores = new autores(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Autor");
        btn.setText("Alterar");
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png")));
        tfNome.setText(nome);
        tfCPF.setText(cpf);
        tfCPF.setEditable(false);
        tfNacionalidade.setText(nacionalidade);
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/autor70.png")));
    }
    
    private CadastroAutores(){}
    
    private boolean camposPreenchidos(){
        if(tfCPF.getText().length() == 0 && tfNacionalidade.getText().length() == 0 &&
            tfNome.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Preencha todos campos obrigatórios!", "Campos não preenchidos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        tfNacionalidade = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Autores");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btn.setBackground(new java.awt.Color(255, 255, 255));
        btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ok30.png"))); // NOI18N
        btn.setText("Cadastrar");
        btn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        tfNacionalidade.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNacionalidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nacionalidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfCPF.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfCPF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

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
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn))
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        if(camposPreenchidos()){    
            if(btn.getText().equals("Alterar"))
                autores.altera(tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());               
            else
                autores.cadastra(tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
            if(ca != null)
                ca.consulta();
            dispose();
        }
    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}