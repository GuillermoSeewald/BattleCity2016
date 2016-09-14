package Mapa;

public class Celda{
	protected int posicionX,posicionY;
	protected String nombre;
	
	public Celda(){
	}
	public void setX(int x){
		posicionX=x;
	}
	public void setY(int y){
		posicionY=y;
	}
	public void setNombre(String s){
		nombre=s;
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
}