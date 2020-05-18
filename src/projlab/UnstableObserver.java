package projlab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UnstableObserver extends ClickableComponent implements Observer {
	Unstable observed;

	public UnstableObserver(){
		super();
	}

	@Override
	public void Update(Observable o) {
		observed = (Unstable) o;
		// TODO Auto-generated method stub
	}

	@Override
	public void clicked() {
		//TODO
	}
}
