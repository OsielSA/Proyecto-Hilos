package mina;

import java.util.Vector;
import utils.*;
public class Mina {

    public int[] mineralesEuropa;
    public int[] mineralesAsia;
    public Semaforo semaforoEuropa;
    public Semaforo semaforoAsia;
    private boolean minandoEu;
    private boolean minandoAs;

    public Mina() {
        cargarMinerales();
        semaforoEuropa = new Semaforo(1);
        semaforoAsia = new Semaforo(1);
        minandoEu = false;
        minandoAs = false;
    }

    private void cargarMinerales() {
        mineralesEuropa = new int[3];
        mineralesAsia = new int[3];

        int mineralesTotales = Rutinas.nextInt(10000, 20000);
        int mineralesTipo1 = (int) (mineralesTotales * 0.30);
        int mineralesTipo2 = (int) (mineralesTotales * 0.60);
        int mineralesTipo3 = (int) mineralesTotales - (mineralesTipo1 + mineralesTipo2);

        mineralesEuropa[0] = (int) mineralesTipo1 / 2;
        mineralesEuropa[1] = (int) mineralesTipo2 / 2;
        mineralesEuropa[2] = (int) mineralesTipo3 / 2;

        mineralesAsia[0] = (int) mineralesTipo1 / 2;
        mineralesAsia[1] = (int) mineralesTipo2 / 2;
        mineralesAsia[2] = (int) mineralesTipo3 / 2;

    }

    public int solicitarMinerales(int continente, int tipo, int cantidad) {
        int minerales = 0;
        if (continente == 1) {
            for (int i = 0; i < cantidad; i++) {
                if (mineralesEuropa[tipo - 1] <= 0) {
                    return minerales;
                }
                mineralesEuropa[tipo - 1]--;
                minerales++;
            }
            return minerales;
        }
        for (int i = 0; i < cantidad; i++) {
            if (mineralesAsia[tipo - 1] <= 0) {
                return minerales;
            }
            mineralesAsia[tipo - 1]--;
            minerales++;
        }
        return minerales;
    }

    public boolean hayDisponibles(int continente) {
        if (continente == 1) {
            if (mineralesEuropa[0] > 0 || mineralesEuropa[1] > 0 || mineralesEuropa[2] > 0) {
                return true;
            }
            return false;
        }
        if (mineralesAsia[0] > 0 || mineralesAsia[1] > 0 || mineralesAsia[2] > 0) {
            return true;
        }
        return false;
    }

    public boolean isMinandoAs() {
        return minandoAs;
    }

    public boolean isMinandoEu() {
        return minandoEu;
    }

    public void setMinandoAs(boolean minandoAs) {
        this.minandoAs = minandoAs;
    }

    public void setMinandoEu(boolean minandoEu) {
        this.minandoEu = minandoEu;
    }

}
