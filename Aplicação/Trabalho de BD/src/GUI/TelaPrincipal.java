package GUI;

import BD.Servicos;
import Classes.funcoes;
import Classes.usuario;
import java.awt.Toolkit;

/**
 *
 * @author angel, arquivo criado dia 09/11/2018 às 19:47:26
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Servicos serv;    
    private String nome = "", usuario_id;
    private usuario u;
    
    private Thread t = new Thread(){
        funcoes f = new funcoes();
        public void run(){
            while (true){
                String data = f.pegaDataAtual();
                String hora = f.pegaHoraAtual();
                String mes = data.substring(data.indexOf("/") + 1, data.length() - 5);
                switch(mes){
                    case "01": mes = "Janeiro de "; break;
                    case "02": mes = "Fevereiro de "; break;
                    case "03": mes = "Março de "; break;
                    case "04": mes = "Abril de "; break;
                    case "05": mes = "Maio de "; break;
                    case "06": mes = "Junho de "; break;
                    case "07": mes = "Julho de "; break;
                    case "08": mes = "Agosto de "; break;
                    case "09": mes = "Setembro de "; break;
                    case "10": mes = "Outubro de "; break;
                    case "11": mes = "Novembro de "; break;
                    case "12": mes = "Dezembro de "; break;
                }
                boasVindas.setText("Seja Bem Vindo " + nome + "! Hoje é dia " + data.substring(0, data.indexOf("/")) + " de " + mes + data.substring(data.length() - 4) + ", " + hora);
            }
        }
    };
    
    public TelaPrincipal(Servicos serv, String usuario_id) {
        this.usuario_id = usuario_id;
        this.serv = serv;
        
        u = new usuario(serv);
        nome = u.pegaNome(usuario_id);
        
        initComponents();
        setLocationRelativeTo(null);
        
        t.start();
        
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/principal.png")));
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
        btnLogout = new javax.swing.JButton();
        boasVindas = new javax.swing.JLabel();
        btnConsultaReserva = new javax.swing.JButton();
        btnConsultaEmprestimo = new javax.swing.JButton();
        BarraDeMenu = new javax.swing.JMenuBar();
        menuBiblioteca = new javax.swing.JMenu();
        itemEmprestimo = new javax.swing.JMenuItem();
        itemConsultaEmprestimo = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        itemReserva = new javax.swing.JMenuItem();
        itemConsultaReserva = new javax.swing.JMenuItem();
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
        itemCAutor = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemCLivro = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemCCategoria = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        itemCCurso = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        itemCBibliotec = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        itemCUsuario = new javax.swing.JMenuItem();
        config = new javax.swing.JMenu();
        configUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setName(""); // NOI18N

        btnCadastraAutores.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastraAutores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/autor70.png"))); // NOI18N
        btnCadastraAutores.setText("Cadastrar Autor");
        btnCadastraAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraAutoresActionPerformed(evt);
            }
        });

        btnCadastraBibliotecario.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastraBibliotecario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraBibliotecario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bibliotecario70.png"))); // NOI18N
        btnCadastraBibliotecario.setText("Cadastrar Bibliotecário");
        btnCadastraBibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraBibliotecarioActionPerformed(evt);
            }
        });

        btnConsultaAutor.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaAutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaautor70.png"))); // NOI18N
        btnConsultaAutor.setText("Consultar Autor");
        btnConsultaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaAutorActionPerformed(evt);
            }
        });

        btnCadastraLivros.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastraLivros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/livros70.png"))); // NOI18N
        btnCadastraLivros.setText("Cadastrar Livro");
        btnCadastraLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraLivrosActionPerformed(evt);
            }
        });

        btnCadastraCategoria.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastraCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria70.png"))); // NOI18N
        btnCadastraCategoria.setText("Cadastrar Categoria");
        btnCadastraCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCategoriaActionPerformed(evt);
            }
        });

        btnCadastraCurso.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastraCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastraCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/curso70.png"))); // NOI18N
        btnCadastraCurso.setText("Cadastrar Curso");
        btnCadastraCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCursoActionPerformed(evt);
            }
        });

        btnConsultaLivros.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaLivros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscalivros70.png"))); // NOI18N
        btnConsultaLivros.setText("Consultar Livro");
        btnConsultaLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaLivrosActionPerformed(evt);
            }
        });

        btnConsultaCategoria.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacategoria70.png"))); // NOI18N
        btnConsultaCategoria.setText("Consultar Categoria");
        btnConsultaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCategoriaActionPerformed(evt);
            }
        });

        btnEmprestimo.setBackground(new java.awt.Color(255, 255, 255));
        btnEmprestimo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo70.png"))); // NOI18N
        btnEmprestimo.setText("Fazer Empréstimo");
        btnEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimoActionPerformed(evt);
            }
        });

        btnReserva.setBackground(new java.awt.Color(255, 255, 255));
        btnReserva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reserva70.png"))); // NOI18N
        btnReserva.setText("Fazer Reserva");
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnConsultaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscausuario70.png"))); // NOI18N
        btnConsultaUsuarios.setText("Consultar Usuário");
        btnConsultaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaUsuariosActionPerformed(evt);
            }
        });

        btnConsultaCurso.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacurso70.png"))); // NOI18N
        btnConsultaCurso.setText("Consultar Curso");
        btnConsultaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCursoActionPerformed(evt);
            }
        });

        btnConsultaBibliotec.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaBibliotec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaBibliotec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscabibliotecario70.png"))); // NOI18N
        btnConsultaBibliotec.setText("Consultar Bibilotecário");
        btnConsultaBibliotec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaBibliotecActionPerformed(evt);
            }
        });

        btnCadastroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastroUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/usuario70.png"))); // NOI18N
        btnCadastroUsuario.setText("Cadastrar Usuário");
        btnCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroUsuarioActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logout30.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        boasVindas.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        boasVindas.setText("Seja Bem Vindo abcdef ghijk! Hoje é dia 22 de Novembro de 2018, 14:05:13");

        btnConsultaReserva.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaReserva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscareserva70.png"))); // NOI18N
        btnConsultaReserva.setText("Consultar Reserva");
        btnConsultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaReservaActionPerformed(evt);
            }
        });

        btnConsultaEmprestimo.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaEmprestimo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultaEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaemprestimo70.png"))); // NOI18N
        btnConsultaEmprestimo.setText("Consultar Empréstimo");
        btnConsultaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaEmprestimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
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
                        .addGap(30, 30, 30))))
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        painelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastraAutores, btnCadastraBibliotecario, btnCadastraCategoria, btnCadastraCurso, btnCadastraLivros, btnCadastroUsuario, btnConsultaAutor, btnConsultaBibliotec, btnConsultaCategoria, btnConsultaCurso, btnConsultaEmprestimo, btnConsultaLivros, btnConsultaReserva, btnConsultaUsuarios, btnEmprestimo, btnReserva});

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
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(boasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );

        painelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastraAutores, btnCadastraBibliotecario, btnCadastraCategoria, btnCadastraCurso, btnCadastraLivros, btnCadastroUsuario, btnConsultaAutor, btnConsultaBibliotec, btnConsultaCategoria, btnConsultaCurso, btnConsultaEmprestimo, btnConsultaLivros, btnConsultaReserva, btnConsultaUsuarios, btnEmprestimo, btnReserva});

        BarraDeMenu.setForeground(new java.awt.Color(255, 255, 255));
        BarraDeMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        menuBiblioteca.setForeground(new java.awt.Color(255, 255, 255));
        menuBiblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/livros.png"))); // NOI18N
        menuBiblioteca.setText("Biblioteca");
        menuBiblioteca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemEmprestimo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        itemEmprestimo.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo30.png"))); // NOI18N
        itemEmprestimo.setText("Fazer Empréstimo");
        itemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmprestimoActionPerformed(evt);
            }
        });
        menuBiblioteca.add(itemEmprestimo);

        itemConsultaEmprestimo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemConsultaEmprestimo.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemConsultaEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaemprestimo30.png"))); // NOI18N
        itemConsultaEmprestimo.setText("Consultar Empréstimo");
        itemConsultaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaEmprestimoActionPerformed(evt);
            }
        });
        menuBiblioteca.add(itemConsultaEmprestimo);
        menuBiblioteca.add(jSeparator12);

        itemReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemReserva.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reserva30.png"))); // NOI18N
        itemReserva.setText("Fazer Reserva");
        itemReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReservaActionPerformed(evt);
            }
        });
        menuBiblioteca.add(itemReserva);

        itemConsultaReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemConsultaReserva.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemConsultaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscareserva30.png"))); // NOI18N
        itemConsultaReserva.setText("Consultar Reserva");
        itemConsultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaReservaActionPerformed(evt);
            }
        });
        menuBiblioteca.add(itemConsultaReserva);

        BarraDeMenu.add(menuBiblioteca);

        menuCadastros.setForeground(new java.awt.Color(255, 255, 255));
        menuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adcionar30.png"))); // NOI18N
        menuCadastros.setText("Cadastros");
        menuCadastros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemAutor.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/autor30.png"))); // NOI18N
        itemAutor.setText("Cadastro de Autor");
        itemAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAutorActionPerformed(evt);
            }
        });
        menuCadastros.add(itemAutor);
        menuCadastros.add(jSeparator1);

        itemLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemLivro.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/livros30.png"))); // NOI18N
        itemLivro.setText("Cadastro de Livro");
        menuCadastros.add(itemLivro);
        menuCadastros.add(jSeparator2);

        itemCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        itemCategoria.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria30.png"))); // NOI18N
        itemCategoria.setText("Cadastro de Categoria");
        menuCadastros.add(itemCategoria);
        menuCadastros.add(jSeparator3);

        itemCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCurso.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/curso30.png"))); // NOI18N
        itemCurso.setText("Cadastro de Curso");
        itemCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCursoActionPerformed(evt);
            }
        });
        menuCadastros.add(itemCurso);
        menuCadastros.add(jSeparator4);

        itemBibliotec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemBibliotec.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemBibliotec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bibliotecario30.png"))); // NOI18N
        itemBibliotec.setText("Cadastro de Bibliotecário");
        itemBibliotec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBibliotecActionPerformed(evt);
            }
        });
        menuCadastros.add(itemBibliotec);
        menuCadastros.add(jSeparator5);

        itemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemUsuario.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/usuario30.png"))); // NOI18N
        itemUsuario.setText("Cadastro de Usuário");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(itemUsuario);

        BarraDeMenu.add(menuCadastros);

        menuConsultas.setForeground(new java.awt.Color(255, 255, 255));
        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemCAutor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCAutor.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscaautor30.png"))); // NOI18N
        itemCAutor.setText("Consulta de Autor");
        itemCAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCAutorActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCAutor);
        menuConsultas.add(jSeparator6);

        itemCLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCLivro.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscalivros30.png"))); // NOI18N
        itemCLivro.setText("Consulta de Livro");
        itemCLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCLivroActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCLivro);
        menuConsultas.add(jSeparator7);

        itemCCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCCategoria.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacategoria30.png"))); // NOI18N
        itemCCategoria.setText("Consulta de Categoria");
        itemCCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCCategoriaActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCCategoria);
        menuConsultas.add(jSeparator8);

        itemCCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCCurso.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscacurso30.png"))); // NOI18N
        itemCCurso.setText("Consulta de Curso");
        itemCCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCCursoActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCCurso);
        menuConsultas.add(jSeparator9);

        itemCBibliotec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCBibliotec.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCBibliotec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscabibliotecario30.png"))); // NOI18N
        itemCBibliotec.setText("Consulta de Bibliotecário");
        itemCBibliotec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCBibliotecActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCBibliotec);
        menuConsultas.add(jSeparator10);

        itemCUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemCUsuario.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        itemCUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscausuario30.png"))); // NOI18N
        itemCUsuario.setText("Consulta de Usuário");
        itemCUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCUsuarioActionPerformed(evt);
            }
        });
        menuConsultas.add(itemCUsuario);

        BarraDeMenu.add(menuConsultas);

        config.setForeground(new java.awt.Color(255, 255, 255));
        config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/config.png"))); // NOI18N
        config.setText("Configurações");

        configUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        configUser.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        configUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.jpg"))); // NOI18N
        configUser.setText("Configurações de Usuário");
        configUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configUserActionPerformed(evt);
            }
        });
        config.add(configUser);

        BarraDeMenu.add(config);

        setJMenuBar(BarraDeMenu);

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
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        new ConsultaCursos(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaCursoActionPerformed

    private void itemCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCursoActionPerformed
        btnCadastraCursoActionPerformed(evt);
    }//GEN-LAST:event_itemCursoActionPerformed

    private void itemBibliotecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBibliotecActionPerformed
        btnCadastraBibliotecarioActionPerformed(evt);
    }//GEN-LAST:event_itemBibliotecActionPerformed

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed
        btnCadastroUsuarioActionPerformed(evt);
    }//GEN-LAST:event_itemUsuarioActionPerformed

    private void btnCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsuarioActionPerformed
        new CadastroUsuario(serv).setVisible(true);
    }//GEN-LAST:event_btnCadastroUsuarioActionPerformed

    private void itemCAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCAutorActionPerformed
        btnConsultaAutorActionPerformed(evt);
    }//GEN-LAST:event_itemCAutorActionPerformed

    private void itemCLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCLivroActionPerformed
        btnConsultaLivrosActionPerformed(evt);
    }//GEN-LAST:event_itemCLivroActionPerformed

    private void itemCCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCCategoriaActionPerformed
        btnConsultaCategoriaActionPerformed(evt);
    }//GEN-LAST:event_itemCCategoriaActionPerformed

    private void itemCCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCCursoActionPerformed
        btnConsultaCursoActionPerformed(evt);
    }//GEN-LAST:event_itemCCursoActionPerformed

    private void itemCBibliotecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCBibliotecActionPerformed
        btnConsultaBibliotecActionPerformed(evt);
    }//GEN-LAST:event_itemCBibliotecActionPerformed

    private void itemCUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCUsuarioActionPerformed
        btnConsultaUsuariosActionPerformed(evt);
    }//GEN-LAST:event_itemCUsuarioActionPerformed

    private void itemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmprestimoActionPerformed
        btnEmprestimoActionPerformed(evt);
    }//GEN-LAST:event_itemEmprestimoActionPerformed

    private void itemReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReservaActionPerformed
        btnReservaActionPerformed(evt);
    }//GEN-LAST:event_itemReservaActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new TelaLogin(serv).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void itemConsultaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaEmprestimoActionPerformed
        btnConsultaEmprestimoActionPerformed(evt);
    }//GEN-LAST:event_itemConsultaEmprestimoActionPerformed

    private void itemAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAutorActionPerformed
        btnCadastraAutoresActionPerformed(evt);
    }//GEN-LAST:event_itemAutorActionPerformed

    private void btnConsultaBibliotecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaBibliotecActionPerformed
        new ConsultaBibliotecario(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaBibliotecActionPerformed

    private void btnConsultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaReservaActionPerformed
        new ConsultaReserva(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaReservaActionPerformed

    private void btnConsultaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaEmprestimoActionPerformed
        new ConsultaEmprestimo(serv).setVisible(true);
    }//GEN-LAST:event_btnConsultaEmprestimoActionPerformed

    private void itemConsultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaReservaActionPerformed
        btnConsultaReservaActionPerformed(evt);
    }//GEN-LAST:event_itemConsultaReservaActionPerformed

    private void configUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configUserActionPerformed
        new CadastroBibliotecario(serv, usuario_id).setVisible(true);
    }//GEN-LAST:event_configUserActionPerformed

   
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
    private javax.swing.JLabel boasVindas;
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
    private javax.swing.JButton btnConsultaEmprestimo;
    private javax.swing.JButton btnConsultaLivros;
    private javax.swing.JButton btnConsultaReserva;
    private javax.swing.JButton btnConsultaUsuarios;
    private javax.swing.JButton btnEmprestimo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReserva;
    private javax.swing.JMenu config;
    private javax.swing.JMenuItem configUser;
    private javax.swing.JMenuItem itemAutor;
    private javax.swing.JMenuItem itemBibliotec;
    private javax.swing.JMenuItem itemCAutor;
    private javax.swing.JMenuItem itemCBibliotec;
    private javax.swing.JMenuItem itemCCategoria;
    private javax.swing.JMenuItem itemCCurso;
    private javax.swing.JMenuItem itemCLivro;
    private javax.swing.JMenuItem itemCUsuario;
    private javax.swing.JMenuItem itemCategoria;
    private javax.swing.JMenuItem itemConsultaEmprestimo;
    private javax.swing.JMenuItem itemConsultaReserva;
    private javax.swing.JMenuItem itemCurso;
    private javax.swing.JMenuItem itemEmprestimo;
    private javax.swing.JMenuItem itemLivro;
    private javax.swing.JMenuItem itemReserva;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu menuBiblioteca;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}