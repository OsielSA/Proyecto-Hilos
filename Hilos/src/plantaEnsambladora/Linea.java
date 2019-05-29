package plantaEnsambladora;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.*;

import com.sun.javafx.geom.Rectangle;

public class Linea extends Thread {

    private final String ruta = ".\\src\\plantaEnsambladora\\images\\";
    private final int[] posEstaciones = {40, 150, 260, 370, 480, 590, 700};
    private JPanel pnlLinea;
    private Estacion[] estaciones;
    private JLabel imgLinea;
    private JLabel auto;
    private Image imagen;
    private Vector<Robot[]> robots;
    private static int contAutos = 0;
    private boolean band;
    private boolean contAutosOcupado;
    private Semaforo semaforo;

    public Linea(Vector<Robot[]> robots) {
        this.robots = robots;
        contAutosOcupado = false;
        semaforo = new Semaforo(1);
        band = false;
//		this.contAutos = contAutos;
        crearLinea();

    }

    private void crearLinea() {
        pnlLinea = new JPanel();
        pnlLinea.setLayout(null);
        pnlLinea.setBounds(1, 1, 200, 100);
        colocaEstaciones();
        //colocar auto
        auto = new JLabel();
        auto.setIcon(Rutinas.changeSize(ruta + "car1.png", 50, 40));
        auto.setBounds(-10, 50, 50, 40);
        pnlLinea.add(auto);

        imgLinea = new JLabel();
        imgLinea.setIcon(Rutinas.changeSize(ruta + "linea2.png", 700, 100));
        imgLinea.setBounds(1, 40, 700, 100);
        pnlLinea.add(imgLinea);
    }

    private void colocaEstaciones() {
        estaciones = new Estacion[6];
        for (int i = 0; i < estaciones.length; i++) {
            estaciones[i] = new Estacion(i, 500);
        }
        int ejeX = 35;
        for (int i = 0; i < estaciones.length; i++) {
            estaciones[i].setBounds(ejeX, 1, 60, 50);
            pnlLinea.add(estaciones[i]);
            ejeX += 110;
        }
    }

    @Override
    public void run() {
        Robot[] robotsAux;
        Robot robotAux;
        while (true) {
//			if(contAutos >= 15)
//				return;
            auto.setBounds(-10, 50, 50, 40);
            
            System.out.println(contAutos);
            if (!contAutosOcupado) {
                contAutosOcupado = true;
                semaforo.Espera();
                contAutos++;
                contAutosOcupado = false;
                semaforo.Libera();
            }
            
            for (int i = 0; i < posEstaciones.length; i++) {
                if (contAutos > 15) 
                	 band = true;

                //lleg� a estaci�n final
                if (i == posEstaciones.length - 1) {
                    avanzaAuto(posEstaciones[i]);
                    auto.setIcon(Rutinas.changeSize(ruta + "car1.png", 50, 40));
                    break;
                }

                robotsAux = robots.get(i);
                avanzaAuto(posEstaciones[i]);

                robotAux = robotDisponible(robotsAux);
                if (robotAux == null) {
                    i--;
                    continue;
                }
                robotAux.setTrabajando(true);
                robotAux.semaforo.Espera();
                estaciones[i].setIcon(robotAux.getImgRobot());
                try {
                    sleep(estaciones[i].getTiempo());
                } catch (Exception e) {
                }
                auto.setIcon(Rutinas.changeSize(ruta + "car" + (i + 1) + ".png", 50, 40));
                estaciones[i].setIcon(null);
                robotAux.setTrabajando(false);
                robotAux.semaforo.Libera();
            }
            if(band)
            	return;

        }

    }

    private Robot robotDisponible(Robot robots[]) {
        for (int i = 0; i < robots.length; i++) {
            if (!robots[i].isTrabajando()) {
                return robots[i];
            }
        }
        return null;
    }

    private void avanzaAuto(int limite) {
        while (auto.getX() <= limite) {
            auto.setBounds(auto.getX() + 1, 50, 60, 50);
            try {
                sleep(10);
            } catch (Exception e) {
            }
        }

    }

    public JPanel getPnlLinea() {
        return pnlLinea;
    }
}
