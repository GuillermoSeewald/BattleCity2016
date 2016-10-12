package Tanque;

import Mapa.*;
import Level.*;
import Shot.*;
import java.awt.event.KeyEvent;

public class Player extends Character{
	
	protected Level level;
	protected boolean vulnerability;
	protected int simultaneousShots, life;
	
	public Player(Map map){
		super(12,1,"Jugador","arriba",208,624, map);
		points=0;
		life=3;
		simultaneousShots=1;
		level=new Level1();
		vulnerability=false;
		setImage(level.getImage(0, 0));
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
		int[] pos=super.generatePosShot();
		new ShotPlayer(direction,pos[0],pos[1],map,level.getSpeedShot(),this);
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		int dir=0;
		boolean movimiento=false;
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = -1;dx=0;dir=0;direction="arriba";movimiento=true;
			break;
		case KeyEvent.VK_DOWN :
			dy = 1;dx=0;dir=2;direction="abajo";movimiento=true;
			break;
		case KeyEvent.VK_LEFT :
			dx = -1;dy=0;dir=1;direction="izquierda";movimiento=true;
			break;
		case KeyEvent.VK_RIGHT :
			dx = 1;dy=0;dir=3;direction="derecha";movimiento=true;
			break;
		}
		if(movImage==0){
			movImage=1;
		}
		else{
			movImage=0;
		}
		if(movimiento){
			setImage(level.getImage(movImage,dir));
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
		x=208;y=624;
		level= new Level1();
		setImage(level.getImage(0, 0));
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