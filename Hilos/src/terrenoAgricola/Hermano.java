package terrenoAgricola;

public class Hermano extends Thread {

    private Hectarea hectareas[];
    public int id;
    private int contadorHectareas;

    public Hermano(Hectarea hectareas[], int id) {
        this.hectareas = hectareas;
        this.id = id;
        this.contadorHectareas = 0;
    }

    @Override
    public void run() {
        int noHectarea;
        while (hectareasLibres()) {
            noHectarea = Rutinas.nextInt(0, 99);
            hectareas[noHectarea].getSemaforo().Espera();

            if (hectareas[noHectarea].isOcupada()) {
                hectareas[noHectarea].getSemaforo().Libera();
                continue;
            }
            contadorHectareas++;
            hectareas[noHectarea].setHermano(id);
            hectareas[noHectarea].getSemaforo().Libera();
        }
    }

    public boolean hectareasLibres() {
        //true = hay hectareas libres
        for (int i = 0; i < hectareas.length; i++) {
            if (!hectareas[i].isOcupada()) {
                return true;
            }
        }
        return false;
    }

    public int getContadorHectareas() {
        return contadorHectareas;
    }

}
