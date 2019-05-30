package plantaEnsambladora;

import javax.swing.ImageIcon;
import utils.*;
public class Robot {

    private final String ruta = ".\\src\\plantaEnsambladora\\images\\";
    private ImageIcon imgRobot;
    private boolean trabajando;
    public Semaforo semaforo;

    public Robot() {
        semaforo = new Semaforo(1);
        trabajando = false;
        imgRobot = Rutinas.changeSize(ruta + "robot.png", 50, 45);
    }

    public boolean isTrabajando() {
        return trabajando;
    }

    public void setTrabajando(boolean trabajando) {
        this.trabajando = trabajando;
    }

    public ImageIcon getImgRobot() {
        return imgRobot;
    }
}
