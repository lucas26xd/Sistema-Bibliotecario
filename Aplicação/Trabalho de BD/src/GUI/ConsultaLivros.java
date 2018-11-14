package GUI;

import BD.Servicos;
import Classes.livros;
import java.util.ArrayList;

/**
 *
 * @author lucas, arquivo criado dia 08/11/2018 às 00:40:55
 */
public class ConsultaLivros extends javax.swing.JFrame {

    private Servicos serv;
    private livros livros;
    private ArrayList<String> codsCategoria;
    private int index;
    
    public ConsultaLivros(Servicos serv) {
        this.serv = serv;
        livros = new livros(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        codsCategoria = livros.povoaCategorias(cbCategoria);
        
        //index = cbCategoria.getSelectedIndex();
        //livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }

    private ConsultaLivros(){}
    
    public void consulta(){
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        tfISBN = new javax.swing.JTextField();
        tfQntdCopias = new javax.swing.JTextField();
        tfAno = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        tfEditora = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Livros");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Ano", "Editora", "Cópias", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLivros);

        tfISBN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfISBNActionPerformed(evt);
            }
        });

        tfQntdCopias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfQntdCopias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cópias Disponíveis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfQntdCopias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQntdCopiasActionPerformed(evt);
            }
        });

        tfAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano Lançamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAnoActionPerformed(evt);
            }
        });

        tfTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTituloActionPerformed(evt);
            }
        });

        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        tfEditora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfEditora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEditoraActionPerformed(evt);
            }
        });

        tfAutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfAutor)
                        .addGap(18, 18, 18)
                        .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfAno, tfISBN});

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

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        if(evt.getClickCount() >= 2){
            int row = jtLivros.getSelectedRow();
            new CadastroLivros(this, serv, jtLivros.getValueAt(row, 0)+"", jtLivros.getValueAt(row, 1)+"", jtLivros.getValueAt(row, 2)+"", jtLivros.getValueAt(row, 3)+"", jtLivros.getValueAt(row, 4)+"", jtLivros.getValueAt(row, 5)+"").setVisible(true);
        }
    }//GEN-LAST:event_jtLivrosMouseClicked

    private void tfAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAutorActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfAutorActionPerformed

    private void tfISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfISBNActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfISBNActionPerformed

    private void tfQntdCopiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQntdCopiasActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfQntdCopiasActionPerformed

    private void tfAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnoActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfAnoActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        try{
            index = cbCategoria.getSelectedIndex();
            livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
        }catch(NullPointerException npe){}
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void tfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTituloActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfTituloActionPerformed

    private void tfEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditoraActionPerformed
        index = cbCategoria.getSelectedIndex();
        livros.consulta(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
    }//GEN-LAST:event_tfEditoraActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtLivros;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfEditora;
    private javax.swing.JTextField tfISBN;
    private javax.swing.JTextField tfQntdCopias;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}