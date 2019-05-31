package mina;

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
        	
            tipo = Rutinas.nextInt(0, 2);
            cantidad = Rutinas.nextInt(50, 100);
            //Europa
            if (continente == 1) {
                if (mina.isMinandoEu(tipo)) {
                    continue;
                }
                
                mina.getSemaforoEuropa(tipo).Espera();
                mina.setMinandoEu(true, tipo);
                
                if(!mina.hayDisponibles(continente)) {
                	v.btnConsulta.setEnabled(true);
                	return;
                }
                	
                if(!mina.hayDisponibles(continente, tipo))
                	continue;
                v.lblPaisEuropa[tipo].setIcon(paisImagen);
                //Minar
//                solicitud = "<html><center>Tipo: " + tipo + "<p>Cantidad: " + cantidad + "</center></html>";
//                v.lblSolicitudEu.setText(solicitud);
                
                minerales[tipo] += mina.solicitarMinerales(continente, tipo, cantidad);
                v.actualizar(continente, tipo);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
                
                v.lblPaisEuropa[tipo].setIcon(paisDefault);
                mina.setMinandoEu(false, tipo);
                mina.getSemaforoEuropa(tipo).Libera();
           
            }
            //Asia
            if(continente == 2) {
            	if (mina.isMinandoAs(tipo)) {
                    continue;
                }
                mina.getSemaforoAsia(tipo).Espera();
                mina.setMinandoAs(true, tipo);
                
                if(!mina.hayDisponibles(continente)) 
                	return;
                
                if(!mina.hayDisponibles(continente, tipo))
                	continue;
                v.lblPaisAsia[tipo].setIcon(paisImagen);
                //Minar
//                solicitud = "<html><center>Tipo: " + tipo + "<p>Cantidad: " + cantidad + "</center></html>";
//                v.lblSolicitudEu.setText(solicitud);
                
                minerales[tipo] += mina.solicitarMinerales(continente, tipo, cantidad);
                v.actualizar(continente, tipo);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
                
                v.lblPaisAsia[tipo].setIcon(paisDefault);
                mina.setMinandoAs(false, tipo);
                mina.getSemaforoAsia(tipo).Libera();
               
            }
            }
            
    }

    private void asignaIcono() {
        if (continente == 1) {
            paisImagen = Rutinas.changeSize(ruta + "europaP" + id + ".png", 180, 130);
            paisDefault = Rutinas.changeSize(ruta + "europaP" + 0 + ".png", 180, 130);
            return;
        }
        paisImagen = Rutinas.changeSize(ruta + "asiaP" + id + ".png", 250, 170);
        paisDefault = Rutinas.changeSize(ruta + "asiaP" + 0 + ".png", 250, 170);
        
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
