package Tanque;

import Mapa.*;

public abstract class Character extends Element{
	protected int speedMove, resistance, movImage, points;
	protected String direction;
	
	protected int dx;
	protected int dy;
	
	public Character(int speedM,int res,String n,String dir, int x, int y, Map map){
		super(n+" "+dir+"-mov1", x, y,map);
		speedMove=speedM;
		resistance=res;
		direction=dir;
		movImage=0;
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
	public abstract void attack();
	
	public void attack(int s){
		int ejeX=0;
		int ejeY=0;
		switch(direction){
		case "arriba":
			ejeX=(this.x+(this.getWidth()/2));
			ejeY=(this.y+1);
			break;
		case "abajo":
			ejeX=(this.x+(this.getWidth()/2));
			ejeY=(this.y+this.getHeigth()+1);
			break;
		case "izquierda":
			ejeX=(this.x-1);
			ejeY=(this.y+(this.getHeigth()/2));
			break;
		case "derecha":
			ejeX=(this.x+this.getWidth()+1);
			ejeY=(this.y+(this.getHeigth()/2));
			break;
		}
		new Shot(direction, ejeX, ejeY, map, s);
	}
	public int getSpeedMove(){
		return speedMove;
	}
	public int getResistance(){
		return resistance;
	}
	public String getDirection(){
		return direction;
	}
	public int getPoints(){
		return points;
	}
}