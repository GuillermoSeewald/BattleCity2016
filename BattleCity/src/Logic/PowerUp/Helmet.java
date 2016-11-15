package Logic.PowerUp;

import Logic.Map.*;
import Logic.Tank.*;
import Graphic.PowerUp.*;

public class Helmet extends PowerUp implements Runnable{
	
	protected GraphicHelmet graphic;
	
	public Helmet(int x, int y, int posX, int posY, Map map){
		super(posX, posY, map);
		graphic= new GraphicHelmet(x,y,"Escudo");
	}
	public void run(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e){
		}
		kill();
	}
	public GraphicHelmet getGraphic(){
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
	public boolean collide(Player pla){
		pla.setPoints(points);
		map.getPlay().getFrame().getInformationPanel().updatelabelPoints();
		ForceField f= new ForceField(pla,map,15000);
		Thread t= new Thread(f);
		t.start();
		pla.activateForceField(f);
		kill();
		return false;
	}
	public boolean collide(Enemy ene){
		return false;
	}
}