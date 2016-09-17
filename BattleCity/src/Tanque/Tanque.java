package Tanque;

import Mapa.*;
import javax.swing.ImageIcon;

public abstract class Tanque extends Celda{
	private int vida, velMovimiento, velDisparo, golpesQueResiste;
	private String direccion;
	private boolean hayDisparo;
	
	public Tanque(int v,int velM,int velD,int golpes,String nom,String dir){
		super(nom+dir);
		vida=v;
		velDisparo=velD;
		velMovimiento=velM;
		golpesQueResiste=golpes;
		direccion=dir;
	}
	
	public void asignarVida(int v){
		vida=v;
	}
	public void asignarVelocidadDisparo(int v){
		velDisparo=v;
	}
	public void asignarVelocidadMovimientoo(int v){
		velMovimiento=v;
	}
	public void asignarGolpes(int g){
		golpesQueResiste=g;
	}
	public void disparar(){
		hayDisparo=true;
		new Disparo(direccion, this);
	}
	public void mover(int dir){
		switch(dir){
			case 0:
				this.setY(this.getY()-1);
				direccion="arriba";
				break;
			case 1:
				this.setY(this.getY()+1);
				direccion="abajo";
				break;
			case 2:
				this.setX(this.getX()-1);
				direccion="izquierda";
				break;
			case 3:
				this.setX(this.getX()+1);
				direccion="derecha";
				break;
		}
		setImagen();
	}
	public void setDireccion(String dir){
		direccion=dir;
	}
	public void setImagen(){
		this.imagen= new ImageIcon("Imagenes/"+this.nombre+this.direccion+".png");
	}
	public int getVidas(){
		return vida;
	}
	public int getVelDisparo(){
		return velDisparo;
	}
	public int getvelMovimiento(){
		return velMovimiento;
	}
	public int getGolpes(){
		return golpesQueResiste;
	}
	public String getDireccion(){
		return direccion;
	}
	public boolean hayDisparo(){
		return hayDisparo;
	}
}