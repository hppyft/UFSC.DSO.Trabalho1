package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;
import ufsc.dso.trabalho1.Entidades.DataInvalidaException;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorHorario implements Tela{

    private Scanner scanner = new Scanner(System.in);

    public TelaControladorHorario() {
    }    

    public int telaNovaHora () throws DataInvalidaException{
        int hora = -1;
        System.out.println("Por favor digite a hora");
        try{
            hora = scanner.nextInt();
            while(hora < 0 || hora > 23){
                System.out.println("Voce digitou um valor de hora invalido. Por favor digite a hora atual");
                hora = scanner.nextInt();
            }
        }
        catch(Exception e){
            scanner.nextLine();
            throw new DataInvalidaException("Hora Invalida");
        }
        return hora;
    }
    
    public int telaNovoMinuto() throws DataInvalidaException{
        int minuto = -1;
        System.out.println("Por favor digite o minuto");
        try{
            minuto = scanner.nextInt();
            while(minuto < 0 || minuto > 59){
                System.out.println("Voce digitou um valor de minuto invalido. Por favor digite o minuto atual");
                minuto = scanner.nextInt();
            }
        }
        catch(Exception e){
            scanner.nextLine();
            throw new DataInvalidaException("Minuto Invalido");
        }
        return minuto;
    }
    
    @Override
    public void telaMensagem(String mensagem){
        System.out.println("");
        System.out.println(mensagem);
    }
    
    public void telaNovoHorarioEntrada(){
        System.out.println("");
        System.out.println("A seguir insira o horario de entrada");
    }
    
    public void telaNovoHorarioSaida(){
        System.out.println("");
        System.out.println("A seguir insira o horario de saida");
    }
}
