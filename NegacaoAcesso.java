
package ufsc.dso.trabalho1.Entidades;

public class NegacaoAcesso {
    
    private Integer matricula;
    private String data;
    private String horario;
    private Motivo motivo;

    public NegacaoAcesso(Integer matricula, String data, String horario, Motivo motivo) {
        this.matricula = matricula;
        this.data = data;
        this.horario = horario;
        this.motivo = motivo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public Motivo getMotivo() {
        return motivo;
    }
    
}
