
package ufsc.dso.trabalho1.Controladores;

import ufsc.dso.trabalho1.Entidades.DataInvalidaException;
import ufsc.dso.trabalho1.Entidades.Horario;
import ufsc.dso.trabalho1.Telas.TelaControladorHorario;

public class ControladorHorario {
    private static ControladorHorario instancia;
    private Horario horarioAtual;
    
    private ControladorHorario(){
    }
    
    public static ControladorHorario getInstance(){
        if (instancia == null){
            instancia = new ControladorHorario();
        }
        return instancia;
    }
    
    public Horario novoHorario(){
        boolean horaValida = false;
        boolean minutoValido = false;
        int hora = -1;
        int minuto = -1;
        TelaControladorHorario telaControladorHorario = new TelaControladorHorario();
        while(!horaValida){
            try{
                hora = telaControladorHorario.telaNovaHora();
                horaValida = true;
            }
            catch (DataInvalidaException e){
                telaControladorHorario.telaMensagem(e.getMessage());
            }
        }
        while(!minutoValido){
            try{
                minuto = telaControladorHorario.telaNovoMinuto();
                minutoValido = true;
            }
            catch (DataInvalidaException e){
                telaControladorHorario.telaMensagem(e.getMessage());
            }
        }
        Horario horario = new Horario(hora,minuto);
        return horario;
    }

    public Horario getHorarioAtual() {
        return horarioAtual;
    }
    
    public void atualizaHorarioSistema() {
        TelaControladorHorario telaControladorHorario = new TelaControladorHorario();
        telaControladorHorario.telaMensagem("Por favor, atualize o horario do sistema");
        this.horarioAtual = novoHorario();
    }
    
    public Horario novoHorarioEntrada(){
        TelaControladorHorario telaControladorHorario = new TelaControladorHorario();
        telaControladorHorario.telaNovoHorarioEntrada();
        return this.novoHorario();
    }
    
    public Horario novoHorarioSaida(){
        TelaControladorHorario telaControladorHorario = new TelaControladorHorario();
        telaControladorHorario.telaNovoHorarioSaida();
        return this.novoHorario();
    }
    
    public Horario HorarioMaisTarde(Horario horario1, Horario horario2){
        Horario horario = null;
        if(horario1.getHora()>horario2.getHora()){
            horario = horario1;
        }
        else if(horario1.getHora()<horario2.getHora()){
            horario = horario2;
        }
        else{
            if(horario1.getMinuto()>horario2.getMinuto()){
                horario = horario1;
            }
            else if(horario1.getMinuto()<horario2.getMinuto()){
                horario = horario2;
            }
        }
        return horario;
    }
    
    public Horario HorarioMaisCedo(Horario horario1, Horario horario2){
        Horario horario = null;
        if(horario1.getHora()>horario2.getHora()){
            horario = horario2;
        }
        else if(horario1.getHora()<horario2.getHora()){
            horario = horario1;
        }
        else{
            if(horario1.getMinuto()>horario2.getMinuto()){
                horario = horario2;
            }
            else if(horario1.getMinuto()<horario2.getMinuto()){
                horario = horario1;
            }
        }
        return horario;
    }
    
}
