package projlab;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

public class MapWindow extends JFrame {
	
	JPanel p1;
	ArrayList<ClickableComponent> map = new ArrayList<ClickableComponent>();
	InfoFrame infoFrame = new InfoFrame();
	
	public MapWindow() {

		super("Map");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900,900);
		
		GridLayout gl = new GridLayout();
		gl.setColumns(6);
		gl.setRows(6);
		p1 = new JPanel(gl);
		
		for(int i = 0; i < 36; i++) {
			if(i == 2 || i == 3 || i == 14 || i == 18) {
				HoleObserver ho = new HoleObserver();
				map.add(ho);
				p1.add(ho);
			}
			else
			if(i == 5 || i == 7 || i == 21 || i == 30 || i == 35) {
				UnstableObserver uo = new UnstableObserver();
				map.add(uo);
				p1.add(uo);
			}
			else {
				FieldObserver fo = new FieldObserver();
				map.add(fo);
				p1.add(fo);
			}
			map.get(i).SetInfoFrame(infoFrame);
		}
		
		
		
		this.add(p1);
		this.setVisible(true);
		this.setResizable(false);
	}
}
