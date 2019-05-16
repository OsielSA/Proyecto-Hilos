package mina;

import java.awt.Color;

import javax.swing.*;

public class MinaVta extends JFrame{
	private final String ruta = ".\\src\\mina\\images\\"; 
	
	private JLabel lblInfoRegularEu;
	private JLabel lblInfoBuenaEu;
	private JLabel lblInfoExelenteEu;
	private JLabel lblInfoRegularAs;
	private JLabel lblInfoBuenaAs;
	private JLabel lblInfoExelenteAs;
	
	
	private JLabel lblPaisEuropa;
	private JLabel lblPaisAsia;
	
	private Mina mina;
	
	public MinaVta() {
		super("Mina");
		mina = new Mina();
		createInterface();
	}

	private void createInterface() {
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(new Color(215, 253, 169));
//		----------------------------
		
		cargarInfoMina();
		cargarPaises();
		
//		----------------------------
		setVisible(true);
		
	}

	private void cargarInfoMina() {
		//info Regular
		lblInfoRegularEu = new JLabel("Cantidad Europa: "+mina.mineralesEuropa[0]);
		lblInfoRegularEu.setBounds(330, 120, 130, 30);
		add(lblInfoRegularEu);
		
		lblInfoRegularAs = new JLabel("Cantidad Asia: "+mina.mineralesAsia[0]);
		lblInfoRegularAs.setBounds(330, 140, 120, 30);
		add(lblInfoRegularAs);
		
		//info Buena
		lblInfoBuenaEu = new JLabel("Cantidad Europa: "+mina.mineralesEuropa[1]);
		lblInfoBuenaEu.setBounds(330, 240, 130, 30);
		add(lblInfoBuenaEu);
		
		lblInfoBuenaAs = new JLabel("Cantidad Asia: "+mina.mineralesAsia[1]);
		lblInfoBuenaAs.setBounds(330, 260, 120, 30);
		add(lblInfoBuenaAs);
		
		//info Exelente
		lblInfoExelenteEu = new JLabel("Cantidad Europa: "+mina.mineralesEuropa[2]);
		lblInfoExelenteEu.setBounds(330, 360, 130, 30);
		add(lblInfoExelenteEu);
		
		lblInfoExelenteAs = new JLabel("Cantidad Asia: "+mina.mineralesAsia[2]);
		lblInfoExelenteAs.setBounds(330, 380, 120, 30);
		add(lblInfoExelenteAs);
		
		//Mina
		JLabel infoMina = new JLabel();
		infoMina.setIcon(Rutinas.changeSize(ruta+"infoMina.png", 500, 350));
		infoMina.setBounds(10, 80, 500, 350);
		add(infoMina);
	}
	
	private void cargarPaises() {
		lblPaisEuropa = new JLabel();
		lblPaisEuropa.setIcon(Rutinas.changeSize(ruta+"europaP0.png", 200, 150));
		lblPaisEuropa.setBounds(600, 30, 200, 150);
		add(lblPaisEuropa);
		lblPaisAsia = new JLabel();
		lblPaisAsia.setIcon(Rutinas.changeSize(ruta+"asiaP0.png", 300, 200));
		lblPaisAsia.setBounds(600, 250, 300, 200);
		add(lblPaisAsia);
		
	}
}
