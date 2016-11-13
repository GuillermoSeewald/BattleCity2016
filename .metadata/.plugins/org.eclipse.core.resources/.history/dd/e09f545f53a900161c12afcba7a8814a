package Graphic.Animation;

import Logic.Map.*;

public class EnemiesExplosion extends Explosion implements Runnable{
	
	private volatile boolean execute;
	protected int posToDelete;
	
	public EnemiesExplosion(int x, int y, Map map, int posInEnemies){
		super(x,y,"Explosion 1", map);
		posInAnimations=map.getGraphicMap().insertAnimation(this);
		execute=true;
		posToDelete=posInEnemies;
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
				map.deleteEnemy(posToDelete);				
				map.getGraphicMap().deleteAnimation(posInAnimations);
				terminate();
			}
		}
	}
}