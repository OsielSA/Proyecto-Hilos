package terrenoAgricolaE;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Hermano extends Thread{
	private  List<Hectarea> field;
	private Color color;
	
	public Hermano(List<Hectarea> field,Color color) {
		this.field = field;
		this.color = color;
	}
	
	@Override
	public void run() {
		while(!fieldFull()) {
			
			int noHectarea = Rutinas.nextInt(0,99);
			Hectarea hectarea = field.get(noHectarea);
			hectarea.getSemaphore().Espera();
			if(hectarea.isOcuped()) {
				hectarea.getSemaphore().Libera();
				continue;
			}
			hectarea.setOcuped(true);
			hectarea.getSemaphore().Libera();
			hectarea.setBackground(color);
		}
	}
	
	public boolean fieldFull() {
		for(Hectarea h: field) {
			if(!h.isOcuped())
				return false;
		}
		return true;
			
	}
}
