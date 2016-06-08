
package ufsc.dso.trabalho1.Controladores;

import ufsc.dso.trabalho1.Entidades.Horario;
import ufsc.dso.trabalho1.Entidades.IntervaloHorario;
import ufsc.dso.trabalho1.Entidades.IntervaloInvalidoException;
import ufsc.dso.trabalho1.Telas.TelaControladorIntervaloHorario;


public class ControladorIntervaloHorario {
    private static ControladorIntervaloHorario instancia;
    
    private ControladorIntervaloHorario(){
    }
    
    public static ControladorIntervaloHorario getInstance(){
        if (instancia == null){
            instancia = new ControladorIntervaloHorario();
        }
        return instancia;
    }

    public IntervaloHorario novoIntervalo(Horario horarioEntrada, Horario horarioSaida) {
        TelaControladorIntervaloHorario telaControladorIntervaloHorario = new TelaControladorIntervaloHorario();
        IntervaloHorario intervaloHorario = null;
        try{
            if (ControladorHorario.getInstance().HorarioMaisCedo(horarioEntrada, horarioSaida)==horarioSaida){
                throw new IntervaloInvalidoException("Intervalo Invalido, horario de saida maior que horario de entrada"); 
            }
            intervaloHorario = new IntervaloHorario(horarioEntrada, horarioSaida);
            return intervaloHorario;
        }
        catch(IntervaloInvalidoException e){
            telaControladorIntervaloHorario.telaMensagem(e.getMessage());
            return intervaloHorario;
        }
        catch(NumberFormatException e){
            telaControladorIntervaloHorario.telaMensagem("Voce digitou um tipo incorreto de caracter, por favor digite apenas numeros quando for pedido");
            return intervaloHorario;
        }
    }

    public boolean adicionarOutroIntervaloHorario() {
        TelaControladorIntervaloHorario telaControladorIntervaloHorario = new TelaControladorIntervaloHorario();
        int opcao = telaControladorIntervaloHorario.telaAdicionarOutroIntervaloHorario();
        boolean adicionarOutro = false;
        if (opcao == 1){
            adicionarOutro = true;
        }
        return adicionarOutro;
    }
    
    public boolean horarioEstaNoIntervalo(IntervaloHorario intervaloHorario, Horario horario){
        boolean estaNoIntervalo = false;
        if (ControladorHorario.getInstance().HorarioMaisCedo(intervaloHorario.getHorarioEntrada(), horario)!=horario){
            if(ControladorHorario.getInstance().HorarioMaisTarde(intervaloHorario.getHorarioSaida(), horario)!=horario){
                estaNoIntervalo = true;
            }
        }
        return estaNoIntervalo;
    }
    
    public void printIntervalo(IntervaloHorario intervaloHorario){
    TelaControladorIntervaloHorario telaControladorIntervaloHorario = new TelaControladorIntervaloHorario();
    telaControladorIntervaloHorario.telaMensagem("Horario Entrada - "+intervaloHorario.getHorarioEntrada().getHorarioEscrito()+
            " - "+"Horario Saida - "+intervaloHorario.getHorarioSaida().getHorarioEscrito());
    }
}
