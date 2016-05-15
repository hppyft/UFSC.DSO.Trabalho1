
package ufsc.dso.trabalho1.Entidades;
import java.util.HashMap;


public class Cargo {
    
    private String nome;
    private int codigo;
    private boolean acesso;
    private HashMap<String, String> listaHorarios = new HashMap<>();
    private boolean gerencial;

    public Cargo(String nome, int codigo, boolean acesso, boolean ehGerencial, String horarioEntrada1, String horarioSaida1, String horarioEntrada2, String horarioSaida2) {
        this.nome = nome;
        this.codigo = codigo;
        this.acesso = acesso;
        this.gerencial = ehGerencial;
        this.listaHorarios.put(horarioEntrada1,horarioSaida1);
        this.listaHorarios.put(horarioEntrada2,horarioSaida2);
    }

    public Cargo(String nome, int codigo, boolean acesso, boolean ehGerencial) {
        this.nome = nome;
        this.codigo = codigo;
        this.acesso = acesso;
        this.gerencial = ehGerencial;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
    
    
}
