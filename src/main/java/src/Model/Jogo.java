/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import Enums.TipoCasa;
import java.util.ArrayList;
/**
 *
 * @author ALUNOS
 */
public class Jogo {
    
    private final static ArrayList<Casa> casas = new ArrayList<>();
    private final static ArrayList<Casa> casasIniciais = new ArrayList<>();
    private final static ArrayList<Casa> casasFinais = new ArrayList<>();
    private final static ArrayList<Casa> casasRetaFinalAzul = new ArrayList<>();
    private final static ArrayList<Casa> casasRetaFinalVerde = new ArrayList<>();

    private boolean vencedor;
    
    public Jogo() {
        this.vencedor = false;
    }
    
    public void addCasaLiberada(Casa casa){
        casas.add(casa);
    }
    
    public void addCasaInicias(Casa casa){
        casasIniciais.add(casa);
    }
    
    public void addCasaFinais(Casa casa){
        casasFinais.add(casa);
    }
     
    public void addCasaRetaFinalAzul(Casa casa){
        casasRetaFinalAzul.add(casa);
    }
    
    public void addCasaRetaFinalVerde(Casa casa){
        casasRetaFinalVerde.add(casa);
    }
    
    public int rodarDado(){
       int valorDado = 1 + (int)(Math.random()*6);
       return valorDado;
    }
    
    public void reiniciarTabuleiro(){
        if(!casas.isEmpty()){
            casas.clear();
        }
        criacaoCasas();   
        criacaoPeoes();
    }    
    
    public void iniciarJogo(){
        reiniciarTabuleiro();     
    }
    public boolean temPeao(int posAntiga){
        System.out.println(posAntiga);
        if(posAntiga<52){
            if(casas.get(posAntiga).getPeoes().size() > 0){
                return true;
            }
        }else if(posAntiga<79){
            if(casasRetaFinalAzul.get(posAntiga-70).getPeoes().size() > 0){
                return true;
            }
        }else if(posAntiga<89){
            if(casasRetaFinalVerde.get(posAntiga-80).getPeoes().size() > 0){
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean fimDeJogo(int index){
        if(casasFinais.get(index).verificaCasaFinalCheia()){
            this.vencedor = true;
            return true;
        }
        return false;
    }
    
    public Integer mover(Movimento movimento){
        int valorDado = movimento.getValorDado();
        int numeroCasa = movimento.getNumeroCasa();
        
        if(movimento.isIsHost()){
            if((numeroCasa == 100 || numeroCasa == 101 || numeroCasa == 102 || numeroCasa == 103) && valorDado == 6){
                Peao peao = casasIniciais.get(0).removePeaoI();
                casas.get(0).addPeao(peao);
                return 0;
            } else if ((numeroCasa == 100 || numeroCasa == 101 || numeroCasa == 102 || numeroCasa == 103) && valorDado != 6){
                return null;
            }
            
            int casaFutura = numeroCasa + valorDado;
            if(numeroCasa > 69){
                if (casaFutura > 75){
                    return null;
                } else if (casaFutura == 75){
                    Peao peao = casasRetaFinalAzul.get(numeroCasa).removePeaoI();
                    casasFinais.get(0).addPeao(peao);
                    return casaFutura;
                }{
                    Peao peao = casasRetaFinalAzul.get(numeroCasa).removePeaoI();
                    casasRetaFinalAzul.get(casaFutura).addPeao(peao);
                    return casaFutura;
                }
            } else if (casaFutura > 50){
                Peao peao = casas.get(numeroCasa).removePeaoI();
                casasRetaFinalAzul.get(casaFutura - 51).addPeao(peao);
                return 70 + (casaFutura - 51);
            } else {
                Peao peao = casas.get(numeroCasa).removePeaoI();
                casas.get(casaFutura).addPeao(peao);
                    return casaFutura;     
            }
        } else {
            if((numeroCasa == 110 || numeroCasa == 111 || numeroCasa == 112 || numeroCasa == 113) && valorDado == 6){
                Peao peao = casasIniciais.get(1).removePeaoI();
                casas.get(26).addPeao(peao);
                return 26;
            } else if ((numeroCasa == 110 || numeroCasa == 111 || numeroCasa == 112 || numeroCasa == 113) && valorDado != 6){
                return null;
            }
            
            int casaFutura = numeroCasa + valorDado;

            if(numeroCasa > 79){
                if (casaFutura > 85){
                    return null;
                } else if (casaFutura == 85){
                    Peao peao = casasRetaFinalVerde.get(numeroCasa).removePeaoI();
                    casasFinais.get(1).addPeao(peao);
                    return casaFutura;
                }{
                    Peao peao = casasRetaFinalVerde.get(numeroCasa).removePeaoI();
                    casasRetaFinalVerde.get(casaFutura).addPeao(peao);
                    return casaFutura;
                }
            } else if(casaFutura > 51){
                Peao peao = casas.get(numeroCasa).removePeaoI();
                casas.get(casaFutura - 52).addPeao(peao);
                return casaFutura - 52;
            } else if (casaFutura > 24 && numeroCasa < 25 ) {
                Peao peao = casas.get(numeroCasa).removePeaoI();
                casasRetaFinalVerde.get(casaFutura - 25).addPeao(peao);
                return 80 + (casaFutura - 25);
            } else {
                System.out.println(casaFutura);
                Peao peao = casas.get(numeroCasa).removePeaoI();
                casas.get(casaFutura).addPeao(peao);
                return casaFutura;
            }
        }
    }
    
    public void criacaoCasas(){
        Casa casa = new Casa(TipoCasa.ESPECIAL);
        Casa casa1 = new Casa(TipoCasa.NORMAL);
        Casa casa2 = new Casa(TipoCasa.NORMAL);
        Casa casa3 = new Casa(TipoCasa.NORMAL);
        Casa casa4 = new Casa(TipoCasa.NORMAL);
        Casa casa5 = new Casa(TipoCasa.NORMAL);
        Casa casa6 = new Casa(TipoCasa.NORMAL);
        Casa casa7 = new Casa(TipoCasa.NORMAL);
        Casa casa8 = new Casa(TipoCasa.ESPECIAL);
        Casa casa9 = new Casa(TipoCasa.NORMAL);
        Casa casa10 = new Casa(TipoCasa.NORMAL);
        Casa casa11 = new Casa(TipoCasa.NORMAL);
        Casa casa12 = new Casa(TipoCasa.NORMAL);
        Casa casa13 = new Casa(TipoCasa.ESPECIAL);
        Casa casa14 = new Casa(TipoCasa.NORMAL);
        Casa casa15 = new Casa(TipoCasa.NORMAL);
        Casa casa16 = new Casa(TipoCasa.NORMAL);
        Casa casa17 = new Casa(TipoCasa.NORMAL);
        Casa casa18 = new Casa(TipoCasa.NORMAL);
        Casa casa19 = new Casa(TipoCasa.NORMAL);
        Casa casa20 = new Casa(TipoCasa.NORMAL);
        Casa casa21 = new Casa(TipoCasa.ESPECIAL);
        Casa casa22 = new Casa(TipoCasa.NORMAL);
        Casa casa23 = new Casa(TipoCasa.NORMAL);
        Casa casa24 = new Casa(TipoCasa.NORMAL);
        Casa casa25 = new Casa(TipoCasa.NORMAL);
        Casa casa26 = new Casa(TipoCasa.ESPECIAL);
        Casa casa27 = new Casa(TipoCasa.NORMAL);
        Casa casa28 = new Casa(TipoCasa.NORMAL);
        Casa casa29 = new Casa(TipoCasa.NORMAL);
        Casa casa30 = new Casa(TipoCasa.NORMAL);
        Casa casa31 = new Casa(TipoCasa.NORMAL);
        Casa casa32 = new Casa(TipoCasa.NORMAL);
        Casa casa33 = new Casa(TipoCasa.NORMAL);
        Casa casa34 = new Casa(TipoCasa.ESPECIAL);
        Casa casa35 = new Casa(TipoCasa.NORMAL);
        Casa casa36 = new Casa(TipoCasa.NORMAL);
        Casa casa37 = new Casa(TipoCasa.NORMAL);
        Casa casa38 = new Casa(TipoCasa.NORMAL);
        Casa casa39 = new Casa(TipoCasa.ESPECIAL);
        Casa casa40 = new Casa(TipoCasa.NORMAL);
        Casa casa41 = new Casa(TipoCasa.NORMAL);
        Casa casa42 = new Casa(TipoCasa.NORMAL);
        Casa casa43 = new Casa(TipoCasa.NORMAL);
        Casa casa44 = new Casa(TipoCasa.NORMAL);
        Casa casa45 = new Casa(TipoCasa.NORMAL);
        Casa casa46 = new Casa(TipoCasa.NORMAL);
        Casa casa47 = new Casa(TipoCasa.ESPECIAL);
        Casa casa48 = new Casa(TipoCasa.NORMAL);
        Casa casa49 = new Casa(TipoCasa.NORMAL);
        Casa casa50 = new Casa(TipoCasa.NORMAL);
        Casa casa51 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalAzul = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalAzul2 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalAzul3 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalAzul4 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalAzul5 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalVerde = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalVerde2 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalVerde3 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalVerde4 = new Casa(TipoCasa.NORMAL);
        Casa casaRetaFinalVerde5 = new Casa(TipoCasa.NORMAL);
        Casa casaInicialAzul = new Casa(TipoCasa.INICIAL);
        Casa casaInicialVerde = new Casa(TipoCasa.INICIAL);
        Casa casaFinalAzul = new Casa(TipoCasa.FINAL);
        Casa casaFinalVerde = new Casa(TipoCasa.FINAL);
        
        addCasaLiberada(casa);
        addCasaLiberada(casa1);
        addCasaLiberada(casa2);
        addCasaLiberada(casa3);
        addCasaLiberada(casa4);
        addCasaLiberada(casa5);
        addCasaLiberada(casa6);
        addCasaLiberada(casa7);
        addCasaLiberada(casa8);
        addCasaLiberada(casa9);
        addCasaLiberada(casa10);
        addCasaLiberada(casa11);
        addCasaLiberada(casa12);
        addCasaLiberada(casa13);
        addCasaLiberada(casa14);
        addCasaLiberada(casa15);
        addCasaLiberada(casa16);
        addCasaLiberada(casa17);
        addCasaLiberada(casa18);
        addCasaLiberada(casa19);
        addCasaLiberada(casa20);
        addCasaLiberada(casa21);
        addCasaLiberada(casa22);
        addCasaLiberada(casa23);
        addCasaLiberada(casa24);
        addCasaLiberada(casa25);
        addCasaLiberada(casa26);
        addCasaLiberada(casa27);
        addCasaLiberada(casa28);
        addCasaLiberada(casa29);
        addCasaLiberada(casa30);
        addCasaLiberada(casa31);
        addCasaLiberada(casa32);
        addCasaLiberada(casa33);
        addCasaLiberada(casa34);
        addCasaLiberada(casa35);
        addCasaLiberada(casa36);
        addCasaLiberada(casa37);
        addCasaLiberada(casa38);
        addCasaLiberada(casa39);
        addCasaLiberada(casa40);
        addCasaLiberada(casa41);
        addCasaLiberada(casa42);
        addCasaLiberada(casa43);
        addCasaLiberada(casa44);
        addCasaLiberada(casa45);
        addCasaLiberada(casa46);
        addCasaLiberada(casa47);
        addCasaLiberada(casa48);
        addCasaLiberada(casa49);
        addCasaLiberada(casa50);
        addCasaLiberada(casa51);
        addCasaInicias(casaInicialAzul);
        addCasaInicias(casaInicialVerde);
        addCasaFinais(casaFinalAzul);
        addCasaFinais(casaFinalVerde);
        addCasaRetaFinalAzul(casaRetaFinalAzul);
        addCasaRetaFinalAzul(casaRetaFinalAzul2);
        addCasaRetaFinalAzul(casaRetaFinalAzul3);
        addCasaRetaFinalAzul(casaRetaFinalAzul4);
        addCasaRetaFinalAzul(casaRetaFinalAzul5);
        addCasaRetaFinalVerde(casaRetaFinalVerde);
        addCasaRetaFinalVerde(casaRetaFinalVerde2);
        addCasaRetaFinalVerde(casaRetaFinalVerde3);
        addCasaRetaFinalVerde(casaRetaFinalVerde4);
        addCasaRetaFinalVerde(casaRetaFinalVerde5);
    }
    
    public void criacaoPeoes(){
        Peao peaoAzul = new Peao(1);
        Peao peaoAzul2 = new Peao(1);
        Peao peaoAzul3 = new Peao(1);
        Peao peaoAzul4 = new Peao(1);
        Peao peaoVerde = new Peao(2);
        Peao peaoVerde2 = new Peao(2);
        Peao peaoVerde3 = new Peao(2);
        Peao peaoVerde4 = new Peao(2);
        
        casasIniciais.get(0).addPeao(peaoAzul);
        casasIniciais.get(0).addPeao(peaoAzul2);
        casasIniciais.get(0).addPeao(peaoAzul3);
        casasIniciais.get(0).addPeao(peaoAzul4);
        casasIniciais.get(1).addPeao(peaoVerde);
        casasIniciais.get(1).addPeao(peaoVerde2);
        casasIniciais.get(1).addPeao(peaoVerde3);
        casasIniciais.get(1).addPeao(peaoVerde4);
    }

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }
}
