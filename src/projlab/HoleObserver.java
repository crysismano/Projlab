package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HoleObserver extends ClickableComponent implements Observer {
	
	Hole observed;
	private BufferedImage bi;
	
	public HoleObserver(){
		super();
		try {
			bi = ImageIO.read(new File("img/hole.png"));
		}
		catch(IOException e) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bi, 0, 0, this);
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
