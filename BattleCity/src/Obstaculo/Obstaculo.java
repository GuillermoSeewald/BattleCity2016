package Obstaculo;

import Mapa.*;

public abstract class Obstaculo extends Celda{
	protected int resistencia;
	
	public void setResistencia(int res){
		resistencia=res;
	}
	public int getResistencia(){
		return resistencia;
	}
}