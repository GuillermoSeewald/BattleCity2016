package Logic.Tank;

import Logic.Map.*;
import Logic.Obstacle.Obstacle;
import Graphic.Tank.*;

public abstract class Enemy extends Character{
	
	protected int posInEnemies;
	protected boolean stop;
	protected boolean haveShot;
	
	
	public Enemy(int speedMov,int res, Map map, int posE, int posx, int posy){
		super(speedMov,res,map,posx,posy);
		stop=false;
		posInEnemies=posE;
	}
	public abstract void terminate();
	public abstract void initialize();
	public void enableShot(){
		haveShot=false;
	}
	public void disableShot(){
		haveShot=true;
	}
	public int getPosInEnemies(){
		return posInEnemies;
	}
	public boolean move(GraphicEnemy graphic){
		boolean mov=false;
		if(graphic.getDX()!=0){
			int auxX= graphic.getNewPos(graphic.getX()+graphic.getDX(),graphic,map.getMap().length);
			if((graphic.getX()+graphic.getDX())<0){
				graphic.changeX(0);
			}
			else{
				if((graphic.getX()+graphic.getDX()+graphic.getHeight())>676){
					graphic.changeX(676-graphic.getHeight());
					}
				else{
					Obstacle obs1= map.getObstacle(auxX, posY);
					Obstacle obs2= null;
					if(graphic.betweenTwoCell(graphic.getY(), map.getMap().length)){
						if(graphic.getY()>(posY*52)){
							obs2=map.getObstacle(posX, posY+1);
						}
						else{
							obs2=map.getObstacle(posX, posY-1);
						}
					}
					boolean canMove=false;
					if(obs1==null){
						if((obs2==null)||(!obs2.collide(this))){
							canMove=true;
						}
					}
					else{
						if(!obs1.collide(this)){
							if((obs2==null)||(!obs2.collide(this))){
								canMove=true;
							}
						}
					}				
					if(canMove){
						Enemy c= graphic.haveEnemyTank(map,posInEnemies);
						if((c==null)||(!c.collide(this))){
							Player p= graphic.havePlayerTank(map);
							if((p==null)||(!p.collide(this))){
								graphic.changeX(graphic.getX()+graphic.getDX());
								posX=auxX;
								mov=true;
							}
						}
					}
				}
			}
		}
		if(graphic.getDY()!=0){
			int auxY= graphic.getNewPos(graphic.getY()+graphic.getDY(),graphic,map.getMap().length);
			if((graphic.getY()+graphic.getDY())<0){
				graphic.changeY(0);
				}
			else{
				if((graphic.getY()+graphic.getDY()+graphic.getHeight())>676){
					graphic.changeY(676-graphic.getHeight());
					}
				else{
					Obstacle obs1= map.getObstacle(posX, auxY);
					Obstacle obs2=null;
					if(graphic.betweenTwoCell(graphic.getX(), map.getMap().length)){
						if(graphic.getX()>(posX*52)){
							obs2=map.getObstacle(posX+1, posY);
						}
						else{
							obs2=map.getObstacle(posX-1, posY);
						}
					}
					boolean canMove=false;
					if(obs1==null){
						if((obs2==null)||(!obs2.collide(this))){
							canMove=true;
						}
					}
					else{
						if(!obs1.collide(this)){
							if((obs2==null)||(!obs2.collide(this))){
								canMove=true;
							}
						}
					}				
					if(canMove){
						Enemy c= graphic.haveEnemyTank(map,posInEnemies);
						if((c==null)||(!c.collide(this))){
							Player p= graphic.havePlayerTank(map);
							if((p==null)||(!p.collide(this))){
								graphic.changeY(graphic.getY()+graphic.getDY());
								posY=auxY;
								mov=true;
							}
						}
					}
				}
			}
		}
		map.getGraphicMap().repaint();
		return mov;
	}
}