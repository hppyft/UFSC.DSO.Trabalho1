
package ufsc.dso.trabalho1.Entidades;

public class CargoInexistenteException extends Exception{
    
    public CargoInexistenteException(){
        super( "Cargo Inexistente");
    }
}
