package cpjlaboratoriofinal;

import excepciones.*;
import java.util.Scanner;
import negocio.*;

public class CPJLaboratorioFinal {

    public static void main(String[] args) throws AccesoDatosEx {
        Scanner entrada = new Scanner(System.in);
        int opcion = 10;
        String nombreArchivo = "default.txt";
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        catalogo.iniciarArchivo(nombreArchivo);//Inicio el catalogo default

        while (opcion != 0) {
            System.out.println("Que accion desea realizar?: ");
            System.out.println("\t 1-Iniciar catalogo de peliculas");
            System.out.println("\t 2-Agregar una pelicula.");
            System.out.println("\t 3-Listar todas las peliculas.");
            System.out.println("\t 4-Buscar una pelicula");
            System.out.println("\t 0-Salir.");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Programa terminado.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
                case 1: {
                    System.out.println("Ingrese el nombre del catalogo: ");
                    nombreArchivo = entrada.nextLine() + ".txt";

                    catalogo.iniciarArchivo(nombreArchivo);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Introduce el nombre de la pelicula agregar");
                    String nombre = entrada.nextLine();
                    System.out.println("A cual catalogo desea agregarlo?");
                    String catalogoAgregar = entrada.nextLine();
                    catalogo.agregarPelicula(nombre, catalogoAgregar);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
                }
                case 3: {

                    System.out.println("Ingrese el catalogo que desea listar");
                    nombreArchivo = entrada.nextLine();
                    System.out.println("Listado de pelicuas:");
                    catalogo.listarPeliculas(nombreArchivo);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Cual pelicula desea buscar: ");
                    var nombre = entrada.nextLine();
                    System.out.println("En cual catalogo desea buscarlo?");
                    String catalogoBuscar = entrada.nextLine();
                    catalogo.buscarPelicula(catalogoBuscar, nombre);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                    break;
                }

            }
        }

    }

}
