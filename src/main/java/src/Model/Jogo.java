/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ALUNOS
 */
public class Jogo {
    
    private ArrayList<Peao> peoes;

    public Jogo(ArrayList<Peao> peoes) {
        this.peoes = peoes;
    }
    
    
    
    public int rodarDado(){
        int valorDado = 1 + (int)(Math.random()*6);
        return valorDado;
    }
    
    public boolean verificaPeoesNaMesmaCasa(int casa){
        List<Peao> listaPeoes = peoes.stream().filter(a -> a.getCasa() == casa).collect(Collectors.toList());
        if(listaPeoes.size() != 1){
            return verificaSePeoesSaoDiferentes(listaPeoes);
        } else {
            return false;
        }
    }
    
    public boolean verificaSePeoesSaoDiferentes(List<Peao> listaPeoes){                
        int corPrimeiroPeao = listaPeoes.get(0).getCor();
        for(Peao peao : listaPeoes){
            if(peao.getCor() != corPrimeiroPeao){
                peao.setCasa(0);
                return true;
            }
        }
        
        return false;
    }
}
