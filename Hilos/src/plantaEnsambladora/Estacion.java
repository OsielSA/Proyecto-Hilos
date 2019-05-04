package plantaEnsambladora;

import javax.swing.JLabel;

public class Estacion extends JLabel{
	private final String ruta = ".\\src\\plantaEnsambladora\\images\\"; 
	public Estacion(int s) {
		setIcon(Rutinas.changeSize(ruta+"car"+s+".png", 100, 80));
	}
}
