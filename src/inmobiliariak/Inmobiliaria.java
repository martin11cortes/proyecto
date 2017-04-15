package inmobiliariak;

import excepciones_inmobiliaria.*;
import java.util.ArrayList;

public class Inmobiliaria {

    public int tCasas = 0;
    public int tOficinas = 0;
    public int tApartamentos = 0;
    public ArrayList<Inmueble> listaInmuebles;
    public ArrayList<Inmueble> listaInmueblesVendidos;
    public float totalRecaudoPorVentas;
    public float totalImpuestosPagados;
    public float ventasDespuesdeImpuestos;
    public int inmueblesVendidos;
    int count = 0;

    public Inmobiliaria() {
        listaInmuebles = new ArrayList<>();
        listaInmueblesVendidos = new ArrayList<>();
    }

    public void agregarInmueble(String strInmueble) throws inmuebleRepetidoException, parametrosFaltantesException, parqueaderoOficinaException {
        Inmueble nuevoInmueble = crearInmueble(strInmueble);
        listaInmuebles.add(nuevoInmueble);
    }

    public void mostrarInmuebles() {
        System.out.println("Listado inmuebles: " + listaInmuebles.size());
        for (Inmueble inmueble : listaInmuebles) {
            System.out.println(inmueble);
        }
    }

    public void venderInmueble(int id) {
        Inmueble inmueble = buscarInmueblePorId(id);
        totalRecaudoPorVentas += inmueble.darValorVenta();
        totalImpuestosPagados += inmueble.darValorImpuestos();
        inmueblesVendidos++;
        System.out.println("Venta inmueble: " + id);
        System.out.println(" Valor venta: " + inmueble.darValorVenta());
        System.out.println(" Impuestos pagados: " + inmueble.darValorImpuestos());
        listaInmueblesVendidos.add(inmueble);
        listaInmuebles.remove(inmueble);
        
    }

    public int darCantidadInmuebles(int type) throws tipoInmuebleException {
        int cantidad = 0;
        if (type <= 3) {
            switch (type) {
                case 1:
                    cantidad = tOficinas;
                    break;
                case 2:
                    cantidad = tCasas;
                    break;
                case 3:
                    cantidad = tApartamentos;
                    break;
            }

        } else {
            tipoInmuebleException ex = new tipoInmuebleException(type);
            throw ex;
        }
        return cantidad;
    }

    public float getTotalRecaudoPorVentas() {
        return totalRecaudoPorVentas;
    }

    public float getTotalImpuestosPagados() throws calcularImpuestosException {
        if (inmueblesVendidos == 0) {
            calcularImpuestosException exception = new calcularImpuestosException();
            throw exception;
        }
        return totalImpuestosPagados;
    }

    public float darRecaudosDespuesDeImpuestos() throws calcularImpuestosException {
        float total = (totalRecaudoPorVentas - totalImpuestosPagados);
        ventasDespuesdeImpuestos = total;
        return ventasDespuesdeImpuestos;
    }

    private Inmueble buscarInmueblePorId(int id) {
        for (int i = 0; i < listaInmuebles.size(); i++) {
            Inmueble inmueble = listaInmuebles.get(i);
            if (inmueble.darId() == id) {
                return inmueble;
            }
        }
        return null;
    }

    private Inmueble crearInmueble(String strInmueble) throws inmuebleRepetidoException, parametrosFaltantesException, parqueaderoOficinaException {
        Inmueble inmuebleNuevo = null;
        String[] datosInmueble = strInmueble.split("-");
        String tipoInmueble = datosInmueble[1];
        int id = Integer.parseInt(datosInmueble[0]);

        if (inmuebleRepetido(id)) {
            inmuebleRepetidoException exception = new inmuebleRepetidoException(id);
            throw exception;
        }

        switch (tipoInmueble) {
            case "1":
                inmuebleNuevo = crearOficia(datosInmueble);
                break;
            case "2":
                inmuebleNuevo = crearCasa(datosInmueble);
                break;
            case "3":
                inmuebleNuevo = crearApartamento(datosInmueble);
                break;
        }

        return inmuebleNuevo;

    }

    private boolean inmuebleRepetido(int identificador) {
        boolean repetido = false;
        for (int i = 0; i < listaInmuebles.size(); i++) {
            Inmueble myinmueble = listaInmuebles.get(i);
            if (identificador == myinmueble.darId()) {
                repetido = true;
            }
        }
        return repetido;
    }

    private Inmueble crearOficia(String[] datosInmueble) throws parametrosFaltantesException, parqueaderoOficinaException {
        int valor = 6;
        if (datosInmueble.length != valor) {
            parametrosFaltantesException ex = new parametrosFaltantesException(datosInmueble.length, valor);
            throw ex;
        }

        int id = Integer.parseInt(datosInmueble[0]);
        int tipo = 1;
        int metrosCuadradosConstruidos = Integer.parseInt(datosInmueble[2]);
        int estrato = Integer.parseInt(datosInmueble[3]);
        double valorMetroCuadrado = Double.parseDouble(datosInmueble[4]);
        String parking = (datosInmueble[5]);
        if ("true".equals(parking)) {
            boolean tieneParqueaderoVisitantes = Boolean.parseBoolean(datosInmueble[5]);
            Oficina oficina = new Oficina(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, tieneParqueaderoVisitantes);
            tOficinas++;
            return oficina;
        } else if ("false".equals(parking)) {
            boolean tieneParqueaderoVisitantes = Boolean.parseBoolean(datosInmueble[5]);
            Oficina oficina = new Oficina(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, tieneParqueaderoVisitantes);
            tOficinas++;
            return oficina;
        } else {
            parqueaderoOficinaException e = new parqueaderoOficinaException(parking);
            throw e;
        }
    }

    private Inmueble crearCasa(String[] datosInmueble) throws parametrosFaltantesException {
        int valor = 7;
        if (datosInmueble.length != valor) {
            parametrosFaltantesException ex = new parametrosFaltantesException(datosInmueble.length, valor);
            throw ex;
        }

        int id = Integer.parseInt(datosInmueble[0]);
        int tipo = 2;
        int metrosCuadradosConstruidos = Integer.parseInt(datosInmueble[2]);
        int estrato = Integer.parseInt(datosInmueble[3]);
        double valorMetroCuadrado = Double.parseDouble(datosInmueble[4]);
        int numeroParqueaderos = Integer.parseInt(datosInmueble[5]);
        boolean tieneVigilanciaPrivada = Boolean.parseBoolean(datosInmueble[6]);
        Casa casa = new Casa(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, numeroParqueaderos, tieneVigilanciaPrivada);
        tCasas++;
        return casa;
    }

    private Inmueble crearApartamento(String[] datosInmueble) throws parametrosFaltantesException {
        int valor = 7;
        if (datosInmueble.length != valor) {
            parametrosFaltantesException ex = new parametrosFaltantesException(datosInmueble.length, valor);
            throw ex;

        }

        int id = Integer.parseInt(datosInmueble[0]);
        int tipo = 3;
        int metrosCuadradosConstruidos = Integer.parseInt(datosInmueble[2]);
        int estrato = Integer.parseInt(datosInmueble[3]);
        double valorMetroCuadrado = Double.parseDouble(datosInmueble[4]);
        int numeroParqueaderos = Integer.parseInt(datosInmueble[5]);
        int piso = Integer.parseInt(datosInmueble[6]);
        Apartamento apartamento = new Apartamento(id, tipo, metrosCuadradosConstruidos, estrato, valorMetroCuadrado, numeroParqueaderos, piso);
        tApartamentos++;
        return apartamento;
    }

}
