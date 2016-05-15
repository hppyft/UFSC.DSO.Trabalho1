
package ufsc.dso.trabalho1.Entidades;
import java.util.Calendar;
import java.util.Date;

public class Funcionario {
    
    private Integer matricula;
    private String nome;
    private Calendar dataDeNascimento = Calendar.getInstance();
    private int telefone;
    private int salario;
    private Cargo cargo;

    public Funcionario(Integer matricula, String nome, int anoNascimento, int mesNascimento, int diaNascimento, int telefone, int salario, Cargo cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataDeNascimento.set(Calendar.YEAR,anoNascimento);
        this.dataDeNascimento.set(Calendar.MONTH,mesNascimento);
        this.dataDeNascimento.set(Calendar.DAY_OF_MONTH,diaNascimento);
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNascimento() {
        return (dataDeNascimento.get(Calendar.DAY_OF_MONTH)+"/"+dataDeNascimento.get(Calendar.MONTH)+"/"+dataDeNascimento.get(Calendar.YEAR));
    }

    public void setDataDeNascimento(int anoNascimento, int mesNascimento, int diaNascimento) {
        this.dataDeNascimento.set(Calendar.YEAR,anoNascimento);
        this.dataDeNascimento.set(Calendar.MONTH,mesNascimento);
        this.dataDeNascimento.set(Calendar.DAY_OF_MONTH,diaNascimento);
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
}
