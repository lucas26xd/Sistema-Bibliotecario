package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 07/11/2018 às 21:52:46
 */
public class livros {

    private Servicos serv;
    
    public livros(Servicos serv){
        this.serv = serv;
    }
    
    public void cadastra(String isbn, String titulo, String ano, String editora, String qtd, String categoria, JTable jtAutores){
        serv.Acao("insert into livros values ('"+isbn+"', '"+titulo+"', '"+ano+"', '"+editora+"', '"+qtd+"', '"+categoria+"');");
        cadastraAutoresdosLivros(isbn, jtAutores);
        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
    
    private void cadastraAutoresdosLivros(String isbn, JTable jtAutores){
        for (int i = 0; i < jtAutores.getRowCount(); i++) {
            String cpf = jtAutores.getValueAt(i, 1).toString().replaceAll("\\.", "").replaceAll("-", "");
            serv.Acao("insert into livros_tem_autores values ('"+isbn+"', '"+cpf+"');");
        }
    }
    
    private void apagaAutoresdosLivros(String isbn){
        serv.Acao("delete from livros_tem_autores where isbn = '"+isbn+"';");
    }
    
    public void altera(String isbn, String titulo, String ano, String editora, String qtd, String categoria, JTable jtAutores){
        serv.Acao("update livros set titulo = '"+titulo+"', ano_lancamento = '"+ano+"', editora = '"+editora+"', qtd_copias = '"+qtd+"', codigo_categoria = '"+categoria+"';");
        
        apagaAutoresdosLivros(isbn);
        cadastraAutoresdosLivros(isbn, jtAutores);
        
        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }
    
    public void apaga(String isbn){
        serv.Acao("delete from livros where isbn = '"+isbn+"';");
        apagaAutoresdosLivros(isbn);
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    public void consulta(JTable jt, String isbn, String titulo, String ano, String editora, String qtd, String categoria, String autor){
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try {
            ArrayList<String> result = serv.Acao("select l.isbn, l.titulo, l.ano_lancamento, l.editora, l.qtd_copias, c.descricao from livros as l, \n" +
                                                    "categorias as c, livros_tem_autores as lta, autores as a where c.codigo = l.codigo_categoria and \n" +
                                                    "a.CPF = lta.CPF_autor and lta.isbn_livro = l.isbn and a.nome like '%"+autor+"%' and l.isbn like '"+isbn+"%' " +
                                                    "and l.titulo like '%"+titulo+"%' and l.ano_lancamento like '"+ano+"%'  and l.editora like '"+editora+"%' and \n" +
                                                    "l.qtd_copias like '"+qtd+"%' and l.codigo_categoria like '"+categoria+"%' order by l.titulo;");
            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    mod.addRow(new Object[]{result.get(i), result.get(++i), result.get(++i), result.get(++i), result.get(++i), result.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultaAutoresdosLivros(JTable jtAutores, String isbn){
        DefaultTableModel mod = (DefaultTableModel) jtAutores.getModel();
        mod.setNumRows(0);
        try {
            ArrayList<String> result = serv.Acao("select a.nome, a.CPF, a.nacionalidade from livros_tem_autores as lta, autores as a where lta.CPF_autor = a.CPF and lta.isbn = '" + isbn + "' order by a.nome;");
            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    mod.addRow(new Object[]{result.get(i), result.get(++i), result.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<String> povoaCategorias(JComboBox cbCategorias){
        ArrayList<String> cods = new ArrayList<>();
        try{
            ArrayList<String> a = serv.Acao("select * from categorias;");
            for (int i = 0; i < a.size(); i++) {
                cods.add(a.get(i));
                cbCategorias.addItem(a.get(++i));
            }
        }catch(IndexOutOfBoundsException ioob){
            JOptionPane.showMessageDialog(null, "Erro no povoamento do combobox!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        cbCategorias.setSelectedIndex(-1);
        return cods;
    }
    
}
