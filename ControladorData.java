package ufsc.dso.trabalho1.Controladores;

import ufsc.dso.trabalho1.Entidades.Data;
import ufsc.dso.trabalho1.Entidades.DataInvalidaException;
import ufsc.dso.trabalho1.Telas.TelaControladorData;

public class ControladorData {
    private static ControladorData instancia;
    private Data dataAtual;
    
    private ControladorData(){
    }
    
    public static ControladorData getInstance(){
        if (instancia == null){
            instancia = new ControladorData();
        }
        return instancia;
    }

    public Data getDataAtual() {
        return dataAtual;
    }
    
    public int novoAno(){
        int ano = -1;
        boolean anoValido = false;
        TelaControladorData telaControladorData = new TelaControladorData();
        while(!anoValido){
            try{
                ano = telaControladorData.telaNovoAno();
                anoValido = true;
            }
            catch (DataInvalidaException e){
                telaControladorData.telaMensagem(e.getMessage());
            }
        }
        return ano;
    }
    
    public int novoMes(){
        int mes = -1;
        boolean mesValido = false;
        TelaControladorData telaControladorData = new TelaControladorData();
        while(!mesValido){
            try{
                mes = telaControladorData.telaNovoMes();
                mesValido = true;
            }
            catch (DataInvalidaException e){
                telaControladorData.telaMensagem(e.getMessage());
            }
        }
        return mes;
    }
    
    public int novoDia(Data data){
        int dia = -1;
        boolean diaValido = false;
        TelaControladorData telaControladorData = new TelaControladorData();
        while(!diaValido){
            try{
                dia = telaControladorData.telaNovoDia();
                switch (data.getMes()){
                    case 1:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 2:
                        if(ehBisexto(data.getAno())){
                            if(dia>29){
                                throw new DataInvalidaException("por favor, dia maximo eh 29");
                            }
                        }
                        else{
                            if(dia>28){
                                throw new DataInvalidaException("por favor, dia maximo eh 28");
                            }
                        }
                        break;
                    case 3:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 4:
                        if(dia>30){
                            throw new DataInvalidaException("por favor, dia maximo eh 30");
                        }
                        break;
                    case 5:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 6:
                        if(dia>30){
                            throw new DataInvalidaException("por favor, dia maximo eh 30");
                        }
                        break;
                    case 7:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 8:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 9:
                        if(dia>30){
                            throw new DataInvalidaException("por favor, dia maximo eh 30");
                        }
                        break;
                    case 10:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    case 11:
                        if(dia>30){
                            throw new DataInvalidaException("por favor, dia maximo eh 30");
                        }
                        break;
                    case 12:
                        if(dia>31){
                            throw new DataInvalidaException("por favor, dia maximo eh 31");
                        }
                        break;
                    default:
                        break;
                }
                diaValido = true;
            }
            catch (DataInvalidaException e){
                telaControladorData.telaMensagem(e.getMessage());
            }
        }
        return dia;
    }

    public boolean ehBisexto(int ano) {
        boolean ehBisexto = false;
        if (ano%4 == 0){
            if (ano%100 == 0){
                if (ano%400 ==0){
                    ehBisexto = true;
                }
            }
            else{
                ehBisexto = true;
            }
        }
        return ehBisexto;
    }
    
    public void atualizaDiaSistema(){
        TelaControladorData telaControladorData = new TelaControladorData();
        telaControladorData.telaMensagem("Por favor, atualize o dia do sistema");
        this.dataAtual.setDia(novoDia(this.dataAtual));
    }
    
    public void atualizaMesSistema(){
        TelaControladorData telaControladorData = new TelaControladorData();
        telaControladorData.telaMensagem("Por favor, atualize o mes do sistema");
        this.dataAtual.setMes(novoMes());
    }
    
    public void atualizaAnoSistema(){
        TelaControladorData telaControladorData = new TelaControladorData();
        telaControladorData.telaMensagem("Por favor, atualize o ano do sistema");
        boolean anoValido = false;
        int ano = -1;
        while(!anoValido){
            try{
                ano = novoAno();
                if(ano<2016){
                    throw new DataInvalidaException("Ano atual deve ser maior ou igual a 2016");
                }
                else{
                    anoValido=true;
                }
            }
            catch(DataInvalidaException e){
                telaControladorData.telaMensagem(e.getMessage());
            }
        }
        this.dataAtual = new Data();
        this.dataAtual.setAno(ano);
    }
    
    public void atualizaDataSistema(){
        atualizaAnoSistema();
        atualizaMesSistema();
        atualizaDiaSistema();
    }
}
