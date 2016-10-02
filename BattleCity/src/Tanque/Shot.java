package Tanque;

import Mapa.*;

public class Shot extends Element{
	
	protected int speed, dx, dy;
	
	public Shot(String dir, int x, int y, Map map, int speed){
		super("Disparo "+dir,x, y, map);
		assignIncrementDir(dir);
	}
	public void move(){
		if((x==0)&&(dx==(-1))){
			kill();
		}
		else{
			if((x==625)&&(dx==1)){
				kill();
			}
			else{
				x+=dx;
			}
		}
		if((y==0)&&(dy==(-1))){
			kill();
		}
		else{
			if((y==625)&&(dy==1)){
				kill();
			}
			else{
				y+=dy;
			}
		}		
	}
	public int kill(){
		return 0;
	}
/*	public boolean collide(Player jug){
		
	}
	public boolean collide(Enemy ene){
		
	}
	*/
	public int getWidth(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
		}
	}
	public int getHeight(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
		}
	}
	public int getWidht(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
		}
	}
	private void assignIncrementDir(String dir){
		switch(dir){
		case "arriba":
			dx=0;dy=-1;
			break;
		case "abajo":
			dx=0;dy=1;
			break;
		case "izquierda":
			dx=-1;dy=0;
		case "derecha":
			dx=1;dy=0;
			break;
		}
	}
}