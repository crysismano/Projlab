package projlab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ClickableComponent extends JComponent implements Observer {
	protected MouseAdapter mouseListener;

	protected InfoFrame infoFrame;
	
	public void SetInfoFrame(InfoFrame f) {
		infoFrame = f;
		
	}

	public ClickableComponent(){
		mouseListener = new ComponentMouseListener(this);
		this.addMouseListener(mouseListener);
	}
	

	public abstract void clicked();

	private class ComponentMouseListener extends MouseAdapter {
		boolean in_component = false;
		ClickableComponent owner;

		public ComponentMouseListener(ClickableComponent owner){
			this.owner = owner;
		}
		@Override
		public void mouseEntered(MouseEvent e){
			in_component = true;
		}
		@Override
		public void mouseExited(MouseEvent e){
			in_component = false;
		}
		@Override
		public void mousePressed(MouseEvent e){
			if(in_component) {
				owner.clicked();
			}
		}
	}
}
