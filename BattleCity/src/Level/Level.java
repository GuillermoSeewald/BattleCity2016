package Level;

import java.awt.Image;

public abstract class Level{
	protected int speedShot;
	protected Image[][] images;
	
	public abstract int getSpeedShot();

	public Image getImage(int x, int y){
		return images[x][y];
	}
}