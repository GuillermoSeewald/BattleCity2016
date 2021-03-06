package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;

public class Water extends Obstacle{
	
	protected GraphicWater graphic;
	
	public Water(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicWater(x,y,"Agua");
	}
	public GraphicWater getGraphic(){
		return graphic;
	}
	
	protected int kill(){
		return 0;
	}
	public int kill(Player pla){
		return kill();
	}
	public int kill(Enemy ene){
		return kill();
	}
	public boolean collide(Player pla){
		return true;	
	}
	public boolean collide(Enemy ene){
		return true;		
	}
}