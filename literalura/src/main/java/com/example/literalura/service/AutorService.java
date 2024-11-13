package com.example.literalura.service;

import com.example.literalura.dto.AutorDTO;
import com.example.literalura.models.Autores;
import com.example.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<AutorDTO> convierteDatos(List<Autores> autor){
        return autor.stream()
                .map(a->new AutorDTO(a.getNombre(),a.getAnio_nacimiento(),a.getAnio_fallecimiento()))
                .collect(Collectors.toList());
    }

    public List<AutorDTO> obtenerAutores(){
        return convierteDatos(autorRepository.findAll());
    }

    public List<AutorDTO> obtenerPorFecha(Integer fecha){
        return convierteDatos(autorRepository.findAutorPorFecha(fecha));
    }
}
