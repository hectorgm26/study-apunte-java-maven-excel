package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEpoca() {
        return epoca;
    }

    public void setEpoca(int epoca) {
        this.epoca = epoca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        final String multilinea = """
                             
                {
                nombre:  %s,
                epoca:  %d,
                precio:  %.2f,
                duracion:  %d,
                genero:  %s,
                empresa:  %s
                } 
                """;
        return String.format(multilinea, nombre, epoca, precio, duracion, genero, empresa);
    }
}


/*
SE CREA UNA CLASE QUE MODELARA UNA FILA DE LA TABLA COMO UN OBJETO
SE USA LA ANOTACION @ExcelSheet PARA INDICAR EL NOMBRE DE LA HOJA EXCEL QUE SE VA A LEER
PARA CADA ATRIBUTO LE INDICAMOS EL NOMBRE DE LA COLUMNA CON @ExcelCellName

SE DEBE TENER EL PATH DEL EXCEL EN LA CARPETA RESOURCES/DATA

 */
