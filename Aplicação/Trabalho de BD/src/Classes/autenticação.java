package Classes;

import BD.Servicos;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lucas, arquivo criado dia 06/11/2018 às 09:44:40
 */
public class autenticação {

    private Servicos serv;
    
    public autenticação(Servicos serv){
        this.serv = serv;
    }
    
    public boolean autentica(String login, String senha){
        try{
            return serv.Acao("SELECT * FROM usuarios WHERE login = '"+login+"' AND senha = '"+encripta(senha)+"';").size() > 0;
        }catch(IndexOutOfBoundsException ioob){
            return false;
        }
    }
    
    private String encripta(String senha){
        try{
            MessageDigest cript = MessageDigest.getInstance("SHA-1");
            cript.reset();
            cript.update(senha.getBytes("UTF-8"));

            return new BigInteger(1, cript.digest()).toString(16);
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return "";
        }
    }
    
    public String tipoUsuario(String login, String senha){
        try{
            return serv.Acao("SELECT tipo_usuario FROM usuarios WHERE login = '"+login+"' AND senha = '"+encripta(senha)+"';").get(0);
        }catch(IndexOutOfBoundsException ioob){
            return "";
        }
    }
    
}
