package terrenoAgricolaE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;

public class TerrenoAgricolaView extends JFrame{
	
	private JPanel centerPane,southPane;
	private List<Hectarea> field;
	private JButton btnStart;
	private TerrenoAgricolaController controller;
	
	public TerrenoAgricolaView() {
		super("Terreno Agricola");
		setSize(800,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		field = new LinkedList<Hectarea>();
		centerPane = new JPanel();
		southPane = new JPanel();
		
		btnStart = new JButton("Iniciar");
		add(btnStart,BorderLayout.NORTH);
		
		createCenterPane();
		createSouthPane();
		setVisible(true);
	}
	
	private void createCenterPane() {
		centerPane.setLayout(new GridLayout(10,10,5,5));
		
		for(int i = 1; i <= 100; i++)
			field.add(new Hectarea(i+""));
		
		field.forEach( hectarea ->{
			hectarea.setOpaque(true);
			hectarea.setBackground(Color.GREEN);
			centerPane.add(hectarea);
		});
	
		add(centerPane,BorderLayout.CENTER);
	}
	
	private void createSouthPane() {
		JLabel h1 = new JLabel("     "),h2 = new JLabel("     "),h3 = new JLabel("     ");
		h1.setOpaque(true); h2.setOpaque(true); h3.setOpaque(true);
		h1.setBackground(Color.red); h2.setBackground(Color.BLUE); h3.setBackground(Color.YELLOW);
		
		southPane.add(new JLabel("Hermano 1:"));
		southPane.add(h1);
		southPane.add(new JLabel("Hermano 2:"));
		southPane.add(h2);
		southPane.add(new JLabel("Hermano 3:"));
		southPane.add(h3);
		add(southPane,BorderLayout.SOUTH);
	}
	
	public void start() {
		Hermano h1 = new Hermano(field,Color.RED),
				h2 = new Hermano(field,Color.BLUE),
				h3 = new Hermano(field,Color.YELLOW);
		
		h1.start();
		h2.start();
		h3.start();
		
//		while(h1.isAlive() || h2.isAlive() || h3.isAlive()) {
//			System.out.println("ALIVE");
//		}
	}
	
	public void setController(TerrenoAgricolaController controller) {
		this.controller = controller;
		btnStart.addActionListener(controller);
	}
	
	public void update() {
		SwingUtilities.updateComponentTreeUI(this);
	}

}
