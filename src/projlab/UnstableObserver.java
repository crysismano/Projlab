package projlab;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UnstableObserver extends ClickableComponent{
	Unstable observed;
	private BufferedImage fieldImage;
	private BufferedImage flippedImage;
	private BufferedImage snowImage;
	private BufferedImage drowningImage;
	private BufferedImage itemImage;
	private BufferedImage eskimoImage;
	private BufferedImage explorerImage;
	private BufferedImage polarbearImage;
	private BufferedImage iglooImage;
	private BufferedImage tentImage;
	
	public UnstableObserver(){
		super();
		try {
			fieldImage = ImageIO.read(new File("img/field.png"));
			flippedImage = ImageIO.read(new File("img/flipped.png"));
			snowImage = ImageIO.read(new File("img/snow.png"));
			drowningImage = ImageIO.read(new File("img/drowning.png"));
			itemImage = ImageIO.read(new File("img/item.png"));
			eskimoImage = ImageIO.read(new File("img/eskimo.png"));
			explorerImage = ImageIO.read(new File("img/explorer.png"));
			polarbearImage = ImageIO.read(new File("img/polarbear.png"));
			iglooImage = ImageIO.read(new File("img/igloo.png"));
			tentImage = ImageIO.read(new File("img/tent.png"));
		}
		catch(IOException e) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if(observed.IsFlipped())
			g.drawImage(flippedImage, 0, 0, this);
		else
			g.drawImage(fieldImage, 0, 0, this);
		
		if(observed.GetItem() != null)
			g.drawImage(itemImage, 0, 0, this);
		
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
			else if(c instanceof Explorer) {
				Explorer ex = (Explorer)c;
				if(ex.GetDrowning() > 0) {
					g.drawImage(drowningImage, 0, 0, this);
				}
				else
					g.drawImage(explorerImage, 0, 0, this);
			}
			else if(c instanceof PolarBear) {
				g.drawImage(polarbearImage, 0, 0, this);
			}
				
		}
		Igloo cover = observed.GetIgloo();
		if(cover != null) {
			if(cover instanceof Tent)
				g.drawImage(tentImage, 0, 0, this);
			else
				g.drawImage(iglooImage, 0, 0, this);
		}
		super.repaint();
	}

	@Override
	public void Update(Observable o) {
		observed = (Unstable) o;
		// TODO Auto-generated method stub
	}

	@Override
	public void clicked() {
		System.out.println("Unstable vagyok, klikkeltél rajtam");
		System.out.println(observed.GetSnow());
	}
}
