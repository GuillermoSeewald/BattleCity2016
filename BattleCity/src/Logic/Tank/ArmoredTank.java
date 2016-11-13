package Logic.Tank;

import Logic.Map.*;
import Logic.Shot.ShotEnemy;
import Graphic.Tank.*;

import java.util.Random;

public class ArmoredTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	
	protected GraphicArmoredTank graphic;
	
	public ArmoredTank(int x, int y, Map map, int posE, int posx, int posy){
		super(60,4, map, posE, posx, posy);
		graphic= new GraphicArmoredTank(x,y,"Armored tank abajo-mov1","abajo");
		points=400;
		this.execute=true;
		haveShot=false;
	}
	public void initialize(){
		execute=true;
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		while(execute){
			if(!stop){
				if(!haveShot){
					attack();
				}
				Random r= new Random();
				int x= r.nextInt(4);
				int i=0;
				move();
				boolean mov=true;
				while((x>0)&&(mov)){
					while((i<13)&&(mov)){
						mov=super.move(graphic);
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
			else{
				try {
					Thread.sleep(10000);
				} catch(InterruptedException e){
				}
				stop=false;
			}
		}
	}
	public GraphicArmoredTank getGraphic(){
		return graphic;
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
		int m= r.nextInt(4);
		
		switch (m){
		case 0: //Muevo hacia arriba
			graphic.changeDY(-4);graphic.changeDX(0);
			graphic.setDirection("arriba");
			break;
		case 1: //Muevo hacia la izquierda
			graphic.changeDX(-4);graphic.changeDY(0);
			graphic.setDirection("izquierda");
			break;
		case 2: //Muevo hacia abajo
			graphic.changeDY(4);graphic.changeDX(0);
			graphic.setDirection("abajo");
			break;
		case 3: //Muevo hacia la derecha
			graphic.changeDX(4);graphic.changeDY(0);
			graphic.setDirection("derecha");
			break;
		}
	}
	protected int kill(){
		if(resistance==1){
			map.deleteEnemy(posInEnemies);
		}
		else{
			resistance--;
		}
		return 1;
	}
	public int kill(Player pla){
		return kill();
	}
	public int kill(Enemy ene){
		return 0;
	}
	public boolean collide(Player pla){
		return true;
	}
	public boolean collide(Enemy ene){
		return true;
	}
}