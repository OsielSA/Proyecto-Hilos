package plantaEnsambladora;

import javax.swing.*;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

public class plantaEnsambladoraApp {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        plantaEnsambladoraVta v = new plantaEnsambladoraVta();
        plantaEnsambladoraCtd c = new plantaEnsambladoraCtd(v);
    }
}
