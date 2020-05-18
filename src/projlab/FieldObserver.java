package projlab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FieldObserver extends ClickableComponent implements Observer {
	Field observed;

	public FieldObserver(){
		super();
	}

	@Override
	public void Update(Observable o) {
		observed = (Field) o;
		// TODO Auto-generated method stub
	}

	@Override
	public void clicked() {
		//TODO
	}
}
