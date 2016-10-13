package Shot;

import Mapa.Element;
import Mapa.Map;
import Obstaculo.*;

public abstract class Shot extends Element{
	
	protected int speed, dx, dy, posInShots;
	
	public Shot(String dir, int x, int y, Map map, int speed){
		super("Disparo "+dir,x, y, map);
		this.speed=speed;
		assignIncrementDir(dir);
	}
	public void addPosInShots(int x){
		posInShots=x;
	}
	public boolean move(){
		boolean mov=true;
		Obstacle obs[]= new Obstacle[2];
		if(((x+dx)<0)||((x+dx)>677)){
			mov=false;
		}
		else{
			if(dx==-1){
				obs=map.getObstacle(x-1, y);
			}
			else
				if(dx==1){
					obs=map.getObstacle(x+getWidth(), y);
				}
			if((obs[0]==null)&&(obs[1]==null)){
				x+=dx;
			}
		}
		if(((y+dy)<0)||((y+dy)>677)){
			mov=false;
		}
		else{
			y+=dy;
		}
		return mov;
	}
	public int getWidth(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
		}
	}
	public int getHeight(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
		}
	}
	public int getWidht(){
		if((dx==-1)||(dx==1)){
			return 4;
		}
		else{
			return 3;
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
		case "derecha":
			dx=1;dy=0;
			break;
		}
	}
}