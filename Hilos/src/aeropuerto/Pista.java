package aeropuerto;

public class Pista {

    private boolean disponible;
    private Semaforo semaforo;

    public Pista() {
        disponible = true;
        semaforo = new Semaforo(1);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }
}
