
package ufsc.dso.trabalho1.Telas;
import java.util.Scanner;
import ufsc.dso.trabalho1.Entidades.DataInvalidaException;

public class TelaControladorGeral {
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorGeral() {
    }
    
    public String telaAtualizaHora () throws DataInvalidaException{
        int hora = -1;
        int minutos = -1;
        System.out.println("Para iniciar o sistema, por favor digite o hora atual");
        try{
            hora = Integer.parseInt(scanner.nextLine());
            while(hora < 0 || hora > 23){
            
                System.out.println("Voce digitou um valor incorreto. Para iniciar o sistema, por favor digite o hora atual");
                hora = Integer.parseInt(scanner.nextLine());
            }
        }catch(NumberFormatException e){
            throw new DataInvalidaException("Hora invalida.");
        }
        System.out.println("Para iniciar o sistema, por favor digite o minuto atual");
        try{
            minutos = Integer.parseInt(scanner.nextLine());
            while(minutos < 0 || minutos > 59){
                System.out.println("Voce digitou um valor incorreto. Para iniciar o sistema, por favor digite o minuto atual");
                minutos = Integer.parseInt(scanner.nextLine());
            }
        }catch(NumberFormatException e){
            throw new DataInvalidaException("Minuto invalido.");
        }
        String data = ""+hora+":"+minutos;
        return data; 
   }

    public int mostraMenu() {
        
        System.out.println("Bem Vindo ao sitema");
        System.out.println("");
        System.out.println("Selecione a opcao no menu a seguir:");
        System.out.println("-----------");
        System.out.println("1 - Opcoes de acesso");
        System.out.println("2 - Opcoes de cadastro");
        System.out.println("3 - Atualizar hora");
        System.out.println("4 - Fechar sistema");
        
        return scanner.nextInt();
    }
}
