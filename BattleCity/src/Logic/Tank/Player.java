package Logic.Tank;

import Logic.Map.*;
import Logic.Level.*;
import Logic.Shot.*;
import Graphic.Tank.*;
import java.awt.event.KeyEvent;

public class Player extends Character implements Runnable{
	
	protected Level level;
	protected boolean vulnerability;
	protected int simultaneousShots, life;
	protected GraphicPlayer graphic;
	private volatile boolean execute;
	
	public Player(Map map, int posx, int posy){
		super(55,1, map,posx,posy);
		graphic= new GraphicPlayer(213,638,"Jugador arriba-mov1-level1","arriba");
		points=0;
		life=3;
		simultaneousShots=1;
		level=new Level1();
		vulnerability=false;
		execute=true;
		graphic.changeWidth(38);
		graphic.changeHeight(34);
		graphic.setImage(level.getGraphic().getImage(0, 0));
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			move(graphic);
			try {
				Thread.sleep(speedMove);
			} catch (InterruptedException e){
			}
		}
	}
	public GraphicPlayer getGraphic(){
		return graphic;
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
	public boolean isVulnerable(){
		return vulnerability;
	}
	protected int kill(){
		decrementLifes();
		graphic.changeX(213);graphic.changeHeight(638);
		level= new Level1();
		graphic.setImage(level.getGraphic().getImage(0, 0));
		return 0;
	}
	public int kill(Player pla){
		return 0;
	}
	public int kill(Enemy ene){
		return 0;
	}
/*	public boolean collide(Player pla){
		
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}