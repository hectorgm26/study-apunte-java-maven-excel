package parser;

import modelos.App;
import reader.ExcelReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppParser {
    public static App[] getArrayApp() {

        final List<App> listaApp = ExcelReader.obtenerListaApp();
        final int n = listaApp.size();

        final App[] arrayApp = new App[n];

        for (var i = 0; i < n; i++) {
            arrayApp[i] = listaApp.get(i);
        }
        return arrayApp;
    }

    public static Map<String, App> getAppMap() {
        final Map<String, App> appMap = new HashMap<String, App>();

        final List<App> listaApp = ExcelReader.obtenerListaApp();

        for (App app : listaApp) {
            appMap.put(app.getNombre(), app); // se guarda el nombre del juego como key y el objeto App como value
        }
        return appMap;
    }
}

/*
PODEMOS CONVERTIR LA LISTA LEIDA DE POIJI EN UN ARRAY O EN UN MAP
IMPORTANTE QUE UN ARRAY ES MAS FACIL DE ORDENAR QUE UNA LISTA


 */