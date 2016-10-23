package Logic.Tank;

import Logic.Map.*;
import Logic.Shot.*;
import Graphic.Tank.*;

import java.util.Random;

public class PowerTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	protected GraphicPowerTank graphic;
	
	public PowerTank(int x, int y, Map map, int posE, int posx, int posy){
		super(12,1, map, posE, posx, posy);
		graphic= new GraphicPowerTank(x,y,"Power tank abajo-mov1","abajo");
		points=300;
		this.execute=true;
		haveShot=false;
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		this.execute=true;
		while(execute){
			move();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
			}
		}
	}
	public void enableShot(){
		haveShot=false;
	}
	public void attack(){
		if(!haveShot){
			Thread tShot;
			int[] pos=super.generatePosShot(graphic);
			ShotEnemy s= new ShotEnemy(graphic.getDirection(),pos[0],pos[1],map,9,this,posX,posY);
			tShot= new Thread(s);
			tShot.start();
			s.getGraphic().addPosInShots(map.getGraphicMap().insertShot(s));
		}
	}
	public void move(){
		Random r= new Random();
		int m= r.nextInt(16);
		int dir=0;
		switch (m){
		case 0|1|2|3: //Muevo hacia arriba
			graphic.changeDY(-4);graphic.changeDX(0);
			dir=0;
			graphic.setDirection("arriba");
			break;
		case 4|5|6|7: //Muevo hacia la izquierda
			graphic.changeDX(-4);graphic.changeDY(0);
			graphic.setDirection("izquierda");
			dir=1;
			break;
		case 8|9|10|11: //Muevo hacia abajo
			graphic.changeDY(4);graphic.changeDX(0);
			graphic.setDirection("abajo");
			dir=2;
			break;
		case 12|13|14|15: //Muevo hacia la derecha
			graphic.changeDX(4);graphic.changeDY(0);
			graphic.setDirection("derecha");
			dir=3;
			break;
		}
		super.move(graphic);
		if(graphic.getMoveImage()==0){
			graphic.setMoveImage(1);
		}
		else{
			graphic.setMoveImage(0);
		}
		graphic.setImage(graphic.getImageInArray(graphic.getMoveImage(), dir));		
	}
	public GraphicPowerTank getGraphic(){
		return graphic;
	}
	protected int kill(){
		map.deleteEnemy(posInEnemies);
		return 1;
	}
	public int kill(Player pla){
		kill();
		return 1;
	}
	public int kill(Enemy ene){
		return 0;
	}
/*	public boolean collide(Jugador pla){
	
	}
	public boolean collide(Enemigo ene){
		
	}
	*/
}