package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author lucas, arquivo criado dia 05/11/2018 às 12:30:01
 */

/**
 * Classe onde abre a conexão com Banco de Dados.
 */
public class Conexao {
    Connection con = null;
    
    /**
    * Método onde de fato inicia a conexão com o Banco de Dados a partir da biblioteca  'com.mysql.jdbc_5.1.5.jar'
    * O retorno do método é um objeto do tipo Connection que é utilizado na classe de Servicos que usa 
    * essa conexão com o Banco para executar as SQLs.
    * @param login login de acesso ao Banco de Dados
    * @param senha senha de acesso ao Banco de Dados
    * @param bd nome do Banco de Dados
    * @param endereco IP/Local do Banco de Dados
    * @return Objeto do tipo Servicos que será usado por todas as telas para execução dos comando SQL.
    */
    public Connection Abrir(String login, String senha, String bd, String endereco){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + endereco + "/" + bd, login, senha);
            System.out.println("Conexão aberta com sucesso na classe Conexão.");
        }catch ( ClassNotFoundException | SQLException ex ){
            System.err.println("Error ao abrir conexão na classe Conexão.\n" + ex);
            JOptionPane.showMessageDialog(null, "Error ao abrir conexão do banco de dados!\nErro: " + ex, null, JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
    
    /**
    * Método onde eventualmente fecha a conexão com o banco de dados caso seja necessário.
    * @param con Connection à ser fechada
    */
    public void Fechar(Connection con){
        try{
            con.close();
            System.out.println("Conexão fechada com sucesso na classe Conexao.");
        }catch (SQLException ex){
            System.out.println("Erro ao fechar a conexão na classe Conexão.\n" + ex);
        }
    }
}
