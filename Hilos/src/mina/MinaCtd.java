package mina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinaCtd implements ActionListener {

    private MinaVta vista;
    private MinaMdl modelo;
    private boolean band = false;

    public MinaCtd(MinaVta vista, MinaMdl modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.btnIniciar.addActionListener(this);
        vista.btnConsulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
    	if(evt.getSource() == vista.btnConsulta) {
    		if (!band) {
                vista.crearTabla(modelo.obtenerInfoPaises(vista.getPaisesEuropa(), vista.getPaisesAsia()));
                band = true;
            }

            vista.frameConsulta.setVisible(true);
            return;
    	}
        vista.iniciar();
    }
}
