package minaOld;

import java.util.Vector;

import javax.swing.ImageIcon;
import utils.*;
public class Pais extends Thread {

    private final String ruta = ".\\src\\mina\\images\\";

    public int continente;//1 = Europa ; 2 = Asia
    public int id;
    private ImageIcon paisImagen;
    private ImageIcon paisDefault;
    private MinaVta v;
    public int[] minerales;
    private Vector<String> info;

    public Pais(int continente, int id, MinaVta vista) {
        this.continente = continente;
        this.id = id;
        this.v = vista;
        minerales = new int[3];
        info = new Vector<String>();
        asignaIcono();

    }

    @Override
    public void run() {
        int tipo, cantidad;
        String solicitud;
        Mina mina = v.getMina();
        while (true) {
        	
            tipo = Rutinas.nextInt(1, 3);
//			cantidad = Rutinas.nextInt(1, 3);
            cantidad = Rutinas.nextInt(100, 200);
            if (continente == 1) {
                if (mina.isMinandoEu()) {
                    continue;
                }

                mina.setMinandoEu(true);
                mina.semaforoEuropa.Espera();
                v.lblPaisEuropa.setIcon(paisImagen);
                //Minar
                solicitud = "<html><center>Tipo: " + tipo + "<p>Cantidad: " + cantidad + "</center></html>";
                v.lblSolicitudEu.setText(solicitud);
                minerales[tipo - 1] += mina.solicitarMinerales(continente, tipo, cantidad);
                v.actualizar(continente);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
                
                v.lblPaisEuropa.setIcon(paisDefault);
                if (!mina.hayDisponibles(continente)) {
                    v.btnConsulta.setEnabled(true);
                    return;
                }
                mina.setMinandoEu(false);
                mina.semaforoEuropa.Libera();
                
//                continue;
            }
            if (continente == 2) {
            	
            	if (mina.isMinandoAs()) {
            		continue;
            	}

            	mina.setMinandoAs(true);
            	mina.semaforoAsia.Espera();
            	v.lblPaisAsia.setIcon(paisImagen);
            	//Minar
            	solicitud = "<html><center>Tipo: " + tipo + "<p>Cantidad: " + cantidad + "</center></html>";
            	v.lblSolicitudAs.setText(solicitud);
            	minerales[tipo - 1] += mina.solicitarMinerales(continente, tipo, cantidad);
            	v.actualizar(continente);
            	try {
            		sleep(1000);
            	} catch (Exception e) {
            	}
            	
            	v.lblPaisAsia.setIcon(paisDefault);
            	if (!mina.hayDisponibles(continente)) {
            		return;
            	}
            	mina.setMinandoAs(false);
            	mina.semaforoAsia.Libera();
            	

            }
           
        }
    }

    private void asignaIcono() {
        if (continente == 1) {
            paisImagen = Rutinas.changeSize(ruta + "europaP" + id + ".png", 200, 150);
            paisDefault = Rutinas.changeSize(ruta + "europaP" + 0 + ".png", 200, 150);
            return;
        }
        paisImagen = Rutinas.changeSize(ruta + "asiaP" + id + ".png", 300, 200);
        paisDefault = Rutinas.changeSize(ruta + "asiaP" + 0 + ".png", 300, 200);
        
    }

    public Vector<String> getVectorInfo() {
        if (continente == 1) {
            info.add("Europa " + id);
        }
        if (continente == 2) {
            info.add("Asia " + id);
        }
        info.add("" + minerales[0]);
        info.add("" + minerales[1]);
        info.add("" + minerales[2]);
        return info;
    }
}
