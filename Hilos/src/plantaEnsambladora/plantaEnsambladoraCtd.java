package plantaEnsambladora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class plantaEnsambladoraCtd implements ActionListener, ChangeListener {

    plantaEnsambladoraVta vista;
    private boolean band;

    public plantaEnsambladoraCtd(plantaEnsambladoraVta vista) {
        this.vista = vista;
        band = false;
        vista.sliderLineas.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        vista.ocultarMenu();
        vista.iniciarProduccion();
    }

    @Override
    public void stateChanged(ChangeEvent evt) {
        if (!band) {
            band = true;
            vista.btnIniciar.addActionListener(this);
        }
        vista.setNumLineas(vista.sliderLineas.getValue());
    }

}
