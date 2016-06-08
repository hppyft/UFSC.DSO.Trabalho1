package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorAcesso implements Tela{
    
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorAcesso() {
    }

    @Override
    public void telaMensagem(String mensagem) {
        System.out.println("");
        System.out.println(mensagem);
    }
    
    public int mostraMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("Bem Vindo ao menu de acesso");
        System.out.println("");
        System.out.println("");
        System.out.println("Selecione a opcao no menu a seguir:");
        System.out.println("");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("1 - Tentar acesso");
        System.out.println("2 - Tentar acesso alterando a data");
        System.out.println("3 - Relatorio de negacoes de acesso de um funcionario");
        System.out.println("4 - Relatorio de todas as negacoes de acesso");
        System.out.println("5 - Relatorio de negacao de acesso por motivo");
        System.out.println("");
        System.out.println("Para voltar ao menu principal digite qualquer outro numero");
        
        return scanner.nextInt();
    }
    
    public Integer telaNegacaoPelaMatricula(){
        System.out.println("");
        System.out.println("Digite a matricula do funcionario, o qual voce deseja ver as negacoes");
        return scanner.nextInt();
    }
    
    public int telaNegacaoPeloMotivo(){
        System.out.println("");
        System.out.println("Digite o numero referente ao motivo o qual voce quer ver as negacoes");
        System.out.println("1 - ACESSO BLOQUEADO");
        System.out.println("2 - FORA DE HORARIO");
        System.out.println("3 - NAO POSSUI ACESSO");
        return scanner.nextInt();
    }
}
