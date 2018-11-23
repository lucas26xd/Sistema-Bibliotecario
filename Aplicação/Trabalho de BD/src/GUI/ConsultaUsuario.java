package GUI;

import BD.Servicos;
import Classes.usuario;

/**
 *
 * @author lucas, arquivo criado dia 15/11/2018 às 20:07:33
 */
public class ConsultaUsuario extends javax.swing.JFrame {

    private Servicos serv;
    private usuario user;
    private Emprestimo emp;
    
    public ConsultaUsuario(Emprestimo emp, Servicos serv) {
        this.serv = serv;
        user = new usuario(serv);
        this.emp = emp;
        
        initComponents();
        setLocationRelativeTo(null);
        
        user.consulta(jtUsuario, tfNome.getText(), cbTipo.getSelectedItem()+"");
    }
    
    public ConsultaUsuario(Servicos serv) {
        this.serv = serv;
        user = new usuario(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        user.consulta(jtUsuario, tfNome.getText(), cbTipo.getSelectedItem()+"");
    }

    private ConsultaUsuario(){}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        cbTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Usuário");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Login", "Endereço", "Tipo de Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuario.setToolTipText("");
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

        cbTipo.setBackground(new java.awt.Color(255, 255, 255));
        cbTipo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Professor", "Funcionários" }));
        cbTipo.setSelectedIndex(-1);
        cbTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfNome)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNome)
                    .addComponent(cbTipo))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        user.consulta(jtUsuario, tfNome.getText(), cbTipo.getSelectedItem()+"");
    }//GEN-LAST:event_cbTipoItemStateChanged

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        user.consulta(jtUsuario, tfNome.getText(), cbTipo.getSelectedItem()+"");
    }//GEN-LAST:event_tfNomeActionPerformed

    private void jtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuarioMouseClicked
        if(evt.getClickCount() >= 2){
            int row = jtUsuario.getSelectedRow();
            if(emp != null){
                emp.setaValoresUsuario(user.pegaID(jtUsuario.getValueAt(row, 1)+""), jtUsuario.getValueAt(row, 0)+"", jtUsuario.getValueAt(row, 3)+"");
                dispose();
            }
        }
    }//GEN-LAST:event_jtUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}