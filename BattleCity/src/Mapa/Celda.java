package Mapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;;

public abstract class Celda{
	protected int posicionX,posicionY;
	protected String nombre;
	protected ImageIcon imagen;
	protected JLabel etiqueta;
	
	public Celda(String nom){
		nombre=nom;
		imagen= new ImageIcon("Imagenes/"+nom+".png");
		etiqueta= new JLabel();
		etiqueta.setSize(52,52);
		etiqueta.setIcon(imagen);
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
	public JLabel getEtiqueta(){
		return etiqueta;
	}
}