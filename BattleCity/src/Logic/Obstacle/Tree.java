package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;

public class Tree extends Obstacle{
	
	protected GraphicTree graphic;
	
	public Tree(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicTree(x,y,"Arbol");
	}
	public GraphicTree getGraphic(){
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
		return false;
	}
	public boolean collide(Enemy ene){
		return false;
	}
}