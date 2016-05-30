
package ufsc.dso.trabalho1.Entidades;
import java.util.HashMap;


public class Cargo {
    
    private String nome;
    private Integer codigo;
    private boolean acesso;
    private HashMap<String, String> listaHorarios = new HashMap<>();
    private boolean gerencial;

    public Cargo(String nome, Integer codigo, boolean ehGerencial, boolean acesso) {
        this.nome = nome;
        this.codigo = codigo;
        this.gerencial = ehGerencial;
        this.acesso = acesso;
    }

    public boolean isGerencial() {
        return gerencial;
    }

    public void setGerencial(boolean gerencial) {
        this.gerencial = gerencial;
    }
    
    public void incluiHorario(String horarioEntrada, String horarioSaida){
        this.listaHorarios.put(horarioEntrada,horarioSaida);
    }
    
    public HashMap<String,String> getHorarios(){
        return listaHorarios;
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
