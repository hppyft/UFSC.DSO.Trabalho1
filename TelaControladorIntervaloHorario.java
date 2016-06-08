package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorIntervaloHorario implements Tela{
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorIntervaloHorario() {
    }

    public int telaAdicionarOutroIntervaloHorario() {
        System.out.println("");
        System.out.println("Deseja inserir um novo intervalo de horarios");
        System.out.println("1 - SIM");
        System.out.println("Qualquer outro numero inteiro - NAO");
        return scanner.nextInt();
    }

    @Override
    public void telaMensagem(String message) {
        System.out.println("");
        System.out.println(message);
    }
    
}
