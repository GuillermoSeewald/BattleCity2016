package Logic.Obstacle;

import Logic.Map.*;

public abstract class Wall extends Obstacle{
	
	protected int resistance;
	
	public Wall(int posX, int posY, Map map){
		super(posX, posY, map);
	}
}