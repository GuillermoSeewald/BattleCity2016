package Tanque;

import Mapa.*;

public class Disparo extends Celda{
	private String direccion;
	private Tanque tanque;
	
	public Disparo(String dir, Tanque t){
		super("disparo");
		direccion=dir;
		tanque=t;
	}
	public void setDireccio(String dir){
		direccion=dir;
	}
	public String getDireccion(){
		return direccion;
	}
}