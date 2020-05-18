package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HoleObserver extends ClickableComponent {
	
	Hole observed;
	private BufferedImage holeImage;
	private BufferedImage snowImage;
	private BufferedImage drowningImage;
	private BufferedImage eskimoImage;
	private BufferedImage explorerImage;
	private BufferedImage polarbearImage;
	
	public HoleObserver(){
		super();
		try {
			holeImage = ImageIO.read(new File("img/hole.png"));
			snowImage = ImageIO.read(new File("img/snow.png"));
			drowningImage = ImageIO.read(new File("img/drowning.png"));
			eskimoImage = ImageIO.read(new File("img/eskimo.png"));
			explorerImage = ImageIO.read(new File("img/explorer.png"));
			polarbearImage = ImageIO.read(new File("img/polarbear.png"));
		}
		catch(IOException e) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(holeImage, 0, 0, this);
		
		if(observed.GetSnow() > 0)
			g.drawImage(snowImage, 0, 0, this);
		
		for(int i = 0; i < observed.GetCharacters().size(); i++) {
			Character c = observed.GetCharacters().get(i);
			if(c instanceof Eskimo) {
				Eskimo e = (Eskimo)c;
				if(e.GetDrowning() > 0) {
					g.drawImage(drowningImage, 0, 0, this);
				}
				else
					g.drawImage(eskimoImage, 0, 0, this);
			}
			if(c instanceof Explorer) {
				Explorer ex = (Explorer)c;
				if(ex.GetDrowning() > 0) {
					g.drawImage(drowningImage, 0, 0, this);
				}
				else
					g.drawImage(explorerImage, 0, 0, this);
			}
			if(c instanceof PolarBear) {
				g.drawImage(polarbearImage, 0, 0, this);
			}
				
		}
		super.repaint();
	}

	@Override
	public void Update(Observable o) {
		observed = (Hole) o;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clicked() {
		System.out.println("Hole vagyok, klikkeltél rajtam");
		System.out.println(observed.GetSnow());
	}
}
