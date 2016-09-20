package Tanque;

import Mapa.*;
import javax.swing.ImageIcon;

public abstract class Character extends Element{
	protected int vida, velMovimiento, velDisparo, golpesQueResiste, movImagen;
	protected String direccion;
	protected boolean hayDisparo;
	
	protected int dx;
	protected int dy;
	
	public Character(int v,int velM,int velD,int golpes,String nom,String dir, int x, int y){
		super(nom+" "+dir+"-mov"+1, x, y);
		vida=v;
		velDisparo=velD;
		velMovimiento=velM;
		golpesQueResiste=golpes;
		direccion=dir;
		movImagen=0;
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
	public void mover(){
		x+=dx;
		y+=dy;
	}
//	public void disparar(){
//		hayDisparo=true;
//		new Disparo(direccion, this);
//	}
	public int getVidas(){
		return vida;
	}
	public int getVelDisparo(){
		return velDisparo;
	}
	public int getVelMovimiento(){
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