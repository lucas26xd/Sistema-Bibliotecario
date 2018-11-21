package GUI;

/**
 *
 * @author lucas, arquivo criado dia 20/11/2018 às 23:40:51
 */
public class CadastrarUsuario extends javax.swing.JFrame {

    public CadastrarUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        tfEndereco = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        abas = new javax.swing.JTabbedPane();
        painelAluno = new javax.swing.JPanel();
        tfMatrAluno = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnMaisTelAluno = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTelefonesFunc1 = new javax.swing.JTable();
        btnMenosAluno = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        tfNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btn.setText("Cadastrar");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        tfEndereco.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tfLogin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jPasswordField1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        abas.setBackground(new java.awt.Color(255, 255, 255));

        painelAluno.setBackground(new java.awt.Color(255, 255, 255));

        tfMatrAluno.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfMatrAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        btnMaisTelAluno.setBackground(new java.awt.Color(255, 255, 255));
        btnMaisTelAluno.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        btnMaisTelAluno.setForeground(new java.awt.Color(0, 255, 0));
        btnMaisTelAluno.setText("+");
        btnMaisTelAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisTelAlunoActionPerformed(evt);
            }
        });

        jtTelefonesFunc1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtTelefonesFunc1);

        btnMenosAluno.setBackground(new java.awt.Color(255, 255, 255));
        btnMenosAluno.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        btnMenosAluno.setForeground(new java.awt.Color(255, 0, 0));
        btnMenosAluno.setText("-");
        btnMenosAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaisTelAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMaisTelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenosAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        tfDataIngresso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Ingresso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataIngresso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataIngresso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        tfDataConclusao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Conclusão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        tfDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataConclusao.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        cbCursoAluno.setBackground(new java.awt.Color(255, 255, 255));
        cbCursoAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCursoAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout painelAlunoLayout = new javax.swing.GroupLayout(painelAluno);
        painelAluno.setLayout(painelAlunoLayout);
        painelAlunoLayout.setHorizontalGroup(
            painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAlunoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelAlunoLayout.createSequentialGroup()
                        .addComponent(tfMatrAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCursoAluno, 0, 172, Short.MAX_VALUE)))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        abas.addTab("Aluno", painelAluno);

        painelProfessor.setBackground(new java.awt.Color(255, 255, 255));

        tfMatSiape.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tfMatSiape.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SIAPE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        cbCursoProf.setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(112, Short.MAX_VALUE))
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
        btnMaisTelFunc.setText("+");
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
        btnMenosTelFunc.setText("-");
        btnMenosTelFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosTelFuncActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaisTelFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenosTelFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMaisTelFunc, btnMenosTelFunc});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMaisTelFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenosTelFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMaisTelFunc, btnMenosTelFunc});

        javax.swing.GroupLayout painelFuncLayout = new javax.swing.GroupLayout(painelFunc);
        painelFunc.setLayout(painelFuncLayout);
        painelFuncLayout.setHorizontalGroup(
            painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMatrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        painelFuncLayout.setVerticalGroup(
            painelFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfMatrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        abas.addTab("Funcionário", painelFunc);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn))
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))))
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
                        .addComponent(jPasswordField1)
                        .addGap(1, 1, 1)))
                .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btn)
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

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        /*if(camposPreenchidos()){
            if(btn.getText().equals("Alterar")){
                autores.altera(tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
                dispose();
            }else
            autores.cadastra(tfNome.getText(), tfCPF.getText(), tfNacionalidade.getText());
            limpar();
        }*/
    }//GEN-LAST:event_btnActionPerformed

    private void btnMaisTelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisTelFuncActionPerformed
        //new ConsultaAutores(serv, this).setVisible(true);
    }//GEN-LAST:event_btnMaisTelFuncActionPerformed

    private void btnMenosTelFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosTelFuncActionPerformed
        //apagaLinhaAutor();
    }//GEN-LAST:event_btnMenosTelFuncActionPerformed

    private void btnMaisTelAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisTelAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaisTelAlunoActionPerformed

    private void btnMenosAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenosAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btn;
    private javax.swing.JButton btnMaisTelAluno;
    private javax.swing.JButton btnMaisTelFunc;
    private javax.swing.JButton btnMenosAluno;
    private javax.swing.JButton btnMenosTelFunc;
    private javax.swing.JComboBox<String> cbCursoAluno;
    private javax.swing.JComboBox<String> cbCursoProf;
    private javax.swing.JComboBox<String> cbRegime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTelefonesFunc;
    private javax.swing.JTable jtTelefonesFunc1;
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
    private javax.swing.JTextField tfTelCelular;
    // End of variables declaration//GEN-END:variables
}