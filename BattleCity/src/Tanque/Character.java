package Tanque;

import Mapa.*;

public abstract class Character extends Element{
	protected int speedMove, resistance, movImagen, points;
	protected String direction;
	protected boolean haveShot;
	
	protected int dx;
	protected int dy;
	
	public Character(int speedM,int res,String n,String dir, int x, int y, Map map){
		super(n+" "+dir+"-mov1", x, y,map);
		speedMove=speedM;
		resistance=res;
		direction=dir;
		movImagen=1;
	}
	
	public void setSpeedMove(int s){
		speedMove=s;
	}
	public void setResistance(int r){
		resistance=r;
	}
	public void setPoints(int p){
		points=p;
	}
	public void move(){
		if((x==0)&&(dx==(-1))){
			x=0;
		}
		else{
			if((x==625)&&(dx==1)){
				x=625;
			}
			else{
				x+=dx;
			}
		}
		if((y==0)&&(dy==(-1))){
			y=0;
		}
		else{
			if((y==625)&&(dy==1)){
				y=625;
			}
			else{
				y+=dy;
			}
		}
	}
//	public void disparar(){
//		hayDisparo=true;
//		new Disparo(direccion);
//	}
	public int getSpeedMove(){
		return speedMove;
	}
	public int getResistance(){
		return resistance;
	}
	public String getDirection(){
		return direction;
	}
	public boolean haveShot(){
		return haveShot;
	}
	public int getPoints(){
		return points;
	}
}