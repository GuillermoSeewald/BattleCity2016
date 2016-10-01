package Tanque;

import Mapa.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Character{
	
	protected String nom;
	

	protected int simultaneousShot, life;
	
	public Player(Map map){
		super(12,1,"Jugador","arriba",208,624, map);
		nom= "Jugador";
		direction="arriba";
		points=0;
		life=3;
		simultaneousShot=1;
	}
	public void incrementLife(){
		life++;
	}
	public void decrementLife(){
		if(life>0){
			life--;
		}
	}
	public void setMap(Map m){
		this.map=m;
	}
	public void setDisparos(int d){
		simultaneousShot=d;
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = -1;
			dx=0;
			direction="arriba";
			break;
		case KeyEvent.VK_DOWN :
			dy = 1;
			dx=0;
			direction="abajo";
			break;
		case KeyEvent.VK_LEFT :
			dx = -1;
			dy=0;
			direction="izquierda";
			break;
		case KeyEvent.VK_RIGHT :
			dx = 1;
			dy=0;
			direction="derecha";
			break;
		}
		if(movImagen==1){
			movImagen=2;
		}
		else{
			movImagen=1;
		}
		ImageIcon ima = new ImageIcon("Imagenes/"+nom+" "+direction+"-mov"+movImagen+".png");
		setImagen(ima.getImage());
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
	public int getDisparos(){
		return simultaneousShot;
	}
	
/*	public int kill(){
		
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}