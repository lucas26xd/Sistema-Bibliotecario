package GUI;

import BD.Servicos;
import Classes.emprestimo;
import Classes.funcoes;
import Classes.livros;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author lucas, arquivo criado dia 08/11/2018 às 00:40:55
 */
//Tela de consulta de livros
public class ConsultaLivros extends javax.swing.JFrame {

    private Servicos serv;
    private livros livros;
    private Emprestimo emp;
    private Reserva res;
    private ArrayList<String> codsCategoria;
    private int index;
    private boolean reserva = false;
    private String usuario_id;

    //construtor de funcionamento normal da tela
    public ConsultaLivros(Servicos serv) {
        this.serv = serv;
        livros = new livros(serv);

        initComponents();
        setLocationRelativeTo(null);

        codsCategoria = livros.povoaCategorias(cbCategoria);

        consulta();
        
        setIcon();
    }

    //construtor que modifica o funcionamento normal caso tenha sido chamada pela emprestimo
    public ConsultaLivros(Emprestimo emp, Servicos serv) {
        this.serv = serv;
        livros = new livros(serv);
        this.emp = emp;

        initComponents();
        setLocationRelativeTo(null);

        codsCategoria = livros.povoaCategorias(cbCategoria);
        
        consulta();
        
        setIcon();
    }
    
    //construtor que modifica o funcionamento normal caso tenha sido chamada pela reserva
    public ConsultaLivros(Reserva res, Servicos serv) {
        this.serv = serv;
        livros = new livros(serv);
        this.res = res;

        initComponents();
        setLocationRelativeTo(null);

        codsCategoria = livros.povoaCategorias(cbCategoria);
        
        consulta();
        
        setIcon();
    }
    
    //construtor que modifica o funcionamento normal caso tenha sido chamada por um usuário comum e esta tela vira uma cadastra reserva
    public ConsultaLivros(Servicos serv, boolean reserva, String usuario_id) {
        this.serv = serv;
        livros = new livros(serv);
        this.reserva = reserva;
        this.usuario_id = usuario_id;
        
        initComponents();
        setLocationRelativeTo(null);

        codsCategoria = livros.povoaCategorias(cbCategoria);
        
        consulta();
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/buscalivros70.png")));
    }
    
    private ConsultaLivros() {}

    public void consulta() {
        try{
            index = cbCategoria.getSelectedIndex();
            livros.consultaView(jtLivros, tfISBN.getText(), tfTitulo.getText(), tfAno.getText(), tfEditora.getText(), tfQntdCopias.getText(), (index == -1 ? "" : codsCategoria.get(index)), tfAutor.getText());
        } catch (NullPointerException npe) {}
    }

    private void limpar(){
        tfISBN.setText("");
        tfAutor.setText("");
        tfAno.setText("");
        tfEditora.setText("");
        tfQntdCopias.setText("");
        tfTitulo.setText("");
        cbCategoria.setSelectedIndex(-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        tfISBN = new javax.swing.JTextField();
        tfQntdCopias = new javax.swing.JTextField();
        tfAno = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        tfEditora = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Livros");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

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

        cbCategoria.setEditable(true);
        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCategoria.setBorder(null);
        cbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbCategoria.setFocusable(false);
        cbCategoria.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                .addGap(24, 24, 24)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104))
                                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(tfTitulo)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfISBN)
                                .addGap(18, 18, 18)
                                .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQntdCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
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

    private void tfAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAutorActionPerformed
        consulta();
    }//GEN-LAST:event_tfAutorActionPerformed

    private void tfISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfISBNActionPerformed
        consulta();
    }//GEN-LAST:event_tfISBNActionPerformed

    private void tfQntdCopiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQntdCopiasActionPerformed
        consulta();
    }//GEN-LAST:event_tfQntdCopiasActionPerformed

    private void tfAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnoActionPerformed
        consulta();
    }//GEN-LAST:event_tfAnoActionPerformed

    private void tfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTituloActionPerformed
        consulta();
    }//GEN-LAST:event_tfTituloActionPerformed

    private void tfEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditoraActionPerformed
        consulta();
    }//GEN-LAST:event_tfEditoraActionPerformed

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        if (evt.getClickCount() >= 2) {
            int row = jtLivros.getSelectedRow();
            if (emp != null) {
                emp.pesquisa(jtLivros.getValueAt(row, 0) + "");
                dispose();
            } else if (res != null) {
                res.pesquisa(jtLivros.getValueAt(row, 0) + "");
                dispose();
            } else if(reserva){
                if(JOptionPane.showConfirmDialog(null, "Deseja realmente reservar este livro?", "Confirmar reserva?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    new emprestimo(serv).cadastraReserva(usuario_id, jtLivros.getValueAt(row, 0) + "", new funcoes().pegaDataAtual());
                    limpar();
                    consulta();
                }
            }else
                new CadastroLivros(this, serv, jtLivros.getValueAt(row, 0) + "", jtLivros.getValueAt(row, 1) + "", jtLivros.getValueAt(row, 2) + "", jtLivros.getValueAt(row, 3) + "", jtLivros.getValueAt(row, 4) + "", jtLivros.getValueAt(row, 7) + "").setVisible(true);
        }
    }//GEN-LAST:event_jtLivrosMouseClicked

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
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
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
