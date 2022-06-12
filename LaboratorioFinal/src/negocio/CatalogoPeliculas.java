
package negocio;

import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;


public interface CatalogoPeliculas {
    public void agregarPelicula(String nombrePelicula, String nombreArchivo)throws EscrituraDatosEx;
    
    public void listarPeliculas(String nombreArchivo)throws LecturaDatosEx;
    
    public void buscarPelicula(String nombreArchivo,String buscar)throws LecturaDatosEx;
    
    public void iniciarArchivo(String nombreArchivo)throws EscrituraDatosEx;
}
