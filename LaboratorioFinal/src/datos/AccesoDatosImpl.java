package datos;

import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                System.out.println("linea = " + linea);
                var pelicua = new Pelicula(linea);
                peliculas.add(pelicua);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        }
        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);//Crea un objeto del archivo en memoria
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//Escribe el archivo en disco
            salida.println(pelicula);//Imprime el contenido en el archivo

            salida.close();//Cierra el Archivo.
            System.out.println("Pelicula agregada exitosamente.");
        } catch (IOException x) {
            x.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al agregar la pelicula");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        int indice = 1;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                if (lectura.equalsIgnoreCase(buscar)) {
                    resultado = "Pelicula " + lectura + " encontrada en el indice " + indice;
                    return resultado;
                    
                }
                lectura = entrada.readLine();
                indice++;
            }
            resultado = "Pelicula no Disponible.";
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al buscar la pelicula");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al buscar la pelicula");
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Error al crear el archivo" + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Catalogo Eliminado");
        } else {
            System.out.println("El Catalogo no existe");
        }

    }

}
