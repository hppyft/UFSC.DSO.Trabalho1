
package ufsc.dso.trabalho1.Telas;
import java.util.Scanner;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorGeral implements Tela{
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorGeral() {
    }
        
    public int mostraMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("Bem Vindo ao sitema");
        System.out.println("");
        System.out.println("");
        System.out.println("Selecione a opcao no menu a seguir:");
        System.out.println("");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("1 - Opcoes de acesso e relatorios de negacao");
        System.out.println("2 - Opcoes de funcionario (cadastro, atualizacoes, relatorios...)");
        System.out.println("3 - Opcoes de cargos (cadastro, atualizacoes, relatorios...)");
        System.out.println("4 - Atualizar hora do sistema");
        System.out.println("5 - Atualizar data do sistema");
        System.out.println("6 - Fechar sistema");
        
        return scanner.nextInt();
    }
    
    @Override
    public void telaMensagem(String mensagem) {
        System.out.println("");
        System.out.println(mensagem);
    }
    
    public int telaFecharSistema(){
        System.out.println("");
        System.out.println("tem certeza que deseja fechar o sistema");
        System.out.println("1 - SIM");
        System.out.println("2 - NAO");
        return scanner.nextInt();
    }
}
