package Filosofos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Tenedor extends JLabel{
	private int id;
	private boolean status;
	private Semaforo sem;
	private final String ruta = ".\\src\\Filosofos\\images\\"; 
	public Tenedor(int id) {
		this.id = id;
		status = false;
		sem = new Semaforo(1);
	}
	
	public void tomaTenedorAmc() {
		setBounds(getX(), getY(), 130, 120);
		setIcon(Rutinas.changeSize(ruta+"tenedor"+(id+1)+".png", 130, 120));
//		update(getGraphics());
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void sueltaTenedorAmc() {
		setBounds(getX(),getY(), 90, 80);
		setIcon(Rutinas.changeSize(ruta+"tenedor"+(id+1)+".png", 90, 80));
//		update(getGraphics());
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Semaforo getSem() {
		return sem;
	}

	public void setSem(Semaforo sem) {
		this.sem = sem;
	}
}
