package principal;

import modelos.App;
import parser.AppParser;
import reader.ExcelReader;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final List<App> listaApp = ExcelReader.obtenerListaApp();
        System.out.printf("El primer elemento es: %s%n", listaApp.get(0));

        final App[] arrayApp = AppParser.getArrayApp();

        ordenarArrayApp(arrayApp);
        System.out.printf("El juego con mayor duracion es: %s%n", arrayApp[0]);

        // MAP
        final Map<String, App> appMap = AppParser.getAppMap();
        final App app = appMap.get("HOGWARTS LEGACY");
        System.out.printf("La informacion de HOGWARTS LEGACY es: %s%n", app);

    }

    private static void ordenarArrayApp(App[] arrayApp) {
        final int n = arrayApp.length;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n - i - 1; j++) {
                if (arrayApp[j].getDuracion() < arrayApp[j + 1].getDuracion()) {
                    App temp = arrayApp[j];
                    arrayApp[j] = arrayApp[j + 1];
                    arrayApp[j + 1] = temp;
                }
            }
        }
    }
}
