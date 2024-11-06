Catálogo de Libros
Este proyecto es un catálogo de libros desarrollado en Java con el framework Spring, que permite consultar y gestionar información de libros y autores. La aplicación se integra con la API Gutendex para buscar libros y utiliza JPA para realizar consultas en la base de datos.

Características
Búsqueda de libros en la API Gutendex.
Mostrar libros almacenados en la base de datos.
Mostrar autores de los libros obtenidos en la API.
Mostrar autores vivos en un año determinado.
Filtrar libros por idioma.
Top 10 de libros más descargados.

Estructura del Proyecto
Java y Spring Framework: El proyecto está desarrollado en Java, utilizando Spring para la gestión de dependencias, controladores y servicios.
Integración JSON con Gson: Gson permite la serialización y deserialización de datos JSON obtenidos de la API Gutendex.
API Gutendex: Se utiliza la API Gutendex para obtener información sobre libros y autores.
Consultas en JPA: JPA facilita la persistencia y recuperación de datos en la base de datos con consultas personalizadas para distintos criterios de búsqueda.

Uso

Ejemplos de Uso de Funcionalidades
Búsqueda de Libros en la API Gutendex: La aplicación permite buscar libros directamente en la API de Gutendex y mostrar resultados detallados.

Mostrar Libros Guardados: Consulta y muestra todos los libros almacenados en la base de datos.

Mostrar Autores Vivos en un Año Determinado: Para encontrar autores que estaban vivos en un año específico, utiliza una consulta personalizada en el repositorio JPA.

Filtrar Libros por Idioma: Listado de libros en la base de datos según el idioma especificado.

Top 10 Libros Más Descargados: Consulta para obtener los libros con mayor número de descargas.

Integración JSON con Gson
Para manejar la respuesta de la API Gutendex en formato JSON, se utiliza Gson para convertir entre JSON y objetos Java.

Licencia
Este proyecto está bajo la licencia MIT.

Agradecimientos especiales a la API Gutendex por proporcionar el acceso a su contenido.
