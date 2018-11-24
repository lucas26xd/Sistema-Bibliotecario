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
        if(serv.Acao("INSERT INTO livros VALUES ('"+isbn+"', '"+titulo+"', '"+ano+"', '"+editora+"', '"+qtd+"', '"+categoria+"');") != null){
            if(cadastraAutoresdosLivros(isbn, jtAutores))
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }
    }
    
    private boolean cadastraAutoresdosLivros(String isbn, JTable jtAutores){
        String sql = "INSERT INTO livros_tem_autores VALUES ";
        for (int i = 0; i < jtAutores.getRowCount(); i++) {
            String cpf = jtAutores.getValueAt(i, 1).toString().replaceAll("\\.", "").replaceAll("-", "");
            sql += "('"+isbn+"', '"+cpf+"')";
            if (i < jtAutores.getRowCount()-1)
                sql += ", ";
        }
        sql += ";";
        return serv.Acao(sql) != null;
    }
    
    private boolean apagaAutoresdosLivros(String isbn){
        return serv.Acao("DELETE FROM livros_tem_autores WHERE isbn_livro = '"+isbn+"';") != null;
    }
    
    public void altera(String isbn, String titulo, String ano, String editora, String qtd, String categoria, JTable jtAutores){
        if(serv.Acao("UPDATE livros SET titulo = '"+titulo+"', ano_lancamento = '"+ano+"', editora = '"+editora+"', qtd_copias = '"+qtd+"', "
                    + "codigo_categoria = '"+categoria+"' WHERE isbn = '"+isbn+"';") != null){
        
            if(apagaAutoresdosLivros(isbn)){
                if(cadastraAutoresdosLivros(isbn, jtAutores))
                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            }
        }
    }
    
    public void apaga(String isbn){
        if(apagaAutoresdosLivros(isbn)){
            if(serv.Acao("DELETE FROM livros WHERE isbn = '"+isbn+"';") != null)
                JOptionPane.showMessageDialog(null, "Apagado com Sucesso!");
        }
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
    
    public void consultaView(JTable jt, String isbn, String titulo, String ano, String editora, String qtd, String categoria, String autor){
        try {
            ArrayList<String> a = serv.Acao("SELECT * FROM viewLivrosbyCategoria "
                                            + "WHERE isbn LIKE '"+isbn+"%' AND titulo LIKE '%"+titulo+"%' AND qtd_copias LIKE '"+qtd+"%' AND "
                                            + "nome LIKE '%"+autor+"%' AND ano_lancamento LIKE '"+ano+"%'  AND "
                                            + "editora LIKE '" + editora + "%' AND descricao LIKE '" + categoria + "%';");
            String ISBN, emprestados, reservas;
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    ISBN = a.get(i);
                    emprestados = serv.Acao("SELECT COUNT(*) FROM emprestimo WHERE entregue = 'Não' AND isbn_livro = '" + ISBN + "';").get(0);
                    reservas = serv.Acao("SELECT COUNT(*) FROM reserva WHERE atendida = 'Não' AND isbn_livro = '" + ISBN + "';").get(0);
                    mod.addRow(new Object[]{ISBN, a.get(++i), a.get(++i), a.get(++i), a.get(++i), emprestados, reservas, a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {}
    }
    
    public void consultaAutoresdosLivros(JTable jtAutores, String isbn){
        DefaultTableModel mod = (DefaultTableModel) jtAutores.getModel();
        mod.setNumRows(0);
        try {
            ArrayList<String> result = serv.Acao("SELECT a.nome, a.CPF, a.nacionalidade "
                                                + "FROM (livros_tem_autores lta JOIN autores a ON lta.CPF_autor = a.CPF) "
                                                + "WHERE lta.isbn_livro = '" + isbn + "' ORDER BY a.nome;");
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
        cbCategorias.removeAllItems();
        ArrayList<String> cods = new ArrayList<>();
        try{
            ArrayList<String> a = serv.Acao("SELECT * FROM categorias;");
            if(a != null){
                for (int i = 0; i < a.size(); i++) {
                    cods.add(a.get(i));
                    cbCategorias.addItem(a.get(++i));
                }
            }
        }catch(IndexOutOfBoundsException ioob){
            JOptionPane.showMessageDialog(null, "Erro no povoamento do combobox!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        cbCategorias.setSelectedIndex(-1);
        return cods;
    }
}
