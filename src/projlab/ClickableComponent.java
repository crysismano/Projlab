package projlab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ClickableComponent extends JComponent {
	protected MouseAdapter mouseListener;

	public ClickableComponent(){
		mouseListener = new ComponentMouseListener(this);
	}

	public abstract void clicked();

	private class ComponentMouseListener extends MouseAdapter {
		//	A kattintás megfelelő kezelését biztosító osztály.
		boolean in_component = false;
		ClickableComponent owner;

		public ComponentMouseListener(ClickableComponent owner){
			this.owner = owner;
		}

		public void mouseEntered(MouseEvent e){
			in_component = true;
		}

		public void mouseExited(MouseEvent e){
			in_component = false;
		}

		public void mouseClicked(MouseEvent e){
			owner.clicked();
		}
	}
}
