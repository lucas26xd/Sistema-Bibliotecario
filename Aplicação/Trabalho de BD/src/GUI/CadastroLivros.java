package GUI;

import BD.Servicos;
import Classes.livros;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author angela, arquivo criado dia 05/11/2018 às 15:09:56
 */
//Tela de cadastro de livros
public class CadastroLivros extends javax.swing.JFrame {

    private Servicos serv;
    private livros livro;
    private DefaultTableModel mod;
    private ArrayList<String> codCategorias;
    private ConsultaLivros consultaLivros;
    
    //construtor de funcionamento normal da tela
    public CadastroLivros(Servicos serv) {
        this.serv = serv;
        livro = new livros(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        codCategorias = livro.povoaCategorias(cbCategoria);
        mod = (DefaultTableModel) jtAutores.getModel();
        
        setIcon();
    }
    
    //construtor usado para usar a tela como alteração de livros
    public CadastroLivros(ConsultaLivros consultaLivros, Servicos serv, String isbn, String titulo, String ano, String editora, String qtd, String categoria) {
        this.serv = serv;
        livro = new livros(serv);
        this.consultaLivros = consultaLivros;
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Livro");
        btnCadastrar.setText("Alterar");
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png")));
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
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/livros70.png")));
    }
    
    private CadastroLivros(){}

    public void povoaCombo(){
        codCategorias = livro.povoaCategorias(cbCategoria);
    }
    
    public void adicionaAutor(String nome, String cpf, String nacionalidade){
        boolean b = true;
        for (int i = 0; i < jtAutores.getRowCount(); i++) {
            if (jtAutores.getValueAt(i, 1).equals(cpf))
                b = false;
        }
        if (b)
            mod.addRow(new Object[]{nome, cpf, nacionalidade});
        else
            JOptionPane.showMessageDialog(null, "Autor já está na lista de autores cadastrados!", "Autor já na lista!", JOptionPane.WARNING_MESSAGE);
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
        cbCategoria.setSelectedIndex(-1);
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
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

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
        tfQntdCopias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cópias no Acervo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tfISBN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfISBNKeyReleased(evt);
            }
        });

        tfAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano Lançamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ok30.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnMais.setBackground(new java.awt.Color(255, 255, 255));
        btnMais.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMais.setForeground(new java.awt.Color(0, 51, 51));
        btnMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
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
        btnMenos.setForeground(new java.awt.Color(0, 51, 51));
        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover30.png"))); // NOI18N
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
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenos)))
                .addGap(11, 11, 11))
        );

        btnMaisCategoria.setBackground(new java.awt.Color(255, 255, 255));
        btnMaisCategoria.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMaisCategoria.setForeground(new java.awt.Color(0, 51, 51));
        btnMaisCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        btnMaisCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisCategoriaActionPerformed(evt);
            }
        });

        cbCategoria.setEditable(true);
        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategoria.setBorder(null);
        cbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbCategoria.setFocusable(false);
        cbCategoria.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Categoria");

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
                        .addComponent(btnCadastrar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfISBN)
                        .addGap(18, 18, 18)
                        .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfTitulo)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaisCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addGap(13, 13, 13)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaisCategoria))
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addContainerGap(19, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfISBNKeyReleased
        if (tfISBN.getText().length() > 13)
            tfISBN.setText(tfISBN.getText().substring(0, 13));
    }//GEN-LAST:event_tfISBNKeyReleased

   
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
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
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