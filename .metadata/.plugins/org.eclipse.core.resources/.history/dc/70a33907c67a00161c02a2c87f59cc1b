package Tanque;

import Mapa.*;

public class Tanque extends Celda{
	private int vida, velMovimiento, velDisparo, golpesQueResiste;
	private String direccion;
	
	public Tanque(int v,int velM,int velD,int golpes,String nom,String dir){
		vida=v;
		velDisparo=velD;
		velMovimiento=velM;
		golpesQueResiste=golpes;
		this.setNombre(nom);
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
		new Disparo(direccion);
	}
	public void moverIzquierda(){
		direccion="izquierda";
		this.setX(this.getX()-1);
	}
	public void moverDerecha(){
		direccion="derecha";
		this.setX(this.getX()+1);
	}
	public void moverArriba(){
		direccion="arriba";
		this.setY(this.getY()+1);
	}
	public void moverAbajo(){
		direccion="abajo";
		this.setY(this.getY()-1);
	}
	public void setDireccion(String dir){
		direccion=dir;
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
	public String getNombre(){
		return nombre;
	}
	public String getDireccion(){
		return direccion;
	}
}