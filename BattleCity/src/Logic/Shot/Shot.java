package Logic.Shot;

import Logic.Map.*;
import Logic.Obstacle.*;
import Logic.Tank.Player;
import Graphic.Map.GraphicElement;
import Graphic.Shot.*;

public abstract class Shot extends Element{
	
	protected int speed, dx, dy, posInShots;
	protected GraphicShot graphic;
	
	public Shot(String dir, int x, int y, Map map, int speed, int posx, int posy){
		super(map, posx, posy);
		graphic= new GraphicShot(x,y,"Disparo "+dir,dir);
		this.speed=speed;
		assignIncrementDir(dir);
	}
	public void addPosInShots(int x){
		posInShots=x;
	}
	public boolean move(){
		boolean mov=true;
		Obstacle obs= null;
		if(dx!=0){
			int auxX= getNewPos(graphic.getX()+dx);
			if(((graphic.getX()+dx)<0)||((graphic.getX()+dx)>677)){
				mov=false;
			}
			else{
				obs=map.getObstacle(auxX, posY);
				if(obs==null){
					graphic.changeX(graphic.getX()+dx);
					posX=auxX;
				}
				else{
					Player p=null;
					int aux=obs.kill(p);
					if(aux==1){
						mov=false;
					}
					else{
						graphic.changeX(graphic.getX()+dx);
						posX=auxX;
					}
				}
			}
		}
		if(dy!=0){
			int auxY= getNewPos(graphic.getY()+dy);
			if(((graphic.getY()+dy)<0)||((graphic.getY()+dy)>677)){
				mov=false;
			}
			else{
				obs= map.getObstacle(posX, auxY);
				if(obs==null){
					graphic.changeY(graphic.getY()+dy);
					posY=auxY;
				}
				else{
					Player p=null;
					int aux=obs.kill(p);
					if(aux==1){
						mov=false;
					}
					else{
						graphic.changeY(graphic.getY()+dy);
						posY=auxY;
					}
				}
			}
		}
		map.repaint();
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
			break;
		case "derecha":
			dx=1;dy=0;
			break;
		}
	}
	private int getNewPos(int newPosGraph){
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
					if((graphic.getDirection()=="abajo")||(graphic.getDirection()=="derecha")){
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
	public GraphicElement getGraphic(){
		return graphic;
	}
}