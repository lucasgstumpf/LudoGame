/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author ALUNOS
 */

public class Peao {
    
    private int cor;
    //Verde = 1
    //Azul = 2
   
    
    private int casa;

    public Peao(int cor, int casa) {
        this.cor = cor;
        this.casa = casa;
    }
    
    
    public void andar(){
        
    }
    
    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getCasa() {
        return casa;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }
}
