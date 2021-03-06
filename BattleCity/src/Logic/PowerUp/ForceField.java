package Logic.PowerUp;

import Logic.Tank.Player;
import Logic.Map.*;
import Graphic.Animation.*;

public class ForceField implements Runnable{
	
	protected Player p;
	protected ForceFieldGraphic graphic;
	protected Map map;
	protected int time;
	
	public ForceField(Player pla, Map map, int time){
		int auxX= pla.getGraphic().getX()-((60-pla.getGraphic().getWidth())/2);
		int auxY= pla.getGraphic().getY()-((60-pla.getGraphic().getHeight())/2);
		graphic= new ForceFieldGraphic(auxX,auxY,"Force field 1",map);
		Thread t= new Thread(graphic);
		t.start();
		p=pla;
		this.map=map;
		this.time=time;
		graphic.setPosInAnimations(map.getGraphicMap().insertAnimation(graphic));
		p.activateForceField(this);
	}
	public void run(){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e){
		}
		map.getGraphicMap().deleteAnimation(graphic.getPosInAnimations());
		graphic.terminate();
		p.desactivateForceField();
	}
	public ForceFieldGraphic getGraphic(){
		return graphic;
	}
}