package Logic.Obstacle;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.Obstacle.*;
import javax.swing.ImageIcon;

public class Base extends Obstacle{
	
	protected boolean destroyed;
	protected GraphicBase graphic;
	protected Obstacle[] wall;
	protected Base startBase;
	
	public Base(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicBase(x,y,"Bandera1");
		destroyed=false;
		wall= new Wall[5];
	}
	public void setWall(Obstacle[] w){
		wall=w;
	}	
	public boolean itsDestroyed(){
		return destroyed;
	}
	protected int kill(){
		if(!map.getWin()){
			graphic.setImage(new ImageIcon("Imagenes/Bandera2.png").getImage());
			destroyed=true;
			map.gameOver();
		}
		return 1;
	}
	public void setObstacleInWall(Obstacle o, int pos){
		wall[pos]=o;
		map.setObstacle(o, o.getPosX(), o.getPosY());
	}
	public Obstacle[] getWall(){
		return wall;
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