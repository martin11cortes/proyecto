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
public class Casa extends Vivienda {

    public boolean tieneVigilanciaPrivada;

    public Casa(int id,
            int tipo,
            int metrosCuadradosConstruidos,
            int estrato,
            double valorMetroCuadrado,
            int numeroParqueaderos,
            boolean tieneVigilanciaPrivada) {
        super(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, numeroParqueaderos);
        this.tieneVigilanciaPrivada = tieneVigilanciaPrivada;
    }

    @Override
    public String toString() {
        return id + "-"
                + tipo + "-"
                + metrosCuadradosConstruidos + "-"
                + estrato + "-"
                + valorMetroCuadrado + "-"
                + numeroParqueaderos + "-"
                + tieneVigilanciaPrivada;
    }

    @Override
    public double darValorVenta() {
        double valorBase = darValorVentaBase();
        double incremento1 = valorBase * 0.025 * estrato;
        double decremento1 = 0;
        if (!tieneVigilanciaPrivada) {
            decremento1 = valorBase * -0.1;
        }
        double valorVenta = valorBase + incremento1 + decremento1;
        return valorVenta;
    }
}
