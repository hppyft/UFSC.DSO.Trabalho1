package ufsc.dso.trabalho1.Controladores;

import java.util.ArrayList;
import java.util.Objects;
import ufsc.dso.trabalho1.Entidades.Cargo;
import ufsc.dso.trabalho1.Entidades.Data;
import ufsc.dso.trabalho1.Entidades.Funcionario;
import ufsc.dso.trabalho1.Entidades.Horario;
import ufsc.dso.trabalho1.Entidades.IntervaloHorario;
import ufsc.dso.trabalho1.Entidades.Motivo;
import static ufsc.dso.trabalho1.Entidades.Motivo.ACESSO_BLOQUEADO;
import static ufsc.dso.trabalho1.Entidades.Motivo.FORA_DE_HORARIO;
import static ufsc.dso.trabalho1.Entidades.Motivo.NAO_POSSUI_ACESSO;
import ufsc.dso.trabalho1.Entidades.NegacaoAcesso;
import ufsc.dso.trabalho1.Telas.TelaControladorAcesso;

public class ControladorAcesso {
    
    private static ControladorAcesso instancia;
    private ArrayList<NegacaoAcesso> listaNegacoes = new ArrayList<>();
    
    private ControladorAcesso(){
    }
    
    public static ControladorAcesso getInstance(){
        if (instancia == null){
            instancia = new ControladorAcesso();
        }
        return instancia;
    }

    void inicializa() {
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        int opcao = telaControladorAcesso.mostraMenu();
        try{
            switch (opcao){
                case 1:
                    tentarAcesso();
                    break;
                    
                case 2:
                    tentarAcessoAlterandoData();
                    break;
                    
                case 3:
                    mostraNegacaoPelaMatricula();
                    break;
                    
                case 4:
                    mostraTodasNegacoes();
                    break;
                    
                case 5:
                    mostraNegacaoPeloMotivo();
                    break;
                    
                default:
                    telaControladorAcesso.telaMensagem(opcao+" nao eh uma opcao valida");
                    break;
            }
            
        }
        catch(Exception e){
            telaControladorAcesso.telaMensagem("Voce digitou um tipo incorreto de caracter, por favor digite apenas numeros quando for pedido");
        }
    }

    public boolean tentarAcesso() {
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        telaControladorAcesso.telaMensagem("Para tentar acesso, por favor digite a matricula do funcionario");
        Funcionario funcionario = ControladorFuncionario.getInstance().buscaFuncionarioPelaMatricula();
        Cargo cargo = funcionario.getCargo();
        boolean acessoPermitido = true;
        boolean acessoNegado = false;
        Horario horarioAtual = ControladorHorario.getInstance().getHorarioAtual();
        Data dataAtual = ControladorData.getInstance().getDataAtual();
        if(cargo.isGerencial()){
            telaControladorAcesso.telaMensagem("PORTA ABERTA, POR FAVOR FECHE-A AO ENTRAR, E SEJA BEM-VINDO GERENTE "+funcionario.getNome());
            return acessoPermitido;
        }
        else{
            if(!funcionario.isAcessoBloqueado()){
                if(!cargo.isAcesso()){
                    telaControladorAcesso.telaMensagem("VOCE NAO TEM ACESSO POIS SEU CARGO NAO PERMITE, POR FAVOR RETIRE-SE "+funcionario.getNome());
                    novaNegacao(funcionario.getMatricula(), dataAtual.getDataEscrita(), horarioAtual.getHorarioEscrito(), NAO_POSSUI_ACESSO);
                    if(numeroNegacoes(funcionario.getMatricula())>3){
                        funcionario.setAcessoBloqueado(true);
                        telaControladorAcesso.telaMensagem("A PARTIR DE AGORA SEU ACESSO ESTA BLOQUEADO");
                    }
                    return acessoNegado;
                }
                else{
                    for(IntervaloHorario iterator: cargo.getListaIntervaloHorarios()){
                        if(ControladorIntervaloHorario.getInstance().horarioEstaNoIntervalo(iterator,horarioAtual)){
                            telaControladorAcesso.telaMensagem("PORTA ABERTA, POR FAVOR FECHE-A AO ENTRAR, E SEJA BEM-VINDO "+funcionario.getNome());
                            return acessoPermitido;
                        }
                    }
                    telaControladorAcesso.telaMensagem("VOCE NAO TEM ACESSO NESTE HORARIO, POR FAVOR RETIRE-SE "+funcionario.getNome());
                    novaNegacao(funcionario.getMatricula(), dataAtual.getDataEscrita(), horarioAtual.getHorarioEscrito(), FORA_DE_HORARIO);
                    if(numeroNegacoes(funcionario.getMatricula())>3){
                        funcionario.setAcessoBloqueado(true);
                        telaControladorAcesso.telaMensagem("A PARTIR DE AGORA SEU ACESSO ESTA BLOQUEADO");
                    }
                    return acessoNegado;
                }
            }
            else{
                telaControladorAcesso.telaMensagem("VOCE ESTAH COM SEU ACESSO BLOQUEADO, POR FAVOR RETIRE-SE "+funcionario.getNome());
                novaNegacao(funcionario.getMatricula(), dataAtual.getDataEscrita(), horarioAtual.getHorarioEscrito(), ACESSO_BLOQUEADO);
                return acessoNegado;
            }
        }
    }
    
    public boolean tentarAcessoAlterandoData(){
        ControladorHorario.getInstance().atualizaHorarioSistema();
        ControladorData.getInstance().atualizaDataSistema();
        return tentarAcesso();
    }
    
    public NegacaoAcesso novaNegacao(Integer matricula, String data, String horario, Motivo motivo){
        NegacaoAcesso negacaoAcesso = new NegacaoAcesso(matricula,data,horario,motivo);
        listaNegacoes.add(negacaoAcesso);
        return negacaoAcesso;
    }
    
    public void mostraNegacao(NegacaoAcesso negacaoAcesso){
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        telaControladorAcesso.telaMensagem("Matricula - "+negacaoAcesso.getMatricula());
        telaControladorAcesso.telaMensagem("Data - "+negacaoAcesso.getData());
        telaControladorAcesso.telaMensagem("Horario - "+negacaoAcesso.getHorario());
        telaControladorAcesso.telaMensagem("Motivo - "+negacaoAcesso.getMotivo());
        telaControladorAcesso.telaMensagem("");
    }
    
    public void mostraTodasNegacoes (){
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        for (NegacaoAcesso iterator: listaNegacoes){
            mostraNegacao(iterator);
            telaControladorAcesso.telaMensagem("");
            telaControladorAcesso.telaMensagem("--------------");
            telaControladorAcesso.telaMensagem("");
        }
    }
    
    public void mostraNegacaoPelaMatricula(){
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        Integer matricula = telaControladorAcesso.telaNegacaoPelaMatricula();
        if(!ControladorFuncionario.getInstance().verificaMatriculaRepetida(matricula)){
            telaControladorAcesso.telaMensagem("Esta matricula nao existe");
        }
        else{
            for (NegacaoAcesso iterator: listaNegacoes){
                if(Objects.equals(iterator.getMatricula(), matricula)){
                    mostraNegacao(iterator);
                    telaControladorAcesso.telaMensagem("");
                    telaControladorAcesso.telaMensagem("--------------");
                    telaControladorAcesso.telaMensagem("");
                }
            }
        }
    }
    
    public void mostraNegacaoPeloMotivo(){
        TelaControladorAcesso telaControladorAcesso = new TelaControladorAcesso();
        int opcao = 0;
        Motivo motivo = null;
        opcao = telaControladorAcesso.telaNegacaoPeloMotivo();
        while (opcao<1 || opcao>3){
            telaControladorAcesso.telaMensagem("Por favor, digite uma opcao valida");
            opcao = telaControladorAcesso.telaNegacaoPeloMotivo();
        }
        switch (opcao){
            case 1:
                motivo = ACESSO_BLOQUEADO;
                break;
                
            case 2:
                motivo = FORA_DE_HORARIO;
                break;
                
            case 3:
                motivo = NAO_POSSUI_ACESSO;
                break;
                
            default:
                break;
        }
        
        for (NegacaoAcesso iterator: listaNegacoes){
            if(iterator.getMotivo()==motivo){
                mostraNegacao(iterator);
                telaControladorAcesso.telaMensagem("");
                telaControladorAcesso.telaMensagem("--------------");
                telaControladorAcesso.telaMensagem("");
            }
        }
    }
    
    public int numeroNegacoes(Integer matricula){
        int numeroNegacoes = 0;
        for (NegacaoAcesso iterator: listaNegacoes){
            if(Objects.equals(iterator.getMatricula(), matricula)){
                numeroNegacoes++;
            }
        }
        return numeroNegacoes;
    }
}
