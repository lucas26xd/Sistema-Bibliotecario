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
        serv.Acao("INSERT INTO livros VALUES ('"+isbn+"', '"+titulo+"', '"+ano+"', '"+editora+"', '"+qtd+"', '"+categoria+"');");
        cadastraAutoresdosLivros(isbn, jtAutores);
        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
    
    private void cadastraAutoresdosLivros(String isbn, JTable jtAutores){
        for (int i = 0; i < jtAutores.getRowCount(); i++) {
            String cpf = jtAutores.getValueAt(i, 1).toString().replaceAll("\\.", "").replaceAll("-", "");
            serv.Acao("INSERT INTO livros_tem_autores VALUES ('"+isbn+"', '"+cpf+"');");
        }
    }
    
    private void apagaAutoresdosLivros(String isbn){
        serv.Acao("DELETE FROM livros_tem_autores WHERE isbn = '"+isbn+"';");
    }
    
    public void altera(String isbn, String titulo, String ano, String editora, String qtd, String categoria, JTable jtAutores){
        serv.Acao("UPDATE livros SET titulo = '"+titulo+"', ano_lancamento = '"+ano+"', editora = '"+editora+"', qtd_copias = '"+qtd+"', "
                    + "codigo_categoria = '"+categoria+"' WHERE isbn = '"+isbn+"';");
        
        apagaAutoresdosLivros(isbn);
        cadastraAutoresdosLivros(isbn, jtAutores);
        
        JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
    }
    
    public void apaga(String isbn){
        serv.Acao("DELETE FROM livros WHERE isbn = '"+isbn+"';");
        apagaAutoresdosLivros(isbn);
        JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
    }
    
    public void consulta(JTable jt, String isbn, String titulo, String ano, String editora, String qtd, String categoria, String autor){
        DefaultTableModel mod = (DefaultTableModel) jt.getModel();
        mod.setNumRows(0);
        try {
            ArrayList<String> result = serv.Acao("SELECT l.isbn, l.titulo, l.ano_lancamento, l.editora, l.qtd_copias, c.descricao "
                                                + "FROM (((livros l JOIN categorias c ON c.codigo = l.codigo_categoria) "
                                                    + "JOIN livros_tem_autores lta ON lta.isbn_livro = l.isbn) JOIN autores a ON a.CPF = lta.CPF_autor) "
                                                + "WHERE a.nome LIKE '%"+autor+"%' AND l.isbn LIKE '"+isbn+"%' AND l.titulo LIKE '%"+titulo+"%' AND "
                                                    + "l.ano_lancamento LIKE '"+ano+"%'  AND l.editora LIKE '"+editora+"%' AND l.qtd_copias LIKE '"+qtd+"%' AND "
                                                    + "l.codigo_categoria LIKE '"+categoria+"%' "
                                                + "GROUP BY c.descricao, l.isbn, l.titulo, l.ano_lancamento, l.editora, l.qtd_copias ORDER BY l.titulo;");
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
            ArrayList<String> result = serv.Acao("SELECT a.nome, a.CPF, a.nacionalidade FROM livros_tem_autores AS lta, autores AS a WHERE lta.CPF_autor = a.CPF AND lta.isbn = '" + isbn + "' ORDER BY a.nome;");
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
            ArrayList<String> a = serv.Acao("SELECT * FROM categorias;");
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
