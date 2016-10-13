package Obstaculo;

import javax.swing.ImageIcon;
import Mapa.*;
import Tanque.Enemy;
import Tanque.Player;

public class Base extends Obstacle{
	
	protected boolean destroyed;
	
	public Base(int x, int y, int posX, int posY, Map map){
		super("Bandera1", x, y, posX, posY, map);
		destroyed=false;
	}
	
	public boolean itsDestroyed(){
		return destroyed;
	}
	protected int kill(){
		setImage(new ImageIcon("Imagenes/Bandera2.png").getImage());
		destroyed=true;
		return 0;
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
}