/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones_inmobiliaria;

public class parqueaderoOficinaException extends Exception{
    
    private String parking;

    

    public parqueaderoOficinaException(String parking) {
        this.parking = parking;
    }

    @Override
    public String getMessage() {
        return "Ha ingresado incorrectamente el parametro parqueadero, debe ingresar (true o false), ingreso: " + parking;
    }

}
