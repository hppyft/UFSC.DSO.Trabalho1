
package ufsc.dso.trabalho1.Telas;
import ufsc.dso.trabalho1.Entidades.CargoInexistenteException;

public class TelaControladorCargo {

    public TelaControladorCargo() {
    }
    
    public void cargoInexistente(CargoInexistenteException e){
        System.out.println(e.getMessage());
    }
}
