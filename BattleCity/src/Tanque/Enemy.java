package Tanque;

import Mapa.*;

public abstract class Enemy extends Character{
	public Enemy(int v,int velM,int golpes,String nom,String dir, int x, int y, Map map){
		super(v,velM,golpes,nom,dir,x,y,map);
	}
}