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
public abstract class Vivienda extends Inmueble{
    public int numeroParqueaderos;
    
    public Vivienda(int id, 
                    int tipo,
                    int metrosCuadradosConstruidos,
                    int estrato,
                    double valorMetroCuadrado,
                    int numeroParqueaderos){
        super(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado);    
        this.numeroParqueaderos = numeroParqueaderos;
    }
    
    @Override
    public double darValorImpuestos() {
        return darValorVenta() * 0.05;
    }
}
