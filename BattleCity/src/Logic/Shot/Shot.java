package Logic.Shot;

import Logic.Map.*;
import Logic.Obstacle.*;
import Logic.Tank.Player;
import Graphic.Shot.*;

public abstract class Shot extends Element{
	
	protected int speed;
	protected GraphicShot graphic;
	
	public Shot(String dir, int x, int y, Map map, int speed, int posx, int posy){
		super(map, posx, posy);
		graphic= new GraphicShot(x,y,"Disparo "+dir,dir);
		this.speed=speed;
	}
	public int getSpeed(){
		return speed;
	}
	public boolean move(){
		boolean mov=true;
		Obstacle obs= null;
		if(graphic.getDX()!=0){
			int auxX= getNewPos(graphic.getX()+graphic.getDX());
			if(((graphic.getX()+graphic.getDX())<0)||((graphic.getX()+graphic.getDX())>677)){
				mov=false;
			}
			else{
				obs=map.getObstacle(auxX, posY);
				if(obs==null){
					graphic.changeX(graphic.getX()+graphic.getDX());
					posX=auxX;
				}
				else{
					Player p=null;
					int aux=obs.kill(p);
					if(aux==1){
						mov=false;
					}
					else{
						graphic.changeX(graphic.getX()+graphic.getDX());
						posX=auxX;
					}
				}
			}
		}
		if(graphic.getDY()!=0){
			int auxY= getNewPos(graphic.getY()+graphic.getDY());
			if(((graphic.getY()+graphic.getDY())<0)||((graphic.getY()+graphic.getDY())>677)){
				mov=false;
			}
			else{
				obs= map.getObstacle(posX, auxY);
				if(obs==null){
					graphic.changeY(graphic.getY()+graphic.getDY());
					posY=auxY;
				}
				else{
					Player p=null;
					int aux=obs.kill(p);
					if(aux==1){
						mov=false;
					}
					else{
						graphic.changeY(graphic.getY()+graphic.getDY());
						posY=auxY;
					}
				}
			}
		}
		map.getGraphicMap().repaint();
		return mov;
	}
	
	//Calcula la ubicaci�n logica en la cual se encontrar� el disparo en el siguiente movimiento
	//utilizando la posicion en pixeles
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
	public GraphicShot getGraphic(){
		return graphic;
	}
}