package Tanque;

import Mapa.*;

public class Shot extends Element{
	
	protected int speed;
	
	public Shot(String dir, int x, int y, Map map, int speed){
		super("Disparo",x, y, map);
	}
	public void move(){
		
	}
	public int kill(){
		return 0;
	}
/*	public boolean collide(Player jug){
		
	}
	public boolean collide(Enemy ene){
		
	}
	*/
}