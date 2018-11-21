package Classes;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lucas, arquivo criado dia 21/11/2018 às 17:52:45
 */
public class funcoes {
    
    public String encripta(String senha) {
        try {
            MessageDigest cript = MessageDigest.getInstance("SHA-1");
            cript.reset();
            cript.update(senha.getBytes("UTF-8"));

            return new BigInteger(1, cript.digest()).toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return "";
        }
    }
    
    public String pegaDataAtual() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public String pegaDataAtualBD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public String converteDataJ2BD(String data) {
        int y = Integer.parseInt(data.substring(data.length() - 4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("/") + 1, data.lastIndexOf("/"))) - 1, d = Integer.parseInt(data.substring(0, data.indexOf("/")));
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(y, m, d));
    }

    public String converteDataBD2J(String data) {
        int y = Integer.parseInt(data.substring(0, 4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("-") + 1, data.lastIndexOf("-"))) - 1, d = Integer.parseInt(data.substring(data.lastIndexOf("-") + 1));
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(y, m, d));
    }
}