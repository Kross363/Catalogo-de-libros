package com.example.literalura.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name="libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(unique = true)
    private String autor;
    private String titulo;
    private String idiomas;
    private Double descargas;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Autores> autores;

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        autores.forEach(a->a.setLibro(this));//CON ESTO HACEMOS QUE LOS AUTORES SE RELACIONEN CON EL LIBRO, ES DECIR, QUE TENGAN EL MISMO ID PARA LA BASE DE DATOS
        this.autores = autores;
    }


    //CONSTRUCTOR PREDETERMINADO
    public Libros(){}

    //CONSTRUCTOR PERSONALIZADO

    public Libros( DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idiomas = datosLibros.idiomas().get(0);
        this.descargas = datosLibros.descargas();
        this.autor=datosLibros.autor().get(0).nombre();
    }

    public Libros(List<DatosLibros> libros) {
    }

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", descargas=" + descargas +
                '}';
    }

    //GETTERS Y SETTERS


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas=idiomas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
}
