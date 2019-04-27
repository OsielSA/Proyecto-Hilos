package terrenoAgricolaE;

import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class Hectarea extends JLabel{
	private boolean isOcuped;
	private Semaforo semaphore;
	
	public Hectarea(String txt) {
		super(txt);
		this.isOcuped = false;
		this.semaphore = new Semaforo(1);
	}

	public boolean isOcuped() {
		return isOcuped;
	}

	public void setOcuped(boolean isOcuped) {
		this.isOcuped = isOcuped;
	}

	public Semaforo getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaforo semaphore) {
		this.semaphore = semaphore;
	}
	
}
