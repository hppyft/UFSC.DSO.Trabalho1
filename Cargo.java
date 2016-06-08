
package ufsc.dso.trabalho1.Entidades;
import java.util.ArrayList;
import ufsc.dso.trabalho1.Entidades.IntervaloHorario;


public class Cargo {
    
    private String nome;
    private Integer codigo;
    private boolean acesso;
    private ArrayList<IntervaloHorario> listaIntervaloHorarios = new ArrayList<>();
    private boolean gerencial;

    public Cargo(boolean ehGerencial, String nome, Integer codigo) {
        this.gerencial = ehGerencial;
        this.nome = nome;
        this.codigo = codigo;
        this.acesso = true;
    }

    public Cargo(String nome, Integer codigo, boolean acesso) {
        this.nome = nome;
        this.codigo = codigo;
        this.acesso = acesso;
        this.gerencial = false;
    }
    

    public boolean isGerencial() {
        return gerencial;
    }

    public void setGerencial(boolean gerencial) {
        this.gerencial = gerencial;
    }
    
    public void incluiHorario(IntervaloHorario intervaloHorario){
        this.listaIntervaloHorarios.add(intervaloHorario);
    }
    
    public ArrayList<IntervaloHorario> getListaIntervaloHorarios(){
        return listaIntervaloHorarios;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
    
}
