package Tanque;

import Mapa.*;

public abstract class Character extends Element{
	protected int vida, velMovimiento, golpesQueResiste, movImagen;
	protected String direccion;
	protected boolean hayDisparo;
	
	protected int dx;
	protected int dy;
	
	public Character(int v,int velM,int golpes,String nom,String dir, int x, int y, Map map){
		super(nom+" "+dir+"-mov1", x, y,map);
		vida=v;
		velMovimiento=velM;
		golpesQueResiste=golpes;
		direccion=dir;
		movImagen=1;
	}
	
	public void asignarVida(int v){
		vida=v;
	}
	public void asignarVelocidadMovimientoo(int v){
		velMovimiento=v;
	}
	public void asignarGolpes(int g){
		golpesQueResiste=g;
	}
	public void mover(){
		if((x==0)&&(dx==(-1))){
			x=0;
		}
		else{
			if((x==625)&&(dx==1)){
				x=625;
			}
			else{
				x+=dx;
			}
		}
		if((y==0)&&(dy==(-1))){
			y=0;
		}
		else{
			if((y==625)&&(dy==1)){
				y=625;
			}
			else{
				y+=dy;
			}
		}
	}
//	public void disparar(){
//		hayDisparo=true;
//		new Disparo(direccion);
//	}
	public int getVidas(){
		return vida;
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