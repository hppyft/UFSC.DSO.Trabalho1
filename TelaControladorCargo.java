
package ufsc.dso.trabalho1.Telas;
import java.util.Scanner;
import ufsc.dso.trabalho1.Entidades.CargoInexistenteException;

public class TelaControladorCargo {

    private Scanner scanner = new Scanner(System.in);
    
    public TelaControladorCargo() {
    }
    
    public void cargoInexistente(CargoInexistenteException e){
        System.out.println(e.getMessage());
    }

    public String telaCadastroCargoNome() {
        System.out.println("Digite o nome do cargo");
        return scanner.nextLine();
    }

    public Integer telaCadastroCargoCodigo() {
        System.out.println("Digite o codigo do cargo");
        return scanner.nextInt();
    }

    public boolean telaCadastroCargoAcesso() {
        System.out.println("Digite se o cargo possui acesso para a porta do financeiro ou nao, usando true para sim ou false para nao");
        return scanner.nextBoolean();
    }

    public boolean telaCadastroCargoEhGerencial() {
        System.out.println("Digite se o cargo eh gerencial ou nao, usando true para sim ou false para nao");
        return scanner.nextBoolean();
    }

    public int telaCadastroCargoHoraEntrada() {
        System.out.println("Digite a hora de entrada permitida para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoMinutoEntrada() {
        System.out.println("Digite o minuto de entrada permitido para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoHoraSaida() {
        System.out.println("Digite a hora de saida permitida para o cargo");
        return scanner.nextInt();
    }

    public int telaCadastroCargoMinutoSaida() {
        System.out.println("Digite o minuto de saida permitido para o cargo");
        return scanner.nextInt();
    }
    
    public boolean telaCadastroCargoNovoHorario(){
        System.out.println("Deseja cadastrar outro cargo")
    }
}
