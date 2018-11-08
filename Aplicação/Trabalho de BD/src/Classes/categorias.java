package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angela, arquivo criado em 08/11/2018 às 00:12:38
 */
public class categorias {

    private Servicos serv;
    
    public categorias(Servicos serv) {
        this.serv = serv;
    }
    
    public void cadastra(String codigo, String descricao){
        serv.Acao("insert into categorias values ('"+codigo+"', '"+descricao+"');");
        JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
    }
    
    public void altera(String codigo, String descricao){
        serv.Acao("update categorias set descricao = '"+descricao+"' where codigo = '"+codigo+"';");
        JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso!");
    }
    
     public void apaga(String codigo) {
        serv.Acao("delete from categorias where codigo = '"+codigo+"';");
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
     
    public void consulta(JTable jt, String codigo, String descricao){
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try{
            ArrayList<String> result = serv.Acao("select from categorias where codigo like '"+codigo+"'%, descricao like '%"+descricao+"%' order by codigo;");
            if (result != null) {
                for (int i = 0; i < result.size(); i++){
                    mod.addRow(new Object[]{result.get(i), result.get(++i)});
                }
            }
        }catch(IndexOutOfBoundsException ioob){
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } 
}