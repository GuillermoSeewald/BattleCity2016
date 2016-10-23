package Graphic.Shot;

import Graphic.GraphicElementWithMovement.*;

public class GraphicShot extends GraphicElementWithMovement{
	
	protected int posInShots;
	
	public GraphicShot(int x, int y, String n, String dir){
		super(x,y,n,dir);
		assignIncrementDir(dir);
	}
	public int getPosInShots(){
		return posInShots;
	}
	public void addPosInShots(int x){
		posInShots=x;
	}
	public int getWidth(){
		if((direction=="izquierda")||(direction=="derecha")){
			return 4;
		}
		else{
			return 3;
		}
	}
	public int getHeight(){
		if((direction=="izquierda")||(direction=="derecha")){
			return 3;
		}
		else{
			return 4;
		}
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
}