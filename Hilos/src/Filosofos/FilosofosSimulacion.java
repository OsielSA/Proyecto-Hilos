package Filosofos;

import java.awt.Color;

import javax.swing.*;

public class FilosofosSimulacion extends JFrame {
	private JLabel mesa;
	private JLabel platos[];
	private Tenedor tenedores[];
	private Filosofo filosofos[];
	private JPanel glass;
	final String ruta = ".\\src\\Filosofos\\images\\"; 
	public FilosofosSimulacion() {
		super("Filosofos Comensales");
		hazInterfaz();
	}

	private void hazInterfaz() {
		setLayout(null);
		setSize(850, 700);
		setResizable(false);
//		---------------------------------
		glass = (JPanel) getGlassPane();
        glass.setLayout(null);
        glass.setVisible(true);
//		---------------------------------
		ponMesa();
		asignaFilosofos();
		for(Filosofo f: filosofos)
			f.start();
//		tomaTenedorAmc(3);
//		tomaTenedorAmc(1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	private void ponMesa() {
		//añade tenedores
		tenedores = new Tenedor[5];
		tenedores[0] = new Tenedor(0);
		tenedores[0].setBounds(210, 170, 90, 80);
		tenedores[0].setIcon(Rutinas.changeSize(ruta+"tenedor1.png", 90, 80));
		glass.add(tenedores[0]);
		tenedores[1] = new Tenedor(1);
		tenedores[1].setBounds(460, 180, 90, 80);
		tenedores[1].setIcon(Rutinas.changeSize(ruta+"tenedor2.png", 90, 80));
		glass.add(tenedores[1]);
		tenedores[2] = new Tenedor(2);
		tenedores[2].setBounds(550, 350, 90, 80);
		tenedores[2].setIcon(Rutinas.changeSize(ruta+"tenedor3.png", 90, 80));
		glass.add(tenedores[2]);
		tenedores[3] = new Tenedor(3);
		tenedores[3].setBounds(350, 450, 90, 80);
		tenedores[3].setIcon(Rutinas.changeSize(ruta+"tenedor4.png", 90, 80));
		glass.add(tenedores[3]);
		tenedores[4] = new Tenedor(4);
		tenedores[4].setBounds(160, 350, 90, 80);
		tenedores[4].setIcon(Rutinas.changeSize(ruta+"tenedor5.png", 90, 80));
		glass.add(tenedores[4]);
		
		//añade mesa
		mesa = new JLabel();
		mesa.setBounds(40, 40, 700, 600);
		mesa.setIcon(Rutinas.changeSize(ruta+"mesa.png", 700, 600));
		add(mesa);
		
	}
	private void asignaFilosofos() {
		filosofos = new Filosofo[5];
		filosofos[0] = new Filosofo(1, tenedores[0], tenedores[4]);
		filosofos[1] = new Filosofo(2, tenedores[1], tenedores[0]);
		filosofos[2] = new Filosofo(3, tenedores[1], tenedores[2]);
		filosofos[3] = new Filosofo(4, tenedores[2], tenedores[3]);
		filosofos[4] = new Filosofo(5, tenedores[3], tenedores[4]);

		//lugares
		filosofos[0].accion.setBounds(140,260, 65, 20);
		glass.add(filosofos[0].accion);
		filosofos[1].accion.setBounds(350,130, 65, 20);
		glass.add(filosofos[1].accion);
		filosofos[2].accion.setBounds(590,260, 65, 20);
		glass.add(filosofos[2].accion);
		filosofos[3].accion.setBounds(515,470, 65, 20);
		glass.add(filosofos[3].accion);
		filosofos[4].accion.setBounds(200,470, 65, 20);
		glass.add(filosofos[4].accion);
	}
	
	
	public Tenedor[] getTenedores() {
		return tenedores;
	}
}
