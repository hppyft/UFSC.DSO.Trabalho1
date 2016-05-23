/*
PERGUNTAR:
O QUE É MELHOR, FAZER UMA LISTA OU HASHMAP DE CARGOS?
HASHMAP OU HASHSET?
*/
package ufsc.dso.trabalho1;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import ufsc.dso.trabalho1.Controladores.ControladorGeral;


public class teste {
    
    private static boolean fecharSistema = false;
 
    public static void main (String[] Args) throws ParseException{
        
        while (!isFecharSistema()){
            ControladorGeral.getInstance().inicializa();
        }
        
        
        /*
        int a = 1995;
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR,a);
        System.out.println(dataNascimento.get(Calendar.YEAR));
        */
        /*
        SimpleDateFormat datos = new SimpleDateFormat("HH:mm");
        String dataString = "20:30";
        Date data = datos.parse(dataString);
        System.out.println(data);
        */
        /*
        Calendar data = Calendar.getInstance();
        data.set(Calendar.HOUR_OF_DAY, 17);
        data.set(Calendar.MINUTE, 28);
        System.out.println(data.get(data.HOUR_OF_DAY)+":"+data.get(data.MINUTE));
        */
    }

    public static boolean isFecharSistema() {
        return fecharSistema;
    }

    public static void setFecharSistema(boolean fecharSistema) {
        teste.fecharSistema = fecharSistema;
    }
    
}
