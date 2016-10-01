package Obstaculo;

import javax.swing.ImageIcon;
import Mapa.*;

public class Base extends Obstacle{
	
	protected boolean destroyed;
	
	public Base(int x, int y, int posX, int posY, Map map){
		super("Bandera1", x, y, posX, posY, map);
		destroyed=false;
	}
	
	public boolean itsDestroyed(){
		return destroyed;
	}
	public int kill(){
		setImage(new ImageIcon("Imagenes/Bandera2.png").getImage());
		destroyed=true;
		return 0;
	}
/*	public boolean collide(Player jug){
	
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}