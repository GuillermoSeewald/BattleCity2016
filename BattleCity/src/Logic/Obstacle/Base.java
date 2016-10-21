package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;
import javax.swing.ImageIcon;

public class Base extends Obstacle{
	
	protected boolean destroyed;
	protected GraphicBase graphic;
	
	public Base(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicBase(x,y,"Bandera1");
		destroyed=false;
	}
	
	public boolean itsDestroyed(){
		return destroyed;
	}
	protected int kill(){
		graphic.setImage(new ImageIcon("Imagenes/Bandera2.png").getImage());
		destroyed=true;
		return 1;
	}
	public GraphicBase getGraphic(){
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