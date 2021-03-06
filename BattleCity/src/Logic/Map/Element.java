package Logic.Map;

import Logic.Tank.*;
import Graphic.Map.*;

public abstract class Element{
	
	protected Map map;
	protected int posX;
	protected int posY;
	
	public Element(Map map, int posx, int posy){
		this.map=map;
		posX=posx;
		posY=posy;
	}
	//X de matriz
	public int getPosX(){
		return posX;
	}
	//Y de matriz
	public int getPosY(){
		return posY;
	}
	public abstract GraphicElement getGraphic();
	protected abstract int kill();
	public abstract int kill(Player pla);
	public abstract int kill(Enemy ene);
	public abstract boolean collide(Player jug);
	public abstract boolean collide(Enemy ene);
}