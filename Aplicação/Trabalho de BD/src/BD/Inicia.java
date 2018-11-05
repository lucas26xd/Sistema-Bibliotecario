package BD;

import java.sql.Connection;

/**
 *
 * @author lucas, arquivo criado dia 05/11/2018 às 12:35:09
 */
public class Inicia {
    private Connection con = null;
    private Conexao c = null;
    
    public Servicos Inicia(String login, String senha, String bd, String local){
        c = new Conexao();
        con = c.Abrir(login, senha, bd, local);
        return new Servicos(con);
    }
    /*
    public Connection Inicia_sem_banco(String login, String senha, String local){
        c = new Conexao();
        con = c.Abrir_forcado(login, senha, local);
        return con;
    }*/
}
