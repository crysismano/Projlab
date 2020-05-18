package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FieldObserver extends ClickableComponent implements Observer {
	
	private Field observed;
	private BufferedImage bi;
	
	public FieldObserver(){
		super();
		try {
			bi = ImageIO.read(new File("img/field.png"));
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
		observed = (Field) o;
		// TODO Auto-generated method stub
	}

	@Override
	public void clicked() {
		//TODO
	}
}
