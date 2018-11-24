package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 24/11/2018 às 12:52:43
 */
public class buscarbyViews {

    private Servicos serv;
    private ArrayList<String> a;
    private DefaultTableModel mod;
    
    public buscarbyViews(Servicos serv){
        this.serv = serv;
    }
    
    public void povoaCombo (JComboBox cb, String sql) {
        try{
            a = serv.Acao(sql);
            if(a != null){
                for (int i = 0; i < a.size(); i++) {
                    cb.addItem(a.get(i));
                }
            }
        }catch(IndexOutOfBoundsException ioob){}
    }
    
    public void ProfbyCurso (JTable jt, String nome, String regime, String curso) {
        try {
            a = serv.Acao("SELECT * FROM viewProfbyCurso WHERE nome LIKE '" + nome + "%' AND regime_trabalho LIKE '" + regime + "%' AND nome_curso = '" + curso + "%';");
            if (a != null) {
                mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {}
    }
    
    public void LivrosbyX (String view, JTable jt, String editora, String categoria) {
        try {
            a = serv.Acao("SELECT * FROM " + view + " WHERE editora LIKE '" + editora + "%' AND descricao LIKE '" + categoria + "%';");
            String isbn, emprestados, reservas;
            if (a != null) {
                mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    isbn = a.get(i);
                    emprestados = serv.Acao("SELECT COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND isbn_livro = '" + isbn + "';").get(0);
                    reservas = serv.Acao("SELECT COUNT(*) FROM reserva WHERE atendida = 'Não' AND isbn_livro = '" + isbn + "';").get(0);
                    mod.addRow(new Object[]{isbn, a.get(++i), a.get(++i), a.get(++i), a.get(++i), emprestados, reservas, a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {}
    }    
}
