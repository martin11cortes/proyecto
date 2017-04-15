package excepciones_inmobiliaria;

/*Error cuando el usuario ingresa un mismo inmueble dos veces*/
public class inmuebleRepetidoException extends Exception {

    private int id;

    public inmuebleRepetidoException(int id) {
        this.id = id;

    }

    @Override
    public String getMessage() {
        return "El inmueble con el id: " + id + ", ya se encuentra registrado";
    }

}
