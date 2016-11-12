package Graphic.Tank;


public class GraphicPlayer extends GraphicCharacter{
	public GraphicPlayer(int x,int y, String n, String dir){
		super(x,y,n,dir);
	}
	
	public void relocate(){
		X=213;Y=638;
	}
}