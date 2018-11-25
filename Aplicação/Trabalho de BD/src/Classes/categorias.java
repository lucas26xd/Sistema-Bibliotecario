package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author angela, arquivo criado em 08/11/2018 às 00:12:38
 */
public class categorias {

    private Servicos serv;
    
    public categorias(Servicos serv) {
        this.serv = serv;
    }
    
    //cadastra categorias
    public void cadastra(String codigo, String descricao){
        if(serv.Acao("INSERT INTO categorias VALUES ('"+codigo+"', '"+descricao+"');") != null)
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
    }
    
    //altera categorias
    public void altera(String codigo, String descricao){
        if(serv.Acao("UPDATE categorias SET descricao = '"+descricao+"' WHERE codigo = '"+codigo+"';") != null)
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso!");
    }
    
    //apaga categorias
    public void apaga(String codigo) {
        if(serv.Acao("DELETE FROM categorias WHERE codigo = '"+codigo+"';") != null)
            JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    //consulta e povoa tabela de categorias pelo codigo e descricao
    public void consulta(JTable jt, String codigo, String descricao){
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try{
            ArrayList<String> result = serv.Acao("SELECT * FROM categorias WHERE codigo LIKE '"+codigo+"%' AND descricao LIKE '%"+descricao+"%' ORDER BY codigo;");
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