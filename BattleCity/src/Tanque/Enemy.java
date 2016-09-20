package Tanque;

public abstract class Enemy extends Character{
	public Enemy(int v,int velM,int velD,int golpes,String nom,String dir, int x, int y){
		super(v,velM,velD,golpes,nom,dir,x,y);
	}
}