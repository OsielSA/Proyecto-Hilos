package plantaEnsambladora;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import com.sun.javafx.geom.Rectangle;

public class Linea extends Thread {
	private final String ruta = ".\\src\\plantaEnsambladora\\images\\"; 
	private JPanel pnlLinea;
	private Estacion[] estaciones;
	private JLabel imgLinea;
	private JLabel auto;
	private Image imagen;
	public Linea() {
		crearLinea();
		
	}
	private void crearLinea() {
		pnlLinea = new JPanel();
		pnlLinea.setLayout(null);
		pnlLinea.setBounds(1, 1, 200, 100);
		colocaEstaciones();
		//colocar auto
		auto = new JLabel();
		auto.setIcon(Rutinas.changeSize(ruta+"car1.png", 50, 40));
		auto.setBounds(10, 50, 50, 40);
		pnlLinea.add(auto);
		
		
		imgLinea = new JLabel();
		imgLinea.setIcon(Rutinas.changeSize(ruta+"linea2.png", 700, 100));
		imgLinea.setBounds(1, 40, 700, 100);
		pnlLinea.add(imgLinea);
	}
	private void colocaEstaciones() {
		estaciones = new Estacion[6];
		int pos = 40;
		for(int i=0;i<estaciones.length;i++) {
			estaciones[i] = new Estacion(i,500,pos);
			pos += 40;
		}
		int ejeX = 35;
		for(int i=0;i<estaciones.length;i++) {
			estaciones[i].setBounds(ejeX, 1, 60, 50);
			pnlLinea.add(estaciones[i]);
			ejeX+=110;
		}
	}
//	@Override
    public void paint(Graphics g) {
    	g.drawImage(imagen, 0, 0, pnlLinea.getWidth(), pnlLinea.getHeight(),pnlLinea);
 
        pnlLinea.setOpaque(false);
        pnlLinea.paint(g);
    }
	@Override
	public void run() {
		avanzaAuto();
	}
	private void avanzaAuto() {
		
		while(true) {
			if(auto.getX() == 1000)
				return;
			auto.setBounds(auto.getX()+1, 50, 60, 50);
			try {
				sleep(10);
			}catch(Exception e) {}
			SwingUtilities.updateComponentTreeUI(pnlLinea);
		}

	}
	public JPanel getPnlLinea() {
		return pnlLinea;
	}
}
