package plantaEnsambladora;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Estacion extends JLabel {

    private final String ruta = ".\\src\\plantaEnsambladora\\i mages\\";
    private final int tiempo[] = {2000, 600, 1000, 500, 500, 1000};
    private int numEstacion;

    public Estacion(int numEstacion, int tiempo) {
        this.numEstacion = numEstacion;
    }

    public int getTiempo() {
        return tiempo[numEstacion];
    }
}
