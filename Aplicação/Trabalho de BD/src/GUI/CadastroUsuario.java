package GUI;

import BD.Servicos;
import Classes.usuario;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 20/11/2018 às 23:40:51
 */
public class CadastroUsuario extends javax.swing.JFrame {

    private Servicos serv;
    private usuario u;
    private String usuario_id = "";
    private DefaultTableModel mod;
    private ArrayList<String> cods;
    
    public CadastroUsuario(Servicos serv) {
        this.serv = serv;
        
        u = new usuario(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        povoaCombos();
        
        setIcon();
    }
    
    public CadastroUsuario(Servicos serv, String usuario_id) {
        this.serv = serv;
        this.usuario_id = usuario_id;
        
        u = new usuario(serv);
        
        initComponents();
        setLocationRelativeTo(null);
        
        setTitle("Alterar Usuário");
        btn.setText("Alterar");
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png")));
        
        povoaCombos();
        
        String tipo = u.consultaUsuario(usuario_id, tfNome, tfEndereco, tfLogin);
        
        abas.setEnabled(false);
        
        if (tipo.equals("alunos")){
            abas.setSelectedIndex(0);
            u.consultaAluno(usuario_id, tfMatrAluno, tfDataIngresso, tfDataConclusao, cbCursoAluno, jtTelefonesAlunos);
        } else if (tipo.equals("professores")){
            abas.setSelectedIndex(1);
            u.consultaProfessor(usuario_id, tfMatSiape, tfDataContratacao, tfTelCelular, cbCursoProf, cbRegime);
        } else if (tipo.equals("funcionarios")){
            abas.setSelectedIndex(2);
            u.consultaFuncionario(usuario_id, tfMatrFunc, jtTelefonesFunc);
        }
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/usuario70.png")));
    }
    
    private CadastroUsuario(){}
    
    private void povoaCombos(){
        cods = u.povoaCombo(cbCursoAluno, "SELECT * FROM curso;");
        for (int i = 0; i < cbCursoAluno.getItemCount(); i++) {
            cbCursoProf.addItem(cbCursoAluno.getItemAt(i));
        }
    }
    
    private boolean camposPreenchidos(){
        if (tfNome.getText().length() > 0 && tfEndereco.getText().length() > 0 && 
            tfLogin.getText().length() > 0 && tfSenha.getText().length() > 0) {
            switch (abas.getSelectedIndex()) {
                case 0:
                    return tfMatrAluno.getText().length() > 0 && tfDataIngresso.getText().length() > 0 &&
                           tfDataConclusao.getText().length() > 0;
                case 1:
                    return tfMatSiape.getText().length() > 0 && tfDataContratacao.getText().length() > 0 &&
                           tfTelCelular.getText().length() > 0;
                default:
                    return tfMatrFunc.getText().length() > 0;
            }
        } else
            return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        tfEndereco = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        abas = new javax.swing.JTabbedPane();
        painelAluno = new javax.swing.JPanel();
        tfMatrAluno = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnMaisTelAluno = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTelefonesAlunos = new javax.swing.JTable();
        btnMenosAluno = new javax.swing.JButton();
        tfTelefoneAluno = new javax.swing.JTextField();
        tfDataIngresso = new javax.swing.JFormattedTextField();
        tfDataConclusao = new javax.swing.JFormattedTextField();
        cbCursoAluno = new javax.swing.JComboBox<>();
        painelProfessor = new javax.swing.JPanel();
        tfMatSiape = new javax.swing.JTextField();
        cbCursoProf = new javax.swing.JComboBox<>();
        tfDataContratacao = new javax.swing.JFormattedTextField();
        cbRegime = new javax.swing.JComboBox<>();
        tfTelCelular = new javax.swing.JTextField();
        painelFunc = new javax.swing.JPanel();
        tfMatrFunc = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnMaisTelFunc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTelefonesFunc = new javax.swing.JTable();
        btnMenosTelFunc = new javax.swing.JButton();
        tfTelefoneFunc = new javax.swing.JTextField();
        btnApagar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
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

        tfEndereco.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfLogin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfSenha.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        abas.setBackground(new java.awt.Color(255, 255, 255));

        painelAluno.setBackground(new java.awt.Color(255, 255, 255));

        tfMatrAluno.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfMatrAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnMaisTelAluno.setBackground(new java.awt.Color(255, 255, 255));
        btnMaisTelAluno.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMaisTelAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnMaisTelAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        btnMaisTelAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisTelAlunoActionPerformed(evt);
            }
        });

        jtTelefonesAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtTelefonesAlunos);

        btnMenosAluno.setBackground(new java.awt.Color(255, 255, 255));
        btnMenosAluno.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        btnMenosAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnMenosAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover30.png"))); // NOI18N
        btnMenosAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosAlunoActionPerformed(evt);
            }
        });

        tfTelefoneAluno.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTelefoneAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTelefoneAluno)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenosAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMaisTelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfTelefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaisTelAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMenosAluno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tfDataIngresso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Ingresso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataIngresso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataIngresso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        tfDataConclusao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Conclusão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataConclusao.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        cbCursoAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCursoAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        cbCursoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCursoAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAlunoLayout = new javax.swing.GroupLayout(painelAluno);
        painelAluno.setLayout(painelAlunoLayout);
        painelAlunoLayout.setHorizontalGroup(
            painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAlunoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(painelAlunoLayout.createSequentialGroup()
                        .addComponent(tfMatrAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCursoAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelAlunoLayout.setVerticalGroup(
            painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMatrAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataConclusao)
                    .addComponent(cbCursoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        abas.addTab("Aluno", painelAluno);

        painelProfessor.setBackground(new java.awt.Color(255, 255, 255));

        tfMatSiape.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfMatSiape.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SIAPE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        cbCursoProf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCursoProf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfDataContratacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Contratação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataContratacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataContratacao.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        cbRegime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbRegime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20h", "40h", "DE" }));
        cbRegime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Regime de Trabalho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfTelCelular.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTelCelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefone Celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout painelProfessorLayout = new javax.swing.GroupLayout(painelProfessor);
        painelProfessor.setLayout(painelProfessorLayout);
        painelProfessorLayout.setHorizontalGroup(
            painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbRegime, 0, 184, Short.MAX_VALUE)
                    .addComponent(tfMatSiape))
                .addGap(18, 18, 18)
                .addGroup(painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDataContratacao, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(tfTelCelular))
                .addGap(18, 18, 18)
                .addComponent(cbCursoProf, 0, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelProfessorLayout.setVerticalGroup(
            painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMatSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCursoProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        abas.addTab("Professor", painelProfessor);

        painelFunc.setBackground(new java.awt.Color(255, 255, 255));

        tfMatrFunc.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfMatrFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnMaisTelFunc.setBackground(new java.awt.Color(255, 255, 255));
        btnMaisTelFunc.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMaisTelFunc.setForeground(new java.awt.Color(0, 255, 0));
        btnMaisTelFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        btnMaisTelFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisTelFuncActionPerformed(evt);
            }
        });

        jtTelefonesFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTelefonesFunc);

        btnMenosTelFunc.setBackground(new java.awt.Color(255, 255, 255));
        btnMenosTelFunc.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        btnMenosTelFunc.setForeground(new java.awt.Color(255, 0, 0));
        btnMenosTelFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover30.png"))); // NOI18N
        btnMenosTelFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosTelFuncActionPerformed(evt);
            }
        });

        tfTelefoneFunc.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfTelefoneFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTelefoneFunc)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaisTelFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosTelFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfTelefoneFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaisTelFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMenosTelFunc)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelFuncLayout = new javax.swing.GroupLayout(painelFunc);
        painelFunc.setLayout(painelFuncLayout);
        painelFuncLayout.setHorizontalGroup(
            painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMatrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        painelFuncLayout.setVerticalGroup(
            painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfMatrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        abas.addTab("Funcionário", painelFunc);

        btnApagar.setBackground(new java.awt.Color(255, 255, 255));
        btnApagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/apagar30.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
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
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(tfSenha)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addGap(30, 30, 30)
                                .addComponent(btnApagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn))
                            .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfSenha)
                        .addGap(1, 1, 1)))
                .addComponent(abas)
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addGap(37, 37, 37))
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

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        if(camposPreenchidos()){
            if (btn.getText().equals("Alterar")) {
                if(u.alteraUsuario(usuario_id, tfNome.getText(), tfEndereco.getText(), tfSenha.getText())) {
                    switch (abas.getSelectedIndex()) {
                        case 0:
                            u.alteraTelefonesAluno(usuario_id, jtTelefonesAlunos);
                            break;
                        case 1:
                            u.alteraProfessor(usuario_id, tfTelCelular.getText());
                            break;
                        case 2:
                            u.alteraTelefonesFuncionario(usuario_id, jtTelefonesFunc);
                            break;
                    }
                }   
            } else {
                String tipoUser = (abas.getSelectedIndex() == 0 ? "alunos" : abas.getSelectedIndex() == 1 ? "professores" : "funcionarios");
                usuario_id = u.cadastraUsuario(tfLogin.getText(), tfSenha.getText(), tfNome.getText(), tfEndereco.getText(), tipoUser);
                switch (abas.getSelectedIndex()) {
                    case 0:
                        u.cadatraAluno(usuario_id, tfMatrAluno.getText(), tfDataIngresso.getText(), tfDataConclusao.getText(), cods.get(cbCursoAluno.getSelectedIndex()), jtTelefonesAlunos);
                        break;
                    case 1:
                        u.cadatraProfessor(usuario_id, tfMatSiape.getText(), tfTelCelular.getText(), cbRegime.getSelectedItem()+"", tfDataContratacao.getText(), cods.get(cbCursoProf.getSelectedIndex()));
                        break;
                    case 2:
                        u.cadatraFuncionario(usuario_id, tfMatrFunc.getText(), jtTelefonesFunc);
                        break;
                }
            }
            dispose();
        } else
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!", "Campos obrigatórios", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnActionPerformed

    private void btnMaisTelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisTelFuncActionPerformed
        if (tfTelefoneFunc.getText().length() >= 8) {
            mod = (DefaultTableModel) jtTelefonesFunc.getModel();
            mod.addRow(new Object[]{tfTelefoneFunc.getText()});
            tfTelefoneFunc.setText("");
        }
    }//GEN-LAST:event_btnMaisTelFuncActionPerformed

    private void btnMenosTelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosTelFuncActionPerformed
        if (jtTelefonesFunc.getRowCount() > 0){
            mod = (DefaultTableModel) jtTelefonesFunc.getModel();
            int row = jtTelefonesFunc.getSelectedRow();
            if (row == -1)
                mod.removeRow(mod.getRowCount() - 1);
            else
                mod.removeRow(row);
        }
    }//GEN-LAST:event_btnMenosTelFuncActionPerformed

    private void btnMaisTelAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisTelAlunoActionPerformed
        if (tfTelefoneAluno.getText().length() >= 8) {
            mod = (DefaultTableModel) jtTelefonesAlunos.getModel();
            mod.addRow(new Object[]{tfTelefoneAluno.getText()});
            tfTelefoneAluno.setText("");
        }
    }//GEN-LAST:event_btnMaisTelAlunoActionPerformed

    private void btnMenosAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosAlunoActionPerformed
        if (jtTelefonesAlunos.getRowCount() > 0){
            mod = (DefaultTableModel) jtTelefonesAlunos.getModel();
            int row = jtTelefonesAlunos.getSelectedRow();
            if (row == -1)
                mod.removeRow(mod.getRowCount() - 1);
            else
                mod.removeRow(row);
        }
    }//GEN-LAST:event_btnMenosAlunoActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if(!usuario_id.equals("")){
            if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro deste usuário?", "Excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                u.apaga(usuario_id);
                dispose();
            }
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void cbCursoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btn;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnMaisTelAluno;
    private javax.swing.JButton btnMaisTelFunc;
    private javax.swing.JButton btnMenosAluno;
    private javax.swing.JButton btnMenosTelFunc;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCursoAluno;
    private javax.swing.JComboBox<String> cbCursoProf;
    private javax.swing.JComboBox<String> cbRegime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTelefonesAlunos;
    private javax.swing.JTable jtTelefonesFunc;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelAluno;
    private javax.swing.JPanel painelFunc;
    private javax.swing.JPanel painelProfessor;
    private javax.swing.JFormattedTextField tfDataConclusao;
    private javax.swing.JFormattedTextField tfDataContratacao;
    private javax.swing.JFormattedTextField tfDataIngresso;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfMatSiape;
    private javax.swing.JTextField tfMatrAluno;
    private javax.swing.JTextField tfMatrFunc;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfTelCelular;
    private javax.swing.JTextField tfTelefoneAluno;
    private javax.swing.JTextField tfTelefoneFunc;
    // End of variables declaration//GEN-END:variables
}