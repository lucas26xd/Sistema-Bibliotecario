package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public void inserirDados(String sql) {
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("erro ao inserir dados na " + getClass() + " -> " + ex.getMessage());
        }
    }

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
            System.out.println("erro ao retornar os dados na " + getClass() + " -> " + ex.getMessage());
            return null;
        }
        return lista;
    }
}
