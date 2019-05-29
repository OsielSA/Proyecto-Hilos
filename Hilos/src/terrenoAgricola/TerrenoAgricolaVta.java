package terrenoAgricola;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.*;

public class TerrenoAgricolaVta extends JFrame {

    private JPanel panelTerreno;
    private JPanel panelMenu;
    public Hectarea hectareas[];

    public JButton btnRepartir;
    public JRadioButton rdBtnHer1, rdBtnHer2, rdBtnHer3, rdBtnTodos;
    private ButtonGroup grupo;

    public TerrenoAgricolaVta() {
        super("Terreno Agricola");
        hazInterfaz();
    }

    private void hazInterfaz() {
        setLayout(null);
        setSize(900, 700);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(109, 109, 109));

        iniciaMenu();
        creaTerreno();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void iniciaMenu() {
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        JLabel lblMenu = new JLabel("Men�");
        JLabel separador = new JLabel();
        btnRepartir = new JButton("Repartir");

        //Añade titulo
        lblMenu.setBounds(120, 20, 40, 20);
        panelMenu.add(lblMenu);
        separador.setBounds(10, 55, 235, 1);
        separador.setOpaque(true);
        separador.setBackground(new Color(90, 89, 88));
        panelMenu.add(separador);
        //añade bot�n
        btnRepartir.setBounds(90, 70, 90, 35);
        panelMenu.add(btnRepartir);
        //añadir radios
        rdBtnHer1 = new JRadioButton("Hermano 1");
        rdBtnHer2 = new JRadioButton("Hermano 2");
        rdBtnHer3 = new JRadioButton("Hermano 3");
        rdBtnTodos = new JRadioButton("Todos");
        grupo = new ButtonGroup();
        grupo.add(rdBtnHer1);
        grupo.add(rdBtnHer2);
        grupo.add(rdBtnHer3);
        grupo.add(rdBtnTodos);
        rdBtnHer1.setBounds(90, 120, 100, 20);
        rdBtnHer2.setBounds(90, 140, 100, 20);
        rdBtnHer3.setBounds(90, 160, 100, 20);
        rdBtnTodos.setBounds(90, 180, 100, 20);
        panelMenu.add(rdBtnHer1);
        panelMenu.add(rdBtnHer2);
        panelMenu.add(rdBtnHer3);
        panelMenu.add(rdBtnTodos, true);
        rdBtnHer1.setEnabled(false);
        rdBtnHer2.setEnabled(false);
        rdBtnHer3.setEnabled(false);
        rdBtnTodos.setEnabled(false);
        añadeInfo();

        panelMenu.setBounds(1080, 100, 260, 450);
        panelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelMenu.setBackground(new Color(163, 163, 162));
        add(panelMenu);
    }

    private void añadeInfo() {
        JLabel lblInfo = new JLabel("Información");
        JLabel separador = new JLabel();
        JLabel separador2 = new JLabel();
        Hectarea tierraMala = new Hectarea(1);
        Hectarea tierraBuena = new Hectarea(2);
        Hectarea tierraExelente = new Hectarea(3);

        //Añade titulo
        separador.setBounds(0, 220, 300, 1);
        separador.setOpaque(true);
        separador.setBackground(Color.BLACK);
        panelMenu.add(separador);
        lblInfo.setBounds(100, 235, 80, 20);
        panelMenu.add(lblInfo);
        separador2.setBounds(10, 265, 235, 1);
        separador2.setOpaque(true);
        separador2.setBackground(new Color(90, 89, 88));
        panelMenu.add(separador2);
        //añadir tierras
        tierraMala.setBounds(70, 290, 20, 20);
        tierraBuena.setBounds(70, 320, 20, 20);
        tierraExelente.setBounds(70, 350, 20, 20);
        panelMenu.add(tierraMala);
        panelMenu.add(tierraBuena);
        panelMenu.add(tierraExelente);
        //añadir info
        JLabel lbltierraMala = new JLabel("Tierra mala");
        JLabel lbltierraBuena = new JLabel("Tierra buena");
        JLabel lbltierraExelente = new JLabel("Tierra excelente");
        lbltierraMala.setBounds(100, 290, 120, 20);
        lbltierraBuena.setBounds(100, 320, 120, 20);
        lbltierraExelente.setBounds(100, 350, 120, 20);
        panelMenu.add(lbltierraMala);
        panelMenu.add(lbltierraBuena);
        panelMenu.add(lbltierraExelente);
    }

    private void creaTerreno() {
        panelTerreno = new JPanel();
        panelTerreno.setBounds(50, 30, 1000, 650);
        hectareas = new Hectarea[100];
        panelTerreno.setLayout(new GridLayout(10, 10, 2, 2));
        panelTerreno.setBackground(new Color(99, 99, 99));

        for (int i = 0; i < hectareas.length; i++) {
            hectareas[i] = new Hectarea(Rutinas.nextInt(1, 3));
        }
        for (int i = 0; i < hectareas.length; i++) {
            panelTerreno.add(hectareas[i]);
        }

        add(panelTerreno);
    }

    public void mostraHectareas(int hermano) {
        if (hermano == 0) {
            for (int i = 0; i < hectareas.length; i++) {
                hectareas[i].setVisible(true);
            }
            return;
        }
        for (int i = 0; i < hectareas.length; i++) {
            if (hectareas[i].getHermano() != hermano) {
                hectareas[i].setVisible(false);
                continue;
            }
            hectareas[i].setVisible(true);
        }
    }
}
