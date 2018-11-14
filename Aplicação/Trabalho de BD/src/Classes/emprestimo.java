package Classes;

import BD.Servicos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas, arquivo criado dia 13/11/2018 às 22:31:51
 */
public class emprestimo {

    private Servicos serv;

    public emprestimo(Servicos serv) {
        this.serv = serv;
    }

    public void cadastra(String usuario_id, String isbn_livro, String data, String data_entrega) {
        if (verificaSePodePegar(usuario_id)) {
            serv.Acao("INSERT INTO emprestimo VALUES ('" + usuario_id + "', '" + isbn_livro + "', '" + data + "', '" + data_entrega + "', 'Não');");
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário atingiu o limite de empréstimos!", "Limite de Empréstimos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verificaSePodePegar(String usuario_id) {
        String tipo_usuario = tipo_usuario(usuario_id);
        int qtdEmprestimos = qtdLivrosPegos(usuario_id);

        if (tipo_usuario.equals("alunos") && qtdEmprestimos < 3) {
            return true;
        } else if (tipo_usuario.equals("funcionarios") && qtdEmprestimos < 4) {
            return true;
        } else if (tipo_usuario.equals("professores") || tipo_usuario.equals("administrador")
                || tipo_usuario.equals("bibliotecario") && qtdEmprestimos < 5) {
            return true;
        } else {
            return false;
        }
    }

    private int qtdLivrosPegos(String usuario_id) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND usuarios_id = '" + usuario_id + "';").get(0));
        } catch (IndexOutOfBoundsException ioob) {
            return 0;
        }
    }

    private String tipo_usuario(String usuario_id) {
        try {
            return serv.Acao("SELECT tipo_usuario FROM usuarios WHERE id = '" + usuario_id + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }

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

    private int anoBissexto(int ano) {
        if (ano % 100 != 0 && ano % 4 == 0 || ano % 400 == 0) {
            return 1;
        }
        return 0;
    }

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

    public void alterar(String usuario_id, String isbn_livro, String data, String entregue) {
        serv.Acao("UPDATE emprestimo SET entregue = '" + entregue + "' "
                + "WHERE usuario_id = '" + usuario_id + "' AND isbn_livro = '" + isbn_livro + "' AND data = '" + data + "';");
        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }

    public void apagar(String usuario_id, String isbn_livro, String data) {
        serv.Acao("DELETE FROM emprestimo WHERE usuario_id = '" + usuario_id + "' AND isbn_livro = '" + isbn_livro + "' AND data = '" + data + "';");
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }

    public int qtdLivrosDisponiveis(String isbn) {
        try {
            return Integer.parseInt(serv.Acao("SELECT (SELECT qtd_copias FROM livros WHERE isbn = '" + isbn + "') - COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND isbn_livro = '" + isbn + "';").get(0));
        } catch (IndexOutOfBoundsException ioob) {
            return 0;
        }
    }

    public int qtdReserva(String isbn) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "';").get(0));
        } catch (IndexOutOfBoundsException ioob) {
            return 0;
        }
    }

    public boolean usuarioReservou(String usuario_id, String isbn) {
        try {
            return serv.Acao("SELECT * FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "' AND usuario_id = '" + usuario_id + "'").size() > 0;
        } catch (IndexOutOfBoundsException ioob) {
            return false;
        }
    }

    public boolean noRanking(String usuario_id, String isbn, String ranking) {
        try {
            ArrayList<String> a = serv.Acao("SELECT usuario_id FROM reserva "
                    + "WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "' "
                    + "ORDER BY data LIMIT " + ranking + ";");
            return a.contains(usuario_id);
        } catch (IndexOutOfBoundsException ioob) {
            return false;
        }
    }

    public void atendeReserva(String usuario_id, String isbn) {
        serv.Acao("UPDATE reserva SET atendida = 'Sim' WHERE usuario_id = '" + usuario_id + "' AND isbn_livro = '" + isbn + "';");
        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }
    
    public void cadastraReserva(String usuario_id, String isbn, String data){
        serv.Acao("INSERT INTO reserva VALUES ('"+usuario_id+"', '"+isbn+"', '"+data+"', 'Não');");
        JOptionPane.showMessageDialog(null, "Reservado com Sucesso!");
    }

    public String pega_Data(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
    
    public String pegaDataFormatada(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public String converteDataBD(String data){
        int y = Integer.parseInt(data.substring(data.length()-4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("/")+1, data.lastIndexOf("/"))) - 1, d = Integer.parseInt(data.substring(0, data.indexOf("/")));
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(y, m, d));
    }
    
    public String converteDataJava(String data){
        int y = Integer.parseInt(data.substring(0, 4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("-")+1, data.lastIndexOf("-"))) - 1, d = Integer.parseInt(data.substring(data.lastIndexOf("-")+1));
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(y, m, d));
    }
    
    public void consultar(String nome_usuario, String isbn_livro, String titulo, String data, String data_entrega, String entregue) {

    }
}
