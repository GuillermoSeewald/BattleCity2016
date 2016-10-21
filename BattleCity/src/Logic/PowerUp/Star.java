package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.PowerUp.*;

public class Star extends PowerUp{
	
	protected GraphicStar graphic;
	
	public Star(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicStar(x,y,"Star");
	}
	public GraphicStar getGraphic(){
		return graphic;
	}
	
	protected int kill(){
		map.deleteObstacle(posX, posY);
		return 0;
	}
	public int kill(Player pla){
		return 0;
	}
	public int kill(Enemy ene){
		return 0;
	}
/*	public boolean collide(Player pla){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}