package com.example.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(@JsonAlias("name")String nombre,
                         @JsonAlias("birth_year") Integer anio_nacimiento,
                         @JsonAlias("death_year") Integer anio_fallecimiento){

}

