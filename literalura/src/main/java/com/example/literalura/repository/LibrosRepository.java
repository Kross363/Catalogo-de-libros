package com.example.literalura.repository;

import com.example.literalura.models.Idioma;
import com.example.literalura.models.Libros;
import com.example.literalura.models.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibrosRepository extends JpaRepository<Libros,Long> {
    //@Query(value = "SELECT * FROM libros l WHERE :idioma = ANY(l.idiomas)", nativeQuery = true)
    List<Libros> findByIdiomas(String idiomas);
    List<Libros> findTop10ByOrderByDescargasDesc();
}
