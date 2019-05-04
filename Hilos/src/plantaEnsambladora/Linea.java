package plantaEnsambladora;

import java.awt.Color;

import javax.swing.*;

import com.sun.javafx.geom.Rectangle;

public class Linea extends JPanel {
	private Estacion[] estaciones[];
	public Linea() {
		setLayout(null);
		setBounds(1, 1, 200, 100);
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
	}
}
