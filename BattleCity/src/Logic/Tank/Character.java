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
			int auxX= getNewPos(g.getX()+g.getDX(),g);
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
					if(betweenTwoCell(g.getY())){
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
			int auxY= getNewPos(g.getY()+g.getDY(),g);
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
					if(betweenTwoCell(g.getX())){
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
	
	public int[] generatePosShot(GraphicCharacter g){
		int ejeX=0;
		int ejeY=0;
		switch(g.getDirection()){
		case "arriba":
			ejeX=(g.getX()+(g.getHeight()/2));
			ejeY=(g.getY());
			break;
		case "abajo":
			ejeX=(g.getX()+(g.getHeight()/2));
			ejeY=(g.getY()+g.getHeight());
			break;
		case "izquierda":
			ejeX=(g.getX());
			ejeY=(g.getY()+(g.getHeight()/2));
			break;
		case "derecha":
			ejeX=(g.getX()+g.getHeight());
			ejeY=(g.getY()+(g.getHeight()/2));
			break;
		}
		int[] retorno=new int[2];
		retorno[0]=ejeX;
		retorno[1]=ejeY;
		return retorno;
	}
	public int getSpeedMove(){
		return speedMove;
	}
	public int getResistance(){
		return resistance;
	}
	public int getPoints(){
		return points;
	}
	private boolean betweenTwoCell(int graphPos){
		boolean twoCell=true;
		int aux1=0;
		int aux2=52;
		for(int i=0;(i<map.getMap().length)&&(twoCell);i++){
			if((graphPos>=aux1)&&((graphPos+38)<aux2)){
				twoCell=false;
			}
			else{
				aux1=aux2;
				aux2+=52;
			}
		}
		return twoCell;
	}
	private int getNewPos(int newPosGraph, GraphicCharacter g){
		int newPos=0;
		int aux1=0;
		int aux2=52;
		boolean found=false;
		for(int i=0;(i<map.getMap().length-1)&&(!found);i++){
			if((newPosGraph>=aux1)&&((newPosGraph+34)<aux2)){
				found=true;
			}
			else{
				if((newPosGraph<aux2)&&((newPosGraph+34)>=aux2)){
					found=true;
					if((g.getDirection()=="abajo")||(g.getDirection()=="derecha")){
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