package com.example.literalura.controller;

import com.example.literalura.dto.AutorDTO;
import com.example.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService servicio;
    @GetMapping()//http://localhost:8080/autor
    public List<AutorDTO> obtenerAutores(){
        return servicio.obtenerAutores();
    }
    @GetMapping("/vivo/{fecha}")//http://localhost:8080/autor/vivo/{fecha}
    public List<AutorDTO> obtenerPorFecha(@PathVariable Integer fecha){
        return servicio.obtenerPorFecha(fecha);
    }
}
