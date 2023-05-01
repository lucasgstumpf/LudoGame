/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import Enums.TipoCasa;
import java.util.ArrayList;

/**
 *
 * @author felipe.freitas_visag
 */
public class Casa {
    
    private final static ArrayList<Peao> peoes = new ArrayList<>();

    private TipoCasa tipoCasa;

    public Casa(TipoCasa tipoCasa) {
        this.tipoCasa = tipoCasa;
    }
    
    public boolean verificaCasaFinalCheia(){
        if(peoes.size() == 4){
            return true;
        }
        return false;
    }
    
    public void addPeao(Peao peaoRecente){
        if(tipoCasa.equals(TipoCasa.NORMAL)){
            if(!peoes.isEmpty()){
                int cor = peaoRecente.getCor();
                for(Peao peao : peoes){
                    if(!(cor == peao.getCor())){
                        peoes.remove(peao);
                    }
                }
            }
        }
        
        peoes.add(peaoRecente);        
    }

    public TipoCasa getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(TipoCasa tipoCasa) {
        this.tipoCasa = tipoCasa;
    }
}
