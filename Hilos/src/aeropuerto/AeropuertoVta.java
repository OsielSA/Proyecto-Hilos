package aeropuerto;

import java.awt.Color;

import javax.swing.*;


public class AeropuertoVta extends JFrame{
	private final String ruta = ".\\src\\aeropuerto\\images\\"; 
	
	private JLabel pnlFondo;
	private JPanel glass;
	private Avion aviones[];
	public AeropuertoVta() {
		super("Aeropuerto");
		createInterface();
	}

	private void createInterface() {
		setSize(900, 600);
		setResizable(false);
//		---------------------------------
		glass = (JPanel) getGlassPane();
        glass.setLayout(null);
        glass.setVisible(true);
//		---------------------------------
		colocarFondo();
		creaAviones();
//		add(glass);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void colocarFondo() {
		pnlFondo = new JLabel();
		pnlFondo.setIcon(Rutinas.changeSize(ruta+"pista.jpg", 900, 600));
		add(pnlFondo);
		
	}
	private void creaAviones() {
		Pista p = new Pista();
		aviones = new Avion[5];
		int posY = 2; 
		int posEst = 85;
		for(int i=0;i<aviones.length;i++) {
			aviones[i] = new Avion(p,posY,posEst);
			posY+=30;
			posEst+=115;
		}
		for(int i=0;i<aviones.length;i++)
			glass.add(aviones[i].avionImg);
		
		for(int i=0;i<aviones.length;i++) {
			aviones[i].start();
		}	
	}
}
