package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 15/11/2018 às 20:25:45
 */
public class usuario {

    private Servicos serv;
    private funcoes f = new funcoes();
    
    public usuario(Servicos serv) {
        this.serv = serv;
    }

    public void consulta(JTable jt, String nome, String tipo) {
        try {
            ArrayList<String> a = serv.Acao("SELECT nome, login, endereco, tipo_usuario FROM usuarios "
                    + "WHERE nome LIKE '%" + nome + "%' AND tipo_usuario"
                    + (tipo != null ? " <> 'administrador' AND tipo_usuario <> 'bibliotecario'" : " = '" + tipo + "'") + " GROUP BY tipo_usuario, nome, login, endereço ORDER BY nome ;");
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
        }
    }

    public String pegaUsuario_id(String login) {
        try {
            return serv.Acao("SELECT id FROM usuarios WHERE login = '" + login + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }

    public String cadastra(String login, String senha, String nome, String endereco, String tipo_usuario) {
        try {
            if (serv.Acao("INSERT INTO usuarios VALUES ('DEFAULT', '" + login + "', '" + f.encripta(senha) + "', '" + nome + "', '" + endereco + "', '" + tipo_usuario + "');") != null) {
                //JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
                try {Thread.sleep(100);} catch (InterruptedException ie) {}
                return serv.Acao("SELECT MAX(id) FROM usuarios;").get(0);
            } else
                return "0";
        } catch (IndexOutOfBoundsException ioob) {
            return "0";
        }
    }
    
    public void cadatraAluno(String usuario_id, String matricula, String data_ingresso, String data_conclusao, String cod_curso){
        if (serv.Acao("INSERT INTO alunos VALUES ('"+matricula+"', '"+f.converteDataJ2BD(data_ingresso)+"', '"+f.converteDataJ2BD(data_conclusao)+"', '"+cod_curso+"', '"+usuario_id+"');") != null)
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
}
