package com.example.literalura.repository;

import com.example.literalura.models.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autores,Long> {
    @Query("SELECT a FROM Autores a WHERE a.anio_nacimiento <= :fechaAutor AND (a.anio_fallecimiento IS NULL OR a.anio_fallecimiento > :fechaAutor) ORDER BY a.anio_nacimiento ASC")
    List<Autores> findAutorPorFecha(Integer fechaAutor);
}
