package mina;

import java.util.Vector;

public class Mina {
	public int[] mineralesEuropa;
	public int[] mineralesAsia;
	public Mina() {
		cargarMinerales();
	}
	private void cargarMinerales() {
		mineralesEuropa = new int[3];
		mineralesAsia = new int[3];
		
		int	mineralesTotales = Rutinas.nextInt(10000, 20000); 
		int mineralesTipo1 = (int) (mineralesTotales * 0.30);
		int mineralesTipo2 = (int) (mineralesTotales * 0.60);
		int mineralesTipo3 = (int) mineralesTotales - (mineralesTipo1 + mineralesTipo2);
				
		mineralesEuropa[0] = (int) mineralesTipo1/2;
		mineralesEuropa[1] = (int) mineralesTipo2/2;
		mineralesEuropa[2] = (int) mineralesTipo3/2;
		
		mineralesAsia[0] = (int) mineralesTipo1/2;
		mineralesAsia[1] = (int) mineralesTipo2/2;
		mineralesAsia[2] = (int) mineralesTipo3/2;
		System.out.println(mineralesTipo1);
		System.out.println(mineralesTipo2);
		System.out.println(mineralesTipo3);
		System.out.println("------------------------------");
		for(int i=0;i<mineralesEuropa.length;i++) {
			System.out.println(mineralesEuropa[i]);
		}
		System.out.println("------------------------------");
		for(int i=0;i<mineralesEuropa.length;i++) {
			System.out.println(mineralesAsia[i]);
		}
		
	}
	
}
