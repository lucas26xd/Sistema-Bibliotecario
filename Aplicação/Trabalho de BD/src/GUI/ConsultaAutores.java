package GUI;

import BD.Servicos;
import Classes.autores;
import java.awt.Toolkit;

/**
 * @author lucas, arquivo criado dia 07/11/2018 às 21:13:44
 */
//Tela de consulta de autores
public class ConsultaAutores extends javax.swing.JFrame {

    private Servicos serv;
    private autores autores;    
    private CadastroLivros Livros;
    
    //construtor de funcionamento normal da tela
    public ConsultaAutores(Servicos serv) {
        this.serv = serv;
        autores = new autores(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
        
        setIcon();
    }
    
    //construtor usado para modificar o funcionamento quando essa tela é chamada pela tela de cadastro de livros
    public ConsultaAutores(Servicos serv, CadastroLivros Livros) {
        this.serv = serv;
        autores = new autores(serv);
        this.Livros = Livros;
        
        initComponents();
        setLocationRelativeTo(null);
        
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/buscaautor70.png")));
    }
    
    private ConsultaAutores(){}
    
    public void consulta(){
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAutores = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        tfNacionalidade = new javax.swing.JTextField();
        btnCadastrarAutor = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Autores");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        jtAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Nacionalidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAutores);

        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        tfCPF.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfCPF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });

        tfNacionalidade.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNacionalidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nacionalidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNacionalidadeActionPerformed(evt);
            }
        });

        btnCadastrarAutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        btnCadastrarAutor.setText("Cadastrar Autor");
        btnCadastrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAutorActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrarAutor)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarAutor)
                    .addComponent(btnVoltar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAutoresMouseClicked
        if(evt.getClickCount() >= 2){
            int row = jtAutores.getSelectedRow();
            if(Livros != null){
                Livros.adicionaAutor(jtAutores.getValueAt(row, 0)+"", jtAutores.getValueAt(row, 1)+"", jtAutores.getValueAt(row, 2)+"");
                dispose();
            }else
                new CadastroAutores(serv, jtAutores.getValueAt(row, 0)+"", jtAutores.getValueAt(row, 1)+"", jtAutores.getValueAt(row, 2)+"").setVisible(true);
        }
    }//GEN-LAST:event_jtAutoresMouseClicked

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
    }//GEN-LAST:event_tfCPFActionPerformed

    private void tfNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNacionalidadeActionPerformed
        autores.consulta(jtAutores, tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
    }//GEN-LAST:event_tfNacionalidadeActionPerformed

    private void btnCadastrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAutorActionPerformed
        new CadastroAutores(serv, this).setVisible(true);
    }//GEN-LAST:event_btnCadastrarAutorActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaAutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAutor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAutores;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}