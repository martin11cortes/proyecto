/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliariak;

import excepciones_inmobiliaria.*;
import java.util.Scanner;
import java.util.logging.*;

/**
 *
 * @author felipe
 */
public class MenuInmobiliariaK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuInmobiliariaK menu = new MenuInmobiliariaK();
        menu.desplegarMenu();
    }

    private Inmobiliaria inmobiliaria;

    public MenuInmobiliariaK() {
        inmobiliaria = new Inmobiliaria();
    }

    private void desplegarMenu() {
        System.out.println("--- Inmoviliaria Konrad Menu ---");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Agregar inmueble.");
        System.out.println("2. Mostrar inmuebles disponibles.");
        System.out.println("3. Vender Inmueble.");
        System.out.println("4. Dar total recaudado por ventas netas.");
        System.out.println("5. Dar impuestos pagados.");
        System.out.println("6. Dar total recaudes despues de impuestos.");
        System.out.println("7. Dar cantidad de inmbuebles disponibles");
        System.out.println("8. Salir.");
        Scanner scanner = new Scanner(System.in);
        String opcionSeleccionada = scanner.nextLine();
        switch (opcionSeleccionada) {
            case "1":///Como hacer cuando en una misma opcion necesito dos casos de error
                try {
                    agregarInmueble();
                } catch (inmuebleRepetidoException ex) {
                    System.out.println(ex.getMessage());
                } catch (parametrosFaltantesException e) {
                    System.out.println(e.getMessage());
                } catch (parqueaderoOficinaException e){
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                mostrarInmueblesDisponibles();
                break;
            case "3":
                venderInmueble();
                break;
            case "4":
                darRecaudoNeto();
                break;
            case "5":
                try {
                    darImpuestosPagados();
                } catch (calcularImpuestosException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "6":
                try {
                    darRecaudosDespuesDeImpuestos();
                } catch (calcularImpuestosException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "7"://////En donde lo debo atrapar?
                System.out.println("Ingrese el tipo de inmueble que desea consultar: ");
                int tipo = Integer.parseInt(scanner.next());
                try {
                    System.out.println("La cantidad de inmuebles disponibles es: " + inmobiliaria.darCantidadInmuebles(tipo));
                } catch (tipoInmuebleException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("");
                break;
            case "8":
                System.exit(0);
                break;
        }
        desplegarMenu();

    }

    private void agregarInmueble() throws inmuebleRepetidoException, parametrosFaltantesException, parqueaderoOficinaException{
        System.out.println("Ingrese los datos del inmueble.");
        Scanner scanner = new Scanner(System.in);
        String strInmueble = scanner.nextLine();
        inmobiliaria.agregarInmueble(strInmueble);
    }

    private void mostrarInmueblesDisponibles() {
        inmobiliaria.mostrarInmuebles();
    }

    private void venderInmueble() {
        System.out.println("Ingrese el identificador del inmueble.");
        Scanner scanner = new Scanner(System.in);
        String strId = scanner.nextLine();
        int id = Integer.parseInt(strId);
        inmobiliaria.venderInmueble(id);
    }

    private void darRecaudoNeto() {
        System.out.println("Total ingresos por ventas: " + inmobiliaria.getTotalRecaudoPorVentas());
    }

    private void darImpuestosPagados() throws calcularImpuestosException {
        double impuestosPagados = 0;
        impuestosPagados = inmobiliaria.getTotalImpuestosPagados();
        System.out.println("Total impuestos pagados: " + impuestosPagados);
    }

    private void darRecaudosDespuesDeImpuestos() throws calcularImpuestosException {
        System.out.println("Total recaudo despues de impuestos: " + inmobiliaria.darRecaudosDespuesDeImpuestos());
    }
}
