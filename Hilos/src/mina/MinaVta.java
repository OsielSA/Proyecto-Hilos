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
	public JLabel lblSolicitudEu;
	public JLabel lblSolicitudAs;
	
	
	public JLabel lblPaisEuropa;
	public JLabel lblPaisAsia;
	
	private Mina mina;
	
	private Pais[] paisesEuropa;
	private Pais[] paisesAsia;
	
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
		iniciar();
//		----------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		lblSolicitudEu = new JLabel();
		lblSolicitudEu.setForeground(new Color(101, 101, 101)); 
		lblSolicitudEu.setBounds(700, 180, 100, 50);
		add(lblSolicitudEu);
		
		lblPaisAsia = new JLabel();
		lblPaisAsia.setIcon(Rutinas.changeSize(ruta+"asiaP0.png", 300, 200));
		lblPaisAsia.setBounds(600, 250, 300, 200);
		add(lblPaisAsia);
		lblSolicitudAs = new JLabel();
		lblSolicitudAs.setForeground(new Color(101, 101, 101)); 
		lblSolicitudAs.setBounds(700, 450, 100, 50);
		add(lblSolicitudAs);
		
		//Inicializar Paises
		paisesEuropa = new Pais[Rutinas.nextInt(10, 30)];
		paisesAsia = new Pais[Rutinas.nextInt(5, 7)];
		for(int i=0;i<paisesEuropa.length;i++)
			paisesEuropa[i] = new Pais(1,(i+1),this);
		for(int i=0;i<paisesAsia.length;i++)
			paisesAsia[i] = new Pais(2,(i+1),this);
	}
	
	private void iniciar() {
		for(int i=0;i<paisesEuropa.length;i++)
			paisesEuropa[i].start();
		for(int i=0;i<paisesAsia.length;i++)
			paisesAsia[i].start();
	}

	public void actualizar(int continente) {
		if(continente == 1) {
			//info Regular
			lblInfoRegularEu.setText("Cantidad Europa: "+mina.mineralesEuropa[0]);
			//info Buena
			lblInfoBuenaEu.setText("Cantidad Europa: "+mina.mineralesEuropa[1]);
			//info Exelente
			lblInfoExelenteEu.setText("Cantidad Europa: "+mina.mineralesEuropa[2]);
			return;
		}
		//info Regular
		lblInfoRegularAs.setText("Cantidad Asia: "+mina.mineralesAsia[0]);
		//info Buena
		lblInfoBuenaAs.setText("Cantidad Asia: "+mina.mineralesAsia[1]);
		//info Exelente
		lblInfoExelenteAs.setText("Cantidad Asia: "+mina.mineralesAsia[2]);
	}
	
	public Mina getMina() {
		return mina;
	}
}
