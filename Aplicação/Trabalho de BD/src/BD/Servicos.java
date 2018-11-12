package BD;

import java.sql.Connection;
import java.util.ArrayList;

public class Servicos{

    Connection con;

    public Servicos(Connection con){
        this.con = con;
    }
    
    public ArrayList<String> Acao(String sql){
        ArrayList<String> resultado = null;
        try{
            System.out.println("String no servidor -> "+sql);
            
            SQL action = new SQL(con);

            if(sql.matches("(?i)select.*") || sql.matches("(?i)desc.*") || sql.contains("(?i)show.*")){
                //resultado = new ArrayList<>();
                resultado = action.retornarDados(sql);      //RETORNA O RESULTADO PEDIDO PELO USUÁRIO
                if(resultado != null){
                    System.out.println("enviado: "+resultado.toString());
                }else{
                    System.out.println("Resultado = null na classe: "+getClass());
                }
            }else if(sql.matches("(?i)delete.*") || sql.contains("(?i)drop.*") || 
                    sql.contains("(?i)insert.*") || sql.contains("(?i)update.*") || 
                    sql.contains("(?i)create.*")){
                action.inserirDados(sql);
            }else{
                System.out.println("Nada a Fazer :(");
            }            
        }catch(Exception ex){
            System.out.println("Erro na classe: "+getClass()+" : "+ex.getMessage());
        }
        return resultado;
    }
}