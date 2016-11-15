package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.PowerUp.*;

public class Tank extends PowerUp implements Runnable{
	
	private GraphicTank graphic;
	
	public Tank(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicTank(x,y,"Vida extra");
	}
	public GraphicTank getGraphic(){
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
		pla.incrementLifes();
		pla.setPoints(points);
		map.getPlay().getFrame().getInformationPanel().updatelabelPoints();
		kill();
		return false;
	}
	public boolean collide(Enemy ene){
		return false;
	}
}