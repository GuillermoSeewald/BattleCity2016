package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Logic.Level.*;
import Graphic.PowerUp.*;

public class Star extends PowerUp implements Runnable{
	
	private GraphicStar graphic;
	
	public Star(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicStar(x,y,"Estrella");
	}
	public GraphicStar getGraphic(){
		return graphic;
	}
	public void run(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
		}
		kill();
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
	public boolean collide(Player pla){
		Level l= pla.getLevel();
		pla.setLevel(l.getNextLevel(pla));
		pla.setPoints(points);
		map.getPlay().getFrame().getInformationPanel().updatelabelPoints();
		kill();
		return false;
	}
	public boolean collide(Enemy ene){
		return false;
	}
}