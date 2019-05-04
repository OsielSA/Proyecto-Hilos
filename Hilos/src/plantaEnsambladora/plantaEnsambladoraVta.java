package plantaEnsambladora;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class plantaEnsambladoraVta extends JFrame{
	private final String ruta = ".\\src\\plantaEnsambladora\\images\\"; 
	private JFrame frameMenu;
	public JSlider sliderLineas;
	public JButton btnIniciar;
	private int numLineas;
	
	public plantaEnsambladoraVta() {
		super("Producció");
		createInterfaceMenu();
		createInterfaceProduccion();
	}
 
	private void createInterfaceMenu() {
		frameMenu = new JFrame("Menú Planta Ensambladora");
		frameMenu.setSize(400, 300);
		frameMenu.setResizable(false);
		frameMenu.setLayout(null);
		frameMenu.setLocationRelativeTo(null);
		Image icon = new ImageIcon(ruta+"logo.png").getImage();
		frameMenu.setIconImage(icon);
		//Titulo
		JLabel titulo = new JLabel("Planta Ensambladora NISSON");
		titulo.setFont(new Font("Helvetica", Font.BOLD+Font.ITALIC, 18));
		titulo.setBounds(70, 10, 280, 30);
		titulo.setForeground(new Color(50, 56, 89));
		frameMenu.add(titulo);
		//Seleccionar número de lineas de Produccion
		JLabel tituloSlider = new JLabel("Número de lineas");
		tituloSlider.setBounds(130, 60, 250, 30);
		frameMenu.add(tituloSlider);
		sliderLineas = new JSlider(8,15,8);
		sliderLineas.setMajorTickSpacing(1);
		sliderLineas.setPaintTicks(true);
		sliderLineas.setPaintLabels(true);
		sliderLineas.setBounds(60, 80, 250, 50);
		frameMenu.add(sliderLineas);
		//Botón iniciar produccion
		btnIniciar = new JButton("<html><center>Iniciar<p>Producción</center></html>");
		btnIniciar.setBounds(140, 185, 100, 40);
		frameMenu.add(btnIniciar);
		
		frameMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameMenu.setVisible(true);
	}
	private void createInterfaceProduccion() {
		setLayout(null);
		setSize(900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		Image icon = new ImageIcon(ruta+"logo.png").getImage();
		setIconImage(icon);
		
		frameMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void iniciarProduccion() {
		setVisible(true);
	}
	public void ocultarMenu() {
		frameMenu.setVisible(false);
	}
	public void setNumLineas(int numLineas) {
		this.numLineas = numLineas;
	}
}
