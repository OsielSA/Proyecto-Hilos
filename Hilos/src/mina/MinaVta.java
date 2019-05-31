package mina;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import utils.*;
public class MinaVta extends JFrame {

    private final String ruta = ".\\src\\mina\\images\\";
    public final ImageIcon imgDefaultEu = Rutinas.changeSize(ruta + "europaP0.png", 180, 130);
    public final ImageIcon imgDefaultAs = Rutinas.changeSize(ruta + "asiaP0.png", 250, 170);
    public JFrame frameConsulta;
    private JTable tableInfoPaises;
    //info
    private JLabel lblInfoEuropa[];
    private JLabel lblInfoAsia[];
    public JLabel lblSolicitudEu[];
    public JLabel lblSolicitudAs[];
    //Titulos
    private JLabel lblTituloTipoR;
    private JLabel lblTituloTipoB;
    private JLabel lblTituloTipoE;
    //Paises
    public JLabel lblPaisEuropa[];
    public JLabel lblPaisAsia[];
    
    public JButton btnIniciar;
    public JButton btnConsulta;

    private Mina mina;

    private Pais[] paisesEuropa;
    private Pais[] paisesAsia;

    public MinaVta() {
        super("Mina");
        mina = new Mina();
        createInterface();
        createInterfaceConsulta();
    }

    private void createInterface() {
        setSize(1300, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(215, 253, 169));
//		----------------------------

        cargarInfoMina();
        cargarPaises();
//		----------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createInterfaceConsulta() {
        frameConsulta = new JFrame("Información");
        frameConsulta.setSize(400, 500);
        frameConsulta.setResizable(false);
        frameConsulta.setLocationRelativeTo(null);

    }

    public void crearTabla(Vector<Vector<String>> infoPaises) {
        // Titulos
        Vector<String> titulos = new Vector<String>();
        titulos.add("País");
        titulos.add("Peticiones");
        titulos.add("Regular");
        titulos.add("Buena");
        titulos.add("Excelente");
        tableInfoPaises = new JTable(infoPaises, titulos);

        frameConsulta.add(new JScrollPane(tableInfoPaises));
    }

    private void cargarInfoMina() {
    	lblInfoEuropa = new JLabel[3];
    	lblInfoAsia = new JLabel[3];
    	
        //info Regular
    	lblInfoEuropa[0] = new JLabel("Cantidad Europa: " + mina.mineralesEuropa[0]);
    	lblInfoEuropa[0].setBounds(330, 120, 130, 30);
        add(lblInfoEuropa[0]);

        lblInfoAsia[0] = new JLabel("Cantidad Asia: " + mina.mineralesAsia[0]);
        lblInfoAsia[0].setBounds(330, 140, 120, 30);
        add(lblInfoAsia[0]);

        //info Buena
        lblInfoEuropa[1] = new JLabel("Cantidad Europa: " + mina.mineralesEuropa[1]);
        lblInfoEuropa[1].setBounds(330, 240, 130, 30);
        add(lblInfoEuropa[1]);

        lblInfoAsia[1] = new JLabel("Cantidad Asia: " + mina.mineralesAsia[1]);
        lblInfoAsia[1].setBounds(330, 260, 120, 30);
        add(lblInfoAsia[1]);

        //info Exelente
        lblInfoEuropa[2] = new JLabel("Cantidad Europa: " + mina.mineralesEuropa[2]);
        lblInfoEuropa[2].setBounds(330, 360, 130, 30);
        add(lblInfoEuropa[2]);

        lblInfoAsia[2] = new JLabel("Cantidad Asia: " + mina.mineralesAsia[2]);
        lblInfoAsia[2].setBounds(330, 380, 120, 30);
        add(lblInfoAsia[2]);

        //Mina
        JLabel infoMina = new JLabel();
        infoMina.setIcon(Rutinas.changeSize(ruta + "infoMina.png", 500, 350));
        infoMina.setBounds(10, 80, 500, 350);
        add(infoMina);
        
        //Boton Iniciar
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(780, 530, 90, 20);
        add(btnIniciar);
        //Boton Consulta
        btnConsulta = new JButton("Consulta");
        btnConsulta.setBounds(980, 530, 90, 20);
        btnConsulta.setEnabled(false);
        add(btnConsulta);
        
        //Titulos
        lblTituloTipoR = new JLabel("Regular");
        lblTituloTipoR.setForeground(new Color(101, 101, 101));
        lblTituloTipoR.setBounds(630, 30, 80, 30);
        lblTituloTipoR.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTituloTipoR);
        lblTituloTipoB = new JLabel("Buena");
        lblTituloTipoB.setForeground(new Color(101, 101, 101));
        lblTituloTipoB.setBounds(890, 30, 80, 30);
        lblTituloTipoB.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTituloTipoB);
        lblTituloTipoE = new JLabel("Excelente");
        lblTituloTipoE.setForeground(new Color(101, 101, 101));
        lblTituloTipoE.setBounds(1150, 30, 95, 30);
        lblTituloTipoE.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTituloTipoE);
    }

    private void cargarPaises() {
    	//Imagenes de Europa
        lblPaisEuropa = new JLabel[3];
        lblPaisEuropa[0] = new JLabel();
        lblPaisEuropa[0].setIcon(imgDefaultEu);
        lblPaisEuropa[0].setBounds(570, 80, 180, 130);
        add(lblPaisEuropa[0]);
        lblPaisEuropa[1] = new JLabel();
        lblPaisEuropa[1].setIcon(imgDefaultEu);
        lblPaisEuropa[1].setBounds(820, 80, 180, 130);
        add(lblPaisEuropa[1]);
        lblPaisEuropa[2] = new JLabel();
        lblPaisEuropa[2].setIcon(imgDefaultEu);
        lblPaisEuropa[2].setBounds(1070, 80, 180, 130);
        add(lblPaisEuropa[2]);
        //Labels de solicitud de Europa
        lblSolicitudEu = new JLabel[3];
        lblSolicitudEu[0] = new JLabel();
        lblSolicitudEu[0].setForeground(new Color(101, 101, 101));
        lblSolicitudEu[0].setBounds(630, 200, 100, 50);
        add(lblSolicitudEu[0]);
        lblSolicitudEu[1] = new JLabel();
        lblSolicitudEu[1].setForeground(new Color(101, 101, 101));
        lblSolicitudEu[1].setBounds(890, 200, 100, 50);
        add(lblSolicitudEu[1]);
        lblSolicitudEu[2] = new JLabel();
        lblSolicitudEu[2].setForeground(new Color(101, 101, 101));
        lblSolicitudEu[2].setBounds(1150, 200, 100, 50);
        add(lblSolicitudEu[2]);
        
        //Imagenes de Asia
        lblPaisAsia = new JLabel[3];
        lblPaisAsia[0] = new JLabel();
        lblPaisAsia[0].setIcon(imgDefaultAs);
        lblPaisAsia[0].setBounds(530, 300, 250, 170);
        add(lblPaisAsia[0]);
        lblPaisAsia[1] = new JLabel();
        lblPaisAsia[1].setIcon(imgDefaultAs);
        lblPaisAsia[1].setBounds(780, 300, 250, 170);
        add(lblPaisAsia[1]);
        lblPaisAsia[2] = new JLabel();
        lblPaisAsia[2].setIcon(imgDefaultAs);
        lblPaisAsia[2].setBounds(1030, 300, 250, 170);
        add(lblPaisAsia[2]);
        //Labels de solicitud de Asia
        lblSolicitudAs = new JLabel[3];
        lblSolicitudAs[0] = new JLabel();
        lblSolicitudAs[0].setForeground(new Color(101, 101, 101));
        lblSolicitudAs[0].setBounds(630, 460, 100, 50);
        add(lblSolicitudAs[0]);
        lblSolicitudAs[1] = new JLabel();
        lblSolicitudAs[1].setForeground(new Color(101, 101, 101));
        lblSolicitudAs[1].setBounds(890, 460, 100, 50);
        add(lblSolicitudAs[1]);
        lblSolicitudAs[2] = new JLabel();
        lblSolicitudAs[2].setForeground(new Color(101, 101, 101));
        lblSolicitudAs[2].setBounds(1150, 460, 100, 50);
        add(lblSolicitudAs[2]);

        //Inicializar Paises
        paisesEuropa = new Pais[Rutinas.nextInt(10, 30)];
        paisesAsia = new Pais[Rutinas.nextInt(5, 7)];
        for (int i = 0; i < paisesEuropa.length; i++) {
            paisesEuropa[i] = new Pais(1, (i + 1), this);
        }
        for (int i = 0; i < paisesAsia.length; i++) {
            paisesAsia[i] = new Pais(2, (i + 1), this);
        }
    }

    public void iniciar() {
        for (int i = 0; i < paisesEuropa.length; i++) {
            paisesEuropa[i].start();
        }
        for (int i = 0; i < paisesAsia.length; i++) {
            paisesAsia[i].start();
        }
    }

    public void actualizar(int continente, int tipo) {
        if (continente == 1) {
            lblInfoEuropa[tipo].setText("Cantidad Europa: " + mina.mineralesEuropa[tipo]);
            return;
        }
        //info Regular
        lblInfoAsia[tipo].setText("Cantidad Asia: " + mina.mineralesAsia[tipo]);
    }

    public Mina getMina() {
        return mina;
    }

    public Pais[] getPaisesEuropa() {
        return paisesEuropa;
    }

    public Pais[] getPaisesAsia() {
        return paisesAsia;
    }
}
