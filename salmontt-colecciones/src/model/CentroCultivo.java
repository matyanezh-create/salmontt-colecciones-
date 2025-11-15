package model;

 //Contiene información básica como el nombre del centro, la comuna donde se ubica y la cantidad de toneladas producidas
public class CentroCultivo {

    // Nombre del centro de cultivo
    private String nombreCentro;

    // Comuna en la que se encuentra el centro
    private String comuna;

    // Total de toneladas producidas por el centro
    private double toneladasProducidas;

     //Constructor vacío que permite crear un objeto sin valores iniciales
    public CentroCultivo() {}

     //Constructor con parámetros, permite inicializar el objeto con valores completo
    public CentroCultivo(String nombreCentro, String comuna, double toneladasProducidas) {
        this.nombreCentro = nombreCentro;
        this.comuna = comuna;
        this.toneladasProducidas = toneladasProducidas;
    }

    // Getter y setter para nombreCentro
    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    // Getter y setter para comuna
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    // Getter y setter para toneladasProducidas
    public double getToneladasProducidas() {
        return toneladasProducidas;
    }

    public void setToneladasProducidas(double toneladasProducidas) {
        this.toneladasProducidas = toneladasProducidas;
    }

     //Devuelve los valores de los atributos en un formato claro y legible
    @Override
    public String toString() {
        return "CentroCultivo{" +
                "nombreCentro='" + nombreCentro + '\'' +
                ", comuna='" + comuna + '\'' +
                ", toneladasProducidas=" + toneladasProducidas +
                '}';
    }
}
