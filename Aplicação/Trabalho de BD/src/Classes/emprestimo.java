package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author lucas, arquivo criado dia 13/11/2018 às 22:31:51
 */
public class emprestimo {

    private Servicos serv;
    private funcoes f = new funcoes();
    
    public emprestimo(Servicos serv) {
        this.serv = serv;
    }

    //cadastra o emprestimo na banco
    public void cadastra(String usuario_id, String isbn_livro, String data, String data_entrega) {
        if(verificaSeEstaEmDebito(usuario_id) == 0){
            if (verificaSePodePegar(usuario_id)) {
                if(verificaSeUsuarioNaoPegouLivro(isbn_livro, usuario_id)) {
                    if(serv.Acao("INSERT INTO emprestimo VALUES ('" + usuario_id + "', '" + isbn_livro + "', '" + f.converteDataJ2BD(data) + "', '" + f.converteDataJ2BD(data_entrega) + "', 'Não');") != null)
                        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                } else
                    JOptionPane.showMessageDialog(null, "Usuário já pegou este livro!", "Usuário já está com este livro", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Usuário atingiu o limite de empréstimos!", "Limite de Empréstimos", JOptionPane.ERROR_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "Usuário está em débito!", "Usuário com livro não entregue", JOptionPane.ERROR_MESSAGE);
    }

    //verifica se o usuário já pegou o mesmo livro e ainda não devolveu
    private boolean verificaSeUsuarioNaoPegouLivro(String isbn, String usuario_id){
        try{
            return serv.Acao("SELECT * FROM emprestimo "
                    + "WHERE entregue = 'Não' AND isbn_livro = '" + isbn + "' AND usuarios_id = '" + usuario_id + "';").isEmpty();
        }catch(IndexOutOfBoundsException ioob){
            return false;
        }
    }
    
    //verifica se usuário tem livros não entregues e atrasados
    private int verificaSeEstaEmDebito(String usuario_id) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM emprestimo "
                    + "WHERE usuarios_id = '" + usuario_id + "' AND entregue = 'Não' AND data_entrega < '" + f.pegaDataAtualBD() + "';").get(0));
        } catch (IndexOutOfBoundsException ioob) {
            return 0;
        }
    }

    //verifica se o usuário já atingiu o seu limite (de acordo com seu tipo) de emprestimos não entregues
    private boolean verificaSePodePegar(String usuario_id) {
        String tipo_usuario = tipo_usuario(usuario_id);
        int qtdEmprestimos = qtdLivrosPegos(usuario_id);

        if (tipo_usuario.equals("alunos") && qtdEmprestimos < 3) {
            return true;
        } else if (tipo_usuario.equals("funcionarios") && qtdEmprestimos < 4) {
            return true;
        } else if (tipo_usuario.equals("professores") && qtdEmprestimos < 5) {
            return true;
        } else {
            return false;
        }
    }

    //retorna quantidade de livros pegos e não entregues pelo usuário especificado
    private int qtdLivrosPegos(String usuario_id) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND usuarios_id = '" + usuario_id + "';").get(0));
        } catch (IndexOutOfBoundsException | NumberFormatException ioob) {
            return 0;
        }
    }

    //retorna o tipo de usuário pelo ID do usuário
    private String tipo_usuario(String usuario_id) {
        try {
            return serv.Acao("SELECT tipo_usuario FROM usuarios WHERE id = '" + usuario_id + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }

    //calcula a data de entrega pelo tipo de usuário
    public String calculaDataEntrega(String usuario_id, String data) {
        String tipo_usuario = tipo_usuario(usuario_id);

        if (tipo_usuario.equals("alunos")) {
            return incrementaData(data, 15);
        } else if (tipo_usuario.equals("funcionarios")) {
            return incrementaData(data, 21);
        } else {
            return incrementaData(data, 30);
        }
    }

    //retorna 1 se o ano indicado for bissexto e 0 caso contrário
    private int anoBissexto(int ano) {
        if (ano % 100 != 0 && ano % 4 == 0 || ano % 400 == 0) {
            return 1;
        }
        return 0;
    }

    //retorna data incrementada de x dias
    private String incrementaData(String data, int qtdDias) {
        int a = Integer.parseInt(data.substring(data.length() - 4)),
                m = Integer.parseInt(data.substring(3, 5)),
                d = Integer.parseInt(data.substring(0, 2)),
                meses[] = {31, 28 + anoBissexto(a), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        d += qtdDias;

        while (d > meses[m - 1]) {
            d -= meses[m - 1];
            m++;
            if (m > 12) {
                m = 1;
                a++;
            }
        }
        return (d < 10 ? "0" + d : d) + "/" + (m < 10 ? "0" + m : m) + "/" + a;
    }

    //altera emprestimo
    /*public void alterar(String usuario_id, String isbn_livro, String data, String entregue) {
        if(serv.Acao("UPDATE emprestimo SET entregue = '" + entregue + "' "
                + "WHERE usuarios_id = '" + usuario_id + "' AND isbn_livro = '" + isbn_livro + "' AND data = '" + f.converteDataJ2BD(data) + "';") != null)
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }*/

    //apaga emprestimo
    public void apagar(String usuario_id, String isbn_livro, String data) {
        if(serv.Acao("DELETE FROM emprestimo WHERE usuarios_id = '" + usuario_id + "' AND isbn_livro = '" + isbn_livro + "' AND data = '" + f.converteDataJ2BD(data) + "';") != null)
            JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }

    //retorna a quantidade de livros no acervo cadastrados
    public String qtdCopiasLivros(String isbn){
        try{
            return serv.Acao("SELECT qtd_copias FROM livros WHERE isbn = '" + isbn + "';").get(0);
        }catch (IndexOutOfBoundsException ioob){
            return "0";
        }
    }
    
    //calcula a quantidade de livros disponíveis para emprestimos
    public int qtdLivrosDisponiveis(String isbn) {
        try {
            return Integer.parseInt(serv.Acao("SELECT (SELECT qtd_copias FROM livros WHERE isbn = '" + isbn + "') - COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND isbn_livro = '" + isbn + "';").get(0));
        } catch (IndexOutOfBoundsException | NumberFormatException ioob) {
            return 0;
        }
    }
    
    //retorna a quantidade de livros de emprestados
    public String qtdLivrosEmprestados(String isbn){
        try{
            return serv.Acao("SELECT COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND isbn_livro = '" + isbn + "';").get(0);
        }catch (IndexOutOfBoundsException ioob){
            return "0";
        }            
    }
    
    //retorna o titulo do livro especificado
    public String tituloLivro(String isbn) {
        try {
            return serv.Acao("SELECT titulo FROM livros WHERE isbn = '" + isbn + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }

    //retorna a quantidade de reservas apara aquele livro específico
    public int qtdReserva(String isbn) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "';").get(0));
        } catch (IndexOutOfBoundsException | NumberFormatException ioob) {
            return 0;
        }
    }

    //verifica se o usuário já reservou aquele livro e não foi atendida
    public boolean usuarioReservou(String usuario_id, String isbn) {
        try {
            return serv.Acao("SELECT * FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "' AND usuarios_id = '" + usuario_id + "'").size() > 0;
        } catch (IndexOutOfBoundsException ioob) {
            return false;
        }
    }

    //verifica se usuário está no ranking da fila de reservas, caso o livro esteja disponível mas não possa ser emprestado caso tenha mais reservas do que disponíveis
    public boolean noRanking(String usuario_id, String isbn, String ranking) {
        try {
            ArrayList<String> a = serv.Acao("SELECT usuarios_id FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "' "
                    + "ORDER BY data LIMIT " + (ranking.equals("") ? "1000" : ranking) + ";");
            return a.contains(usuario_id);
        } catch (IndexOutOfBoundsException ioob) {
            return false;
        }
    }

    //altera a reserva e coloca a flag de atendida para 'Sim'
    public void atendeReserva(String usuario_id, String isbn) {
        if(serv.Acao("UPDATE reserva SET atendida = 'Sim' WHERE usuarios_id = '" + usuario_id + "' AND isbn_livro = '" + isbn + "';") != null)
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }

    //altera o emprestimo colocando a flag de entregue para 'Sim'
    public void darBaixaEmprestimo(String usuario_id, String isbn, String data){
        if (serv.Acao("UPDATE emprestimo SET entregue = 'Sim' WHERE usuarios_id = '" + usuario_id + "' AND "
                        + "isbn_livro = '" + isbn + "' AND data = '" + f.converteDataJ2BD(data) + "';") != null)
            JOptionPane.showMessageDialog(null, "Livro Entregue!");
    }
    
    //cadastra reserva
    public void cadastraReserva(String usuario_id, String isbn, String data) {
        if(serv.Acao("INSERT INTO reserva VALUES ('" + usuario_id + "', '" + isbn + "', '" + f.converteDataJ2BD(data) + "', 'Não');") != null)
            JOptionPane.showMessageDialog(null, "Reservado com Sucesso!");
    }

    //consulta e povoa tabela de emprestimos pela sql passada por parâmetro
    public ArrayList<String> consultar(JTable jt, String sql) {
        try {
            ArrayList<String> a = serv.Acao(sql), b = new ArrayList<>();
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    b.add(a.get(i++));
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), f.converteDataBD2J(a.get(++i)), f.converteDataBD2J(a.get(++i)), a.get(++i)});
                }
            }
            return b;
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    //consulta e povoa tabela de reservas pela sql passada
    public void consultarReserva(JTable jt, String sql) {
        try {
            ArrayList<String> a = serv.Acao(sql);
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), f.converteDataBD2J(a.get(++i)), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}