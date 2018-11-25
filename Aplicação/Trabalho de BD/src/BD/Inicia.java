package BD;

import java.sql.Connection;

/**
 * @author lucas, arquivo criado dia 05/11/2018 às 12:35:09
 */

/**
 * Classe inicial de conexão com o Banco de Dados.
 */
public class Inicia {
    private Connection con = null;
    private Conexao c = null;

    /**
    * Método que inicia a conexão com o Banco de Dados e retorna um objeto do tipo Servicos
    * que será utilizado por todas as telas para executar os comandos SQL específicos de cada função.
    * @param login login de acesso ao Banco de Dados
    * @param senha senha de acesso ao Banco de Dados
    * @param bd nome do Banco de Dados
    * @param local IP/Local do Banco de Dados
    * @return Objeto do tipo Servicos que será usado por todas as telas para execução dos comando SQL.
    */
    public Servicos Inicia(String login, String senha, String bd, String local){
        c = new Conexao();
        con = c.Abrir(login, senha, bd, local);
        if(con != null)
            return new Servicos(con);
        else
            return null;
    }
}
