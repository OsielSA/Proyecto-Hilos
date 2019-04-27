package terrenoAgricolaE;

public class TerrenoAgricolaApl {

	private TerrenoAgricolaApl(){
		TerrenoAgricolaView view = new TerrenoAgricolaView();
		TerrenoAgricolaController controller = new TerrenoAgricolaController(view);
		view.setController(controller);
	}
	
	public static void main(String[] args) {
		new TerrenoAgricolaApl();
	}

}
