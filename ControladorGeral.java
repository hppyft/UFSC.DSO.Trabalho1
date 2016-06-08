
package ufsc.dso.trabalho1.Controladores;

import ufsc.dso.trabalho1.Telas.TelaControladorGeral;

public class ControladorGeral {
    private static ControladorGeral instancia;
    private boolean fecharSistema = false;
    
    private ControladorGeral(){
    }
    
    public static ControladorGeral getInstance(){
        if (instancia == null){
            instancia = new ControladorGeral();
        }
        return instancia;
    }
    
    public void inicializaSistema() {
        
        while (ControladorHorario.getInstance().getHorarioAtual() == null){
            ControladorHorario.getInstance().atualizaHorarioSistema();
        }
        while (ControladorData.getInstance().getDataAtual() == null){
            ControladorData.getInstance().atualizaDataSistema();
        }
    }
    public void inicializa() {
        this.inicializaSistema();
        while (!this.isFecharSistema()){
            TelaControladorGeral telaControladorGeral = new TelaControladorGeral();
            int opcao = telaControladorGeral.mostraMenu();
            try{
                switch (opcao){
                    case 1:
                        ControladorAcesso.getInstance().inicializa();
                        break;

                    case 2:
                        ControladorFuncionario.getInstance().inicializa();
                        break;

                    case 3:
                        ControladorCargo.getInstance().inicializa();
                        break;

                    case 4:
                        ControladorHorario.getInstance().atualizaHorarioSistema();
                        break;

                    case 5:
                        ControladorData.getInstance().atualizaDataSistema();
                        break;

                    case 6:
                        fecharSistema();
                        break;

                    default:
                        telaControladorGeral.telaMensagem(opcao+" nao eh uma opcao valida");
                        break;
                }
            }
            catch(Exception e){
                telaControladorGeral.telaMensagem("Voce digitou um tipo incorreto de caracter, por favor digite apenas numeros quando for pedido");
            }
        }
    }
    
    public void fecharSistema(){
        TelaControladorGeral telaControladorGeral = new TelaControladorGeral();
        int opcao = telaControladorGeral.telaFecharSistema();
        if (opcao == 1){
            this.setFecharSistema(true);
        }
        else if (opcao ==2){
        }
        else{
            telaControladorGeral.telaMensagem("Por favor digite apenas 1 para SIM ou 2 para NAO");
        }
    }

    public boolean isFecharSistema() {
        return fecharSistema;
    }

    public void setFecharSistema(boolean fecharSistema) {
        this.fecharSistema = fecharSistema;
    }
    
    
}
