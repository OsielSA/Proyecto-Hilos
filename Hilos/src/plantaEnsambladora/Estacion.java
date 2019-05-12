package plantaEnsambladora;

import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Estacion extends JLabel{
	private final String ruta = ".\\src\\plantaEnsambladora\\images\\"; 
	private int parada;
	
	public Estacion(int numEstacion, int tiempo, int pos) {
		super("Estación "+numEstacion);

		setBorder(new LineBorder(Color.BLUE));
		setIcon(Rutinas.changeSize(ruta+"robot.png", 50, 45));
	}
	public void setParada(int parada) {
		this.parada = parada;
	}
	public int getParada() {
		return parada;
	}
}
