package terrenoAgricola;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TerreneoApp {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        TerrenoAgricolaVta v = new TerrenoAgricolaVta();
        TerrenoAgricolaMdl m = new TerrenoAgricolaMdl();
        TerrenoAgricolaCtd c = new TerrenoAgricolaCtd(v, m);
    }
}
