package projlab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoleObserver extends ClickableComponent implements Observer {
	Hole observed;

	public HoleObserver(){
		super();
	}

	@Override
	public void Update(Observable o) {
		observed = (Hole) o;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clicked() {
		//TODO
	}
}
