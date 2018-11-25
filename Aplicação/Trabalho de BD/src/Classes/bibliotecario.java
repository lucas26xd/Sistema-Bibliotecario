package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author angel, arquivo criado em 24/11/2018 às 19:24:08
 */
public class bibliotecario {
    
    private Servicos serv;
    private usuario user;
    
    public bibliotecario(Servicos serv) {        
        this.serv = serv;
        user = new usuario(serv);
    }
    
    public void cadastra(String login, String nome, String endereco, String senha) {
        if(!user.cadastraUsuario(login, senha, nome, endereco, "bibliotecario").equals("0"))
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }       
    
    public void altera(String login, String senha, String nome, String endereco) {
        if(user.alteraUsuario(login, senha, nome, endereco))
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }
    
    public void apaga(String usuario_id) {
        if(serv.Acao("DELETE FROM usuarios WHERE id = '" +usuario_id+ "'; ") != null)
            JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    public void consulta(JTable jt, String nome, String endereco) {        
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        
        try {
            if(serv.Acao("SELECT login, nome, endereco FROM usuarios WHERE nome LIKE '%" +nome+ "%' AND endereco LIKE '%" +endereco+ "%';") != null) { 
                ArrayList<String> result = serv.Acao("SELECT login, nome, endereco FROM usuarios WHERE nome LIKE '%" +nome+ "%' AND endereco LIKE '%" +endereco+ "%';");
                for (int i = 0; i < result.size(); i++) {
                    mod.addRow(new Object[]{result.get(i), result.get(++i), result.get(++i)});
                }
            } 
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }        
    }
}    