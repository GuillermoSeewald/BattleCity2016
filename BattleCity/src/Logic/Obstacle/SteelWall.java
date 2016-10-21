package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;

public class SteelWall extends Wall{
	
	protected GraphicSteelWall graphic;
	
	public SteelWall(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicSteelWall(x,y,"Acero");
	}

	public GraphicSteelWall getGraphic(){
		return graphic;
	}
	protected int kill(){
		return 1;
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