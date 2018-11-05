package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas, arquivo criado dia 05/11/2018 às 12:30:01
 */
public class Conexao {
    Connection con = null;
    
    public Connection Abrir(String login, String senha, String bd, String endereco){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + endereco + "/" + bd, login, senha);
            System.out.println("Conexão aberta com sucesso na classe Conexão.");
        }catch ( ClassNotFoundException | SQLException ex ){
            System.err.println("Error ao abrir conexão na classe Conexão.\n" + ex);
            JOptionPane.showMessageDialog(null, "Error ao abrir conexão do banco de dados!", null, JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
    /*
    public Connection Abrir_forcado(String login, String senha, String endereco){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + endereco, login, senha);
            System.out.println("Conexão aberta com sucesso na classe Conexão.");
        }catch ( ClassNotFoundException | SQLException ex ){
            System.err.println("Error ao abrir conexão forçada na classe Conexão.\n" + ex);
            JOptionPane.showMessageDialog(null, "Error ao abrir conexão forçada do banco de dados!", null, JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }*/
    
    public void Fechar(Connection con){
        try{
            con.close();
            System.out.println("Conexão fechada com sucesso na classe Conexao.");
        }catch (SQLException ex){
            System.out.println("Erro ao fechar a conexão na classe Conexão.\n" + ex);
        }
    }
}
