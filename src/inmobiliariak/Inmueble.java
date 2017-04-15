/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliariak;

/**
 *
 * @author 10
 */
public abstract class Inmueble {
    
    public int id;
    public int tipo;
    public int metrosCuadradosConstruidos;
    public int estrato;
    public double valorMetroCuadrado;
    
    public Inmueble(int id, 
                    int tipo,
                    int metrosCuadradosConstruidos,
                    int estrato,
                    double valorMetroCuadrado){
        this.id = id;
        this.tipo = tipo;
        this.metrosCuadradosConstruidos = metrosCuadradosConstruidos;
        this.estrato = estrato;
        this.valorMetroCuadrado = valorMetroCuadrado;
    }   

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int darId() {
        return id;
    }
    
    public double darValorVenta() {
        return 0;
    }
    
    public double darValorImpuestos() {
        return 0;
    }
    
    protected double darValorVentaBase() {
        return metrosCuadradosConstruidos * valorMetroCuadrado;
    } 
}
