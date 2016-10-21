package Logic.Tank;

import Logic.Map.*;
import Logic.Level.*;
import Logic.Shot.*;
import Graphic.Map.GraphicElement;
import Graphic.Tank.*;
import java.awt.event.KeyEvent;

public class Player extends Character implements Runnable{
	
	protected Level level;
	protected boolean vulnerability;
	protected int simultaneousShots, life;
	protected GraphicPlayer graphic;
	private volatile boolean execute;
	
	public Player(Map map, int posx, int posy){
		super(40,1,"arriba", map,posx,posy);
		graphic= new GraphicPlayer(208,624,"Jugador arriba-mov1-level1");
		points=0;
		life=3;
		simultaneousShots=1;
		level=new Level1();
		vulnerability=false;
		execute=true;
		graphic.changeWidth(38);
		graphic.changeHeight(34);
		graphic.setImage(level.getImage(0, 0));
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
	public GraphicElement getGraphic(){
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
			int[] pos=super.generatePosShot(graphic);
			int aux=52;
			int shotPosX=0;
			int shotPosY=0;
			if((direction=="arriba")||(direction=="abajo")){
				while(pos[0]<aux){
					aux+=52;
					shotPosX++;
				}
				shotPosY=posY;
			}
			else{
				while(pos[1]<aux){
					aux+=52;
					shotPosY++;
				}
				shotPosX=posX;
			}
			ShotPlayer s=new ShotPlayer(direction,pos[0],pos[1],map,level.getSpeedShot(),this,posX,posY);
			t= new Thread(s);
			t.start();
			s.addPosInShots(map.insertShot(s));
			simultaneousShots--;
		}
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		int dir=0;
		boolean movimiento=false;
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = -3;dx=0;dir=0;direction="arriba";movimiento=true;
			break;
		case KeyEvent.VK_DOWN :
			dy = 3;dx=0;dir=2;direction="abajo";movimiento=true;
			break;
		case KeyEvent.VK_LEFT :
			dx = -3;dy=0;dir=1;direction="izquierda";movimiento=true;
			break;
		case KeyEvent.VK_RIGHT :
			dx = 3;dy=0;dir=3;direction="derecha";movimiento=true;
			break;
		case KeyEvent.VK_F :
			attack();
			break;
		}
		if(movImage==0){
			movImage=1;
		}
		else{
			movImage=0;
		}
		if(movimiento){
			graphic.setImage(level.getImage(movImage,dir));
		}
	}
	public void keyReleased(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = 0;
			break;
		case KeyEvent.VK_DOWN :
			dy = 0;
			break;
		case KeyEvent.VK_LEFT :
			dx = 0;
			break;
		case KeyEvent.VK_RIGHT :
			dx = 0;
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
		graphic.changeX(208);graphic.changeHeight(624);
		level= new Level1();
		graphic.setImage(level.getImage(0, 0));
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