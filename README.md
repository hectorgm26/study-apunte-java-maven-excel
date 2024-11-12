# Proyecto Lector de Archivos Excel con Poiji

Un proyecto Java que utiliza la biblioteca **Poiji** para leer archivos Excel y convertir sus datos en objetos Java. En esta implementación, el archivo Excel contiene información de videojuegos que se mapea a una clase Java `App`.

## Requisitos Previos

- Java 17 o superior
- Maven 3.x o superior
- Archivo Excel ubicado en `src/main/resources/data/dataExcel.xlsx`

## Configuración del Proyecto

### Dependencia Maven

Agrega la siguiente dependencia a tu `pom.xml`:

```xml
<dependency>
    <groupId>com.github.ozlerhakan</groupId>
    <artifactId>poiji</artifactId>
    <version>4.6.0</version>
</dependency>
```

### Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   ├── modelos/
│   │   │   └── App.java
│   │   ├── parser/
│   │   │   └── AppParser.java
│   │   ├── reader/
│   │   │   └── ExcelReader.java
│   │   └── principal/
│   │       └── Main.java
│   └── resources/
│       └── data/
│           └── dataExcel.xlsx
```

## Detalles de Implementación

### Clase App (paquete modelos)

La clase `App` representa la información de videojuegos con anotaciones Poiji:

```java
@ExcelSheet("videojuegos")
public class App {
    @ExcelCellName("NOMBRE")
    private String nombre;

    @ExcelCellName("EPOCA")
    private int epoca;

    @ExcelCellName("PRECIO")
    private double precio;

    @ExcelCellName("DURACION")
    private int duracion;

    @ExcelCellName("GENERO")
    private String genero;

    @ExcelCellName("EMPRESA")
    private String empresa;

    // Getters, setters e implementación toString
}
```

### Clase ExcelReader (paquete reader)

```java
public class ExcelReader {
    private static final String excelPath = "src/main/resources/data/dataExcel.xlsx";

    public static List<App> obtenerListaApp() {
        return Poiji.fromExcel(new File(excelPath), App.class);
    }
}
```

### Clase AppParser (paquete parser)

Proporciona métodos para convertir la lista de objetos `App` en arreglos o mapas:

```java
public class AppParser {
    public static App[] getArrayApp() {
        final List<App> listaApp = ExcelReader.obtenerListaApp();
        return listaApp.toArray(new App[0]);
    }

    public static Map<String, App> getAppMap() {
        return ExcelReader.obtenerListaApp().stream()
            .collect(Collectors.toMap(App::getNombre, app -> app));
    }
}
```

### Estructura del Archivo Excel

El archivo Excel debe contener las siguientes columnas:

| Columna   | Descripción        | Tipo    |
|-----------|-------------------|---------|
| NOMBRE    | Nombre del juego   | String  |
| EPOCA     | Año de lanzamiento | Integer |
| PRECIO    | Precio            | Double  |
| DURACION  | Duración (horas)   | Integer |
| GENERO    | Género            | String  |
| EMPRESA   | Empresa           | String  |

## Ejecutando el Proyecto

1. Coloca tu archivo Excel en `src/main/resources/data/dataExcel.xlsx`
2. Compila y ejecuta el proyecto usando Maven:

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn exec:java
```

## Características

- Lectura de archivos Excel usando anotaciones Poiji
- Conversión de datos a arreglos y mapas
- Funcionalidad de ordenamiento basada en la duración del juego
- Búsqueda de juegos por nombre
- Implementación personalizada de toString para mejor visualización de datos

## Funcionalidades Principales

El proyecto permite:
- Leer datos de videojuegos desde Excel
- Convertir datos a diferentes estructuras (Lista, Array, Map)
- Ordenar juegos por duración
- Buscar juegos por nombre
- Visualizar datos en formato legible

## Contribuir

Si tienes mejoras o sugerencias, no dudes en abrir un issue o enviar un pull request.

## Licencia

Este proyecto es de código abierto y está disponible bajo la Licencia MIT.

