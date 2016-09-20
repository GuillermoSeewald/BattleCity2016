package Mapa;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Element{
	
	protected String nombre;
	
	protected int x;
	protected int y;
	
	protected Image imagen;
	
	public Element(String nom, int X, int Y){
		x=X;
		y=Y;
		nombre=nom;
		ImageIcon ima = new ImageIcon("Imagenes/"+nombre+".png");
		imagen= ima.getImage();
	}
	public void setImagen(Image ima){
		imagen= ima;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImagen(){
		return imagen;
	}
}