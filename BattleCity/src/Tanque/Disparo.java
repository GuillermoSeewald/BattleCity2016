package Tanque;

import Mapa.*;

public class Disparo extends Celda{
	private String direccion;
	
	public Disparo(String dir){
		direccion=dir;
	}
	public void setDireccio(String dir){
		direccion=dir;
	}
	public String getDireccion(){
		return direccion;
	}
}