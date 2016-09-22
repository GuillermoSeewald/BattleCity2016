package PowerUp;

import Obstaculo.*;

public abstract class PowerUp extends Obstacle{
	public PowerUp(String nom, int x, int y, int posX, int posY){
		super(nom, x, y, posX, posY);
	}
}