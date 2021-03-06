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
					Thread.sleep(17000);
				} catch(InterruptedException e){
				}
				stop=false;
			}
		}
	}
	public void attack(){
		if(!haveShot){
			Thread tShot;
			int[] pos=graphic.generatePosShot();
			int xShot= pos[0]/52;
			int yShot= pos[1]/52;
			ShotEnemy s= new ShotEnemy(graphic.getDirection(),pos[0],pos[1],map,9,this,xShot,yShot);
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
	public GraphicPowerTank getGraphic(){
		return graphic;
	}
	protected int kill(){
		if(resistance==1){
//			Thread t= new Thread(new EnemiesExplosion(graphic.getX(),graphic.getY(),map));
//			t.start();
			terminate();
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
		return 1;
	}
	public boolean collide(Player pla){
		return true;
	}
	public boolean collide(Enemy ene){
		return true;
	}
}