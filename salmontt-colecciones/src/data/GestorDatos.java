package data;

import model.CentroCultivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase encargada de gestionar la carga de datos desde un archivo externo
 * y transformarlos en objetos CentroCultivo almacenados en una colección dinámica.
 */
public class GestorDatos {

    // Lista donde se almacenan todos los centros de cultivo cargados desde el archivo
    private final List<CentroCultivo> centros = new ArrayList<>();

    /**
     * Retorna una vista de solo lectura de la lista de centros cargados.
     * Esto evita que se modifique la colección desde fuera de esta clase.
     */
    public List<CentroCultivo> getCentros() {
        return Collections.unmodifiableList(centros);
    }

    //Carga los datos desde un archivo ubicado en la carpeta "resources"
    public void cargarDesdeArchivo(String nombreRecurso) {
        centros.clear(); // Limpia la lista antes de cargar nuevos datos

        // Construcción de la ruta relativa hacia el archivo dentro de resources
        String ruta = "resources/" + nombreRecurso;

        // Se utiliza BufferedReader para leer el archivo línea por línea
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(ruta),
                        StandardCharsets.UTF_8))) {

            String linea;

            // Procesa cada línea hasta que no queden más
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Si la línea está vacía, se omite
                if (linea.isEmpty()) continue;

                // Divide la línea en 3 partes usando ";" como separador
                String[] partes = linea.split(";");

                // Validación: la línea debe tener exactamente 3 campos
                if (partes.length != 3) continue;

                // Conversión del tercer campo (producción) a número
                double toneladas = Double.parseDouble(partes[2]);

                // Se crea un nuevo objeto CentroCultivo y se agrega a la lista
                centros.add(new CentroCultivo(partes[0], partes[1], toneladas));
            }

        } catch (IOException e) {
            // Si ocurre un error de lectura, se lanza una excepción más clara
            throw new RuntimeException("Error leyendo archivo: " + ruta, e);
        }
    }

    //Filtra los centros de cultivo cuya producción supere una cantidad mínima
    public List<CentroCultivo> filtrarPorProduccionMinima(double produccionMinima) {
        List<CentroCultivo> r = new ArrayList<>();

        // Recorre la lista completa y agrega solo los que cumplen el filtro
        for (CentroCultivo c : centros) {
            if (c.getToneladasProducidas() > produccionMinima) {
                r.add(c);
            }
        }

        return r;
    }
}
