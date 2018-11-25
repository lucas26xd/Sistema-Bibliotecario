package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 07/11/2018 às 16:12:34
 */
public class autores {

    private Servicos serv;

    public autores(Servicos serv) {
        this.serv = serv;
    }

    public void cadastra(String nome, String cpf, String nacionalidade) {
        if(serv.Acao("INSERT INTO autores VALUES ('" + nome + "', '" + cpf + "', '" + nacionalidade + "');") != null)
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
    }

    public void altera(String nome, String cpf, String nacionalidade) {
        if(serv.Acao("UPDATE autores SET nome = '" + nome + "', nacionalidade = '" + nacionalidade + "' WHERE CPF = '" + cpf + "';") != null)
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }

    public void apaga(String cpf) {
        if(serv.Acao("DELETE FROM autores WHERE CPF = '" + cpf + "';") != null)
            JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }

    public void consulta(JTable jt, String nome, String cpf, String nacionalidade) {
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try {
            ArrayList<String> result = serv.Acao("SELECT * FROM autores WHERE nome LIKE '%" + nome + "%' AND CPF LIKE '" + cpf + "%' AND nacionalidade LIKE '%" + nacionalidade + "%' ORDER BY nome;");
            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    mod.addRow(new Object[]{result.get(i), new funcoes().mascaraCPF(result.get(++i)), result.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
