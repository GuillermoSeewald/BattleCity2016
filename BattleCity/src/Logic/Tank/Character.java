package Logic.Tank;

import Logic.Map.*;
import Logic.Obstacle.*;
import Graphic.Tank.*;

public abstract class Character extends Element{
	protected int speedMove, resistance, movImage, points;
	protected String direction;
	
	protected int dx;
	protected int dy;
	
	public Character(int speedM,int res, String dir, Map map, int posx, int posy){
		super(map, posx, posy);
		speedMove=speedM;
		resistance=res;
		direction=dir;
		movImage=0;
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
		if(dx!=0){
			int auxX= getNewPos(g.getX()+dx);
			if((g.getX()+dx)<0){
				g.changeX(0);
			}
			else{
				if((g.getX()+dx+34)>676){
					g.changeX(642);
					}
				else{
					Obstacle obs1= map.getObstacle(auxX, posY);
					Obstacle obs2= null;
					if(betweenTwoCell(g.getY())){
						obs2=map.getObstacle(posX, posY+1);
					}
					if((obs1==null)&&(obs2==null)){
						g.changeX(g.getX()+dx);
						posX=auxX;
					}
				}
			}
		}
		if(dy!=0){
			int auxY= getNewPos(g.getY()+dy);
			if((g.getY()+dy)<0){
				g.changeY(0);
				}
			else{
				if((g.getY()+dy+34)>676){
					g.changeY(642);
					}
				else{
					Obstacle obs1= map.getObstacle(posX, auxY);
					Obstacle obs2=null;
					if(betweenTwoCell(g.getX())){
						obs2=map.getObstacle(posX+1, posY);
					}
					if((obs1==null)&&(obs2==null)){
						g.changeY(g.getY()+dy);
						posY=auxY;
					}
				}
			}
		}
		map.getPlay().getEtiquetaPuntos().setText("x: "+posX+" /y: "+posY);
		map.repaint();
	}
	public abstract void attack();
	
	public int[] generatePosShot(GraphicCharacter g){
		int ejeX=0;
		int ejeY=0;
		switch(direction){
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
	public String getDirection(){
		return direction;
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
	private int getNewPos(int newPosGraph){
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