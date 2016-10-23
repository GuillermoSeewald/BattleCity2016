package Graphic.Tank;

import Graphic.GraphicElementWithMovement.*;

public class GraphicCharacter extends GraphicElementWithMovement{
	
	protected int moveImage;
	
	public GraphicCharacter(int x, int y, String n, String dir){
		super(x,y,n,dir);
		moveImage=0;
	}
	
	public int getMoveImage(){
		return moveImage;
	}
	public void setMoveImage(int x){
		moveImage=x;
	}
}