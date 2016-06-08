
package ufsc.dso.trabalho1.Entidades;

public class Funcionario {
    
    private Integer matricula;
    private String nome;
    private Data dataNascimento;
    private int telefone;
    private int salario;
    private Cargo cargo;
    private boolean acessoBloqueado = false;

    public Funcionario(Integer matricula, String nome, Data dataNascimento, int telefone, int salario, Cargo cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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

    public String getDataNascimento() {
        return dataNascimento.getDataEscrita();
    }

    public void setDataNascimento(Data data) {
        this.dataNascimento = data;
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

    public boolean isAcessoBloqueado() {
        return acessoBloqueado;
    }

    public void setAcessoBloqueado(boolean acessoBloqueado) {
        this.acessoBloqueado = acessoBloqueado;
    }
}
