package GUI;

import BD.Servicos;

/**
 *
 * @author angel, arquivo criado dia 09/11/2018 às 19:47:26
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Servicos serv;
    private String usuario_id;
    
    public TelaPrincipal(Servicos serv, String usuario_id) {
        this.usuario_id = usuario_id;
        initComponents();
        this.serv = serv;
        setLocationRelativeTo(null);
    }

    private TelaPrincipal(){}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        btnCadastraAutores = new javax.swing.JButton();
        btnCadastraBibliotecario = new javax.swing.JButton();
        btnConsultaAutor = new javax.swing.JButton();
        btnCadastraLivros = new javax.swing.JButton();
        btnCadastraCategoria = new javax.swing.JButton();
        btnCadastraCurso = new javax.swing.JButton();
        btnConsultaLivros = new javax.swing.JButton();
        btnConsultaCategoria = new javax.swing.JButton();
        btnEmprestimo = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnConsultaUsuarios = new javax.swing.JButton();
        btnConsultaCurso = new javax.swing.JButton();
        btnConsultaBibliotec = new javax.swing.JButton();
        btnCadastroUsuario = new javax.swing.JButton();
        BarraDeMenu = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        itemAutor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemLivro = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemCategoria = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemCurso = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemBibliotec = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemUsuario = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setName(""); // NOI18N

        btnCadastraAutores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/autor2-70.png"))); // NOI18N
        btnCadastraAutores.setText("Cadastrar Autor");
        btnCadastraAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraAutoresActionPerformed(evt);
            }
        });

        btnCadastraBibliotecario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraBibliotecario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bibliotecario70.png"))); // NOI18N
        btnCadastraBibliotecario.setText("Cadastrar Bibliotecário");
        btnCadastraBibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraBibliotecarioActionPerformed(evt);
            }
        });

        btnConsultaAutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaautor70.png"))); // NOI18N
        btnConsultaAutor.setText("Consultar Autor");
        btnConsultaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaAutorActionPerformed(evt);
            }
        });

        btnCadastraLivros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/livros4-70.png"))); // NOI18N
        btnCadastraLivros.setText("Cadastrar Livro");
        btnCadastraLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraLivrosActionPerformed(evt);
            }
        });

        btnCadastraCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria70.png"))); // NOI18N
        btnCadastraCategoria.setText("Cadastrar Categoria");
        btnCadastraCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCategoriaActionPerformed(evt);
            }
        });

        btnCadastraCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/curso70.png"))); // NOI18N
        btnCadastraCurso.setText("Cadastrar Curso");
        btnCadastraCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCursoActionPerformed(evt);
            }
        });

        btnConsultaLivros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscalivros70.png"))); // NOI18N
        btnConsultaLivros.setText("Consultar Livro");
        btnConsultaLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaLivrosActionPerformed(evt);
            }
        });

        btnConsultaCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacategoria70.png"))); // NOI18N
        btnConsultaCategoria.setText("Consultar Categoria");
        btnConsultaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCategoriaActionPerformed(evt);
            }
        });

        btnEmprestimo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo70.png"))); // NOI18N
        btnEmprestimo.setText("Fazer Empréstimo");
        btnEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimoActionPerformed(evt);
            }
        });

        btnReserva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reserva1-70.png"))); // NOI18N
        btnReserva.setText("Fazer Reserva");
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnConsultaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscausuario70.png"))); // NOI18N
        btnConsultaUsuarios.setText("Consultar Usuário");
        btnConsultaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaUsuariosActionPerformed(evt);
            }
        });

        btnConsultaCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacurso70.png"))); // NOI18N
        btnConsultaCurso.setText("Consultar Curso");
        btnConsultaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCursoActionPerformed(evt);
            }
        });

        btnConsultaBibliotec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaBibliotec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscabibliotecario70.png"))); // NOI18N
        btnConsultaBibliotec.setText("Consultar Bibilotecário");

        btnCadastroUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/usuario70.png"))); // NOI18N
        btnCadastroUsuario.setText("Cadastrar Usuário");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCadastraAutores, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addComponent(btnConsultaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastraCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConsultaCurso))
                .addGap(60, 60, 60)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultaBibliotec)
                    .addComponent(btnCadastraLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastraBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastraCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastroUsuario))
                .addGap(30, 30, 30))
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastraAutores, btnCadastraBibliotecario, btnCadastraCategoria, btnCadastraCurso, btnCadastraLivros, btnCadastroUsuario, btnConsultaAutor, btnConsultaBibliotec, btnConsultaCategoria, btnConsultaCurso, btnConsultaLivros, btnConsultaUsuarios, btnEmprestimo, btnReserva});

        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastraAutores)
                    .addComponent(btnCadastraLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastraCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultaAutor)
                    .addComponent(btnConsultaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastraCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastraBibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastroUsuario))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultaCurso)
                        .addComponent(btnConsultaBibliotec)))
                .addGap(56, 56, 56)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastraAutores, btnCadastraBibliotecario, btnCadastraCategoria, btnCadastraCurso, btnCadastraLivros, btnCadastroUsuario, btnConsultaAutor, btnConsultaBibliotec, btnConsultaCategoria, btnConsultaCurso, btnConsultaLivros, btnConsultaUsuarios, btnEmprestimo, btnReserva});

        BarraDeMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        menuCadastros.setText("Cadastros");
        menuCadastros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemAutor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemAutor.setText("Cadastro de Autor");
        menuCadastros.add(itemAutor);
        menuCadastros.add(jSeparator1);

        itemLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemLivro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemLivro.setText("Cadastro de Livro");
        menuCadastros.add(itemLivro);
        menuCadastros.add(jSeparator2);

        itemCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        itemCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemCategoria.setText("Cadastro de Categoria");
        menuCadastros.add(itemCategoria);
        menuCadastros.add(jSeparator3);

        itemCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCurso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemCurso.setText("Cadastro de Curso");
        itemCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCursoActionPerformed(evt);
            }
        });
        menuCadastros.add(itemCurso);
        menuCadastros.add(jSeparator4);

        itemBibliotec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemBibliotec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemBibliotec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemBibliotec.setText("Cadastro de Bibliotecário");
        itemBibliotec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBibliotecActionPerformed(evt);
            }
        });
        menuCadastros.add(itemBibliotec);
        menuCadastros.add(jSeparator5);

        itemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        itemUsuario.setText("Cadastro de Usuário");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(itemUsuario);

        BarraDeMenu.add(menuCadastros);

        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BarraDeMenu.add(menuConsultas);

        setJMenuBar(BarraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        painel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraAutoresActionPerformed
        new CadastroAutores(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastraAutoresActionPerformed

    private void btnCadastraLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraLivrosActionPerformed
        new CadastroLivros(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastraLivrosActionPerformed

    private void btnCadastraCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraCategoriaActionPerformed
        new CadastroCategorias(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastraCategoriaActionPerformed

    private void btnCadastraCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraCursoActionPerformed
        new CadastroCurso(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastraCursoActionPerformed

    private void btnCadastraBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraBibliotecarioActionPerformed
        new CadastroBibliotecario(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastraBibliotecarioActionPerformed

    private void btnConsultaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaAutorActionPerformed
        new ConsultaAutores(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaAutorActionPerformed

    private void btnConsultaLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaLivrosActionPerformed
        new ConsultaLivros(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaLivrosActionPerformed

    private void btnConsultaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCategoriaActionPerformed
        new ConsultaCategoria(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaCategoriaActionPerformed

    private void btnEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimoActionPerformed
        new Emprestimo(serv).setVisible(true);
    }//GEN-LAST:event_btnEmprestimoActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        new ConsultaLivros(serv, true, usuario_id).setVisible(true);
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnConsultaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaUsuariosActionPerformed
        new ConsultaUsuario(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaUsuariosActionPerformed

    private void btnConsultaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultaCursoActionPerformed

    private void itemCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCursoActionPerformed

    private void itemBibliotecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBibliotecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemBibliotecActionPerformed

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemUsuarioActionPerformed

   
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JButton btnCadastraAutores;
    private javax.swing.JButton btnCadastraBibliotecario;
    private javax.swing.JButton btnCadastraCategoria;
    private javax.swing.JButton btnCadastraCurso;
    private javax.swing.JButton btnCadastraLivros;
    private javax.swing.JButton btnCadastroUsuario;
    private javax.swing.JButton btnConsultaAutor;
    private javax.swing.JButton btnConsultaBibliotec;
    private javax.swing.JButton btnConsultaCategoria;
    private javax.swing.JButton btnConsultaCurso;
    private javax.swing.JButton btnConsultaLivros;
    private javax.swing.JButton btnConsultaUsuarios;
    private javax.swing.JButton btnEmprestimo;
    private javax.swing.JButton btnReserva;
    private javax.swing.JMenuItem itemAutor;
    private javax.swing.JMenuItem itemBibliotec;
    private javax.swing.JMenuItem itemCategoria;
    private javax.swing.JMenuItem itemCurso;
    private javax.swing.JMenuItem itemLivro;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}