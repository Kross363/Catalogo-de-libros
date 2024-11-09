package com.example.literalura.principal;

import com.example.literalura.models.*;
import com.example.literalura.repository.AutorRepository;
import com.example.literalura.repository.LibrosRepository;
import com.example.literalura.service.ConsumoAPI;
import com.example.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository librosRepository;
    private AutorRepository autorRepository;
    private List<DatosLibros> datosLibros=new ArrayList<>();
    private List<Libros> libros;
    private List<Autores> autores;
    private Optional<Libros> libroBuscado;
    private final String URL_BASE="https://gutendex.com/books/?search=";

    public Principal(LibrosRepository librosRepository, AutorRepository autorRepository) {
        this.librosRepository=librosRepository;
        this.autorRepository=autorRepository;
    }
    public void muestraMenu(){
        var opcion=-1;
        while (opcion!=0){
            var menu= """
                    Elija la opcion a traves del numero que ingrese
                    1 - Buscar libro por titulo en la api
                    2 - Mostrar libros registrados
                    3 - Mostrar autores registrados
                    4 - Mostrar autores vivos por un determinado año
                    5 - Mostrar libros por idioma
                    6-  Mostrar top 10 libros mas descargados

                    0 - Salir
                   \s""";
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion){
                case 1:
                    buscarLibros();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    mostrarAutoresAnioVivo();
                    break;
                case 5:
                    mostrarLibrosPorIdioma();
                    break;
                case 6:
                    mostrarTop10Libros();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private Datos getDatosLibros(){
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine().toLowerCase().replace(" ","%20");
        var json = consumoApi.obtenerDatos(URL_BASE+nombreLibro);
        System.out.println(json);
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        return datos;
    }

    private void buscarLibros() {
        Datos datos=getDatosLibros();
        Libros libro=new Libros(datos.libros().get(0));//OBTIENE EL PRIMER LIBRO QUE SE LE ENCUENTRA
        Autores autor=new Autores(datos.libros().get(0).autor().get(0));//OBTIENE EL PRIMER AUTOR QUE ENCUENTRA
        librosRepository.save(libro);
        autorRepository.save(autor);
        //libro.setAutores(autor);
        System.out.println(libro.toString());
        System.out.println(autor.toString());
    }

    private void mostrarLibros() {
        libros=librosRepository.findAll();
        libros.stream()
                .forEach(l -> {
                    System.out.println("""
                        Titulo: %s
                        Autor: %s
                        Idioma: %s
                        Cantidad de descargas: %s
                    ]
                    """.formatted(l.getTitulo(),
                            l.getAutor(),
                            l.getIdiomas(),
                            l.getDescargas().toString()));
                });
    }

    private void mostrarAutores() {
        autores=autorRepository.findAll();
        autores.stream()
                .forEach(a -> {
                    System.out.println("""
                        Autor: %s
                        Fecha de Nacimiento: %s
                        Fecha de Fallecimiento: %s
                    ]
                    """.formatted(a.getNombre(),
                            a.getAnio_nacimiento(),
                            a.getAnio_fallecimiento()));
                });
    }

    private void mostrarAutoresAnioVivo() {
        System.out.println("Ingrese el año en que estuvo vivo el autor");
        var fechaAutor=teclado.nextInt();
        List<Autores> autoresVivoFecha=autorRepository.findAutorPorFecha(fechaAutor);
        System.out.println("Los autores que estuvieron vivos en "+fechaAutor+" son:");
        autoresVivoFecha.forEach(System.out::println);
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("""
                        Escriba alguno de estos idiomas para mostar los libros por idioma
                        Escriba es para libros en español
                        Escriba en para libros en ingles
                        """);
        var idiomaIngresado=teclado.nextLine();
        List<Libros> librosIdiomas=librosRepository.findByIdiomas(idiomaIngresado);
        System.out.println("Los libros que se encontrar por el idioma son "+idiomaIngresado);
        librosIdiomas.forEach(System.out::println);
    }

    private void mostrarTop10Libros() {
        List<Libros> librosDescargas=librosRepository.findTop10ByOrderByDescargasDesc();
        librosDescargas.forEach(l-> System.out.println("Titulo: "+l.getTitulo()+", Cantidad de descargas: "+l.getDescargas()));
    }
}
