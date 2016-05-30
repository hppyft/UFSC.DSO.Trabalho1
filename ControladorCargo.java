
package ufsc.dso.trabalho1.Controladores;

import java.util.HashMap;
import ufsc.dso.trabalho1.Entidades.Cargo;
import ufsc.dso.trabalho1.Entidades.CargoInexistenteException;
import ufsc.dso.trabalho1.Telas.TelaControladorCargo;

public class ControladorCargo {

    private static ControladorCargo instancia;
    private HashMap<Integer, Cargo> listaCargos = new HashMap<>();
    
    private ControladorCargo(){
    }
    
    public static ControladorCargo getInstance(){
        if (instancia == null){
            instancia = new ControladorCargo();
        }
        return instancia;
    }
    
    public Cargo buscaCargoPeloCodigo(Integer codigoCargo){
        Cargo cargo = null;
        try {
            
            for(HashMap.Entry<Integer, Cargo> entry : listaCargos.entrySet()){
                Integer key = entry.getKey();
                Cargo value = entry.getValue();
                if (codigoCargo == key){
                    cargo = value;
                }
            }
            if (cargo == null){
                throw new CargoInexistenteException();
            }
        }catch(CargoInexistenteException e){
            TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
            telaControladorCargo.cargoInexistente(e);
        }
        return cargo;
    }
    
    public Cargo inserirCargo(){
        TelaControladorCargo telaControladorCargo = new TelaControladorCargo();
        String nome = telaControladorCargo.telaCadastroCargoNome();
        Integer codigo = telaControladorCargo.telaCadastroCargoCodigo();
        boolean ehGerencial = telaControladorCargo.telaCadastroCargoEhGerencial();
        boolean acesso = true;
        if (!ehGerencial){
            acesso = telaControladorCargo.telaCadastroCargoAcesso();
        }
        if (!ehGerencial && acesso){
            int horaEntrada = telaControladorCargo.telaCadastroCargoHoraEntrada();
            int minutoEntrada = telaControladorCargo.telaCadastroCargoMinutoEntrada();
            int horaSaida = telaControladorCargo.telaCadastroCargoHoraSaida();
            int minutoSaida = telaControladorCargo.telaCadastroCargoMinutoSaida();
        }
        
        
    }
}
