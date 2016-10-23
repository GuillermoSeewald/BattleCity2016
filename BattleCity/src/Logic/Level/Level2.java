package Logic.Level;

import Logic.Tank.Player;
import Graphic.Level.GraphicLevel2;


public class Level2 extends Level{
	
	protected GraphicLevel2 graphic;
	
	public Level2(Player pla){
		speedShot=4;
		pla.setSimultaneousShots(1);
		pla.setSpeedMove(45);
		pla.setResistance(1);
		graphic= new GraphicLevel2();
	}
	public int getSpeedShot(){
		return speedShot;
	}
	public Level getNextLevel(Player pla){
		return new Level3(pla);
	}
	public GraphicLevel2 getGraphic(){
		return graphic;
	}
}