package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;

public class TelaControladorFuncionario {
    
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorFuncionario() {
    }

    public int telaCadastroFuncionarioMatricula() {
        System.out.println("Digite a matricula do funcionario");
        return scanner.nextInt();
    }

    public String telaCadastroFuncionarioNome() {
        System.out.println("Digite o nome do funcionario");
        return scanner.nextLine();
    }

    public int telaCadastroFuncionarioAnoNascimento() {
        System.out.println("Digite o ano de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioMesNascimento() {
        System.out.println("Digite o mes de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioDiaNascimento() {
        System.out.println("Digite o dia de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioTelefone() {
        System.out.println("Digite o telefone do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioSalario() {
        System.out.println("Digite o salario do funcionario");
        return scanner.nextInt();
    }

    public Integer telaCadastroFuncionarioCodigoDoCargo() {
        System.out.println("Digite o nome do cargo do funcionario");
        return scanner.nextInt();
    }
}
