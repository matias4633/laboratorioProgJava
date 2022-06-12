package negocio;

import datos.*;
import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    public CatalogoPeliculasImpl() {

    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx {
        AccesoDatos acceso = new AccesoDatosImpl();
        Pelicula pelicula = new Pelicula(nombrePelicula);
        acceso.escribir(pelicula, nombreArchivo, true);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) throws LecturaDatosEx {
        AccesoDatos acceso = new AccesoDatosImpl();
        acceso.listar(nombreArchivo);
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) throws LecturaDatosEx {
        AccesoDatos acceso = new AccesoDatosImpl();
        System.out.println(acceso.buscar(nombreArchivo, buscar));

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws EscrituraDatosEx {
        AccesoDatos acceso = new AccesoDatosImpl();

        try {
            acceso.crear(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al crear el archivo" + ex.getMessage());
        }
    }
}
