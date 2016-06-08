package ufsc.dso.trabalho1.Entidades;

public class Horario {
    
    private String horarioEscrito;
    private int hora;
    private int minuto;

    public Horario(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
        this.horarioEscrito = ""+hora+":"+minuto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
        this.horarioEscrito = ""+hora+":"+this.minuto;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
        this.horarioEscrito = ""+this.hora+":"+minuto;
    }

    public String getHorarioEscrito() {
        return horarioEscrito;
    }
    
    
    
}
