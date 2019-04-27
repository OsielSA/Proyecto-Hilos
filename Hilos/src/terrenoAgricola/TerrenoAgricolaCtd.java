package terrenoAgricola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerrenoAgricolaCtd implements ActionListener{
	private TerrenoAgricolaVta vista;
	TerrenoAgricolaMdl modelo;
	public TerrenoAgricolaCtd(TerrenoAgricolaVta vista, TerrenoAgricolaMdl modelo) {
		this.vista = vista;
		this.modelo = modelo;
		hazEscuchas();
	}
	private void hazEscuchas() {
		vista.btnRepartir.addActionListener(this);
		vista.rdBtnHer1.addActionListener(this);
		vista.rdBtnHer2.addActionListener(this);
		vista.rdBtnHer3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == vista.rdBtnHer1) {
			vista.mostraHectareas(1);
			return;
		} 
		if(evt.getSource() == vista.rdBtnHer2) {
			vista.mostraHectareas(2);
			return;
		} 
		if(evt.getSource() == vista.rdBtnHer3) {
			vista.mostraHectareas(3);
			return;
		} 
		if(evt.getSource() == vista.btnRepartir) {
			modelo.Repartir(vista.hectareas);
			vista.rdBtnHer1.setEnabled(true);
			vista.rdBtnHer2.setEnabled(true);
			vista.rdBtnHer3.setEnabled(true);
			return;
		} 
			
	}
}
