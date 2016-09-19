package Tanque;

import Mapa.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	
	private String direccion= "arriba";
	private String nom;
	

	private int nivel, puntos, disparosSimultaneos;
	
	private int dx;
	private int dy;
	
	public Jugador(){
		super(3,1,1,1,"Jugador","arriba",208,574);
		nom= "Jugador";
		nivel=1;
		puntos=0;
		disparosSimultaneos=1;
	}
	public void mover(){
		x+=dx;
		y+=dy;
	}
	public void setNivel(int i){
		nivel=i;
	}
	public void setPuntos(int p){
		puntos=p;
	}
	public void setDisparos(int d){
		disparosSimultaneos=d;
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = -1;
			direccion="arriba";
			break;
		case KeyEvent.VK_DOWN :
			dy = 1;
			direccion="abajo";
			break;
		case KeyEvent.VK_LEFT :
			dx = -1;
			direccion="izquierda";
			break;
		case KeyEvent.VK_RIGHT :
			dx = 1;
			direccion="derecha";
			break;
		}
		ImageIcon ima = new ImageIcon("Imagenes/"+nom+" "+direccion+".png");
		setImagen(ima.getImage());
	}
	public void keyReleased(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = 0;
			break;
		case KeyEvent.VK_DOWN :
			dy = 0;
			break;
		case KeyEvent.VK_LEFT :
			dx = 0;
			break;
		case KeyEvent.VK_RIGHT :
			dx = 0;
			break;
		}
	}
	public int getNivel(){
		return nivel;
	}
	public int getPuntos(){
		return puntos;
	}
	public int getDisparos(){
		return disparosSimultaneos;
	}
	/*
	public boolean collide(Enemigo ene){
		
	}
	public boolean collide(Disparo dis){
		
	}
	*/
}