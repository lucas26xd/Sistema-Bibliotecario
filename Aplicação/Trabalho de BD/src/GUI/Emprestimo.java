package GUI;

import BD.Servicos;
import Classes.emprestimo;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas, arquivo criado dia 15/11/2018 às 17:44:16
 */
public class Emprestimo extends javax.swing.JFrame {

    private Servicos serv;
    private emprestimo emp;
    private String usuario_id;
    
    public Emprestimo(Servicos serv) {
        this.serv = serv;
        emp = new emprestimo(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        tfData.setText(emp.pega_Data());
    }

    private Emprestimo(){}
    
    public void setaValoresUsuario(String user_id, String nome, String tipo){
        tfNome.setText(nome);
        tfTipo.setText(tipo);
        usuario_id = user_id;
        tfDataEntrega.setText(emp.calculaDataEntrega(usuario_id, tfData.getText()));
        
        if(emp.qtdLivrosDisponiveis(tfISBN.getText()) <= emp.qtdReserva(tfISBN.getText())){
            if(!emp.noRanking(usuario_id, tfISBN.getText(), tfQtdDisponiveis.getText())){
                JOptionPane.showMessageDialog(null, "Este livro não pode ser emprestado para este usuário, pois o mesmo já foi reservado por outros alunos primeiro!", "Livro já foi reservado", JOptionPane.ERROR_MESSAGE);
                if(!emp.usuarioReservou(usuario_id, tfISBN.getText())){
                    if(JOptionPane.showConfirmDialog(null, "Deseja realizar a reservar este livro "+tfNome.getText()+"?") == JOptionPane.OK_OPTION)
                        emp.cadastraReserva(usuario_id, tfISBN.getText(), tfData.getText());
                }
            }
        }
    }
    
    public void pesquisa(String isbn){
        tfISBN.setText(isbn);
        if(tfISBN.getText().length() == 13){
            tfTitulo.setText(emp.tituloLivro(tfISBN.getText()));
            tfQtdDisponiveis.setText(emp.qtdLivrosDisponiveis(tfISBN.getText())+"");
        }
        tfNome.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfISBN = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        tfQtdDisponiveis = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfTipo = new javax.swing.JTextField();
        tfDataEntrega = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        tfData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empréstimo de Livros");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        tfISBN.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfISBNActionPerformed(evt);
            }
        });

        tfTitulo.setEditable(false);
        tfTitulo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfTituloMouseClicked(evt);
            }
        });

        tfQtdDisponiveis.setEditable(false);
        tfQtdDisponiveis.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfQtdDisponiveis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disponíveis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfNome.setEditable(false);
        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfNome.setEnabled(false);
        tfNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfNomeMouseClicked(evt);
            }
        });

        tfTipo.setEditable(false);
        tfTipo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfDataEntrega.setEditable(false);
        tfDataEntrega.setBackground(new java.awt.Color(255, 255, 255));
        tfDataEntrega.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfDataEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        tfData.setEditable(false);
        tfData.setBackground(new java.awt.Color(255, 255, 255));
        tfData.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfQtdDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastrar)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(tfDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQtdDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar)
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

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(tfDataEntrega.getText().length() > 0)
            if(!tfQtdDisponiveis.equals("0")){
                if(emp.qtdLivrosDisponiveis(tfISBN.getText())> emp.qtdReserva(tfISBN.getText())){
                    emp.cadastra(usuario_id, tfISBN.getText(), tfData.getText(), tfDataEntrega.getText());
                    if(emp.usuarioReservou(usuario_id, tfISBN.getText()))
                        emp.atendeReserva(usuario_id, tfISBN.getText());
                }else{
                    if(emp.noRanking(usuario_id, tfISBN.getText(), tfQtdDisponiveis.getText())){
                        emp.cadastra(usuario_id, tfISBN.getText(), tfData.getText(), tfDataEntrega.getText());
                        emp.atendeReserva(usuario_id, tfISBN.getText());
                    }else{
                        JOptionPane.showMessageDialog(null, "Este livro não pode ser emprestado para este usuário, pois o mesmo já foi reservado por outros alunos primeiro!", "Livro já foi reservado", JOptionPane.ERROR_MESSAGE);
                        if(!emp.usuarioReservou(usuario_id, tfISBN.getText())){
                            if(JOptionPane.showConfirmDialog(null, "Deseja realizar a reservar este livro "+tfNome.getText()+"?") == JOptionPane.OK_OPTION)
                                emp.cadastraReserva(usuario_id, tfISBN.getText(), tfData.getText());
                        }
                    }
                }
            }else
                JOptionPane.showMessageDialog(null, "Este livro não pode ser emprestado, pois não há nenhum exemplar disponível!", "Livro já foi reservado", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!", "Campos Obrigatórios", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tfISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfISBNActionPerformed
        pesquisa(tfISBN.getText());
    }//GEN-LAST:event_tfISBNActionPerformed

    private void tfNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNomeMouseClicked
        if(tfNome.isEnabled())
            new ConsultaUsuario(this, serv).setVisible(true);
    }//GEN-LAST:event_tfNomeMouseClicked

    private void tfTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfTituloMouseClicked
        new ConsultaLivros(this, serv).setVisible(true);
    }//GEN-LAST:event_tfTituloMouseClicked

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
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfDataEntrega;
    private javax.swing.JTextField tfISBN;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfQtdDisponiveis;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}