package Logic.Level;

import Logic.Tank.*;
import Graphic.Level.GraphicLevel1;

public class Level1 extends Level{
	
	protected GraphicLevel1 graphic;
	
	public Level1(){
		speedShot=5;
		graphic= new GraphicLevel1();
		killSteel=false;
	}
	public Level1(Player pla){
		speedShot=5;
		pla.setSimultaneousShots(1);
		pla.setSpeedMove(55);
		pla.setResistance(1);
		graphic= new GraphicLevel1();
		killSteel=false;
		pla.getGraphic().changeHeight(40);
		pla.getGraphic().changeWidth(40);
	}
	public Level getNextLevel(Player pla){
		return new Level2(pla);
	}
	public GraphicLevel1 getGraphic(){
		return graphic;
	}
}