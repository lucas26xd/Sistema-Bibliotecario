package GUI;

import BD.Servicos;
import Classes.livros;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel, arquivo criado dia 05/11/2018 às 15:09:56
 */
public class CadastroLivros extends javax.swing.JFrame {

    private Servicos serv;
    private livros livro;
    private DefaultTableModel mod;
    private ArrayList<String> codCategorias;
    private ConsultaLivros consultaLivros;
    
    public CadastroLivros(Servicos serv) {
        this.serv = serv;
        livro = new livros(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        codCategorias = livro.povoaCategorias(cbCategoria);
        mod = (DefaultTableModel) jtAutores.getModel();
    }
    
    public CadastroLivros(ConsultaLivros consultaLivros, Servicos serv, String isbn, String titulo, String ano, String editora, String qtd, String categoria) {
        this.serv = serv;
        livro = new livros(serv);
        this.consultaLivros = consultaLivros;
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Livro");
        btnCadastrar.setText("Alterar");
        tfISBN.setText(isbn);
        tfISBN.setEditable(false);
        tfEditora.setText(editora);
        tfQntdCopias.setText(qtd);
        tfTitulo.setText(titulo);
        tfAno.setText(ano);
        
        povoaCombo();
        mod = (DefaultTableModel) jtAutores.getModel();
        
        cbCategoria.setSelectedItem(categoria);
        livro.consultaAutoresdosLivros(jtAutores, isbn);
    }

    private CadastroLivros(){}

    public void povoaCombo(){
        codCategorias = livro.povoaCategorias(cbCategoria);
    }
    
    public void adicionaAutor(String nome, String cpf, String nacionalidade){
        mod.addRow(new Object[]{nome, cpf, nacionalidade});
    }
   
    private void apagaLinhaAutor(){
        try{
            mod.removeRow(mod.getRowCount()-1);
        }catch(IndexOutOfBoundsException ioob){}
    }
    
    private void limpar(){
        tfAno.setText("");
        tfEditora.setText("");
        tfISBN.setText("");
        tfQntdCopias.setText("");
        tfTitulo.setText("");
        mod.setNumRows(0);
    }
    
    private boolean camposPreenchidos(){
        if(tfISBN.getText().length() == 0 && tfQntdCopias.getText().length() == 0 &&
            tfTitulo.getText().length() == 0 && tfEditora.getText().length() == 0 &&
            tfAno.getText().length() == 0 && cbCategoria.getSelectedIndex() == -1 &&
            jtAutores.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Preencha todos campos obrigatórios!", "Campos não preenchidos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfTitulo = new javax.swing.JTextField();
        tfEditora = new javax.swing.JTextField();
        tfQntdCopias = new javax.swing.JTextField();
        tfISBN = new javax.swing.JTextField();
        tfAno = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnMais = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAutores = new javax.swing.JTable();
        btnMenos = new javax.swing.JButton();
        btnMaisCategoria = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Livros");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfEditora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfEditora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfQntdCopias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfQntdCopias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qtd. de Cópias no Acervo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfISBN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano Lançamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnMais.setBackground(new java.awt.Color(255, 255, 255));
        btnMais.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMais.setForeground(new java.awt.Color(0, 255, 0));
        btnMais.setText("+");
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jtAutores);

        btnMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnMenos.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        btnMenos.setForeground(new java.awt.Color(255, 0, 0));
        btnMenos.setText("-");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMais)
                    .addComponent(btnMenos))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMais, btnMenos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMais, btnMenos});

        btnMaisCategoria.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMaisCategoria.setText("+");
        btnMaisCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisCategoriaActionPerformed(evt);
            }
        });

        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(22, 22, 22))
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMaisCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTitulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                                .addComponent(tfISBN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaisCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfEditora, tfISBN, tfQntdCopias, tfTitulo});

        tfEditora.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        apagaLinhaAutor();
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed
        new ConsultaAutores(serv, this).setVisible(true);
    }//GEN-LAST:event_btnMaisActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(camposPreenchidos()){    
            if(btnCadastrar.getText().equals("Alterar")){
                livro.altera(tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), codCategorias.get(cbCategoria.getSelectedIndex()), jtAutores);
                dispose();
                consultaLivros.consulta();
            }else
                livro.cadastra(tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), codCategorias.get(cbCategoria.getSelectedIndex()), jtAutores);
            limpar();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnMaisCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisCategoriaActionPerformed
        new CadastroCategorias(this, serv).setVisible(true);
    }//GEN-LAST:event_btnMaisCategoriaActionPerformed

   
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
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMaisCategoria;
    private javax.swing.JButton btnMenos;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAutores;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfEditora;
    private javax.swing.JTextField tfISBN;
    private javax.swing.JTextField tfQntdCopias;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}