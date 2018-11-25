package GUI;

import BD.Servicos;
import Classes.buscarbyViews;
import java.awt.Toolkit;

/**
 *
 * @author lucas, arquivo criado dia 24/11/2018 às 14:55:12
 */
public class ConsultaViewLivros extends javax.swing.JFrame {

    private Servicos serv;
    private buscarbyViews views;
    
    public ConsultaViewLivros(Servicos serv) {
        this.serv = serv;
        
        views = new buscarbyViews(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        views.povoaCombo(cbCategoria, "SELECT descricao FROM categorias;");
        cbCategoria.setSelectedIndex(-1);
        
        consulta();
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/buscalivros70.png")));
    }
    
    private ConsultaViewLivros(){}
    
    private void consulta(){
        String view = "";
        if (rbCategoria.isSelected())
            view = "viewLivrosbyCategoria";
        else if (rbAno.isSelected())
            view = "viewLivrosbyAno";
        else if (rbEditora.isSelected())
            view = "viewLivrosbyEditora";
        else if (rbAutor.isSelected())
            view = "viewLivrosbyAutor";
        String categoria = (cbCategoria.getSelectedItem() == null ? "" : cbCategoria.getSelectedItem())+"";
        views.LivrosbyX(view, jtLivros, tfEditora.getText(), categoria);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogrupo = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        tfEditora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rbCategoria = new javax.swing.JRadioButton();
        rbEditora = new javax.swing.JRadioButton();
        rbAno = new javax.swing.JRadioButton();
        rbAutor = new javax.swing.JRadioButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Livros");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfEditora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfEditora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tfEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEditoraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Categoria");

        cbCategoria.setEditable(true);
        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategoria.setBorder(null);
        cbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbCategoria.setFocusable(false);
        cbCategoria.setName(""); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Ano", "Editora", "Cópias", "Emprestados", "Reservas", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtLivros);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agrupar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        rbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        radiogrupo.add(rbCategoria);
        rbCategoria.setSelected(true);
        rbCategoria.setText("Categoria");
        rbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCategoriaMouseClicked(evt);
            }
        });

        rbEditora.setBackground(new java.awt.Color(255, 255, 255));
        radiogrupo.add(rbEditora);
        rbEditora.setText("Editora");
        rbEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEditoraMouseClicked(evt);
            }
        });

        rbAno.setBackground(new java.awt.Color(255, 255, 255));
        radiogrupo.add(rbAno);
        rbAno.setText("Ano de Publicação");
        rbAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAnoMouseClicked(evt);
            }
        });

        rbAutor.setBackground(new java.awt.Color(255, 255, 255));
        radiogrupo.add(rbAutor);
        rbAutor.setText("Autor");
        rbAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAutorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(rbCategoria)
                .addGap(60, 60, 60)
                .addComponent(rbEditora)
                .addGap(60, 60, 60)
                .addComponent(rbAno)
                .addGap(60, 60, 60)
                .addComponent(rbAutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCategoria)
                    .addComponent(rbEditora)
                    .addComponent(rbAno)
                    .addComponent(rbAutor))
                .addContainerGap())
        );

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
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnVoltar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void tfEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditoraActionPerformed
        consulta();
    }//GEN-LAST:event_tfEditoraActionPerformed

    private void rbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCategoriaMouseClicked
        consulta();
    }//GEN-LAST:event_rbCategoriaMouseClicked

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        consulta();
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void rbEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEditoraMouseClicked
        consulta();
    }//GEN-LAST:event_rbEditoraMouseClicked

    private void rbAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAnoMouseClicked
        consulta();
    }//GEN-LAST:event_rbAnoMouseClicked

    private void rbAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAutorMouseClicked
        consulta();
    }//GEN-LAST:event_rbAutorMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaViewLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaViewLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaViewLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaViewLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaViewLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtLivros;
    private javax.swing.JPanel painel;
    private javax.swing.ButtonGroup radiogrupo;
    private javax.swing.JRadioButton rbAno;
    private javax.swing.JRadioButton rbAutor;
    private javax.swing.JRadioButton rbCategoria;
    private javax.swing.JRadioButton rbEditora;
    private javax.swing.JTextField tfEditora;
    // End of variables declaration//GEN-END:variables
}