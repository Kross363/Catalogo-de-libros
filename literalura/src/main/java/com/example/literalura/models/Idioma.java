package com.example.literalura.models;

public enum Idioma {
    ESPANIOL("es","Español"),
    INGLES("en","Ingles");
    private String idiomaApi;
    private String idiomaLibro;

    Idioma(String idiomaApi,String idiomaLibro){
        this.idiomaApi=idiomaApi;
        this.idiomaLibro=idiomaLibro;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaApi.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Idioma fromEspanol(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaLibro.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada en español: " + text);
    }
}
