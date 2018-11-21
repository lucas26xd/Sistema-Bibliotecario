package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 15/11/2018 às 20:25:45
 */
public class usuario {

    private Servicos serv;

    public usuario(Servicos serv) {
        this.serv = serv;
    }

    public void consulta(JTable jt, String nome, String tipo) {
        try {
            ArrayList<String> a = serv.Acao("SELECT nome, login, endereço, tipo_usuario FROM usuarios "
                    + "WHERE nome LIKE '%" + nome + "%' AND tipo_usuario"
                    + (tipo != null ? " <> 'administrador' AND tipo_usuario <> 'bibliotecario'" : " = '" + tipo + "'") + " GROUP BY tipo_usuario, nome, login, endereço ORDER BY nome ;");
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {}
    }

    public String pegaUsuario_id(String login) {
        try {
            return serv.Acao("SELECT id FROM usuarios WHERE login = '" + login + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }
    
    public void cadastra(){
        
    }
}
