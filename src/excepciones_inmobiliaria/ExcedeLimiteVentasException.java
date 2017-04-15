/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones_inmobiliaria;

/**
 *
 * @author felip
 */
public class ExcedeLimiteVentasException extends Exception {
    
    private int inmueblesVendidos;
    private int ventasPermitidas;
    
    public ExcedeLimiteVentasException(int inmueblesVendidos, int ventasPermitidas){
        this.inmueblesVendidos = inmueblesVendidos;
        this.ventasPermitidas = ventasPermitidas;
    }
    
    @Override
    public String getMessage(){
        return "Ha excedido el numero de ventas permitidas, se permiten " + ventasPermitidas + " y usted ha vendido " + inmueblesVendidos;
    }
    
}
