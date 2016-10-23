package Logic.Tank;

import Logic.Map.*;
import Logic.Shot.*;
import Graphic.Tank.*;

import java.util.Random;

public class PowerTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	protected GraphicPowerTank graphic;
	
	public PowerTank(int x, int y, Map map, int posE, int posx, int posy){
		super(55,1, map, posE, posx, posy);
		graphic= new GraphicPowerTank(x,y,"Power tank abajo-mov1","abajo");
		points=300;
		this.execute=true;
		haveShot=false;
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		while(execute){
			Random r= new Random();
			int x= r.nextInt(4);
			int i=0;
			move();
			while(x>0){
				while(i<13){
					super.move(graphic);
					graphic.changeImage();
					i++;
					try {
						Thread.sleep(speedMove);
					}catch (InterruptedException e){
					}
				}
				x--;
			}
		}
	}
	public void enableShot(){
		haveShot=false;
	}
	public void attack(){
		if(!haveShot){
			Thread tShot;
			int[] pos=graphic.generatePosShot();
			ShotEnemy s= new ShotEnemy(graphic.getDirection(),pos[0],pos[1],map,9,this,posX,posY);
			tShot= new Thread(s);
			tShot.start();
			s.getGraphic().addPosInShots(map.getGraphicMap().insertShot(s));
		}
	}
	public void move(){
		Random r= new Random();
		int m= r.nextInt(12);
		
		switch (m){
		case 0|1|2: //Muevo hacia arriba
			graphic.changeDY(-4);graphic.changeDX(0);
			graphic.setDirection("arriba");
			break;
		case 3|4|5: //Muevo hacia la izquierda
			graphic.changeDX(-4);graphic.changeDY(0);
			graphic.setDirection("izquierda");
			break;
		case 6|7|8: //Muevo hacia abajo
			graphic.changeDY(4);graphic.changeDX(0);
			graphic.setDirection("abajo");
			break;
		case 9|10|11: //Muevo hacia la derecha
			graphic.changeDX(4);graphic.changeDY(0);
			graphic.setDirection("derecha");
			break;
		}
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