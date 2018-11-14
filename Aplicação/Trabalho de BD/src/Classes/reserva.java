package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas, arquivo criado dia 13/11/2018 às 22:31:51
 */
public class reserva {

    private Servicos serv;

    public reserva(Servicos serv) {
        this.serv = serv;
    }

    public void cadastra(String usuario_id, String isbn_livro, String data, String data_entrega) {
        if (verificaSePodePegar(usuario_id)) {
            serv.Acao("INSERT INTO reserva VALUES ('" + usuario_id + "', '" + isbn_livro + "', '" + data + "', '" + data_entrega + "', 'Não');");
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } else
            JOptionPane.showMessageDialog(null, "Usuário atingiu o limite de empréstimos!", "Limite de Empréstimos", JOptionPane.ERROR_MESSAGE);
    }

    private boolean verificaSePodePegar(String usuario_id) {
        String tipo_usuario = tipo_usuario(usuario_id);
        int qtdEmprestimos = qtdLivrosPegados(usuario_id);

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

    private int qtdLivrosPegados(String usuario_id) {
        try {
            return Integer.parseInt(serv.Acao("SELECT COUNT(*) FROM reservas WHERE entregue = 'Não' AND usuarios_id = '" + usuario_id + "';").get(0));
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
        serv.Acao("UPDATE reserva SET entregue = '"+entregue+"' "
                + "WHERE usuario_id = '"+usuario_id+"' AND isbn_livro = '"+isbn_livro+"' AND data = '"+data+"';");
        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }
    
    public void apagar(String usuario_id, String isbn_livro, String data) {
        serv.Acao("DELETE FROM reserva WHERE usuario_id = '"+usuario_id+"' AND isbn_livro = '"+isbn_livro+"' AND data = '"+data+"';");
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    
    public void consultar(String nome_usuario, String isbn_livro, String titulo, String data, String data_entrega, String entregue) {
        
    }
}
