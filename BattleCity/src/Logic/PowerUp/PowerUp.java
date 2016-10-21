package Logic.PowerUp;

import Logic.Obstacle.*;
import Logic.Map.*;

public abstract class PowerUp extends Obstacle{
	public PowerUp(int posX, int posY, Map map){
		super(posX, posY, map);
	}
}