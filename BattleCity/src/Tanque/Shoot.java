package Tanque;

import Mapa.*;

public class Shoot extends Element{
	private String direccion;
	
	public Shoot(String dir, int x, int y, Map map){
		super("disparo",x, y, map);
		direccion=dir;
	}
	public void setDireccion(String dir){
		direccion=dir;
	}
	public String getDireccion(){
		return direccion;
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