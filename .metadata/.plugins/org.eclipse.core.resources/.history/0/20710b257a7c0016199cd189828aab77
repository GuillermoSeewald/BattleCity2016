package Mapa;

import javax.swing.ImageIcon;

public abstract class Celda{
	protected int posicionX,posicionY;
	protected String nombre;
	protected ImageIcon imagen;
	
	public Celda(String nom){
		nombre=nom;
		imagen= new ImageIcon("Imagenes/"+nom+".png");
	}
	public void setX(int x){
		if((x>=0)&&(x<13)){
			posicionX=x;
		}
	}
	public void setY(int y){
		if((y>=0)&&(y<13)){
			posicionY=y;
		}
	}
	public int getX(){
		return posicionX;
	}
	public int getY(){
		return posicionY;
	}
	public String getNombre(){
		return nombre;
	}
	public ImageIcon getImagen(){
		return imagen;
	}
}