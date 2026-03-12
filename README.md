# JDBC CRUD Project with PostgreSQL (Legacy Code)

## Overview
Este proyecto demuestra cómo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) usando Java y el driver JDBC para PostgreSQL. El enfoque es legacy, sin frameworks modernos como Spring Boot, y la conexión a la base de datos se gestiona mediante clases utilitarias.

## Características
- Conexión directa a PostgreSQL usando JDBC
- Operaciones CRUD sobre la tabla `products`
- Resultados mostrados por consola
- Uso de clases utilitarias para modularidad (`ConnectionBD`, `QuerysBD`)
- Los parámetros de conexión se obtienen desde el archivo `config.properties`

## Tecnologías Utilizadas
- Java 8+
- JDBC
- PostgreSQL

## Estructura del Proyecto
```
repaso_JDBC/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/JonathanDev/Constructor.java
│   │   ├── java/com/JonathanDev/Utils/ConnectionBD.java
│   │   ├── java/com/JonathanDev/Utils/QuerysBD.java
│   │   └── resources/
│   └── test/
│       └── java/com/JonathanDev/
├── config.properties
└── README.md
```

## Arquitectura y Modularidad
- **Constructor.java:** Punto de entrada, ejecuta operaciones y muestra resultados.
- **ConnectionBD:** Clase utilitaria para obtener la conexión a la base de datos, cargando los parámetros desde `config.properties`.
- **QuerysBD:** Clase utilitaria para almacenar las consultas SQL.
- **Separación de responsabilidades:** Cada clase tiene una función clara, facilitando la extensión y el mantenimiento.

## Instrucciones de Configuración
1. **Base de Datos PostgreSQL:**
   - Asegúrate de que PostgreSQL esté ejecutándose y accesible.
   - Crea una base de datos llamada `repo_local`.
   - Crea una tabla `products` con las columnas: `id`, `name`, `price`, `date_create`.

2. **Configura la Conexión:**
   - Crea un archivo `config.properties` en la raíz del proyecto con el siguiente contenido:
     ```properties
     DB_URL=jdbc:postgresql://localhost:5432/repo_local
     DB_USER=tu_usuario
     DB_PASSWORD=tu_contraseña
     ```
   - La clase `ConnectionBD` cargará estos valores automáticamente.

3. **Compilar y Ejecutar:**
   - Compila el proyecto:
     ```bash
     mvn clean install
     ```
   - Ejecuta la aplicación:
     ```bash
     java -cp target/classes com.JonathanDev.Constructor
     ```

## Operaciones CRUD
- **Leer:** Obtiene todos los productos de la base de datos y los muestra por consola.
- **Crear/Actualizar/Eliminar:** Modifica las sentencias SQL en `QuerysBD.java` y llama los métodos correspondientes en `Constructor.java`.

### Ejemplo para modificar una consulta:
```java
// QuerysBD.java
public static final String INSERT_PRODUCT = "INSERT INTO products (name, price, date_create) VALUES ('Nuevo', 10.0, CURRENT_DATE)";
```

## Buenas Prácticas
- Usa try-with-resources para cerrar automáticamente conexiones y recursos.
- Maneja las excepciones correctamente y muestra mensajes claros.
- No almacenes credenciales sensibles en el repositorio.
- Mantén los comentarios en inglés para estandarización internacional.

## Extensión y Arquitectura
- El proyecto puede extenderse fácilmente añadiendo nuevas clases utilitarias o separando la lógica en capas (`service`, `repository`, etc.).
- Sigue la arquitectura modular para facilitar pruebas y mantenimiento.

## Licencia
Este proyecto es para fines educativos.

## Autor
JonathanDev
