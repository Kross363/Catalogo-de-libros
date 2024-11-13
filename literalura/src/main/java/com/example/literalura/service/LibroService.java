package com.example.literalura.service;

import com.example.literalura.dto.LibroDTO;
import com.example.literalura.models.Libros;
import com.example.literalura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibrosRepository librosRepository;

    public List<LibroDTO> convierteDatos(List<Libros> libro){
        return libro.stream()
                .map(l->new LibroDTO(l.getTitulo(),l.getAutor(),l.getIdiomas(),l.getDescargas()))
                .collect(Collectors.toList());
    }

    public List<LibroDTO> obtenerTodosLosLibros(){
        return convierteDatos(librosRepository.findAll());
    }
    public List<LibroDTO> obtenerPorIdioma(String idioma){
        return convierteDatos(librosRepository.findByIdiomas(idioma));
    }
    public List<LibroDTO> obtenerTop10(){
        return convierteDatos(librosRepository.findTop10ByOrderByDescargasDesc());
    }
}
