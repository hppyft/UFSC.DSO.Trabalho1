
package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;
import ufsc.dso.trabalho1.Entidades.DataInvalidaException;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorData implements Tela{
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorData() {
    }

    @Override
    public void telaMensagem(String mensagem) {
        System.out.println("");
        System.out.println(mensagem);
    }

    public int telaNovoAno() throws DataInvalidaException{
        System.out.println("");
        int ano = -1;
        System.out.println("Por favor digite o ano");
        try{
            ano = scanner.nextInt();
        }
        catch(Exception e){
            scanner.nextLine();
            throw new DataInvalidaException("Ano Invalido");
        }
        return ano;
    }
    
    public int telaNovoMes() throws DataInvalidaException{
        System.out.println("");
        int mes = -1;
        System.out.println("Por favor digite o mes");
        try{
            mes = scanner.nextInt();
            while (mes<1 || mes>12){
                System.out.println("Mes invalido, por favor digite um mes valido");
                mes = scanner.nextInt();
            }
        }
        catch(Exception e){
            scanner.nextLine();
            throw new DataInvalidaException("Mes Invalido");
        }
        return mes;
    }
    
    public int telaNovoDia() throws DataInvalidaException{
        System.out.println("");
        int dia = -1;
        System.out.println("Por favor digite o dia");
        try{
            dia = scanner.nextInt();
            while (dia<1){
                System.out.println("Dia inferior a 1 nah eh valido");
                dia = scanner.nextInt();
            }
        }
        catch(Exception e){
            scanner.nextLine();
            throw new DataInvalidaException("Dia Invalido");
        }
        return dia;
    }
}
