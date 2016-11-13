package Graphic.Animation;

import Logic.Map.*;
import Logic.PowerUp.ForceField;

public class PlayerGeneration extends AnimationOfTanksGeneration implements Runnable{
	
	private volatile boolean execute;
	
	public PlayerGeneration(int x, int y, Map map){
		super(x,y,"Generation 1",map);
		posInAnimations=map.getGraphicMap().insertAnimation(this);
		execute=true;
		map.getPlay().getPlayer().setStop(true);
		map.getPlay().getPlayer().getGraphic().relocate();
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			if(actualImage<images.length){
				try {
					Thread.sleep(200);
				} catch(InterruptedException e){
				}
				image=images[actualImage];
				actualImage++;
			}
			else{
				ForceField f= new ForceField(map.getPlay().getPlayer(),map,5000);
				Thread t= new Thread(f);
				t.start();
				map.getPlay().getPlayer().activateForceField(f);
				map.getPlay().getPlayer().getGraphic().setImage(map.getPlay().getPlayer().getLevel().getGraphic().getImage(0, 0));
				map.getGraphicMap().deleteAnimation(posInAnimations);
				terminate();
			}
			
		}
	}
}