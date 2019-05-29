package mina;

import java.util.Vector;

public class MinaMdl {

    private Vector<Vector<String>> infoPaises;

    public Vector<Vector<String>> obtenerInfoPaises(Pais[] paisesEuropa, Pais[] paisesAsia) {
        infoPaises = new Vector<Vector<String>>();
        Pais paises[] = concatenarPaises(paisesEuropa, paisesAsia);
        for (int i = 0; i < paises.length; i++) {
            infoPaises.add(paises[i].getVectorInfo());
        }

        return infoPaises;
    }

    private Pais[] concatenarPaises(Pais[] paisesEuropa, Pais[] paisesAsia) {
        Pais paises[] = new Pais[paisesEuropa.length + paisesAsia.length];
        int i = 0;
        for (i = 0; i < paisesAsia.length; i++) {
            paises[i] = paisesAsia[i];
        }
        for (int a = 0; a < paisesEuropa.length; a++, i++) {
            paises[i] = paisesEuropa[a];
        }

        return paises;
    }
}
