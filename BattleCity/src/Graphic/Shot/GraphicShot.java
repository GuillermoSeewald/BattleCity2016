package Graphic.Shot;

import Logic.Map.*;
import Graphic.GraphicElementWithMovement.*;

public abstract class GraphicShot extends GraphicElementWithMovement{
	
	protected int posInShots;
	
	public GraphicShot(int x, int y, String n, String dir){
		super(x,y,n,dir);
		width=3;
		height=4;
		assignIncrementDir(dir);
	}
	public int getPosInShots(){
		return posInShots;
	}
	public void addPosInShots(int x){
		posInShots=x;
	}
	private void assignIncrementDir(String dir){
		switch(dir){
		case "arriba":
			dx=0;dy=-1;
			break;
		case "abajo":
			dx=0;dy=1;
			break;
		case "izquierda":
			dx=-1;dy=0;
			break;
		case "derecha":
			dx=1;dy=0;
			break;
		}
	}
	
	//Calcula la ubicación logica en la cual se encontrará el disparo en el siguiente movimiento
	//utilizando la posicion en pixeles
	public int getNewPos(int newPosGraph, Map map){
		int newPos=0;
		int aux1=0;
		int aux2=52;
		boolean found=false;
		for(int i=0;(i<map.getMap().length-1)&&(!found);i++){
			if((newPosGraph>=aux1)&&((newPosGraph+4)<aux2)){
				found=true;
			}
			else{
				if((newPosGraph<aux2)&&((newPosGraph+4)>=aux2)){
					found=true;
					if((direction=="abajo")||(direction=="derecha")){
						newPos++;
					}
				}
				else{
					aux1=aux2;
					aux2+=52;
					newPos++;
					}
			}
		}
		return newPos;
	}
}