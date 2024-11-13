package com.example.literalura.controller;

import com.example.literalura.dto.LibroDTO;
import com.example.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService servicio;
    @GetMapping()//http://localhost:8080/libros
    public List<LibroDTO> obtenerLibros(){
        return servicio.obtenerTodosLosLibros();
    }
    @GetMapping("/top10")//http://localhost:8080/libros/top10
    public List<LibroDTO> obtenerTop10(){
        return servicio.obtenerTop10();
    }
    @GetMapping("/idioma/{idioma}")//http://localhost:8080/libros/idioma/{idioma} es o en
    public List<LibroDTO> obtenerIdioma(@PathVariable String idioma){
        return servicio.obtenerPorIdioma(idioma);
    }
}
