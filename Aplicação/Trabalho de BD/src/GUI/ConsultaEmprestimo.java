package GUI;

import BD.Servicos;
import Classes.emprestimo;
import Classes.funcoes;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author lucas, arquivo criado dia 24/11/2018 às 23:51:07
 */
//Tela de consulta de empréstimos
public class ConsultaEmprestimo extends javax.swing.JFrame {

    private Servicos serv;
    private emprestimo emp;
    private funcoes f = new funcoes();
    private String usuario_id = "";
    private boolean podeDarBaixa = false;
    private ArrayList<String> usuarios_ids;
    
    //construtor de funcionamento normal da tela
    public ConsultaEmprestimo(Servicos serv) {
        this.serv = serv;
        emp = new emprestimo(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setDatas();
        
        setIcon();
        
        //consulta();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/buscaemprestimo70.png")));
    }
    
    public void setaUsuarioID(String usuario_id){
        this.usuario_id = usuario_id;
        consulta();
    }
    
    public void podeDarBaixa(){
        podeDarBaixa = true;
    }
    
    private ConsultaEmprestimo(){}
    
    private void consulta(){
        String cond = "", entregue = "", sql = "SELECT id, isbn, titulo, nome, data, data_entrega, entregue "
                                                + "FROM ((emprestimo JOIN livros ON isbn = isbn_livro) "
                                                + "JOIN usuarios ON usuarios_id = id)";
        
        if (cbSim.isSelected() && !cbNao.isSelected())
            entregue += "AND entregue = 'Sim'";
        else if (cbNao.isSelected() && !cbSim.isSelected())
            entregue += "AND entregue = 'Não'";
        else if (cbSim.isSelected() && cbNao.isSelected())
            entregue += " AND (entregue = 'Sim' OR entregue = 'Não')";
        
        cond = "data BETWEEN '" + dataFormatada(tfDataInicial) + "' AND '" + dataFormatada(tfDataFinal) + "' AND "
                + "titulo LIKE '%" + tfTitulo.getText() + "%' AND nome LIKE '%" + tfNome.getText() + "%' AND isbn LIKE '" + tfISBN.getText() + "%'";
        
        if (!usuario_id.equals(""))
            entregue += " AND id = '" + usuario_id + "'";
        sql += " WHERE " + cond + entregue + " GROUP BY entregue, isbn, titulo, nome, data, data_entrega;";
        
        usuarios_ids = emp.consultar(jtEmprestimo, sql);
    }
    
    private void setDatas(){
        String data = f.pegaDataAtual(),
            mesAtual = data.substring(data.indexOf("/")+1, data.lastIndexOf("/"));
        int y = Integer.parseInt(data.substring(data.length()-4)) - 1900, m = Integer.parseInt(mesAtual)-1;
        tfDataInicial.setDate(new Date(y, m, 1));
        tfDataFinal.setDate(new Date(y, m, ultimoDia(m+1)));
    }
    
    private int ultimoDia(int m){
        switch(m){
            case 1: 
            case 3: 
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return 28;
            default:
                return 30;
        }
    }
    
    private String dataFormatada(JDateChooser data){
        if(tfDataFinal.getDate() != null)
            return new SimpleDateFormat("yyyy-MM-dd").format(data.getDate());
        else
            return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmprestimo = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        tfISBN = new javax.swing.JTextField();
        tfTitulo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cbNao = new javax.swing.JCheckBox();
        cbSim = new javax.swing.JCheckBox();
        tfDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        tfDataFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Empréstimos");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        jtEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Nome", "Data", "Data de Entrega", "Entregue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmprestimoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEmprestimo);

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        tfISBN.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfISBNActionPerformed(evt);
            }
        });

        tfTitulo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTituloActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entregue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        cbNao.setBackground(new java.awt.Color(255, 255, 255));
        cbNao.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        cbNao.setSelected(true);
        cbNao.setText("Não");
        cbNao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNaoMouseClicked(evt);
            }
        });

        cbSim.setBackground(new java.awt.Color(255, 255, 255));
        cbSim.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        cbSim.setSelected(true);
        cbSim.setText("Sim");
        cbSim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSimMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSim)
                .addGap(18, 18, 18)
                .addComponent(cbNao)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSim)
                    .addComponent(cbNao))
                .addGap(0, 0, 0))
        );

        tfDataInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataInicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfDataInicialPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("<-->");

        tfDataFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Final", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfDataFinalPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfTitulo))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVoltar)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 70, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfISBNActionPerformed
        consulta();
    }//GEN-LAST:event_tfISBNActionPerformed

    private void tfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTituloActionPerformed
        consulta();
    }//GEN-LAST:event_tfTituloActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        consulta();
    }//GEN-LAST:event_tfNomeActionPerformed

    private void cbSimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSimMouseClicked
        consulta();
    }//GEN-LAST:event_cbSimMouseClicked

    private void cbNaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNaoMouseClicked
        consulta();
    }//GEN-LAST:event_cbNaoMouseClicked

    private void tfDataFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfDataFinalPropertyChange
        if(tfDataFinal.getDate() != null)
        consulta();
    }//GEN-LAST:event_tfDataFinalPropertyChange

    private void tfDataInicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfDataInicialPropertyChange
        if(tfDataInicial.getDate() != null)
        consulta();
    }//GEN-LAST:event_tfDataInicialPropertyChange

    private void jtEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmprestimoMouseClicked
        if (podeDarBaixa) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente dar baixa neste Empréstimo?", "Dar baixa?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (usuarios_ids != null){
                    int row = jtEmprestimo.getSelectedRow();
                    emp.darBaixaEmprestimo(usuarios_ids.get(row), jtEmprestimo.getValueAt(row, 0)+"", jtEmprestimo.getValueAt(row, 3)+"");
                    consulta();
                }
            }
        }
    }//GEN-LAST:event_jtEmprestimoMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox cbNao;
    private javax.swing.JCheckBox cbSim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtEmprestimo;
    private javax.swing.JPanel painel;
    private com.toedter.calendar.JDateChooser tfDataFinal;
    private com.toedter.calendar.JDateChooser tfDataInicial;
    private javax.swing.JTextField tfISBN;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}