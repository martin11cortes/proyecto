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
public class Oficina extends Inmueble{
    public boolean tieneParqueaderoVisitantes;
    
    public Oficina(int id, 
                    int tipo,
                    int metrosCuadradosConstruidos, 
                    int estrato, 
                    double valorMetroCuadrado,
                    boolean tieneParqueaderoVisitantes) {
        super(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado);
        this.tieneParqueaderoVisitantes = tieneParqueaderoVisitantes;
    }
    
    @Override
    public String toString(){
        return id + "-" +
                tipo + "-" +
                metrosCuadradosConstruidos + "-" +
                estrato + "-" +
                valorMetroCuadrado + "-" +
                tieneParqueaderoVisitantes;
    }
    
    @Override
    public double darValorVenta(){
        double valorBase = darValorVentaBase();
        
        double incremento1 = valorBase * 0.05 * estrato;
        double incremento2 = valorBase * -0.1;
        if (tieneParqueaderoVisitantes)    
            incremento2 = valorBase * 0.2;
        double valorVenta = valorBase + incremento1 + incremento2;
        return valorVenta;
    } 
    
    @Override
    public double darValorImpuestos() {
        if (metrosCuadradosConstruidos > 100)
            return darValorVenta() * 0.07;
        
        return 0;
    }
}
