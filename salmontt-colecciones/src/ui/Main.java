package ui;

import data.GestorDatos;
import model.CentroCultivo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Crea una instancia del gestor encargado de leer el archivo
        GestorDatos gestor = new GestorDatos();

        // Carga los datos desde el archivo centros.txt ubicado en la carpeta resources
        gestor.cargarDesdeArchivo("centros.txt");

        // Muestra todos los centros cargados desde el archivo
        System.out.println("===== TODOS LOS CENTROS =====");
        for (CentroCultivo c : gestor.getCentros()) {
            System.out.println(c);
        }

        // Define un umbral para filtrar centros según su producción
        double umbral = 1000.0;

        // Obtiene los centros cuya producción supera el umbral definido
        List<CentroCultivo> filtrados = gestor.filtrarPorProduccionMinima(umbral);

        // Muestra solo los centros filtrados según la condición
        System.out.println("\n===== CENTROS CON PRODUCCIÓN > " + umbral + " =====");
        for (CentroCultivo c : filtrados) {
            System.out.println(c);
        }
    }
}
