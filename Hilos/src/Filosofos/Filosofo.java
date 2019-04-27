package Filosofos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Filosofo extends Thread{
	private int id;
	private Tenedor teneIzq,teneDer;
	public JLabel accion;
	public Filosofo(int id, Tenedor teneIzd, Tenedor teneDer) {
		this.id=id;
		this.teneIzq=teneIzd;
		this.teneDer=teneDer;
		accion = new JLabel();
	}
	private void comer(boolean status) {
		if(status) {
			accion.setText("Comiendo");
			SwingUtilities.updateComponentTreeUI(accion);
			return;
		}
		accion.setText("");
		SwingUtilities.updateComponentTreeUI(accion);
	}
//	@Override
//	public void run() {
//		boolean waitForDer = false;
//		while(true) {
//			if(teneIzq.getStatus() && !waitForDer ) {
//				continue;
//			}
//			teneIzq.getSem().Espera();
//			teneIzq.setStatus(true);
//			teneIzq.getSem().Libera();
//			waitForDer = true;
//			teneIzq.tomaTenedorAmc();
//			
//			if(teneDer.getStatus()) {
////				teneIzq.sueltaTenedorAmc();
//				teneIzq.setStatus(false);
//				continue;
//			}
//			teneDer.getSem().Espera();
//			teneDer.setStatus(true);
//			teneDer.getSem().Libera();
//			teneDer.tomaTenedorAmc();
//			comer(true);
//			try {
//				System.out.println(this.getId());
//				sleep(5000);
//			}catch(Exception e) {}
//			teneIzq.setStatus(false);
//			teneDer.setStatus(false);
//			teneIzq.sueltaTenedorAmc();
//			teneDer.sueltaTenedorAmc();
//			comer(false);
////			return;
//		}
//	}
	@Override
	public void run() {
		while(true) {
			if(teneIzq.getStatus() && teneDer.getStatus()) {
				continue;
			}
			//toma los tenedore
			teneIzq.getSem().Espera();
			teneIzq.setStatus(true);
			teneDer.getSem().Espera();
			teneDer.setStatus(true);
//			teneIzq.getSem().Libera();
			teneIzq.tomaTenedorAmc();
			teneDer.tomaTenedorAmc();
			
			comer(true);
			try {
				System.out.println(this.getId());
				sleep(5000);
			}catch(Exception e) {}
			
			teneIzq.setStatus(false);
			teneDer.setStatus(false);
			teneIzq.getSem().Libera();
			teneDer.getSem().Libera();
			teneIzq.sueltaTenedorAmc();
			teneDer.sueltaTenedorAmc();
			comer(false);
		}
	}
	
}
