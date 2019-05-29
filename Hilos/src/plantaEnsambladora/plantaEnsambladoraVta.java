package plantaEnsambladora;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class plantaEnsambladoraVta extends JFrame {

    private final String ruta = ".\\src\\plantaEnsambladora\\images\\";
    private JFrame frameMenu;
    public JSlider sliderLineas;
    public JButton btnIniciar;
    private int numLineas;
    private Vector<Robot[]> robotPorEstaciones;
    private Linea[] lineas;

    public plantaEnsambladoraVta() {
        super("Producci√≥n");
        createInterfaceMenu();
        createInterfaceProduccion();
    }

    private void createInterfaceMenu() {
        frameMenu = new JFrame("Men√∫ Planta Ensambladora");
        frameMenu.setSize(400, 300);
        frameMenu.setResizable(false);
        frameMenu.setLayout(null);
        frameMenu.setLocationRelativeTo(null);
        Image icon = new ImageIcon(ruta + "logo.png").getImage();
        frameMenu.setIconImage(icon);
        //Titulo
        JLabel titulo = new JLabel("Planta Ensambladora NISSON");
        titulo.setFont(new Font("Helvetica", Font.BOLD + Font.ITALIC, 18));
        titulo.setBounds(70, 10, 280, 30);
        titulo.setForeground(new Color(50, 56, 89));
        frameMenu.add(titulo);
        //Seleccionar n√∫mero de lineas de Produccion
        JLabel tituloSlider = new JLabel("N√∫mero de lineas");
        tituloSlider.setBounds(130, 60, 250, 30);
        frameMenu.add(tituloSlider);

        sliderLineas = new JSlider(8, 15, 8);
        sliderLineas.setMajorTickSpacing(1);
        sliderLineas.setPaintTicks(true);
        sliderLineas.setPaintLabels(true);
        sliderLineas.setBounds(60, 80, 250, 50);
        frameMenu.add(sliderLineas);
        JLabel seccionRoja = new JLabel();
        seccionRoja.setOpaque(true);
        seccionRoja.setBackground(new Color(233, 65, 65));
        seccionRoja.setBounds(230, 93, 80, 5);
        frameMenu.add(seccionRoja);
        //BotÔøΩn iniciar produccion
        btnIniciar = new JButton("<html><center>Iniciar<p>Producci√≥n</center></html>");
        btnIniciar.setBounds(140, 185, 100, 40);
        frameMenu.add(btnIniciar);

        frameMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameMenu.setVisible(true);
    }

    private void createInterfaceProduccion() {
        setLayout(new GridLayout(0, 2, 8, 2));
        setSize(900, 700);
        setExtendedState(MAXIMIZED_BOTH);
        Image icon = new ImageIcon(ruta + "logo.png").getImage();
        setIconImage(icon);

        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void aÒadirLineas() {
        lineas = new Linea[numLineas];

        for (int i = 0; i < lineas.length; i++) {
            lineas[i] = new Linea(robotPorEstaciones);
        }
        for (int i = 0; i < lineas.length; i++) {
            add(lineas[i].getPnlLinea());
        }
    }

    public void iniciarProduccion() {
        aÒadirRobots();
        aÒadirLineas();
        setVisible(true);
        for (int i = 0; i < lineas.length; i++) {
            lineas[i].start();
        }
    }

    private void aÒadirRobots() {
        robotPorEstaciones = new Vector<Robot[]>();
        int numRobots[] = {5, 4, 3, 3, numLineas, numLineas};

        for (int i = 0; i < numRobots.length; i++) {
            Robot robots[] = new Robot[numRobots[i]];
            for (int j = 0; j < numRobots[i]; j++) {
                robots[j] = new Robot();
            }
            robotPorEstaciones.add(robots);
        }
        for (int i = 0; i < robotPorEstaciones.size(); i++) {
            System.out.println("Robots estacion " + (i + 1) + ": " + robotPorEstaciones.get(i).length);
        }

    }

    public void ocultarMenu() {
        frameMenu.setVisible(false);
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }
}
