package Logic.Obstacle;

import Logic.Map.*;

public abstract class Obstacle extends Element{
	
	public Obstacle(int posx, int posy, Map map){
		super(map, posx, posy);
	}
}