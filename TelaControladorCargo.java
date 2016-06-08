
package ufsc.dso.trabalho1.Telas;
import java.util.Scanner;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorCargo implements Tela{

    private Scanner scanner = new Scanner(System.in);
    
    public TelaControladorCargo() {
    }
    
    public int mostraMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("Bem Vindo ao menu de cargo");
        System.out.println("");
        System.out.println("");
        System.out.println("Selecione a opcao no menu a seguir:");
        System.out.println("");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("1 - Cadastro de novo cargo");
        System.out.println("2 - Relatorio de todos os cargos");
        System.out.println("3 - Buscar cargo pelo codigo");
        System.out.println("4 - Alterar codigo de um cargo");
        System.out.println("5 - Alterar nome de um cargo");
        System.out.println("6 - Alterar acesso de um cargo");
        System.out.println("7 - Alterar gerencia de um cargo");
        System.out.println("8 - Incluir horarios de acesso para um cargo");
        System.out.println("9 - Excluir todos os horarios de acesso de um cargo");
        System.out.println("");
        System.out.println("Para voltar ao menu principal digite qualquer outro numero");
        
        return scanner.nextInt();
    }

    public String telaCadastroCargoNome() {
        System.out.println("");
        System.out.println("Digite o nome do cargo");
        return scanner.nextLine();
    }
    
    public String telaAlteraNome() {
        System.out.println("");
        System.out.println("Digite o novo nome do cargo");
        return scanner.nextLine();
    }

    public Integer telaCadastroCargoCodigo() {
        System.out.println("");
        System.out.println("Digite o codigo do cargo");
        return scanner.nextInt();
    }
    
    public Integer telaAlteraCodigo() {
        System.out.println("");
        System.out.println("Digite o novo codigo do cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoAcesso() {
        System.out.println("");
        System.out.println("Digite se o cargo possui acesso para a porta do financeiro ou nao");
        System.out.println("1 - SIM");
        System.out.println("Qualquer outro numero inteiro - NAO");
        return scanner.nextInt();
    }
    
    public int telaAlteraAcesso() {
        System.out.println("");
        System.out.println("Digite se o cargo agora tera acesso ou nao");
        System.out.println("1 - SIM");
        System.out.println("Qualquer outro numero inteiro - NAO");
        return scanner.nextInt();
    }

    public int telaCadastroCargoEhGerencial() {
        System.out.println("");
        System.out.println("Digite se o cargo eh gerencial ou nao");
        System.out.println("1 - SIM");
        System.out.println("Qualquer outro numero inteiro - NAO");
        return scanner.nextInt();
    }
    
    public int telaAlteraEhGerencial() {
        System.out.println("");
        System.out.println("Digite se o cargo agora serah gerencial ou nao");
        System.out.println("1 - SIM");
        System.out.println("Qualquer outro numero inteiro - NAO");
        return scanner.nextInt();
    }
    
    public int telaCadastroCargoHoraEntrada() {
        System.out.println("");
        System.out.println("Digite a hora de entrada permitida para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoMinutoEntrada() {
        System.out.println("");
        System.out.println("Digite o minuto de entrada permitido para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoHoraSaida() {
        System.out.println("");
        System.out.println("Digite a hora de saida permitida para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoMinutoSaida() {
        System.out.println("");
        System.out.println("Digite o minuto de saida permitido para o cargo");
        return scanner.nextInt();
    }
    
    public int telaExcluiHorarios(){
        System.out.println("");
        System.out.println("Voce tem certeza que deseja excluir todos os horarios de acesso deste cargo");
        System.out.println("1 - SIM");
        System.out.println("2 - NAO");
        return scanner.nextInt();
    }

    @Override
    public void telaMensagem(String mensagem) {
        System.out.println("");
        System.out.println(mensagem);
    }

    public Integer telaBuscaCargoPeloCodigo() {
        System.out.println("");
        System.out.println("Digite o codigo do cargo desejado");
        return scanner.nextInt();
    }
}
