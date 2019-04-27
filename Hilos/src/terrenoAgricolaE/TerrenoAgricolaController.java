package terrenoAgricolaE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerrenoAgricolaController implements ActionListener{

	TerrenoAgricolaView view;
	
	public TerrenoAgricolaController(TerrenoAgricolaView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ASDFG");
		view.start();
	}

}
