package excepciones_inmobiliaria;

/*implemente una nueva subclase de tipo excepción que sirva para administrar el 
caso de error que se genera cuando el usuario intenta contar el número de inmuebles 
de un tipo, pero ingresa un número de inmueble que no soporta el programa.
 */

public class tipoInmuebleException extends Exception {
    
    private int type;

    public tipoInmuebleException(int type) {
        this.type = type;
    }
    
    @Override
    public String getMessage() {
        return "El numero " +type+ " ingresado no corresponde a un codigo valido de inmueble";
    }
}
