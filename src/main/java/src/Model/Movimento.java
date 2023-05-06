/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author felipe.freitas_visag
 */
public class Movimento {
    
    Integer valorDado;
    
    Integer numeroCasa;

    Boolean isHost;
    
    public Movimento(Integer valorDado, Integer numeroCasa, Boolean isHost) {
        this.valorDado = valorDado;
        this.numeroCasa = numeroCasa;
        this.isHost = isHost;
    }
    
    public Integer getValorDado() {
        return valorDado;
    }

    public void setValorDado(Integer valorDado) {
        this.valorDado = valorDado;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Boolean isIsHost() {
        return isHost;
    }

    public void setIsHost(Boolean isHost) {
        this.isHost = isHost;
    } 
    
}
