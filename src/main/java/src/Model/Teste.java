/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.util.ArrayList;

/**
 *
 * @author ALUNOS
 */
public class Teste {
    public static void main(String[] args) {
        
        // Nesse caso o peão peao foi o que se movimentou para a casa 10
        Peao peao = new Peao(1, 10);
        Peao peao2 = new Peao(2, 10);
        Peao peao3 = new Peao(1, 10);
        
        System.out.println("Peão 1, Cor: " + peao.getCor() + "Casa: " + peao.getCasa());
        System.out.println("Peão 2, Cor: " + peao2.getCor() + "Casa: " + peao2.getCasa());
        System.out.println("Peão 3, Cor: " + peao3.getCor() + "Casa: " + peao3.getCasa());
        
        
        ArrayList<Peao> peoes = new ArrayList(); 
        peoes.add(peao);
        peoes.add(peao2);
        peoes.add(peao3);
        
        Jogo jogo = new Jogo(peoes);
        if(jogo.verificaPeoesNaMesmaCasa(10)){
            System.out.println("Peão voltou a casa original");
        }
        System.out.println("Peão 1, Cor: " + peao.getCor() + " Casa: " + peao.getCasa());
        System.out.println("Peão 2, Cor: " + peao2.getCor() + " Casa: " + peao2.getCasa());
        System.out.println("Peão 3, Cor: " + peao3.getCor() + " Casa: " + peao3.getCasa());
    }
}
