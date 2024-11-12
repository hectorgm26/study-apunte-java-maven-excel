package reader;

import com.poiji.bind.Poiji;
import modelos.App;

import java.io.File;
import java.util.List;

public class ExcelReader {

    private static final String excelPath = "src/main/resources/data/dataExcel.xlsx";

    public static List<App> obtenerListaApp() {
        return Poiji.fromExcel(new File(excelPath), App.class); // lee el archivo excel y retorna una lista de la clase App
    }
}

/*
Se declara una clase ExcelReader que se encargara de leer el archivo excel
ESPECIFICAMOS COMO ATRIBUTO EL PATH DEL EXCEL
DECLARAMOS UN METODO QUE RETORNA UNA LISTA DE LA CLASE QUE MODELAMOS CON POIJI, EN ESTE CASO APP
FINALMENTE SE RETORNA LA LISTA USANDO EL METODO FROMEXCEL DE POIJI, DONDE EL PRIMER PARAMETRO ES UN FILE CON EL PATH DEL EXCEL Y EL SEGUNDO PARAMETRO ES LA CLASE QUE MODELAMOS


 */