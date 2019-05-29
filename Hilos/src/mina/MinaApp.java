package mina;

public class MinaApp {
	public static void main(String[] args) {
		MinaVta v = new MinaVta();
		MinaMdl m = new MinaMdl();
		MinaCtd c = new MinaCtd(v, m);
	}
}
