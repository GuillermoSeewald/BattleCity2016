package Tanque;

import Mapa.*;
import javax.swing.ImageIcon;

public abstract class Tanque extends Celda{
	protected int vida, velMovimiento, velDisparo, golpesQueResiste;
	protected String direccion;
	protected boolean hayDisparo;
	
	public Tanque(int v,int velM,int velD,int golpes,String nom,String dir, int x, int y){
		super(nom+" "+dir, x, y);
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