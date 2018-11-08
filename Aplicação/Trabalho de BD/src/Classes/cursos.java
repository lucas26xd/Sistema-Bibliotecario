package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author angela, arquivo criado em 07/11/2018 às 22:15:12
 */
public class cursos {

    private Servicos serv;
    
    public cursos(Servicos serv) {
        this.serv = serv;
    }
    
    public void cadastra(String cod_curso, String nome_curso){
        serv.Acao("insert into curso values ('"+cod_curso+"', '"+nome_curso+"');");
        JOptionPane.showMessageDialog(null, "Curso Inserido com Sucesso!");
    }
    
    public void altera(String cod_curso, String nome_curso){
        serv.Acao("update curso set nome_curso = '"+nome_curso+"' where cod_curso = '"+cod_curso+"';");
        JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso!");
    }
    
    public void apaga(String cod_curso) {
        serv.Acao("delete from curso where cod_curso = '"+cod_curso+"';");
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    public void consulta(JTable jt, String cod_curso, String nome_curso){
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try{
            ArrayList<String> result = serv.Acao("select from curso where cod_curso like '"+cod_curso+"'%, nome_curso like '%"+nome_curso+"%' order by nome_curso;");
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

