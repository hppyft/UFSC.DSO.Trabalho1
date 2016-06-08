package ufsc.dso.trabalho1.Controladores;

import java.util.HashMap;
import java.util.Objects;
import ufsc.dso.trabalho1.Entidades.Funcionario;
import ufsc.dso.trabalho1.Telas.TelaControladorFuncionario;
import ufsc.dso.trabalho1.Entidades.Cargo;
import ufsc.dso.trabalho1.Entidades.Data;
import ufsc.dso.trabalho1.Entidades.MatriculaInvalidaException;

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
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        int opcao = telaControladorFuncionario.mostraMenu();
        try{
            switch (opcao){
                case 1:
                    cadastraFuncionario();
                    break;
                    
                case 2:
                    relatorioTodosFuncionarios();
                    break;
                    
                case 3:
                    mostraFuncionarioPelaMatricula();
                    break;
                    
                case 4:
                    alteraMatricula();
                    break;
                    
                case 5:
                    alteraNome();
                    break;
                    
                case 6:
                    alteraDataNascimento();
                    break;
                    
                case 7:
                    alteraTelefone();
                    break;
                    
                case 8:
                    alteraSalario();
                    break;
                    
                case 9:
                    alteraCargo();
                    break;
                    
                default:
                    telaControladorFuncionario.telaMensagem(opcao+" nao eh uma opcao valida");
                    break;
            }
        }
        catch(Exception e){
            telaControladorFuncionario.telaMensagem("Voce digitou um tipo incorreto de caracter, por favor digite apenas numeros quando for pedido");
        }
    }
    
    public Funcionario cadastraFuncionario (){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        
        Integer matricula = telaControladorFuncionario.telaCadastroFuncionarioMatricula();
        try{
            if (this.verificaMatriculaRepetida(matricula)){
                throw new MatriculaInvalidaException("Esta matricula jah existe");
            }
        }
        catch(MatriculaInvalidaException e){
            telaControladorFuncionario.telaMensagem(e.getMessage());
            return null;
        }
        
        String nome = telaControladorFuncionario.telaCadastroFuncionarioNome();
        
        Data dataNascimento = new Data();
        telaControladorFuncionario.telaMensagem("A partir de agora voce deve digitar a data de nascimento do funcionario");
        dataNascimento.setAno(ControladorData.getInstance().novoAno());
        while (dataNascimento.getAno()>(ControladorData.getInstance().getDataAtual().getAno()-18)){
            telaControladorFuncionario.telaMensagem("A idade minima deve ser 18 anos");
            dataNascimento.setAno(ControladorData.getInstance().novoAno());
        }
        dataNascimento.setMes(ControladorData.getInstance().novoMes());
        dataNascimento.setDia(ControladorData.getInstance().novoDia(dataNascimento));
        int telefone = telaControladorFuncionario.telaCadastroFuncionarioTelefone();
        int salario = telaControladorFuncionario.telaCadastroFuncionarioSalario();
        Cargo cargo = ControladorCargo.getInstance().buscaCargoPeloCodigo();
        Funcionario funcionario = new Funcionario(matricula,nome,dataNascimento,telefone,salario,cargo);
        listaFuncionarios.put(funcionario.getMatricula(), funcionario);
        return funcionario;
    }
    
    public boolean verificaMatriculaRepetida(Integer matricula){
        boolean matriculaRepetida = false;
        for (Integer iterator: listaFuncionarios.keySet()){
            if(Objects.equals(iterator, matricula)){
                matriculaRepetida = true;
            }
        }
        return matriculaRepetida;
    }
    
    public Funcionario buscaFuncionarioPelaMatricula(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Integer matricula;
        boolean matriculaValida = false;
        Funcionario funcionario = null;
        while(!matriculaValida){
            matricula = telaControladorFuncionario.telaBuscaFuncionarioPelaMatricula();
            funcionario = this.listaFuncionarios.get(matricula);
            try{
                if(funcionario == null){
                    throw new MatriculaInvalidaException("Matricula inexistente");
                }
                else{
                    matriculaValida = true;
                }
            }
            catch(MatriculaInvalidaException e){
                telaControladorFuncionario.telaMensagem(e.getMessage());
            }
        }
        return funcionario;
    }
    
    public void alteraMatricula(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        Integer matriculaAntiga = funcionario.getMatricula();
        Integer matricula = funcionario.getMatricula();
        boolean matriculaValida = false;
        while(!matriculaValida){
            matricula = telaControladorFuncionario.telaAlteraMatricula();
            try{
                if (this.verificaMatriculaRepetida(matricula)){
                    throw new MatriculaInvalidaException("Esta matricula jah existe e pertence a outro funcionario");
                }
                else {
                    matriculaValida = true;
                }
            }
            catch(MatriculaInvalidaException e){
                telaControladorFuncionario.telaMensagem(e.getMessage());
            }
        }
        listaFuncionarios.get(matriculaAntiga).setMatricula(matricula);
        listaFuncionarios.put(matricula, funcionario);
        listaFuncionarios.remove(matriculaAntiga);
        
    }
    
    public void alteraNome(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        String nome = telaControladorFuncionario.telaAlteraNome();
        listaFuncionarios.get(funcionario.getMatricula()).setNome(nome);
    }
    
    public void alteraDataNascimento(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        Data dataNascimento = new Data();
        dataNascimento.setAno(ControladorData.getInstance().novoAno());
        while (dataNascimento.getAno()>(ControladorData.getInstance().getDataAtual().getAno()-18)){
            telaControladorFuncionario.telaMensagem("A idade minima deve ser 18 anos");
            dataNascimento.setAno(ControladorData.getInstance().novoAno());
        }
        dataNascimento.setMes(ControladorData.getInstance().novoMes());
        dataNascimento.setDia(ControladorData.getInstance().novoDia(dataNascimento));
        listaFuncionarios.get(funcionario.getMatricula()).setDataNascimento(dataNascimento);
    }
    
    public void alteraTelefone(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        int telefone = telaControladorFuncionario.telaCadastroFuncionarioTelefone();
        listaFuncionarios.get(funcionario.getMatricula()).setTelefone(telefone);
    }
    
    public void alteraSalario(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        int salario = telaControladorFuncionario.telaCadastroFuncionarioSalario();
        listaFuncionarios.get(funcionario.getMatricula()).setSalario(salario);
    }
    
    public void alteraCargo(){
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        Cargo cargo = ControladorCargo.getInstance().buscaCargoPeloCodigo();
        listaFuncionarios.get(funcionario.getMatricula()).setCargo(cargo);
    }

    private void relatorioTodosFuncionarios() {
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        for (Funcionario iterator: listaFuncionarios.values()){
            mostraFuncionario(iterator);
            telaControladorFuncionario.telaMensagem("");
            telaControladorFuncionario.telaMensagem("--------------");
            telaControladorFuncionario.telaMensagem("");
        }
    }

    public void mostraFuncionarioPelaMatricula() {
        Funcionario funcionario = buscaFuncionarioPelaMatricula();
        mostraFuncionario(funcionario);
    }
    
    public void mostraFuncionario(Funcionario funcionario) {
        TelaControladorFuncionario telaControladorFuncionario = new TelaControladorFuncionario();
        telaControladorFuncionario.telaMensagem("Nome - "+funcionario.getNome());
        telaControladorFuncionario.telaMensagem("Matricula - "+funcionario.getMatricula());
        telaControladorFuncionario.telaMensagem("Data de Nascimento - "+funcionario.getDataNascimento());
        telaControladorFuncionario.telaMensagem("Telefone - "+funcionario.getTelefone());
        telaControladorFuncionario.telaMensagem("Salario - "+funcionario.getSalario());
        telaControladorFuncionario.telaMensagem("Cargo - "+funcionario.getCargo().getNome());
        telaControladorFuncionario.telaMensagem("Acesso estah bloqueado - "+funcionario.isAcessoBloqueado());
        telaControladorFuncionario.telaMensagem("");
    }
}
