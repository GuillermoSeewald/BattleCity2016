package Logic.Shot;

import Logic.Map.*;
import Logic.Obstacle.Obstacle;
import Logic.Tank.Enemy;
import Logic.Tank.Player;
import Graphic.Shot.*;

public class ShotEnemy extends Shot implements Runnable{
	
	Enemy enemy;
	protected GraphicShotEnemy graphic;
	private volatile boolean execute;
	
	public ShotEnemy(String dir, int x, int y, Map map, int speed, Enemy ene, int posx, int posy){
		super(map,speed,posx,posy);
		enemy=ene;
		enemy.disableShot();
		graphic= new GraphicShotEnemy(x,y,"Disparo "+dir,dir);
		this.execute=true;
	}
	public GraphicShotEnemy getGraphic(){
		return graphic;
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		while(execute){
			if(!move()){
				terminate();
				kill();
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e){
			}
		}
	}
	

	public boolean move(){
		boolean mov=true;
		Obstacle obs= null;
		if(graphic.getDX()!=0){
			int auxX= graphic.getNewPos(graphic.getX()+graphic.getDX(),map);
			if(((graphic.getX()+graphic.getDX())<0)||((graphic.getX()+graphic.getDX())>677)){
				mov=false;
			}
			else{
				obs=map.getObstacle(auxX, posY);
				Enemy e= graphic.haveEnemyTank(map, -1);
				Player p= graphic.havePlayerTank(map);
				if((e==null)&&(p==null)){
					if(obs==null){
						graphic.changeX(graphic.getX()+graphic.getDX());
						posX=auxX;
					}
					else{
						int aux=obs.kill(enemy);
						if(aux==1){
							mov=false;
						}
						else{
							graphic.changeX(graphic.getX()+graphic.getDX());
							posX=auxX;
						}
					}
				}
				else{
					if(e==null){
						p.kill(enemy);
					}
					else{
						e.kill(enemy);
					}
					mov=false;
				}
			}
		}
		if(graphic.getDY()!=0){
			int auxY= graphic.getNewPos(graphic.getY()+graphic.getDY(),map);
			if(((graphic.getY()+graphic.getDY())<0)||((graphic.getY()+graphic.getDY())>677)){
				mov=false;
			}
			else{
				obs= map.getObstacle(posX, auxY);
				Enemy e= graphic.haveEnemyTank(map, -1);
				Player p= graphic.havePlayerTank(map);
				if((e==null)&&(p==null)){
					if(obs==null){
						graphic.changeY(graphic.getY()+graphic.getDY());
						posY=auxY;
					}
					else{
						int aux=obs.kill(enemy);
						if(aux==1){
							mov=false;
						}
						else{
							graphic.changeY(graphic.getY()+graphic.getDY());
							posY=auxY;
						}
					}
				}
				else{
					if(e==null){
						p.kill(enemy);
					}
					else{
						e.kill(enemy);
					}
					mov=false;
				}
			}
		}
		map.getGraphicMap().repaint();
		return mov;
	}
	
	protected int kill(){
		enemy.enableShot();
		map.getGraphicMap().deleteShot(graphic.getPosInShots());
		return 0;
	}
	public int kill(Player pla){
		return 0;
	}
	public int kill(Enemy ene){
		return 0;
	}
	public boolean collide(Player pla){
		pla.kill(enemy);
		return true;
	}
	public boolean collide(Enemy ene){
		ene.kill(enemy);
		return true;
	}
}