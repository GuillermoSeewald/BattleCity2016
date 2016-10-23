package Graphic.GraphicElementWithMovement;

import Graphic.Map.*;

public class GraphicElementWithMovement extends GraphicElement{
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
}