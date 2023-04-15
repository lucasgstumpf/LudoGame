/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author felipe.freitas_visag
 */
public enum TipoCasa {
    NORMAL, ESPECIAL, INICIAL;
    
    public static TipoCasa getTipoCasa(String dbm) {
        TipoCasa tipoCasa;
        switch (dbm.toLowerCase()) {
            case "normal": 
                tipoCasa = NORMAL;
                break;
            case "especial":
                tipoCasa = ESPECIAL;
                break;
            case "inicial":
                tipoCasa = INICIAL;
                break;
            default:
                tipoCasa = null;
                break;
        }
        return tipoCasa;
    }
}
