package projlab;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

public class MapWindow extends JFrame {
	
	JPanel p1;
	ArrayList<ClickableComponent> map = new ArrayList<ClickableComponent>();
	
	public MapWindow(InfoFrame infoFrame) {

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
				ho.SetInfoFrame(infoFrame);
			}
			else
			if(i == 5 || i == 7 || i == 21 || i == 30 || i == 35) {
				UnstableObserver uo = new UnstableObserver();
				map.add(uo);
				p1.add(uo);
				uo.SetInfoFrame(infoFrame);
			}
			else {
				FieldObserver fo = new FieldObserver();
				map.add(fo);
				p1.add(fo);
				fo.SetInfoFrame(infoFrame);
			}
			map.get(i).SetInfoFrame(infoFrame);
		}
		
		
		
		this.add(p1);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void WinMessage() {
		JOptionPane.showMessageDialog(this,"YOU WIN");
		Controller.ResetGame();
	}
	
	public void GameOverMessage() {
		JOptionPane.showMessageDialog(this,"YOU LOSE");
		Controller.ResetGame();
	}
	
	public ClickableComponent GetClickableComponent(int idx) {
		return map.get(idx);
	}
}
