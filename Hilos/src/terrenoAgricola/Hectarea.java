package terrenoAgricola;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import terrenoAgricolaE.Semaforo;


public class Hectarea extends JLabel{
	private final Color malaC = new Color(237, 96, 0);
	private final Color buenaC = new Color(159, 87, 37);
	private final Color extelenteC = new Color(82, 42, 14);
	private final String ruta = ".\\src\\terrenoAgricola\\images\\"; 
	
	private int calidad;
	private boolean ocupada;
	private Semaforo semaforo;
	private int hermano;
	
	public Hectarea(int calidad) {
		this.calidad = calidad;
		this.semaforo = new Semaforo(1);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ponColor();	
	}
	private void ponColor() {
		setOpaque(true);
		switch(calidad) {
		case 1:
			setBackground(malaC);
			break;
		case 2:
			setBackground(buenaC);
			break;
		case 3:
			setBackground(extelenteC);
			break;
		}
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setHermano(int hermano) {
		setIcon(Rutinas.changeSize(ruta+"hermano"+hermano+".png", 50, 50));
//		setIcon(Rutinas.changeSize(ruta+"hermano"+3+".png", 50, 50));
		ocupada = true;
		this.hermano = hermano;
	}
	public int getHermano() {
		return hermano;
	}
	public Semaforo getSemaforo() {
		return semaforo;
	}
	
}
