package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe onde manda as expressões SQL para o SGBD, para serem executadas.
 */
public class SQL {

    Statement stmt;
    ResultSet rs;

    public SQL(Connection con) {
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("erro na " + getClass() + " -> " + ex.getMessage());
        }
    }

    /**
    * Método que executa SQLs que não tem retorno do SGBD.
    * @param sql Expressão SQL à ser executada
    * @return <emph>TRUE</emph> se foi executaod com sucesso, <emph>FALSE</emph> se ocorreu algum erro no SGBD.
    */
    public boolean inserirDados(String sql) {
        try {
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            //System.out.println("erro ao inserir dados na " + getClass() + " -> " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
    * Método que executa as SQLs que retornam algo do SGBD.
    * @param sql Expressão SQL à ser executada
    * @return ArrayList<String> contendo o resultado da execução da expresão SQL, 
    * retorna <emph>null</emph> se o SGBD retornou algum erro.
    */
    public ArrayList<String> retornarDados(String sql) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            int cont = 1;
            boolean valor = true;
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    while (valor) {
                        try {
                            lista.add(rs.getString(cont));
                            cont++;
                        } catch (SQLException ex) {
                            cont = 1;
                            valor = false;
                        }
                    }
                    valor = true;
                }
            } else {
                lista = null;
            }
        } catch (SQLException ex) {
            //System.out.println("erro ao retornar os dados na " + getClass() + " -> " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
}
