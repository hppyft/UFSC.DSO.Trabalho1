package ufsc.dso.trabalho1.Telas;

import java.util.Scanner;
import ufsc.dso.trabalho1.Interfaces.Tela;

public class TelaControladorFuncionario implements Tela{
    
    private Scanner scanner = new Scanner(System.in);

    public TelaControladorFuncionario() {
    }
    
    public int mostraMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("Bem Vindo ao menu do funcionario");
        System.out.println("");
        System.out.println("");
        System.out.println("Selecione a opcao no menu a seguir:");
        System.out.println("");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("1 - Cadastro de novo funcionario");
        System.out.println("2 - Relatorio de todos os funcionarios");
        System.out.println("3 - Buscar funcionario pela matricula");
        System.out.println("4 - Alterar matricula de um funcionario");
        System.out.println("5 - Alterar nome de um funcionario");
        System.out.println("6 - Alterar data de nascimento de um funcionario");
        System.out.println("7 - Alterar telefone de um funcionario");
        System.out.println("8 - Alterar salario de um funcionario");
        System.out.println("9 - Alterar cargo de um funcionario");
        System.out.println("");
        System.out.println("Para voltar ao menu principal digite qualquer outro numero");
        
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioMatricula() {
        System.out.println("");
        System.out.println("Digite a matricula do funcionario");
        return scanner.nextInt();
    }
    
    public int telaAlteraMatricula() {
        System.out.println("");
        System.out.println("Digite a nova matricula do funcionario");
        return scanner.nextInt();
    }

    public String telaCadastroFuncionarioNome() {
        System.out.println("");
        System.out.println("Digite o nome do funcionario");
        scanner.nextLine();
        return scanner.nextLine();
    }
    
    public String telaAlteraNome() {
        System.out.println("");
        System.out.println("Digite o novo nome do funcionario");
        return scanner.nextLine();
    }

    public int telaCadastroFuncionarioTelefone() {
        System.out.println("");
        System.out.println("Digite o telefone do funcionario");
        return scanner.nextInt();
    }

    public int telaCadastroFuncionarioSalario() {
        System.out.println("");
        System.out.println("Digite o salario do funcionario");
        return scanner.nextInt();
    }

    @Override
    public void telaMensagem(String mensagem) {
        System.out.println("");
        System.out.println(mensagem);
    }
    
    public Integer telaBuscaFuncionarioPelaMatricula(){
        System.out.println("");
        System.out.println("Digite a matricula do funcionario");
        return scanner.nextInt();
    }
}
