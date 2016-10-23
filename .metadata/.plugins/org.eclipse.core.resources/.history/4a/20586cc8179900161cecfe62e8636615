package Logic.Tank;

import Logic.Map.*;
import Logic.Obstacle.*;
import Graphic.Tank.*;

public abstract class Character extends Element{
	protected int speedMove, resistance, points;
	
	public Character(int speedM,int res, Map map, int posx, int posy){
		super(map, posx, posy);
		speedMove=speedM;
		resistance=res;
	}
	
	public void setSpeedMove(int s){
		speedMove=s;
	}
	public void setResistance(int r){
		resistance=r;
	}
	public void setPoints(int p){
		points=p;
	}
	public void move(GraphicCharacter g){
		if(g.getDX()!=0){
			int auxX= g.getNewPos(g.getX()+g.getDX(),g,map.getMap().length);
			if((g.getX()+g.getDX())<0){
				g.changeX(0);
			}
			else{
				if((g.getX()+g.getDX()+34)>676){
					g.changeX(642);
					}
				else{
					Obstacle obs1= map.getObstacle(auxX, posY);
					Obstacle obs2= null;
					if(g.betweenTwoCell(g.getY(), map.getMap().length)){
						obs2=map.getObstacle(posX, posY+1);
					}
					if((obs1==null)&&(obs2==null)){
						g.changeX(g.getX()+g.getDX());
						posX=auxX;
					}
				}
			}
		}
		if(g.getDY()!=0){
			int auxY= g.getNewPos(g.getY()+g.getDY(),g,map.getMap().length);
			if((g.getY()+g.getDY())<0){
				g.changeY(0);
				}
			else{
				if((g.getY()+g.getDY()+34)>676){
					g.changeY(642);
					}
				else{
					Obstacle obs1= map.getObstacle(posX, auxY);
					Obstacle obs2=null;
					if(g.betweenTwoCell(g.getX(), map.getMap().length)){
						obs2=map.getObstacle(posX+1, posY);
					}
					if((obs1==null)&&(obs2==null)){
						g.changeY(g.getY()+g.getDY());
						posY=auxY;
					}
				}
			}
		}
		map.getGraphicMap().repaint();
	}
	public abstract void attack();
	
	public int getSpeedMove(){
		return speedMove;
	}
	public int getResistance(){
		return resistance;
	}
	public int getPoints(){
		return points;
	}
}