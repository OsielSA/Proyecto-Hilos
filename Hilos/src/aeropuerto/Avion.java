package aeropuerto;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import utils.*;

public class Avion extends Thread {

    private final String ruta = ".\\src\\aeropuerto\\images\\";

    private int id;
    private int posEstacionadoX;
    public JLabel avionImg;
    private Pista pista;
    private int posY;
    private JLabel lblintentos;
    int intentos;

    public Avion(Pista pista, int posY, int posEstacionadoX, JLabel lblIntentos) {
        this.id = id;
        this.posEstacionadoX = posEstacionadoX;
        this.pista = pista;
        this.posY = posY;
        this.intentos = 0;
        this.lblintentos = lblIntentos;
        avionImg = new JLabel();
        avionImg.setBounds(5, posY, 100, 80);
        avionImg.setIcon(Rutinas.changeSize(ruta + "avion.png", 50, 40));
    }

    @Override
    public void run() {
    	boolean primerVuelo = true;
        while (true) {
        	if(primerVuelo) {
        		vuela();
                regresa();
                primerVuelo = false;
        	}
            intenta();
            if (pista.isDisponible()) {
                pista.setDisponible(false);
                pista.getSemaforo().Espera();
                aterriza();
                avanzaPorPista();
                pista.setDisponible(true);
                pista.getSemaforo().Libera();
                try {
                    sleep(100);
                } catch (Exception e) {
                }
                estaciona();
                lblintentos.setText(""+intentos);
                return;
            }
            intentos++;
            sube();
            vuela();
            regresa();
        }

    }
    private void intenta() {
    	avionImg.setIcon(Rutinas.changeSize(ruta + "avion.png", 50, 40));
        avionImg.setBounds(1, avionImg.getY(), 100, 80);
        while (avionImg.getY() < 200) {
            avionImg.setBounds(avionImg.getX() + 1, avionImg.getY() + 2, 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }
    private void sube() {
    	avionImg.setIcon(Rutinas.changeSize(ruta + "avion.png", 50, 40));
        avionImg.setBounds(avionImg.getX(), avionImg.getY(), 100, 80);
        while (avionImg.getY() > posY) {
            avionImg.setBounds(avionImg.getX() + 1, avionImg.getY() - 2, 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }
    public void vuela() {
        avionImg.setIcon(Rutinas.changeSize(ruta + "avion.png", 50, 40));
        while (avionImg.getX() < 920) {
            avionImg.setBounds(avionImg.getX() + 3, avionImg.getY(), 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void regresa() {
        avionImg.setIcon(Rutinas.changeSize(ruta + "avion2.png", 50, 40));

        while (avionImg.getX() > -65) {
            avionImg.setBounds(avionImg.getX() - 3, avionImg.getY(), 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void aterriza() {
        avionImg.setIcon(Rutinas.changeSize(ruta + "avion.png", 50, 40));
        avionImg.setBounds(avionImg.getX(), avionImg.getY(), 100, 80);
        while (avionImg.getY() < 400) {
            avionImg.setBounds(avionImg.getX() + 1, avionImg.getY() + 2, 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void avanzaPorPista() {
        while (avionImg.getX() < 500) {
            avionImg.setBounds(avionImg.getX() + 3, avionImg.getY(), 100, 80);
            SwingUtilities.updateComponentTreeUI(avionImg);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void estaciona() {
        avionImg.setBounds(posEstacionadoX, 505, 100, 80);
    }

}
