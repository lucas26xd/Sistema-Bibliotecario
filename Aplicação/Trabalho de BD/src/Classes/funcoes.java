package Classes;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lucas, arquivo criado dia 21/11/2018 às 17:52:45
 */
public class funcoes {
    
    //encripta senha pelo algoritmo SHA-1, retorna a senha encriptada com 40 caracteres
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
    
    //retorna a data atual
    public String pegaDataAtual() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    //retorna hora atual
    public String pegaHoraAtual(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    
    //retorna a data atual no formato da BD
    public String pegaDataAtualBD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    //converte a data do padrão do java (dd/MM/yyyy) para o padrão do BD (yyyy-MM-dd)
    public String converteDataJ2BD(String data) {
        int y = Integer.parseInt(data.substring(data.length() - 4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("/") + 1, data.lastIndexOf("/"))) - 1, d = Integer.parseInt(data.substring(0, data.indexOf("/")));
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(y, m, d));
    }

    //converte a data do padrão do BD (yyyy-MM-dd) para o padrão do java (dd/MM/yyyy)
    public String converteDataBD2J(String data) {
        int y = Integer.parseInt(data.substring(0, 4)) - 1900, m = Integer.parseInt(data.substring(data.indexOf("-") + 1, data.lastIndexOf("-"))) - 1, d = Integer.parseInt(data.substring(data.lastIndexOf("-") + 1));
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(y, m, d));
    }
    
    //mascara de CPF, apenas aparência
    public String mascaraCPF(String cpf1) {
        String cpf2 = "";
        for (int i = 0; i < cpf1.length(); i++) {
            if (i == 3 || i == 6) {
                cpf2 += ".";
            } else if (i == 9) {
                cpf2 += "-";
            }
            cpf2 += cpf1.charAt(i);
        }
        return cpf2;
    }
}