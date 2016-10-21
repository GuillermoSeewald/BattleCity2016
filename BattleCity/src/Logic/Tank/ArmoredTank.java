package Logic.Tank;

import Logic.Map.*;
import Logic.Shot.ShotEnemy;
import Graphic.Map.GraphicElement;
import Graphic.Tank.*;

import java.util.Random;

public class ArmoredTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	
	protected GraphicArmoredTank graphic;
	
	public ArmoredTank(int x, int y, Map map, int posE, int posx, int posy){
		super(12,4,"abajo", map, posE, posx, posy);
		graphic= new GraphicArmoredTank(x,y,"Armored tank abajo-mov1");
		points=400;
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
					changeImage();
					i++;
					try {
						Thread.sleep(100);
					}catch (InterruptedException e){
					}
				}
				x--;
			}
		}
	}
	public GraphicElement getGraphic(){
		return graphic;
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
	private void changeImage(){
		int dir=2;
		switch (direction){
		case "arriba":
			dir=0;
			break;
		case "abajo":
			dir=2;
			break;
		case "izquierda":
			dir=1;
			break;
		case "derecha":
			dir=3;
			break;
		}
		if(movImage==0){
			movImage=1;
		}
		else{
			movImage=0;
		}
		graphic.setImage(graphic.getImageInArray(movImage,dir));
	}
	public void move(){
		Random r= new Random();
		int m= r.nextInt(12);
		
		switch (m){
		case 0|1|2: //Muevo hacia arriba
			dy=-4;dx=0;
			direction="arriba";
			break;
		case 3|4|5: //Muevo hacia la izquierda
			dx=-4;dy=0;
			direction="izquierda";
			break;
		case 6|7|8: //Muevo hacia abajo
			dy=4;dx=0;
			direction="abajo";
			break;
		case 9|10|11: //Muevo hacia la derecha
			dx=4;dy=0;
			direction="derecha";
			break;
		}
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
/*	public boolean collide(Player pla){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}