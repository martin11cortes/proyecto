package excepciones_inmobiliaria;

/*implemente una nueva subclase de tipo excepción que sirva para administrar el caso de error que se genera 
cuando el usuario intenta calcular los impuestos pagados, pero aún no ha realizado ninguna venta.*/

public class calcularImpuestosException extends Exception{
    
    @Override
    public String getMessage() {
        return "No es posible calcular impuestos ya que no se ha vendido ningun inmueble";
    }
    
}
