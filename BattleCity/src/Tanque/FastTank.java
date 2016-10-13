package Tanque;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import Mapa.*;
import Shot.ShotEnemy;

public class FastTank extends Enemy implements Runnable{
	
	private volatile boolean execute;
	
	public FastTank(int x, int y, Map map, int posE){
		super(8,1,"Fast tank","abajo", x, y, map, posE);
		points=200;
		images= new Image[2][4];
		this.execute=true;
		haveShot=false;
		buildImages();
	}
	public void terminate(){
		this.execute=false;
	}
	public void run(){
		while(execute){
			moveEnemy();
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
			int[] pos=super.generatePosShot();
			ShotEnemy s= new ShotEnemy(direction,pos[0],pos[1],map,9,this);
			tShot= new Thread(s);
			tShot.start();
			s.addPosInShots(map.insertShot(s));
		}
	}
	public void moveEnemy(){
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
		move();
		if(movImage==0){
			movImage=1;
		}
		else{
			movImage=0;
		}
		setImage(images[movImage][dir]);		
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
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
	private void buildImages(){
		images[0][0]=new ImageIcon("Imagenes/Fast tank arriba-mov1.png").getImage();		
		images[1][0]=new ImageIcon("Imagenes/Fast tank arriba-mov2.png").getImage();
		images[0][1]=new ImageIcon("Imagenes/Fast tank izquierda-mov1.png").getImage();
		images[1][1]=new ImageIcon("Imagenes/Fast tank izquierda-mov2.png").getImage();
		images[0][2]=new ImageIcon("Imagenes/Fast tank abajo-mov1.png").getImage();
		images[1][2]=new ImageIcon("Imagenes/Fast tank abajo-mov2.png").getImage();
		images[0][3]=new ImageIcon("Imagenes/Fast tank derecha-mov1.png").getImage();
		images[1][3]=new ImageIcon("Imagenes/Fast tank derecha-mov2.png").getImage();
	}
}