package Tanque;

public class Jugador extends Tanque{
	private int nivel, puntos, disparosSimultaneos;
	
	public Jugador(){
		super(3,1,1,1,"jugador","arriba");
		nivel=1;
		puntos=0;
		disparosSimultaneos=1;
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
	public int getNivel(){
		return nivel;
	}
	public int getPuntos(){
		return puntos;
	}
	public int getDisparos(){
		return disparosSimultaneos;
	}
}