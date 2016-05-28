package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;

public class TelaControladorFuncionario {
    
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorFuncionario() {
    }

    public int telaCadastroFuncionarioMatricula() {
        scanner.nextLine();
        System.out.println("Digite a matricula do funcionario");
        return scanner.nextInt();
    }

    public String telaCadastroFuncionarioNome() {
        scanner.nextLine();
        System.out.println("Digite o nome do funcionario");
        return scanner.nextLine();
    }

    public int telaCadastroFuncionarioAnoNascimento() {
        scanner.nextLine();
        System.out.println("Digite o ano de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioMesNascimento() {
        scanner.nextLine();
        System.out.println("Digite o mes de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioDiaNascimento() {
        scanner.nextLine();
        System.out.println("Digite o dia de nascimento do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioTelefone() {
        scanner.nextLine();
        System.out.println("Digite o telefone do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioSalario() {
        scanner.nextLine();
        System.out.println("Digite o salario do funcionario");
        return scanner.nextInt();
    }

    public Integer telaCadastroFuncionarioCodigoDoCargo() {
        scanner.nextLine();
        System.out.println("Digite o nome do cargo do funcionario");
        return scanner.nextInt();
    }
}
