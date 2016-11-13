package Logic.Shot;

import Logic.Map.*;

public abstract class Shot extends Element{
	
	protected int speed;
	
	public Shot(Map map, int speed, int posx, int posy){
		super(map, posx, posy);
		this.speed=speed;
	}
	public int getSpeed(){
		return speed;
	}
}