package Graphic.Animation;

import Logic.Map.*;

public class EnemiesGeneration extends AnimationOfTanksGeneration implements Runnable{
	
	private volatile boolean execute;
	
	public EnemiesGeneration(int x, int y, Map map){
		super(x,y,"Generation 1",map);
		posInAnimations=map.getGraphicMap().insertAnimation(this);
		execute=true;
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
				map.insertEnemy();
				map.getGraphicMap().deleteAnimation(posInAnimations);
				terminate();
			}
		}
	}
}