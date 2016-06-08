package ufsc.dso.trabalho1.Entidades;


public class DataInvalidaException extends NumberFormatException{
    
    public DataInvalidaException(String mensagem){
        super(mensagem);
    }
    
}
