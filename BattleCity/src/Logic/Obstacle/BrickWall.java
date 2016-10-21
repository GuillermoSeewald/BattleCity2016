package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;

public class BrickWall extends Wall{
	
	protected GraphicBrickWall graphic;
	
	public BrickWall(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicBrickWall(x,y,"Ladrillo");
	}
	
	protected int kill(){
		map.deleteObstacle(posX, posY);
		return 1;
	}
	public GraphicBrickWall getGraphic(){
		return graphic;
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