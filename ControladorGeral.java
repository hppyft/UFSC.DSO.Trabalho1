
package ufsc.dso.trabalho1.Controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import ufsc.dso.trabalho1.teste;

import ufsc.dso.trabalho1.Telas.TelaControladorGeral;

public class ControladorGeral {
    private static ControladorGeral instancia;
    private SimpleDateFormat datos = new SimpleDateFormat("HH:mm");
    private Date horarioAtual;
    
    private ControladorGeral(){
    }
    
    public static ControladorGeral getInstance(){
        if (instancia == null){
            instancia = new ControladorGeral();
        }
        return instancia;
    }
    
    public void atualizaHora (){
        while (horarioAtual == null){
            try{
                TelaControladorGeral telaControladorGeral = new TelaControladorGeral();
                String horaAtualizada = telaControladorGeral.telaAtualizaHora();
                this.horarioAtual = datos.parse(horaAtualizada);
            }catch (ParseException e){
                System.out.println("Voce nao pos um horario valido. Logo, o horario nao foi atualizado. Por favor refaca o processo colocando um horario valido");
            }
        }
    }

    public void inicializa() {
        this.atualizaHora();
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
                    this.atualizaHora();
                    break;
                    
                case 4:
                    teste.setFecharSistema(true);
                    break;
            }
        }catch(Exception e){
            System.out.println(opcao+" nao eh uma opcao valida");
        }
    }
}