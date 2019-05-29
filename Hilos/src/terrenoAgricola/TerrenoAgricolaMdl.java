package terrenoAgricola;

public class TerrenoAgricolaMdl {

    private Hermano hermano1;
    private Hermano hermano2;
    private Hermano hermano3;

    public void Repartir(Hectarea[] hectareas) {
        hermano1 = new Hermano(hectareas, 1);
        hermano2 = new Hermano(hectareas, 2);
        hermano3 = new Hermano(hectareas, 3);

        hermano1.start();
        hermano2.start();
        hermano3.start();
        
//        while (hermano1.isAlive() || hermano2.isAlive() || hermano3.isAlive());
    }
    
    public Hermano getHermano(int numeroHermano) {
        switch (numeroHermano) {
            case 1:
                return hermano1;
            case 2:
                return hermano2;
            case 3:
                return hermano3;
            default:
                return null;
        }
    }
}
