
package ufsc.dso.trabalho1.Entidades;

public class IntervaloHorario {
    
    private Horario horarioEntrada;
    private Horario horarioSaida;

    public IntervaloHorario(Horario horarioEntrada, Horario horarioSaida) {
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public Horario getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Horario horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Horario getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Horario horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
    
        
}
