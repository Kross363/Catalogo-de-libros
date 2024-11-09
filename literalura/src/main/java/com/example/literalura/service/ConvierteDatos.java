package com.example.literalura.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        if (json == null || json.trim().isEmpty()) {
            throw new RuntimeException("La fuente de datos está vacía");
        }
        try {
            return objectMapper.readValue(json.toString(),clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
