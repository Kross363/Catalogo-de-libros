package com.example.literalura.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "autores")
public class Autores {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private int anio_nacimiento;
    private int anio_fallecimiento;
    @ManyToOne
    private Libros libro;

    public Autores(){}

    public Autores(DatosAutor autor) {
        this.nombre=autor.nombre();
        this.anio_nacimiento=autor.anio_nacimiento();
        this.anio_fallecimiento= autor.anio_fallecimiento();
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio_fallecimiento() {
        return anio_fallecimiento;
    }

    public void setAnio_fallecimiento(int anio_fallecimiento) {
        this.anio_fallecimiento = anio_fallecimiento;
    }

    public int getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(int anio_naciomiento) {
        this.anio_nacimiento = anio_naciomiento;
    }

    @Override
    public String toString() {
        return "Autores{" +
                ", anio_fallecimiento=" + anio_fallecimiento +
                ", anio_nacimiento=" + anio_nacimiento +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
