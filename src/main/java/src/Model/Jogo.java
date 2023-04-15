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
    
    public Jogo() {
    }
    
    public void addCasaLiberada(Casa casa){
        casas.add(casa);
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
        Casa casaInicialAzul = new Casa(TipoCasa.INICIAL);
        Casa casaInicialVerde = new Casa(TipoCasa.INICIAL);
        
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
        addCasaLiberada(casaInicialAzul);
        addCasaLiberada(casaInicialVerde);
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
        
        casas.get(52).addPeao(peaoAzul);
        casas.get(52).addPeao(peaoAzul2);
        casas.get(52).addPeao(peaoAzul3);
        casas.get(52).addPeao(peaoAzul4);
        casas.get(53).addPeao(peaoVerde);
        casas.get(53).addPeao(peaoVerde2);
        casas.get(53).addPeao(peaoVerde3);
        casas.get(53).addPeao(peaoVerde4);
    }
}
