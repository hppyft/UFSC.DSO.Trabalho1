
package ufsc.dso.trabalho1.Entidades;

public class Data {
    
    private int dia;
    private int mes;
    private int ano;
    private String dataEscrita;
    

    public Data() {
        this.dia = 10;
        this.mes = 06;
        this.ano = 2016;
        this.dataEscrita = "10/06/2016";
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        this.dataEscrita = ""+getDia()+"/"+getMes()+"/"+getAno();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        this.dataEscrita = ""+getDia()+"/"+getMes()+"/"+getAno();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        this.dataEscrita = ""+getDia()+"/"+getMes()+"/"+getAno();
    }

    public String getDataEscrita() {
        return dataEscrita;
    }
    
    
}
