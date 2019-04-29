package plantaEnsambladora;

import javax.swing.*;

public class plantaEnsambladoraVta extends JFrame {
	public plantaEnsambladoraVta() {
		super("Panta Ensambladora");
		createInterface();
	}

	private void createInterface() {
		setSize(500, 700);
		setResizable(false);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
