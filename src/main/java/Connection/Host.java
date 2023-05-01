/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

/**
 *
 * @author felipe.freitas_visag
 */
public class Host implements Runnable {

    /**
     * Objeto da classe Connection
     */
    private Conexao con;

    /**
     * Construtor da classe
     * 
     * @param con Connection
     */
    public Host(Conexao con) {
        this.con = con;
    }

    @Override
    public void run() {
        con.initCon();
    }
}
