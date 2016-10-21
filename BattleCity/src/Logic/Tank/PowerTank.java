package Logic.Tank;

import Logic.Map.*;
import Logic.Shot.*;
import Graphic.Map.GraphicElement;
import Graphic.Tank.*;

import java.util.Random;

public class PowerTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	protected GraphicPowerTank graphic;
	
	public PowerTank(int x, int y, Map map, int posE, int posx, int posy){
		super(12,1,"abajo", map, posE, posx, posy);
		graphic= new GraphicPowerTank(x,y,"Power tank abajo-mov1");
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
			ShotEnemy s= new ShotEnemy(direction,pos[0],pos[1],map,9,this,posX,posY);
			tShot= new Thread(s);
			tShot.start();
			s.addPosInShots(map.insertShot(s));
		}
	}
	public void move(){
		Random r= new Random();
		int m= r.nextInt(16);
		int dir=0;
		switch (m){
		case 0|1|2|3: //Muevo hacia arriba
			dy=-2;dx=0;
			dir=0;
			direction="arriba";
			break;
		case 4|5|6|7: //Muevo hacia la izquierda
			dx=-2;dy=0;
			direction="izquierda";
			dir=1;
			break;
		case 8|9|10|11: //Muevo hacia abajo
			dy=2;dx=0;
			direction="abajo";
			dir=2;
			break;
		case 12|13|14|15: //Muevo hacia la derecha
			dx=2;dy=0;
			direction="derecha";
			dir=3;
			break;
		}
		super.move(graphic);
		if(movImage==0){
			movImage=1;
		}
		else{
			movImage=0;
		}
		graphic.setImage(graphic.getImageInArray(movImage, dir));		
	}
	public GraphicElement getGraphic(){
		return graphic;
	}
	protected int kill(){
		map.deleteEnemy(posInEnemies);
		return points;
	}
	public int kill(Player pla){
		return 0;
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