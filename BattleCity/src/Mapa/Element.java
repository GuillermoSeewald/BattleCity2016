package Mapa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Tanque.Enemy;
import Tanque.Player;

public abstract class Element{
	
	protected String nombre;
	protected Map map;
	
	protected int x;
	protected int y;
	protected final int width= 52;
	protected final int heigth=52;
	
	protected Image imagen;
	protected JLabel etiqueta;
	
	public Element(String nom, int X, int Y, Map map){
		this.map=map;
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
	public int getWidth(){
		return width;
	}
	public int getHeigth(){
		return heigth;
	}
/*	public abstract int kill();
	public abstract boolean collide(Player jug);
	public abstract boolean collide(Enemy ene);
	*/
}