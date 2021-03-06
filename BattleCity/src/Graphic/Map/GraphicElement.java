package Graphic.Map;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class GraphicElement{
	protected int X;
	protected int Y;
	protected int width;
	protected int height;
	
	protected Image image;
	
	public GraphicElement(int x, int y, String nom){
		this.X=x;
		this.Y=y;
		image=new ImageIcon("Imagenes/"+nom+".png").getImage();
		width=52;
		height=52;
	}
	public Image getImagen(){
		return image;
	}
	public void setImage(Image ima){
		image= ima;
	}
	public void changeX(int x){
		X=x;
	}
	public void changeY(int y){
		Y=y;
	}
	public void changeWidth(int w){
		width=w;
	}
	public void changeHeight(int h){
		height=h;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}