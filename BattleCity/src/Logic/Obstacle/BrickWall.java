package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;

public class BrickWall extends Wall{
	
	protected GraphicBrickWall graphic;
	
	public BrickWall(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		resistance=4;
		graphic= new GraphicBrickWall(x,y,"Ladrillo");
	}
	
	protected int kill(){
		if(resistance==1){
			map.deleteObstacle(posX, posY);
		}
		else{
			resistance--;
		}
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