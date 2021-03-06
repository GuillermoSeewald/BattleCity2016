package Graphic.GraphicElementWithMovement;

import Graphic.Map.*;
import Logic.Map.*;
import Logic.Tank.*;

public abstract class GraphicElementWithMovement extends GraphicElement{
	protected int dx;
	protected int dy;
	protected String direction;
	
	public GraphicElementWithMovement(int x, int y, String n, String dir){
		super(x,y,n);
		dx=0;
		dy=0;
		direction=dir;
	}
	public void changeDX(int x){
		dx=x;
	}
	public void changeDY(int y){
		dy=y;
	}
	public void setDirection(String d){
		direction=d;
	}
	public int getDX(){
		return dx;
	}
	public int getDY(){
		return dy;
	}
	public String getDirection(){
		return direction;
	}

	public Enemy haveEnemyTank(Map map, int pos){
		Enemy tank=null;
		Enemy[] e= map.getEnemies();
		int newX= X+dx;
		int newY= Y+dy;
		
		for(int i=0;i<e.length;i++){
			if((e[i]!=null)&&(i!=pos)){
				int wE= e[i].getGraphic().getWidth();
				int hE= e[i].getGraphic().getHeight();
				int xE= e[i].getGraphic().getX();
				int yE= e[i].getGraphic().getY();
				
				if((((newX>=xE)&&(newX<=(xE+wE)))||(((newX+width)>=xE)&&((newX+width)<=(xE+wE))))&&(((newY>=yE)&&(newY<=(yE+hE)))||(((newY+height)>=yE)&&((newY+height)<=(yE+hE))))){
					tank=e[i];
				}
			}
		}		
		return tank;
	}
	public Player havePlayerTank(Map map){
		Player p= null;
		
		int newX= X+dx;
		int newY= Y+dy;
		
		int xP= map.getPlay().getPlayer().getGraphic().getX();
		int yP= map.getPlay().getPlayer().getGraphic().getY();
		int wP= map.getPlay().getPlayer().getGraphic().getWidth();
		int hP= map.getPlay().getPlayer().getGraphic().getHeight();
		
		if((((newX>=xP)&&(newX<=(xP+wP)))||(((newX+width)>=xP)&&((newX+width)<=(xP+wP))))&&(((newY>=yP)&&(newY<=(yP+hP)))||(((newY+height)>=yP)&&((newY+height)<=(yP+hP))))){
			p= map.getPlay().getPlayer();
		}
		
		return p;
	}
}