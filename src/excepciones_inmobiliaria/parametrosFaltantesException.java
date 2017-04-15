package excepciones_inmobiliaria;

/*implemente una nueva excepción que se encargue de manejar el error que se genera cuando un usuario 
ingresa los datos para crear un inmueble, pero ingresa el numero incorrecto de parámetros.*/

public class parametrosFaltantesException extends Exception {

    private int length, valor;
    
    public parametrosFaltantesException(int length, int valor) {
        this.length = length;
        this.valor = valor;
    }

    @Override
    public String getMessage() {
        return "Ha ingresado la cantidad incorrecta de parametros para crear el inmueble, necesarios: " + valor + " ingresados: " + length;
    }
}
