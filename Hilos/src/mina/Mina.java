package mina;

import java.util.Vector;
import utils.*;
public class Mina {

    public int[] mineralesEuropa;
    public int[] mineralesAsia;
    private Semaforo semaforoEuropa[];
    private Semaforo semaforoAsia[];
    private boolean minandoEu[];
    private boolean minandoAs[];

    public Mina() {
        cargarMinerales();
        inicializarSemaforos();
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
    private void inicializarSemaforos() {
    	semaforoEuropa = new Semaforo[3];
    	semaforoEuropa[0] = new Semaforo(1);
    	semaforoEuropa[1] = new Semaforo(1);
    	semaforoEuropa[2] = new Semaforo(1);
    	
    	semaforoAsia = new Semaforo[3];
    	semaforoAsia[0] = new Semaforo(1);
    	semaforoAsia[1] = new Semaforo(1);
    	semaforoAsia[2] = new Semaforo(1);
    	
    	minandoEu = new boolean[3];
    	minandoEu[0] = false;
    	minandoEu[1] = false;
    	minandoEu[2] = false;
    	
    	minandoAs = new boolean[3];
    	minandoAs[0] = false;
    	minandoAs[1] = false;
    	minandoAs[2] = false;
    }

    public int solicitarMinerales(int continente, int tipo, int cantidad, int V1) {
        int minerales = 0;
        if (continente == 1) {
            for (int i = 0; i < cantidad; i++) {
                if (mineralesEuropa[tipo] <= 0) {
                    return minerales;
                }
                mineralesEuropa[tipo]--;
                minerales++;
            }
            return minerales;
        }
        for (int i = 0; i < cantidad; i++) {
            if (mineralesAsia[tipo] <= 0) {
                return minerales;
            }
            mineralesAsia[tipo]--;
            minerales++;
        }
        return minerales;
    }
    public int solicitarMinerales(int continente, int tipo, int cantidad) {
        int minerales = 0;
        if (continente == 1) {
           if(mineralesEuropa[tipo]-cantidad > 0) {
        	   mineralesEuropa[tipo] -= cantidad;
        	   return cantidad;
           }
           for (int i = 0; i < cantidad; i++) {
               if (mineralesEuropa[tipo] <= 0) {
                   return minerales;
               }
               mineralesEuropa[tipo]--;
               minerales++;
           }
            return minerales;
        }
        if(mineralesAsia[tipo]-cantidad > 0) {
        	mineralesAsia[tipo] -= cantidad;
        	return cantidad;
        }
        for (int i = 0; i < cantidad; i++) {
            if (mineralesAsia[tipo] <= 0) {
                return minerales;
            }
            mineralesAsia[tipo]--;
            minerales++;
        }
        return minerales;
    }
    public boolean hayDisponibles(int continente) {
        if (continente == 1) {
            if (mineralesEuropa[0] > 0 || mineralesEuropa[1] > 0 || mineralesEuropa[2] > 0) 
                return true;
            return false;
        }
        if (mineralesAsia[0] > 0 || mineralesAsia[1] > 0 || mineralesAsia[2] > 0) 
            return true;
        return false;
    }
    
    public boolean hayDisponibles(int continente, int tipo) {
        if (continente == 1) {
            if (mineralesEuropa[tipo] > 0) 
                return true;
            return false;
        }
        if (mineralesAsia[tipo] > 0) 
            return true;
        return false;
    }

    public boolean isMinandoAs(int tipo) {
        return minandoAs[tipo];
    }

    public boolean isMinandoEu(int tipo) {
        return minandoEu[tipo];
    }

    public void setMinandoAs(boolean minandoAs, int tipo) {
        this.minandoAs[tipo] = minandoAs;
    }

    public void setMinandoEu(boolean minandoEu, int tipo) {
        this.minandoEu[tipo] = minandoEu;
    }
    
    public Semaforo getSemaforoAsia(int tipo) {
        return semaforoAsia[tipo];
    }
    public Semaforo getSemaforoEuropa(int tipo) {
        return semaforoEuropa[tipo];
    }
}
