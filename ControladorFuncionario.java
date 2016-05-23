package ufsc.dso.trabalho1.Controladores;

import java.util.HashMap;
import ufsc.dso.trabalho1.Entidades.Funcionario;
import ufsc.dso.trabalho1.Telas.TelaControladorFuncionario;

public class ControladorFuncionario {
    
    private static ControladorFuncionario instancia;
    private HashMap<Integer, Funcionario> listaFuncionarios = new HashMap<>();
    
    private ControladorFuncionario(){
    }
    
    public static ControladorFuncionario getInstance(){
        if (instancia == null){
            instancia = new ControladorFuncionario();
        }
        return instancia;
    }

    public void inicializa() {
        TelaControladorFuncionario telaControladorCadastro = new TelaControladorFuncionario();
        //botar as opções e os caralho
    }
    
    public Funcionario cadastraFuncionario (){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        int matricula = telaControladorFuncionario.telaCadastroFuncionarioMatricula();
        String nome = telaControladorFuncionario.telaCadastroFuncionarioNome();
        int anoNascimento = telaControladorFuncionario.telaCadastroFuncionarioAnoNascimento();
        int mesNascimento = telaControladorFuncionario.telaCadastroFuncionarioMesNascimento();
        int diaNascimento = telaControladorFuncionario.telaCadastroFuncionarioDiaNascimento();
        int telefone = telaControladorFuncionario.telaCadastroFuncionarioTelefone();
        int salario = telaControladorFuncionario.telaCadastroFuncionarioSalario();
        String nomeDoCargo = telaControladorFuncionario.telaCadastroFuncionarioNomeDoCargo();
        //criar metodo para localizar funcionario pelo cargo
    }
}