package minaOld;

import java.util.Vector;

public class MinaMdl {

    private Vector<Vector<String>> infoPaises;

    public Vector<Vector<String>> obtenerInfoPaises(Pais[] paisesEuropa, Pais[] paisesAsia) {
        infoPaises = new Vector<Vector<String>>();
        
        for (int i = 0; i < paisesAsia.length; i++) 
            infoPaises.add(paisesAsia[i].getVectorInfo());
        
        for (int i = 0; i < paisesEuropa.length; i++) 
            infoPaises.add(paisesEuropa[i].getVectorInfo());

        return infoPaises;
    }
    
}
