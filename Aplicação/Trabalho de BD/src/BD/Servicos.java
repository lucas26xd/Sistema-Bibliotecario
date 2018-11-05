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

            if(sql.contains("select") || sql.contains("desc") || sql.contains("show")){
                resultado = new ArrayList<>();
                resultado = action.retornarDados(sql);      //RETORNA O RESULTADO PEDIDO PELO USUÁRIO
                if(resultado != null){
                    System.out.println("enviado: "+resultado.toString());
                }else{
                    System.out.println("Resultado = null na classe: "+getClass());
                }
            }else if(sql.contains("delete") || sql.contains("DROP") || sql.contains("insert") || sql.contains("update") || sql.contains("CREATE")){
                action.inserirDados(sql);
            }else{
                System.out.println("Nada a Fazer :(");
            }

            try{
                Thread.interrupted();
            }catch(Exception exception){}
            
        }catch(Exception ex){
            System.out.println("Erro na classe: "+getClass()+" : "+ex.getMessage());
        }
        return resultado;
    }
}