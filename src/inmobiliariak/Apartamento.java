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
public class Apartamento extends Vivienda {
    private int piso;
    
    public Apartamento(int id, 
                        int tipo,     
                        int metrosCuadradosConstruidos, 
                        int estrato, 
                        double valorMetroCuadrado, 
                        int numeroParqueaderos,
                        int piso) {
        super(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, numeroParqueaderos);
        this.piso = piso;
    }

    @Override
    public String toString(){
        return id + "-" +
                3 + "-" +
                metrosCuadradosConstruidos + "-" +
                estrato + "-" +
                valorMetroCuadrado + "-" +
                numeroParqueaderos + "-" +
                piso;
    }
    
    @Override
    public double darValorVenta(){
        double valorBase = darValorVentaBase();
        double incremento1 = valorBase * 0.025 * estrato;
        double decremento1 = valorBase * -0.015 * piso;
        double valorVenta = valorBase + incremento1 + decremento1;
        return valorVenta;
    } 
}
