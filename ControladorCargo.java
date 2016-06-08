
package ufsc.dso.trabalho1.Controladores;

import java.util.HashMap;
import java.util.Objects;
import ufsc.dso.trabalho1.Entidades.Cargo;
import ufsc.dso.trabalho1.Entidades.CodigoInvalidoException;
import ufsc.dso.trabalho1.Telas.TelaControladorCargo;
import ufsc.dso.trabalho1.Entidades.Horario;
import ufsc.dso.trabalho1.Entidades.IntervaloHorario;

public class ControladorCargo {

    private static ControladorCargo instancia;
    private HashMap<Integer, Cargo> listaCargos = new HashMap<>();
    
    private ControladorCargo(){
    }
    
    public static ControladorCargo getInstance(){
        if (instancia == null){
            instancia = new ControladorCargo();
        }
        return instancia;
    }
    
    public Cargo buscaCargoPeloCodigo(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = null;
        Integer codigo;
        boolean codigoValido = false;
        while(!codigoValido){
            codigo = telaControladorCargo.telaBuscaCargoPeloCodigo();
            cargo = this.listaCargos.get(codigo);
            try{
                if(cargo == null){
                    throw new CodigoInvalidoException("Codigo de cargo inexistente");
                }
                else{
                    codigoValido = true;
                }
            }
            catch(CodigoInvalidoException e){
                telaControladorCargo.telaMensagem(e.getMessage());
            }
        }
        return cargo;
    }
    
    public boolean verificarCodigoRepetido(Integer codigo){
        boolean codigoRepetido = false;
        for (Integer iterator: listaCargos.keySet()){
            if (Objects.equals(iterator,codigo)){
                codigoRepetido = true;
            }
        }
        return codigoRepetido;
    }
    
    public Cargo inserirCargo(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        String nome = telaControladorCargo.telaCadastroCargoNome();
        Integer codigo = telaControladorCargo.telaCadastroCargoCodigo();
        boolean ehGerencial = false;
        int opcaoGerencial = telaControladorCargo.telaCadastroCargoEhGerencial();
        if(opcaoGerencial==1){
            ehGerencial = true;
        }
        if (ehGerencial){
            Cargo cargo = new Cargo(ehGerencial,nome,codigo);
            this.listaCargos.put(cargo.getCodigo(), cargo);
            return cargo;
        }
        else{
            int opcao = telaControladorCargo.telaCadastroCargoAcesso();
            boolean acesso = false;
            if (opcao ==1){
                acesso = true;
            }
            Cargo cargo = new Cargo(nome,codigo,acesso);
            this.listaCargos.put(cargo.getCodigo(), cargo);
            if (acesso){
                boolean adicionarOutroIntervaloHorario = true;
                while(adicionarOutroIntervaloHorario){
                    Horario horarioEntrada = ControladorHorario.getInstance().novoHorarioEntrada();
                    Horario horarioSaida = ControladorHorario.getInstance().novoHorarioSaida(); 
                    IntervaloHorario intervaloHorario = ControladorIntervaloHorario.getInstance().novoIntervalo(horarioEntrada, horarioSaida);
                    if (intervaloHorario !=null){
                        listaCargos.get(codigo).incluiHorario(intervaloHorario);
                        adicionarOutroIntervaloHorario = ControladorIntervaloHorario.getInstance().adicionarOutroIntervaloHorario();
                    }
                    else{
                        telaControladorCargo.telaMensagem("Por favor, insira um intervalo valido");
                    }
                }
            }
            return cargo;
        }       
    }

    public void inicializa() {
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        int opcao = telaControladorCargo.mostraMenu();
        try{
            switch (opcao){
                case 1:
                    inserirCargo();
                    break;
                    
                case 2:
                    relatorioTodosCargos();
                    break;
                    
                case 3:
                    mostraCargoPeloCodigo();
                    break;
                    
                case 4:
                    alteraCodigo();
                    break;
                    
                case 5:
                    alteraNome();
                    break;
                    
                case 6:
                    alteraAcesso();
                    break;
                    
                case 7:
                    alteraEhGerencial();
                    break;
                    
                case 8:
                    incluiHorarios();
                    break;
                    
                case 9:
                    excluiHorarios();
                    break;
                
                default:
                    telaControladorCargo.telaMensagem(opcao+" nao eh uma opcao valida");
                    break;
            }
            
        }
        catch(Exception e){
            telaControladorCargo.telaMensagem("Voce digitou um tipo incorreto de caracter, por favor digite apenas numeros quando for pedido");
        }
    }
    
    public void alteraNome (){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        String nome = telaControladorCargo.telaAlteraNome();
        this.listaCargos.get(cargo.getCodigo()).setNome(nome);
    }
    
    public void alteraCodigo (){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        Integer codigoAntigo = cargo.getCodigo();
        Integer codigo = cargo.getCodigo();
        boolean codigoValido = false;
        while(!codigoValido){
            codigo = telaControladorCargo.telaAlteraCodigo();
            try{
                if (this.verificarCodigoRepetido(codigo)){
                    throw new CodigoInvalidoException("este codigo jah existe e pertece a outro cargo");
                }
                else{
                    codigoValido = true;
                }
            }
            catch(CodigoInvalidoException e){
                telaControladorCargo.telaMensagem(e.getMessage());
            }
        }
        this.listaCargos.get(codigoAntigo).setCodigo(codigo);
        this.listaCargos.put(codigo,cargo);
        this.listaCargos.remove(codigoAntigo);
    }
    
    public void alteraEhGerencial(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        boolean ehGerencial = false;
        int opcao = telaControladorCargo.telaAlteraEhGerencial();
        if(opcao==1){
            ehGerencial = true;
        }
        this.listaCargos.get(cargo.getCodigo()).setGerencial(ehGerencial);
        if(ehGerencial){
            this.listaCargos.get(cargo.getCodigo()).setAcesso(true);
        }
    }
    
    public void alteraAcesso(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        if (this.listaCargos.get(cargo.getCodigo()).isGerencial()){
            telaControladorCargo.telaMensagem("O cargo eh gerencial, logo, nao eh possivel retirar seu acesso");
        }
        else{
            int opcao = telaControladorCargo.telaAlteraAcesso();
            if(opcao==1){
                this.listaCargos.get(cargo.getCodigo()).setAcesso(true);
                telaControladorCargo.telaMensagem("cargo agora possui acesso");
            }
        }
    }
    
    public void incluiHorarios(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        if (this.listaCargos.get(cargo.getCodigo()).isAcesso()){
        boolean adicionarOutroIntervaloHorario = true;
            while(adicionarOutroIntervaloHorario){
                Horario horarioEntrada = ControladorHorario.getInstance().novoHorarioEntrada();
                Horario horarioSaida = ControladorHorario.getInstance().novoHorarioSaida(); 
                IntervaloHorario intervaloHorario = ControladorIntervaloHorario.getInstance().novoIntervalo(horarioEntrada, horarioSaida);
                if (intervaloHorario !=null){
                    listaCargos.get(cargo.getCodigo()).incluiHorario(intervaloHorario);
                    adicionarOutroIntervaloHorario = ControladorIntervaloHorario.getInstance().adicionarOutroIntervaloHorario();
                }
                else{
                    telaControladorCargo.telaMensagem("Por favor, insira um intervalo valido");
                }
            }
        }
    }
    
    public void excluiHorarios(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        Cargo cargo = buscaCargoPeloCodigo();
        int opcao = telaControladorCargo.telaExcluiHorarios();
        if(opcao == 1){
            this.listaCargos.get(cargo.getCodigo()).getListaIntervaloHorarios().clear();
            telaControladorCargo.telaMensagem("Lista de horarios excluida");
        }
        else if (opcao ==2){
        }
    }

    private void relatorioTodosCargos() {
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        for (Cargo iterator: listaCargos.values()){
            mostraCargo(iterator);
            telaControladorCargo.telaMensagem("");
            telaControladorCargo.telaMensagem("--------------");
            telaControladorCargo.telaMensagem("");
        }
    }

    private void mostraCargoPeloCodigo() {
        Cargo cargo = buscaCargoPeloCodigo();
        mostraCargo(cargo);
    }
    
    private void mostraCargo(Cargo cargo) {
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        telaControladorCargo.telaMensagem("Nome - "+cargo.getNome());
        telaControladorCargo.telaMensagem("Codigo - "+cargo.getCodigo());
        telaControladorCargo.telaMensagem("Eh Gerencial - "+cargo.isGerencial());
        telaControladorCargo.telaMensagem("Possui Acesso - "+cargo.isAcesso());
        telaControladorCargo.telaMensagem("Lista de Horarios: ");
        for (IntervaloHorario iterator: cargo.getListaIntervaloHorarios()){
            ControladorIntervaloHorario.getInstance().printIntervalo(iterator);
        }
        telaControladorCargo.telaMensagem("");
    }
}
