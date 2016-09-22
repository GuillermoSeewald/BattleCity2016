package PowerUp;

import Obstaculo.*;
import Mapa.*;

public abstract class PowerUp extends Obstacle{
	public PowerUp(String nom, int x, int y, int posX, int posY, Map map){
		super(nom, x, y, posX, posY, map);
	}
}