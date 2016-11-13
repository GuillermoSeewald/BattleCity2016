package Logic.Tank;

import Logic.Map.*;
import Logic.Obstacle.Obstacle;
import Logic.Level.*;
import Logic.Shot.*;
import Logic.PowerUp.*;
import Graphic.Animation.*;
import Graphic.Tank.*;
import java.awt.event.KeyEvent;

public class Player extends Character implements Runnable{
	
	protected Level level;
	protected ForceField forceField;
	protected int simultaneousShots, life, pointsNewLife;
	protected GraphicPlayer graphic;
	private volatile boolean execute;
	
	public Player(Map map, int posx, int posy){
		super(55,1, map,posx,posy);
		graphic= new GraphicPlayer(213,638,"Jugador arriba-mov1-level1","arriba");
		points=0;
		life=4;
		pointsNewLife=0;
		simultaneousShots=1;
		level=new Level1();
		execute=true;
		graphic.changeWidth(38);
		graphic.changeHeight(38);
		graphic.setImage(level.getGraphic().getImage(0, 0));
		forceField=null;
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			if(!stop){
				move();
				try {
					Thread.sleep(speedMove);
				} catch (InterruptedException e){
				}
			}
			else{
				try {
					Thread.sleep(2000);
				} catch(InterruptedException e){
				}
				stop=false;
			}
		}
	}
	public GraphicPlayer getGraphic(){
		return graphic;
	}
	public void activateForceField(ForceField b){
		forceField=b;
	}
	public void desactivateForceField(){
		forceField=null;
	}
	public void setPoints(int p){
		points+=p;
		pointsNewLife+=p;
		if(pointsNewLife>20000){
			life++;
			pointsNewLife-=20000;
		}
	}
	public void incrementLifes(){
		life++;
	}
	public void decrementLifes(){
		if(life>0){
			life--;
		}
	}
	public void setMap(Map m){
		this.map=m;
	}
	public void setSimultaneousShots(int d){
		simultaneousShots=d;
	}
	public void setLevel(Level l){
		level=l;
	}
	public void attack(){
		if(simultaneousShots>0){
			Thread t;
			int[] pos=graphic.generatePosShot();
			ShotPlayer s=new ShotPlayer(graphic.getDirection(),pos[0],pos[1],map,level.getSpeedShot(),this,posX,posY);
			t= new Thread(s);
			t.start();
			s.getGraphic().addPosInShots(map.getGraphicMap().insertShot(s));
			simultaneousShots--;
		}
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		int dir=0;
		boolean movimiento=false;
		
		switch (key){
		case KeyEvent.VK_UP :
			graphic.changeDY(-3);graphic.changeDX(0);dir=0;graphic.setDirection("arriba");;movimiento=true;
			break;
		case KeyEvent.VK_DOWN :
			graphic.changeDY(3);graphic.changeDX(0);dir=2;graphic.setDirection("abajo");;movimiento=true;
			break;
		case KeyEvent.VK_LEFT :
			graphic.changeDX(-3);graphic.changeDY(0);dir=1;graphic.setDirection("izquierda");;movimiento=true;
			break;
		case KeyEvent.VK_RIGHT :
			graphic.changeDX(3);graphic.changeDY(0);dir=3;graphic.setDirection("derecha");;movimiento=true;
			break;
		case KeyEvent.VK_F :
			attack();
			break;
		}
		if(graphic.getMoveImage()==0){
			graphic.setMoveImage(1);
		}
		else{
			graphic.setMoveImage(0);
		}
		if(movimiento){
			graphic.setImage(level.getGraphic().getImage(graphic.getMoveImage(),dir));
		}
	}
	public void keyReleased(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			graphic.changeDY(0);
			break;
		case KeyEvent.VK_DOWN :
			graphic.changeDY(0);
			break;
		case KeyEvent.VK_LEFT :
			graphic.changeDX(0);
			break;
		case KeyEvent.VK_RIGHT :
			graphic.changeDX(0);
			break;
		}
	}
	public int getLifes(){
		return life;
	}
	public int getSimultaneousShots(){
		return simultaneousShots;
	}
	public Level getLevel(){
		return level;
	}
	protected int kill(){
		if((forceField==null)&&(!map.getWin())){
			level= new Level1();
			if(resistance==1){
				posX=4;
				posY=12;
				Thread t= new Thread(new PlayerExplosion(graphic.getX(),graphic.getY(),map));
				t.start();
				if(life>=1){
					decrementLifes();
				}
				else{
					map.gameOver();
				}
			}
			else{
				resistance--;
			}
		}
		map.getPlay().getFrame().getInformationPanel().updatelabelPoints();
		return 1;
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
	public void move(){
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
						Enemy c= graphic.haveEnemyTank(map, -1);
						if((c==null)||(!c.collide(this))){
							graphic.changeX(graphic.getX()+graphic.getDX());
							posX=auxX;
							if(forceField!=null){
								int aux= graphic.getX()-((forceField.getGraphic().getWidth()-graphic.getWidth())/2);
								forceField.getGraphic().changeX(aux);
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
						Enemy c= graphic.haveEnemyTank(map, -1);
						if((c==null)||(!c.collide(this))){
							graphic.changeY(graphic.getY()+graphic.getDY());
							posY=auxY;
							if(forceField!=null){
								int aux= graphic.getY()-((forceField.getGraphic().getHeight()-graphic.getHeight())/2);
								forceField.getGraphic().changeY(aux);
							}
						}
					}
				}
			}
		}
		map.getGraphicMap().repaint();
	}
}